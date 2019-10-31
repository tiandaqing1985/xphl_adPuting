package com.ruoyi.today.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.PermissionUtils;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.impl.SysDictDataServiceImpl;
import com.ruoyi.today.domain.*;
import com.ruoyi.today.domain.enums.TemplateEnum;
import com.ruoyi.today.domain.request.PlanSyncRequest;
import com.ruoyi.today.domain.request.PlanUpdateRequest;
import com.ruoyi.today.domain.request.PlanUpdateStatusRequest;
import com.ruoyi.today.domain.response.*;
import com.ruoyi.today.mapper.ThAreaMapper;
import com.ruoyi.today.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.today.mapper.ThAdMapper;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 广告计划Service业务层处理
 *
 * @author ruoyi
 * @date 2019-08-15
 */
@Service
public class ThAdServiceImpl implements IThAdService {
    @Autowired
    private ThAdMapper thAdMapper;
    @Autowired
    private ThAreaMapper areaMapper;
    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private IThCampaignService thCampaignService;
    @Autowired
    private IThAdvertiserService iThAdvertiserService;
    @Autowired
    private IThCreativityService thCreativityService;
    @Autowired
    private ISysDictDataService sysDictDataService;
    @Autowired
    private IThAdMediaMateriaService thAdMediaMateriaService;
    @Autowired
    private IThAdMateriaService thAdMateriaService;
    @Autowired
    private IThAdIndustryService adIndustryService;
    @Autowired
    private IThCreativityCreativesService creativityCreativesService;

    private Logger log = LoggerFactory.getLogger(ThAdServiceImpl.class);

    /**
     * 查询广告计划
     *
     * @param id 广告计划ID
     * @return 广告计划
     */
    @Override
    public ThAd selectThAdById(Long id) {
        return thAdMapper.selectThAdById(id);
    }

    /**
     * 查询广告计划列表
     *
     * @param thAd 广告计划
     * @return 广告计划
     */
    @Override
    public List<ThAd> selectThAdList(ThAd thAd) {
        return thAdMapper.selectThAdList(thAd);
    }

    /**
     * 新增广告计划
     *
     * @param thAd 广告计划
     * @return 结果
     */
    @Override
    public int insertThAd(ThAd thAd) {
        thAd.setCreateTime(DateUtils.getNowDate());
        return thAdMapper.insertThAd(thAd);
    }

    /**
     * 修改广告计划
     *
     * @param thAd 广告计划
     * @return 结果
     */
    @Override
    public int updateThAd(ThAd thAd) {
        thAd.setUpdateTime(DateUtils.getNowDate());
        thAd.setUpdateBy((String) PermissionUtils.getPrincipalProperty("loginName"));
        Date date = null;
        if (thAd.getStartTime() != null && !"".equals(thAd.getStartTime())) {
            try {
                date = DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", thAd.getStartTime());
                thAd.setStartTime(DateUtils.parseDateToStr("yyyy-MM-dd HH:mm", date));
            } catch (Exception e) {
                log.error("广告计划：" + thAd.getName() + thAd.getAdId() + "日期转换出现错误：", e);
            }
        }
        if (thAd.getStartTime() != null && !"".equals(thAd.getStartTime())) {
            try {
                date = DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", thAd.getEndTime());
                thAd.setEndTime(DateUtils.parseDateToStr("yyyy-MM-dd HH:mm", date));
            } catch (Exception e) {
                log.error("广告计划：" + thAd.getName() + thAd.getAdId() + "日期转换出现错误：", e);
            }
        }
        return thAdMapper.updateThAd(thAd);
    }

    /**
     * 删除广告计划对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThAdByIds(String ids) {

        String[] idArray = Convert.toStrArray(ids);
        StringBuffer errMsg = new StringBuffer();
        for (String id : idArray) {
            try {
                updatePlanStatus(id, "delete");
            } catch (Exception e) {
                log.error("删除广告计划出现错误：", e);
                errMsg.append(e.getMessage());
            }
        }
        if (errMsg.length() == 0) {
            return 1;
        } else {
            log.error(errMsg.toString());
            return 0;
        }
    }

    /**
     * 删除广告计划信息
     *
     * @param id 广告计划ID
     * @return 结果
     */
    public int deleteThAdById(Long id) {
        return thAdMapper.deleteThAdById(id);
    }

    //根据模板组装广告
    private void templateFill(String fileName, List<ThAdCreativityImport> ads) {
        String[] str = fileName.split("-");
        String templateName = str[str.length - 1];
        TemplateEnum template = null;
        try {
            template = TemplateEnum.valueOf(templateName.substring(0, templateName.indexOf(".")));
        } catch (IllegalArgumentException e) {
            log.error("模板不存在：", e);
        } catch (Exception e) {
            log.error("出现未知错误：", e);
            throw e;
        }
        if (template == null) {
            return;
        }
        for (ThAdCreativityImport thAd : ads) {
            thAd.setDeliveryRange(template.getDeliveryRange());
            thAd.setPricing(template.getPricing());
            thAd.setDownloadType(template.getDownloadType());
        }
    }

