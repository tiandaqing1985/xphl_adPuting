package com.ruoyi.today.service.impl;

import java.io.File;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.PermissionUtils;
import com.ruoyi.today.domain.*;
import com.ruoyi.today.domain.enums.VideoOrderStatusEnum;
import com.ruoyi.today.domain.response.ResponseVO;
import com.ruoyi.today.mapper.ThVideoOrderMapper;
import com.ruoyi.today.service.*;
import com.ruoyi.today.tools.VideoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 视频订单Service业务层处理
 *
 * @author ruoyi
 * @date 2020-03-02
 */
@Service
public class ThVideoOrderServiceImpl implements IThVideoOrderService {

    private static Logger logger = LoggerFactory.getLogger(ThVideoOrderServiceImpl.class);

    @Autowired
    private ThVideoOrderMapper thVideoOrderMapper;
    @Autowired
    private IThVideoNeedService thVideoNeedService;
    @Autowired
    private IThVideoMatterService videoMatterService;

    @Autowired
    private IThFileService thFileService;
    @Autowired
    private IThVideoOperationHistoryService thVideoOperationHistoryService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private IThCreativityCreativesService thCreativityCreativesService;

    /**
     * 查询视频订单
     *
     * @param id 视频订单ID
     * @return 视频订单
     */
    @Override
    public ThVideoOrder selectThVideoOrderById(Long id) {
        return thVideoOrderMapper.selectThVideoOrderById(id);
    }

    /**
     * 查询视频订单列表
     *
     * @param thVideoOrder 视频订单
     * @return 视频订单
     */
    @Override
    public List<ThVideoOrder> selectThVideoOrderList(ThVideoOrder thVideoOrder) {
        return thVideoOrderMapper.selectThVideoOrderList(thVideoOrder);
    }