    //根据模板组装广告
    private void templateFill(List<ThAd> ads, String fileName) {
        String[] str = fileName.split("-");
        String templateName = str[str.length - 1];
        TemplateEnum template = null;
        try {
            template = TemplateEnum.valueOf(templateName.substring(0, templateName.indexOf(".")));
        } catch (IllegalArgumentException e) {
            log.error("模板不存在：", e);
        } catch (Exception e) {
            log.error("出现未知错误：", e);
            throw e;
        }
        if (template == null) {
            return;
        }
        for (ThAd thAd : ads) {
            thAd.setDeliveryRange(template.getDeliveryRange());
            thAd.setPricing(template.getPricing());
            thAd.setDownloadType(template.getDownloadType());
        }
    }

    /**
     * 校验必输字段是否存在
     *
     * @param thAd
     * @return
     */
    private void checkValue(ThAd thAd) throws Exception {
        if ("APP".equals(thAd.getLandingType()) && (thAd.getDownloadType() == null || thAd.getDownloadType().equals(""))) {
            throw new Exception("应用下载方式不能为空");
        }
        if ("LINK".equals(thAd.getLandingType()) || ("EXTERNAL_URL".equals(thAd.getDownloadType()) && "APP".equals(thAd.getLandingType()))) {
            if (thAd.getExternalUrl() == null || thAd.getExternalUrl().equals("")) {
                throw new Exception("广告落地页链接");
            }
        }
        //投放范围为默认  DOWNLOAD_URL-下载链接  EXTERNAL_URL-落地页链接  DEFAULT-默认 UNION-穿山甲   CPC-点击量  CPM-展示量 OCPM-转化量
        //如果下载方式是下载链接
        if ("DOWNLOAD_URL".equals(thAd.getDownloadType()) || "APP".equals(thAd.getLandingType())) {
            if (thAd.getDownloadUrl() == null || thAd.getDownloadUrl().equals("")) {
                throw new Exception("下载链接不能为空");
            }
            if (thAd.getAdPackage() == null || thAd.getAdPackage().equals("")) {
                throw new Exception("应用包名不能为空");
            }
        }
        if (thAd.getBudgetMode() == null || thAd.getBudgetMode().equals("")) {
            throw new Exception("广告预算类型不能为空");
        }
        if (thAd.getBudget() == null) {
            throw new Exception("广告预算不能为空");
        }
        if (thAd.getStartTime() == null || thAd.getStartTime().equals("")) {
            throw new Exception("广告投放起始时间不为空");
        }
        if (thAd.getEndTime() == null || thAd.getEndTime().equals("")) {
            throw new Exception("广告投放结束时间不为空");
        }
        if (thAd.getScheduleType() == null || thAd.getScheduleType().equals("")) {
            throw new Exception("广告投放时间类型不为空");
        }
        if (thAd.getScheduleTime() == null || thAd.getScheduleTime().length() != 336) {
            throw new Exception("广告投放时段不为空");
        }
        if (thAd.getName() == null || thAd.getName().equals("")) {
            throw new Exception("广告名称不能为空");
        }
        if (thAd.getBid() == null) {
            throw new Exception("广告出价不能为空");
        }

        //如果投放目标是转化量
        if ("PRICING_OCPM".equals(thAd.getPricing())) {
            if (thAd.getConvertId() == null) {
                throw new Exception("转化目标不能为空");
            }
        } else if ("PRICING_CPM".equals(thAd.getPricing())) {

        } else if ("PRICING_CPC".equals(thAd.getPricing())) {
            if (thAd.getBid() < 0.2 || thAd.getBid() > 100) {
                throw new Exception("出价范围在0.2到100之间");
            }
            if ("BUDGET_MODE_DAY".equals(thAd.getBudgetMode())) {
                if (thAd.getBudget() <= 100) {
                    throw new Exception("日预算需要大于100");
                }
            } else if ("BUDGET_MODE_TOTAL".equals(thAd.getBudgetMode())) {
            }
        }

    }

    public ThAd queryThAd(ThAd thAd) throws Exception {

        ThAd selectVO = new ThAd();
        selectVO.setAdvertiserName(thAd.getAdvertiserName());
        selectVO.setCampaignName(thAd.getCampaignName());
        if (thAd.getAdId() == null || thAd.getAdId().equals("")) {
            selectVO.setName(thAd.getName());
        } else {
            selectVO.setAdId(thAd.getAdId());
        }
        selectVO.setUpdateFlag("0");
        List<ThAd> thAds = thAdMapper.selectThAdList(selectVO);
        if (thAds.size() == 1) {
            //查询该条记录是否存在 修改中的记录
            selectVO.setUpdateFlag("1");
            List<ThAd> updateThAds = thAdMapper.selectThAdList(selectVO);
            if (updateThAds.size() == 1) {
                return updateThAds.get(0);
            } else {
                return thAds.get(0);
            }
        } else {
            //查询广告主ID
            ThAdvertiser advertiserSelectVO = new ThAdvertiser();
            advertiserSelectVO.setName(thAd.getAdvertiserName());
            ThAdvertiser advertiser = iThAdvertiserService.selectThAdvertiserByName(advertiserSelectVO);
            if (advertiser == null) {
                throw new Exception("广告主：" + thAd.getAdvertiserName() + ",不存在，请先创建");
            } else {
                thAd.setAdvertiserId(advertiser.getId());
            }
            //查询广告组ID
            ThCampaign campaignSelectVO = new ThCampaign();
            campaignSelectVO.setAdvertiserId(thAd.getAdvertiserId());
            campaignSelectVO.setCampaignName(thAd.getCampaignName());
            List<ThCampaign> thCampaigns = thCampaignService.selectThCampaignList(campaignSelectVO);
            if (thCampaigns.size() == 1) {
                thAd.setCampaignId(thCampaigns.get(0).getCampaignId());
            } else {
                thCampaigns = thCampaignService.selectThCampaignFromTouTiao(campaignSelectVO);
                for (ThCampaign selectResult : thCampaigns) {
                    if (selectResult.getCampaignName().equals(thAd.getCampaignName())) {
                        thAd.setCampaignId(thCampaigns.get(0).getCampaignId());
                        break;
                    }
                }
                if (thAd.getCampaignId() == null) {
                    return null;
                }
            }
            //从头条查询是否存在
            PlanSyncRequest request = new PlanSyncRequest();
            request.setAdvertiser_id(thAd.getAdvertiserId().toString());
            request.setCampaign_id(thAd.getCampaignId().toString());
            request.setAd_name(thAd.getName());
            PlanSyncResponse response = (PlanSyncResponse) touTiaoAdCenterService.selectPlan(request);
            if (response.getCode().equals("0")) {
                List<PlanSyncThAdVO> adVOS = response.getData().getJSONArray("list").toJavaList(PlanSyncThAdVO.class);
                if (adVOS.size() == 1) {
                    thAd.setAdId(adVOS.get(0).getAdId());
                    return converThAd(adVOS.get(0));
                } else {
                    return null;
                }
            } else {
                throw new Exception("查询广告计划出现错误");
            }
        }
    }