    /**
     * 新增视频订单
     *
     * @param thVideoOrder 视频订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertThVideoOrder(ThVideoOrder thVideoOrder) throws Exception {
        thVideoOrder.setCreateTime(DateUtils.getNowDate());
        try {
            thVideoOrderMapper.insertThVideoOrder(thVideoOrder);
            thVideoNeedService.insertThVideoNeed(thVideoOrder.getNeed());

            ThVideoOperationHistory operationHistory = new ThVideoOperationHistory();
            operationHistory.setOperationBy(thVideoOrder.getCreateBy());
            operationHistory.setOperationTime(thVideoOrder.getCreateTime());
            operationHistory.setOrderId(thVideoOrder.getId());
            operationHistory.setStatus("下单");


            logger.info("订单" + thVideoOrder.getOrderName() + "创建成功，开始上传文件");
            String logoUrl = thFileService.receiveAndUploadFile(thVideoOrder.getLogo());
            String scriptUrl = thFileService.receiveAndUploadFile(thVideoOrder.getScript());

            thVideoOrder.setVideoScript(scriptUrl);
            thVideoOrder.getNeed().setLogoUrl(logoUrl);
            thVideoOrder.getNeed().setOrderId(thVideoOrder.getId().toString());
            thVideoOrderMapper.updateThVideoOrder(thVideoOrder);
            thVideoNeedService.updateThVideoNeed(thVideoOrder.getNeed());
        } catch (Exception e) {
            logger.error("创建订单出现错误:", e);
            throw e;
        }

        return 1;
    }

    /**
     * 修改视频订单
     *
     * @param thVideoOrder 视频订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateThVideoOrder(ThVideoOrder thVideoOrder) throws Exception {

        ThVideoOrder updateVO = thVideoOrderMapper.selectThVideoOrderById(thVideoOrder.getId());
        if (updateVO.getStatus() == VideoOrderStatusEnum.ORDER.getValue()) {
            logger.error("非下单状态无法修改订单信息");
            throw new Exception("非下单状态无法修改订单信息");
        }
        updateVO.setUpdateTime(DateUtils.getNowDate());
        updateVO.setOrderName(thVideoOrder.getOrderName());
        updateVO.setType(thVideoOrder.getType());
        updateVO.setSpecialNeed(thVideoOrder.getSpecialNeed());
        updateVO.setRiskWord(thVideoOrder.getRiskWord());
        try {
            thVideoOrderMapper.updateThVideoOrder(updateVO);
            if (!thVideoOrder.getScript().isEmpty()) {
                String scriptUrl = thFileService.receiveAndUploadFile(thVideoOrder.getScript());
                updateVO.setVideoScript(scriptUrl);
                thVideoOrderMapper.updateThVideoOrder(updateVO);
            }
        } catch (Exception e) {
            logger.error("更新订单信息出现错误", e);
            throw e;
        }

        return 1;
    }

    /**
     * 删除视频订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThVideoOrderByIds(String ids) {
        return thVideoOrderMapper.deleteThVideoOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除视频订单信息
     *
     * @param id 视频订单ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteThVideoOrderById(Long id) {
        thVideoNeedService.deleteThVideoNeedByOrderId(id);
        return thVideoOrderMapper.deleteThVideoOrderById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOrderStatus(ThVideoOrder thVideoOrder, String statusName) throws Exception {

        ThVideoOperationHistory operationHistory = new ThVideoOperationHistory();
        operationHistory.setOperationBy((String) PermissionUtils.getPrincipalProperty("userName"));
        operationHistory.setStatus(statusName);
        operationHistory.setOrderId(thVideoOrder.getId());
        operationHistory.setOperationTime(DateUtils.getNowDate());
        thVideoOperationHistoryService.insertThVideoOperationHistory(operationHistory);

        thVideoOrderMapper.updateThVideoOrder(thVideoOrder);

        ThVideoMatter thVideoMatter = new ThVideoMatter();
        thVideoMatter.setStatus(statusName);
        thVideoMatter.setOrderId(thVideoOrder.getId());
        videoMatterService.updateNoSignInThVideoMatterByOrderId(thVideoMatter);

        if(statusName.equals("拒签")){
            videoMatterService.deleteThVideoMatterByOrderId(thVideoOrder.getId());
        }

        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void orderDelivery(ThVideoOrder thVideoOrder) throws Exception {
        try {
            String fileName = thVideoOrder.getScript().getOriginalFilename();
            ThVideoOperationHistory operationHistory = new ThVideoOperationHistory();
            operationHistory.setOperationBy((String) PermissionUtils.getPrincipalProperty("userName"));
            operationHistory.setOperationTime(DateUtils.getNowDate());
            operationHistory.setOrderId(thVideoOrder.getId());
            operationHistory.setStatus("交付");
            thVideoOperationHistoryService.insertThVideoOperationHistory(operationHistory);


            logger.info("订单" + thVideoOrder.getId() + "，开始接收文件");
            File file = thFileService.receiveFile(thVideoOrder.getScript());
            //获取视频截图作为封面
            File coverFile = new File(file.getParent() + "封面-" + file.getName());
            VideoUtils.fetchFrame(file.getAbsolutePath(), coverFile.getAbsolutePath());

            logger.info("订单" + thVideoOrder.getId() + "，开始上传视频文件");
            String matter = thFileService.uploadFile(file);
            logger.info("订单" + thVideoOrder.getId() + "，开始上传视频封面文件");
            String matterCover = thFileService.uploadFile(coverFile);


            ThVideoMatter videoMatter = new ThVideoMatter();
            videoMatter.setMatter(matter);
            videoMatter.setOrderId(thVideoOrder.getId());
            videoMatter.setFileName(fileName);
            videoMatter.setVideoCover(matterCover);
            videoMatter.setCreateBy((String) PermissionUtils.getPrincipalProperty("userName"));
            videoMatter.setCreateTime(DateUtils.getNowDate());
            videoMatter.setStatus("交付");
            videoMatterService.insertThVideoMatter(videoMatter);
        } catch (Exception e) {
            logger.error("上传素材出现错误:", e);
            throw e;
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void orderDeliveryAgain(ThVideoOrder thVideoOrder) throws Exception {
        try {

            ThVideoMatter video = new ThVideoMatter();
            video.setOrderId(thVideoOrder.getId());
            video.setStatus("签收");
            videoMatterService.deleteThVideoMatter(video);
            video.setStatus("交付");
            videoMatterService.deleteThVideoMatter(video);

            String fileName = thVideoOrder.getScript().getOriginalFilename();
            ThVideoOperationHistory operationHistory = new ThVideoOperationHistory();
            operationHistory.setOperationBy((String) PermissionUtils.getPrincipalProperty("userName"));
            operationHistory.setOperationTime(DateUtils.getNowDate());
            operationHistory.setOrderId(thVideoOrder.getId());
            operationHistory.setStatus("补交付");
            thVideoOperationHistoryService.insertThVideoOperationHistory(operationHistory);


            logger.info("订单" + thVideoOrder.getId() + "，开始接收文件");
            File file = thFileService.receiveFile(thVideoOrder.getScript());
            //获取视频截图作为封面
            File coverFile = new File(file.getParent() + "封面-" + file.getName());
            VideoUtils.fetchFrame(file.getAbsolutePath(), coverFile.getAbsolutePath());

            logger.info("订单" + thVideoOrder.getId() + "，开始上传视频文件");
            String matter = thFileService.uploadFile(file);
            logger.info("订单" + thVideoOrder.getId() + "，开始上传视频封面文件");
            String matterCover = thFileService.uploadFile(coverFile);


            ThVideoMatter videoMatter = new ThVideoMatter();
            videoMatter.setMatter(matter);
            videoMatter.setOrderId(thVideoOrder.getId());
            videoMatter.setFileName(fileName);
            videoMatter.setVideoCover(matterCover);
            videoMatter.setCreateBy((String) PermissionUtils.getPrincipalProperty("userName"));
            videoMatter.setCreateTime(DateUtils.getNowDate());
            videoMatter.setStatus("补交付");
            videoMatterService.insertThVideoMatter(videoMatter);

        } catch (Exception e) {
            logger.error("上传素材出现错误:", e);
            throw e;
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void putInMatter(ThCreativity thCreativity) throws Exception {

        ResponseVO responseVO = (ResponseVO) touTiaoAdCenterService.updateCreativity(thCreativity);
        if (!responseVO.getCode().equals("0")) {
            throw new Exception("错误:" + responseVO.getCode() + responseVO.getMessage());
        } else {
            ThCreativityCreatives creatives = new ThCreativityCreatives();
            creatives.setAdvertiserId(thCreativity.getAdvertiserId());
            creatives.setAdId(thCreativity.getAdId());
            thCreativityCreativesService.syncCreativities(creatives);
        }

    }
}