    /**
     * 创建广告计划
     *
     * @param ads
     * @param b
     * @param operName
     * @return
     */
    public String importThAd(List<ThAd> ads, boolean b, String operName, String fileName) {

        if (StringUtils.isNull(ads) || ads.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        templateFill(ads, fileName);
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //
        ThAd isExit = null;
        Date now = DateUtils.getNowDate();
        for (ThAd thAd : ads) {
            try {
                if (thAd.getStartTime() != null && !thAd.getStartTime().equals("")) {
                    thAd.setStartTime(sdf2.format(sdf1.parse(thAd.getStartTime())));
                }
                if (thAd.getEndTime() != null && !thAd.getEndTime().equals("")) {
                    thAd.setEndTime(sdf2.format(sdf1.parse(thAd.getEndTime())));
                }
                checkValue(thAd);
                transferArea(thAd);
                isExit = queryThAd(thAd);
                if (isExit == null) {
                    //插入新信息
                    thAd.setCreateBy(operName);
                    thAd.setCreateTime(now);
                    thAd.setStatus("10");
                    this.insertThAd(thAd);
                } else if ("1".equals(isExit.getUpdateFlag())) {
                    //如果存在更新状态的记录，直接更新这条记录
                    thAd.setCreateBy(isExit.getCreateBy());
                    thAd.setCreateTime(isExit.getCreateTime());
                    thAd.setUpdateBy(operName);
                    thAd.setUpdateTime(now);
                    thAd.setId(isExit.getId());
                    this.updateThAd(thAd);
                } else if (isExit.getId() == null) {
                    //插入新信息
                    thAd.setCreateBy(operName);
                    thAd.setAdvertiserId(isExit.getAdvertiserId());
                    thAd.setCampaignId(isExit.getCampaignId());
                    thAd.setCreateTime(now);
                    thAd.setUpdateFlag("1");
                    this.insertThAd(thAd);
                } else {
                    if (thAd.getAdId() != null) {
                        //插入新信息
                        thAd.setAdvertiserId(isExit.getAdvertiserId());
                        thAd.setCampaignId(isExit.getCampaignId());
                        thAd.setCreateBy(operName);
                        thAd.setCreateTime(now);
                        thAd.setUpdateFlag("1");
                        this.insertThAd(thAd);
                    } else {
                        if (isExit.getAdId() == null) {
                            thAd.setCreateBy(isExit.getCreateBy());
                            thAd.setCreateTime(isExit.getCreateTime());
                            thAd.setUpdateBy(operName);
                            thAd.setUpdateTime(now);
                            thAd.setId(isExit.getId());
                            this.updateThAd(thAd);
                        } else {
                            //插入新信息
                            thAd.setAdvertiserId(isExit.getAdvertiserId());
                            thAd.setCampaignId(isExit.getCampaignId());
                            thAd.setAdId(isExit.getAdId());
                            thAd.setCreateBy(operName);
                            thAd.setCreateTime(now);
                            thAd.setUpdateFlag("1");
                            this.insertThAd(thAd);
                        }
                    }
                }

                successNum++;
                successMsg.append("<br/>" + successNum + "、广告名称 " + thAd.getName() + " 导入成功");

            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、广告名称 " + thAd.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    /**
     * 导入广告计划和创意
     *
     * @param thAdCreativityImoprts
     * @param b
     * @param operName
     * @param originalFilename
     * @return
     */
    @Override
    public String importThAdAndThCreativity(List<ThAdCreativityImport> thAdCreativityImoprts, boolean b, String operName, String originalFilename) {
        if (StringUtils.isNull(thAdCreativityImoprts) || thAdCreativityImoprts.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        templateFill(originalFilename, thAdCreativityImoprts);
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //
        ThAd isExit = null;
        Date now = DateUtils.getNowDate();
        for (ThAdCreativityImport thAdCreativityImoprt : thAdCreativityImoprts) {
            try {

                importOneThAdCreativityImoprt(thAdCreativityImoprt, sdf1, sdf2, now, operName);

                successNum++;
                successMsg.append("<br/>" + successNum + "、广告名称 " + thAdCreativityImoprt.getName() + " 导入成功");

            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、广告名称 " + thAdCreativityImoprt.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Transactional(rollbackFor = Exception.class)
    public void importOneThAdCreativityImoprt(ThAdCreativityImport imoprt, SimpleDateFormat sdf1, SimpleDateFormat sdf2, Date now, String operName) throws Exception {
        //广告计划
        ThAd thAd = new ThAd();
        BeanUtils.copyProperties(imoprt, thAd);
        if (thAd.getStartTime() != null && !thAd.getStartTime().equals("")) {
            thAd.setStartTime(sdf2.format(sdf1.parse(thAd.getStartTime())));
        }
        if (thAd.getEndTime() != null && !thAd.getEndTime().equals("")) {
            thAd.setEndTime(sdf2.format(sdf1.parse(thAd.getEndTime())));
        }
        checkValue(thAd);
        transferArea(thAd);
        ThAd isExit = queryThAd(thAd);
        if (isExit == null) {
            //插入新信息
            thAd.setCreateBy(operName);
            thAd.setCreateTime(now);
            thAd.setStatus("10");
            this.insertThAd(thAd);
        } else if ("1".equals(isExit.getUpdateFlag())) {
            //如果存在更新状态的记录，直接更新这条记录
            thAd.setCreateBy(isExit.getCreateBy());
            thAd.setCreateTime(isExit.getCreateTime());
            thAd.setUpdateBy(operName);
            thAd.setUpdateTime(now);
            thAd.setId(isExit.getId());
            this.updateThAd(thAd);
        } else if (isExit.getId() == null) {
            //插入新信息
            thAd.setCreateBy(operName);
            thAd.setAdvertiserId(isExit.getAdvertiserId());
            thAd.setCampaignId(isExit.getCampaignId());
            thAd.setCreateTime(now);
            thAd.setUpdateFlag("1");
            this.insertThAd(thAd);
        } else {
            if (thAd.getAdId() != null) {
                //插入新信息
                thAd.setAdvertiserId(isExit.getAdvertiserId());
                thAd.setCampaignId(isExit.getCampaignId());
                thAd.setCreateBy(operName);
                thAd.setCreateTime(now);
                thAd.setUpdateFlag("1");
                this.insertThAd(thAd);
            } else {
                if (isExit.getAdId() == null) {
                    thAd.setCreateBy(isExit.getCreateBy());
                    thAd.setCreateTime(isExit.getCreateTime());
                    thAd.setUpdateBy(operName);
                    thAd.setUpdateTime(now);
                    thAd.setId(isExit.getId());
                    this.updateThAd(thAd);
                } else {
                    //插入新信息
                    thAd.setAdvertiserId(isExit.getAdvertiserId());
                    thAd.setCampaignId(isExit.getCampaignId());
                    thAd.setAdId(isExit.getAdId());
                    thAd.setCreateBy(operName);
                    thAd.setCreateTime(now);
                    thAd.setUpdateFlag("1");
                    this.insertThAd(thAd);
                }
            }
        }
        //广告创意创建
        ThCreativity thCreativity = new ThCreativity();
        BeanUtils.copyProperties(imoprt, thCreativity);
        ThAd select = new ThAd();
        select.setAdvertiserName(thAd.getAdvertiserName());
        select.setCampaignName(thAd.getCampaignName());
        select.setName(thAd.getName());
        List<ThAd> thAds = selectThAdList(select);
        if (thAds.size() == 1) {
            thCreativity.setAdvertiserId(thAds.get(0).getAdvertiserId().toString());
            if (thAds.get(0).getAdId() != null) {
                thCreativity.setAdId(thAds.get(0).getAdId().toString());
            }
            thCreativity.setThAdId(thAds.get(0).getId().toString());
        }
        //广告创意 素材信息等记录创建
        convertField(thCreativity, imoprt, now, operName);
        //广告创意公共属性插入
        thCreativityService.insertThCreativity(thCreativity);

        //如果是程序化创意
        if (thCreativity.getCreativeMaterialMode() != null && !"".equals(thCreativity.getCreativeMaterialMode())) {
            ThCreativityCreatives creativityCreatives = null;
            //程序化创意 自动根据标题素材组合创意
            for (ThCreativityTitle tit : thCreativity.getTitle_list()) {

                for (ThCreativityImage creativityImage : thCreativity.getImage_list()) {

                    creativityCreatives = new ThCreativityCreatives();
                    creativityCreatives.setTitle(tit.getTitle());
                    creativityCreatives.setTitleId(tit.getId());
                    creativityCreatives.setCreativeWordIds(tit.getCreativeWordIds());
                    creativityCreatives.setImageMode(creativityImage.getImageMode());
                    creativityCreatives.setImageIds(creativityImage.getImageIds());
                    creativityCreatives.setImageId(creativityImage.getImageId());
                    creativityCreatives.setVideoId(creativityImage.getVideoId());
                    creativityCreatives.setThirdPartyId(thCreativity.getThirdIndustryId());
                    creativityCreatives.setCreativityId(thCreativity.getId());
                    creativityCreativesService.insertThCreativityCreatives(creativityCreatives);
                }

            }
        }

    }

    private void convertField(ThCreativity thCreativity, ThAdCreativityImport imoprt, Date now, String operName) throws Exception {

        String titleStr = imoprt.getTitleStr();
        String imageStr = imoprt.getImageStr();
        String creativesStr = imoprt.getCreativesStr();
        ThCreativityTitle title = null;
        ThCreativityImage image = null;
        ThCreativityCreatives creatives = null;
        //查询创意分类id值
        String industryName = thCreativity.getThirdIndustryId();
        ThAdIndustry industry = adIndustryService.selectThAdIndustryByIndustryNameAndLevel(industryName, "3");
        thCreativity.setThirdIndustryId(industry.getIndustryId());

        if (thCreativity.getCreativeMaterialMode() != null && !"".equals(thCreativity.getCreativeMaterialMode())) {
            thCreativity.setTitle_list(new ArrayList<>());
            thCreativity.setImage_list(new ArrayList<>());

            //拆分标题列表
            if (titleStr != null && !"".equals(titleStr)) {
                String[] titles = titleStr.split(",");
                for (String tit : titles) {
                    title = new ThCreativityTitle();
                    title.setCreateBy(operName);
                    title.setCreateTime(now);
                    title.setTitle(tit);
                    thCreativity.getTitle_list().add(title);
                }
            }
            //拆分素材列表
            if (imageStr != null && !"".equals(imageStr)) {
                String[] images = imageStr.split("\n");
                //每个素材
                for (String imag : images) {
                    image = new ThCreativityImage();
                    //每个素材中的一个属性
                    String[] imageField = imag.split(",");
                    if (imageField.length > 1) {
                        //查询素材类型对应code
                        SysDictData selectVO = new SysDictData();
                        selectVO.setDictLabel(imageField[0]);
                        List<SysDictData> sysDictData = sysDictDataService.selectDictDataList(selectVO);
                        if (sysDictData.size() != 0) {
                            imageField[0] = sysDictData.get(0).getDictValue();
                        }
                        //视频素材
                        if (imageField[0].contains("VIDEO")) {
                            if (imageField.length < 3) {
                                throw new Exception(imoprt.getName() + "的视频素材资料不足");
                            } else {
                                String iamgeId = thAdMediaMateriaService.selectMediaMateriaIdByFileName(imoprt, imageField[1]);
                                String videoId = thAdMediaMateriaService.selectMediaMateriaIdByFileName(imoprt, imageField[2]);
                                image.setImageId(iamgeId);
                                image.setVideoId(videoId);
                                image.setImageMode(imageField[0]);
                            }
                        } else {
                            //图片素材
                            if (imageField.length < 2) {
                                throw new Exception(imoprt.getName() + "的图片素材资料不足");
                            } else {
                                String imageId = null;
                                for (int i = 1; i < imageField.length; i++) {
                                    imageId = thAdMediaMateriaService.selectMediaMateriaIdByFileName(imoprt, imageField[i]);
                                    image.setImageIds((image.getImageIds() == null ? "" : image.getImageIds()) + imageId);
                                    if (i != imageField.length - 1) {
                                        image.setImageIds(image.getImageIds() + ",");
                                    }
                                }
                                image.setImageMode(imageField[0]);
                            }
                        }
                        thCreativity.getImage_list().add(image);
                    }
                }
            }


        } else {

            //拆分自定义创意
            if (creativesStr != null && !"".equals(creativesStr)) {
                thCreativity.setCreatives(new ArrayList<>());
                String[] creativesArray = creativesStr.split("\n");
                for (String creativy : creativesArray) {
                    creatives = new ThCreativityCreatives();
                    String[] creativiesField = creativy.split(",");
                    if (creativiesField.length >= 3) {
                        if (creativiesField[0].contains("VIDEO")) {
                            if (creativiesField.length <= 3) {
                                throw new Exception(imoprt.getName() + "的视频素材资料不足");
                            } else {
                                creatives.setImageMode(creativiesField[0]);
                                creatives.setTitle(creativiesField[1]);
                                creatives.setImageId(creativiesField[2]);
                                creatives.setVideoId(creativiesField[3]);
                            }
                        } else {
                            if (creativiesField.length < 3) {
                                throw new Exception(imoprt.getName() + "的图片素材资料不足");
                            } else {
                                creatives.setImageMode(creativiesField[0]);
                                creatives.setTitle(creativiesField[1]);
                                for (int i = 2; i < creativiesField.length; i++) {
                                    creatives.setImageIds((creatives.getImageIds() == null ? "" : creatives.getImageIds()) + creativiesField[i]);
                                    if (i != creativiesField.length - 1) {
                                        creatives.setImageIds(creatives.getImageIds() + ",");
                                    }
                                }
                            }
                        }
                        thCreativity.getCreatives().add(creatives);
                    }
                }
            }
        }

    }


    private void transferArea(ThAd thAd) {

        String cit = areaMapper.selectIdByNames(Convert.toStrArray(thAd.getCity()));
        if (cit != null) {
            thAd.setCity(cit);
        }

    }

    /**
     * 停用广告计划
     *
     * @param id
     */
    public int stopPlanById(String id) throws Exception {
        ThAd thAd = thAdMapper.selectThAdById(Long.valueOf(id));
        thAd.setStatus("0");
        thAdMapper.updateThAd(thAd);
        updatePlanStatus(id, "disable");
        return 1;
    }

    /**
     * 启用广告计划
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int startPlanById(String id) throws Exception {

        ThAd thAd = thAdMapper.selectThAdById(Long.valueOf(id));
        //启用之前首先判断广告组是否存在，若不存在则创建
        ThAdvertiser advertiser = new ThAdvertiser();
        advertiser.setName(thAd.getAdvertiserName());
        advertiser = iThAdvertiserService.selectThAdvertiserByName(advertiser);
        if (advertiser == null) {
            throw new Exception("广告主：" + thAd.getAdvertiserName() + " 不存在");
        }
        thAd.setAdvertiserId(advertiser.getId());
        ThCampaign camSelectVO = new ThCampaign();
        camSelectVO.setAdvertiserId(advertiser.getId());
        camSelectVO.setCampaignName(thAd.getCampaignName());
        List<ThCampaign> thCampaigns = thCampaignService.selectThCampaignFromTouTiao(camSelectVO);
        ThCampaign selectResult = null;
        for (ThCampaign select : thCampaigns) {
            if (select.getCampaignName().equals(thAd.getCampaignName())) {
                selectResult = select;
                break;
            }
        }
        //更新广告创意的状态
        ThCreativity thCreativity = thCreativityService.selectThCreativityByThAdId(id);
        if(thCreativity!=null&&thCreativity.getStatus()!=null&&!thCreativity.getStatus().equals("")){
            thCreativity.setStatus("2");
            thCreativityService.updateThCreativity(thCreativity);
        }

        if (selectResult != null) {
            //广告组存在，直接创建广告计划
            thAd.setCampaignId(selectResult.getCampaignId());
            convert(thAd);
            ResponseVO response = null;
            int row = 0;
            if (thAd.getAdId() == null) {
                thAd.setStatus("2");
                thAdMapper.updateThAd(thAd);
                response = (PlanCreateResponse) touTiaoAdCenterService.createAdPlan(thAd);
                if (response.getCode().equals("0")) {
                    thAd.setAdId(((PlanCreateResponse) response).getData().getLong("ad_id"));
                } else {
                    throw new Exception("广告计划'" + thAd.getName() + "'创建失败，错误信息：" + response.getMessage());
                }
                thAdMapper.updateThAd(thAd);
            } else {
                //如果广告计划已经创建过，直接启用
                row = updatePlanStatus(id, "enable");
            }
            if (row == 1 || response.getCode().equals("0")) {
                return 1;
            } else {
                throw new Exception("<br/><br/>广告计划'" + thAd.getName() + "'启动失败，平台错误码：" + response.getCode() + "，错误信息：" + response.getMessage());
            }
        } else if (selectResult == null) {
            //广告组不存在，直接创建广告计划和广告组
            //创建广告组
            ThCampaign camCreateVO = new ThCampaign();
            camCreateVO.setAdvertiserId(advertiser.getId());
            camCreateVO.setBudget(thAd.getGroupBudget());
            camCreateVO.setBudgetMode(thAd.getGroupBudgetMode());
            camCreateVO.setLandingType(thAd.getLandingType());
            camCreateVO.setCampaignName(thAd.getCampaignName());
            int row = thCampaignService.createThCampaign(camCreateVO);
            if (row == 0) {
                throw new Exception("广告计划：" + thAd.getName() + " 对应广告组:" + thAd.getCampaignName() + " 创建失败");
            }
            thAd.setCampaignId(camCreateVO.getCampaignId());
            convert(thAd);
            ResponseVO response = null;
            row = 0;
            thAd.setStatus("2");
            thAdMapper.updateThAd(thAd);
            response = (PlanCreateResponse) touTiaoAdCenterService.createAdPlan(thAd);
            if (response.getCode().equals("0")) {
                thAd.setAdId(((PlanCreateResponse) response).getData().getLong("ad_id"));
            } else {
                throw new Exception("广告计划'" + thAd.getName() + "'创建失败，错误信息：" + response.getMessage());
            }
            thAdMapper.updateThAd(thAd);
            if (row == 1 || response.getCode().equals("0")) {
                return 1;
            } else {
                throw new Exception("<br/><br/>广告计划'" + thAd.getName() + "'启动失败，平台错误码：" + response.getCode() + "，错误信息：" + response.getMessage());
            }
        } else {
            throw new Exception("广告计划：" + thAd.getName() + " 与广告组:" + thAd.getCampaignName() + " 无法关联");
        }

    }

    /**
     * 将从头条查询到的广告计划所转化的VO 转化为ThAd
     *
     * @param adVO
     * @return
     * @throws Exception
     */
    private ThAd converThAd(PlanSyncThAdVO adVO) {
        adVO.setAc(StringUtils.join(adVO.getAudience().getAc(), ","));
        adVO.setAppIds(StringUtils.join(adVO.getAudience().getApp_ids(), ","));
        adVO.setInterestTags(StringUtils.join(adVO.getAudience().getInterest_tags()));
        adVO.setCity(StringUtils.join(adVO.getAudience().getCity(), ","));
        adVO.setDistrict(adVO.getAudience().getDistrict());
        adVO.setPlatform(StringUtils.join(adVO.getAudience().getPlatform(), ","));
        adVO.setAdTag(StringUtils.join(adVO.getAudience().getAd_tag(), ","));
        adVO.setAppCategory(StringUtils.join(adVO.getAudience().getApp_category(), ","));
        adVO.setRetargetingTagsExclude(StringUtils.join(adVO.getAudience().getRetargeting_tags_exclude(), ","));
        adVO.setRetargetingTagsInclude(StringUtils.join(adVO.getAudience().getRetargeting_tags_include(), ","));
        adVO.setArticleCategory(StringUtils.join(adVO.getAudience().getArticle_category(), ","));
        adVO.setAppBehaviorTarget(adVO.getAudience().getApp_behavior_target());
        adVO.setGender(adVO.getAudience().getGender());
        adVO.setAge(StringUtils.join(adVO.getAudience().getAge(), ","));
        adVO.setCarrier(StringUtils.join(adVO.getAudience().getCarrier(), ","));
        if (adVO.getOpt_status() != null && adVO.getOpt_status().equals("AD_STATUS_ENABLE")) {
            adVO.setStatus("2");
        } else {
            adVO.setStatus("0");
        }
        return adVO;
    }

    /**
     * 同步广告计划
     *
     * @return
     */
    @Override
    public int synchronizedPlan(ThAdvertiser advertiser) throws Exception {

        String userName = (String) PermissionUtils.getPrincipalProperty("loginName");

        PlanSyncRequest request = new PlanSyncRequest();
        request.setAdvertiser_id(advertiser.getId().toString());
        request.setPage(1);
        request.setPage_size(1000);
        if (advertiser.getCampaignId() != null) {
            request.setCampaign_id(advertiser.getCampaignId().toString());
        }
        ThAd updateAd = null;
        ThCampaign thCampaign = null;
        PlanSyncResponse response = (PlanSyncResponse) touTiaoAdCenterService.selectPlan(request);
        Date now = new Date();
        if (response.getCode().equals("0")) {

            List<PlanSyncThAdVO> adVOS = response.getData().getJSONArray("list").toJavaList(PlanSyncThAdVO.class);
            for (PlanSyncThAdVO adVO : adVOS) {
                try {
                    thCampaign = thCampaignService.selectThCampaignById(adVO.getCampaignId());
                    if (thCampaign != null) {
                        adVO.setCampaignName(thCampaign.getCampaignName());
                    }
                    adVO.setAdvertiserName(advertiser.getName());
                    converThAd(adVO);
                    updateAd = thAdMapper.selectThAdByAdId(adVO);
                    if (updateAd != null) {
                        adVO.setId(updateAd.getId());
                        adVO.setUpdateTime(now);
                        adVO.setUpdateBy(userName);
                        thAdMapper.updateThAd(adVO);
                    } else {
                        adVO.setCreateBy(userName);
                        adVO.setCreateTime(now);
                        thAdMapper.insertThAd(adVO);
                    }
                } catch (Exception e) {
                    log.error("同步更新广告计划出现错误：", e);
                }
            }
            return 1;
        } else {
            throw new Exception("<br/><br/>广告计划同步失败，平台错误码：" + response.getCode() + "，错误信息：" + response.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePlanStatus(String id, String status) throws Exception {
        ThAd thAd = thAdMapper.selectThAdById(Long.valueOf(id));
        String state = null;
        if (status != null) {
            if (status.equals("enable")) {
                state = "2";
            } else if (status.equals("delete")) {
                state = "0";
                thAd.setDelFlag("2");
            } else if (status.equals("disable")) {
                state = "0";
            } else {
                return 0;
            }
        }
        thAd.setStatus(state);
        thAdMapper.updateThAd(thAd);
        if (thAd.getAdId() == null || thAd.getUpdateFlag().equals("1")) {
            return 1;
        }
        PlanUpdateStatusRequest request = new PlanUpdateStatusRequest();
        request.setAd_ids(new String[]{thAd.getAdId().toString()});
        request.setAdvertiser_id(thAd.getAdvertiserId().toString());
        request.setOpt_status(status);
        PlanUpdateStatusResponse response = (PlanUpdateStatusResponse) touTiaoAdCenterService.updateAdPlanStatus(request);
        if (response.getCode().equals("0")) {
            //更新广告计划状态时，同时更新广告创意的状态
            ThCreativity creativity = new ThCreativity();
            creativity.setStatus(state);
            creativity.setThAdId(id);
            thCreativityService.updateThCreativityByThAdId(creativity);
            return 1;
        } else {
            throw new Exception("<br/><br/>广告计划'" + thAd.getName() + "'修改失败，平台错误码：" + response.getCode() + "，错误信息：" + response.getMessage());
        }


    }


    //将逗号分隔的字符串变成数组
    private void convert(ThAd thAd) {
        String str = null;
        //年龄段
        str = thAd.getAge();
        if (str != null && !str.equals("")) {
            thAd.setAges(Convert.toStrArray(str));
        } else {
            thAd.setAges(new String[]{});
        }
        //受众运营商
        str = thAd.getCarrier();
        if (str != null && !str.equals("")) {
            thAd.setCarriers(Convert.toStrArray(str));
        } else {
            thAd.setCarriers(new String[]{});
        }
        //网络类型
        str = thAd.getAc();
        if (str != null && !str.equals("")) {
            thAd.setAcs(Convert.toStrArray(str));
        } else {
            thAd.setAcs(new String[]{});
        }
        //受众文章分类
        str = thAd.getArticleCategory();
        if (str != null && !str.equals("")) {
            thAd.setArticle_category(Convert.toStrArray(str));
        } else {
            thAd.setArticle_category(new String[]{});
        }
        //受众平台
        str = thAd.getPlatform();
        if (str != null && !str.equals("")) {
            thAd.setPlatforms(Convert.toStrArray(str));
        } else {
            thAd.setPlatforms(new String[]{});
        }
        //地域定向城市或者区县列表
        str = thAd.getCity();
        if (str != null && !str.equals("")) {
            thAd.setCitys(Convert.toStrArray(str));
        } else {
            thAd.setCitys(new String[]{});
        }
        //兴趣分类
        str = thAd.getAdTag();
        if (str != null && !str.equals("")) {
            thAd.setAd_tag(Convert.toStrArray(str));
        } else {
            thAd.setAd_tag(new String[]{});
        }
        //兴趣关键词
        str = thAd.getInterestTags();
        if (str != null && !str.equals("")) {
            thAd.setInterest_tags(Convert.toStrArray(str));
        } else {
            thAd.setInterest_tags(new String[]{});
        }
        //APP行为按分类集合
        str = thAd.getAppCategory();
        if (str != null && !str.equals("")) {
            thAd.setApp_category(Convert.toStrArray(str));
        } else {
            thAd.setApp_category(new String[]{});
        }
        //APP行为定向,APP集合
        str = thAd.getAppIds();
        if (str != null && !str.equals("")) {
            thAd.setApp_ids(Convert.toStrArray(str));
        } else {
            thAd.setApp_ids(new String[]{});
        }
        //定向人群包列表
        str = thAd.getRetargetingTagsInclude();
        if (str != null && !str.equals("")) {
            thAd.setRetargeting_tags_include(Convert.toStrArray(str));
        } else {
            thAd.setRetargeting_tags_include(new String[]{});
        }
        //排除人群包列表
        str = thAd.getRetargetingTagsExclude();
        if (str != null && !str.equals("")) {
            thAd.setRetargeting_tags_exclude(Convert.toStrArray(str));
        } else {
            thAd.setRetargeting_tags_exclude(new String[]{});
        }
    }

    /**
     * 调用广告计划修改接口 修改广告计划
     *
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateTouTiaoPlanById(String id) throws Exception {
        //查询更新的记录副本
        ThAd updateThAd = thAdMapper.selectThAdById(Long.valueOf(id));
        if (updateThAd == null) {
            throw new Exception("更新出现错误，无法根据id查询到更新的记录。");
        }
        //查询原纪录 并将其删除
        ThAd selectVO = new ThAd();
        selectVO.setUpdateFlag("0");
        selectVO.setAdId(updateThAd.getAdId());
        selectVO.setAdvertiserId(updateThAd.getAdvertiserId());
        selectVO.setCampaignId(updateThAd.getCampaignId());
        List<ThAd> thAds = thAdMapper.selectThAdList(selectVO);
        if (thAds.size() == 1) {
            updateThAd.setStatus(thAds.get(0).getStatus());
            thAdMapper.deleteThAdById(thAds.get(0).getId());
        }
        //更新
        updateThAd.setUpdateFlag("0");
        thAdMapper.updateThAd(updateThAd);

        PlanUpdateRequest updateRequest = new PlanUpdateRequest();
        convert(updateThAd);
        BeanUtils.copyProperties(updateThAd, updateRequest);

        //从头条查询是否存在
        PlanSyncRequest syncRequest = new PlanSyncRequest();
        syncRequest.setAdvertiser_id(updateRequest.getAdvertiserId().toString());
        syncRequest.setCampaign_id(updateThAd.getCampaignId().toString());
        syncRequest.setIds(new String[]{updateThAd.getAdId().toString()});
        syncRequest.setAd_name(updateThAd.getName());
        PlanSyncResponse response = (PlanSyncResponse) touTiaoAdCenterService.selectPlan(syncRequest);
        if (response.getCode().equals("0")) {
            List<PlanSyncThAdVO> adVOS = response.getData().getJSONArray("list").toJavaList(PlanSyncThAdVO.class);

            updateRequest.setModify_time(adVOS.get(0).getModify_time());
            PlanUpdateResponse updateResponse = (PlanUpdateResponse) touTiaoAdCenterService.updateAdPlan(updateRequest);
            if (updateResponse.getCode().equals("0")) {
                return 1;
            } else {
                throw new Exception("头条响应码：" + updateResponse.getCode() + ",出现错误：" + updateResponse.getMessage());
            }
        } else {
            throw new Exception("查询该广告计划出现错误");
        }
    }

    //查询已经同步到头条的广告计划
    public List<ThAd> selectSyncThAdList(ThAd thAd) {
        return thAdMapper.selectSyncThAdList(thAd);
    }

}
