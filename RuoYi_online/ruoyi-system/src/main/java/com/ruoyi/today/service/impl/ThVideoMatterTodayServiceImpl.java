package com.ruoyi.today.service.impl;

import java.io.FileInputStream;
import java.util.List;

import com.ruoyi.today.domain.ThAdMateria;
import com.ruoyi.today.domain.ThVideoMatter;
import com.ruoyi.today.domain.ThVideoMatterToday;
import com.ruoyi.today.mapper.ThVideoMatterTodayMapper;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThVideoMatterService;
import com.ruoyi.today.service.IThVideoMatterTodayService;
import com.ruoyi.today.tools.PmsUploadUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 素材在每个广告主的素材idService业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-10
 */
@Service
public class ThVideoMatterTodayServiceImpl implements IThVideoMatterTodayService
{
    @Autowired
    private ThVideoMatterTodayMapper thVideoMatterTodayMapper;
    @Autowired
    private AdCenterService touTiaoAdCenterService;
    @Autowired
    private IThVideoMatterService thVideoMatterService;


    /**
     * 查询素材在每个广告主的素材id
     * 
     * @param id 素材在每个广告主的素材idID
     * @return 素材在每个广告主的素材id
     */
    @Override
    public ThVideoMatterToday selectThVideoMatterTodayById(Long id)
    {
        return thVideoMatterTodayMapper.selectThVideoMatterTodayById(id);
    }

    /**
     * 查询素材在每个广告主的素材id列表
     * 
     * @param thVideoMatterToday 素材在每个广告主的素材id
     * @return 素材在每个广告主的素材id
     */
    @Override
    public List<ThVideoMatterToday> selectThVideoMatterTodayList(ThVideoMatterToday thVideoMatterToday)
    {
        return thVideoMatterTodayMapper.selectThVideoMatterTodayList(thVideoMatterToday);
    }

    /**
     * 新增素材在每个广告主的素材id
     * 
     * @param thVideoMatterToday 素材在每个广告主的素材id
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertThVideoMatterToday(ThVideoMatterToday thVideoMatterToday) throws Exception {
        FileInputStream fileInputStream = null;
        try{
            //从文件服务器下载素材到本地
            ThVideoMatter thVideoMatter = thVideoMatterService.selectThVideoMatterById(thVideoMatterToday.getMatterId());
            String loadFile = PmsUploadUtil.downLoadFile(thVideoMatter.getMatter(),thVideoMatter.getFileName());
            //上传至头条
            ThAdMateria thAdMateria = new ThAdMateria();
            thAdMateria.setLocalPath(loadFile);
            thAdMateria.setAdvertiserId(thVideoMatterToday.getAdvertiserId());
//            thAdMateria.setMd5(DigestUtils.md5Hex(new FileInputStream(path)););
            touTiaoAdCenterService.uploadVideoFile(thAdMateria);
        }catch (Exception e){

        }


        //插入素材id
        return thVideoMatterTodayMapper.insertThVideoMatterToday(thVideoMatterToday);
    }

    /**
     * 修改素材在每个广告主的素材id
     * 
     * @param thVideoMatterToday 素材在每个广告主的素材id
     * @return 结果
     */
    @Override
    public int updateThVideoMatterToday(ThVideoMatterToday thVideoMatterToday)
    {
        return thVideoMatterTodayMapper.updateThVideoMatterToday(thVideoMatterToday);
    }

    /**
     * 删除素材在每个广告主的素材id对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteThVideoMatterTodayByIds(String ids)
    {
        return thVideoMatterTodayMapper.deleteThVideoMatterTodayByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除素材在每个广告主的素材id信息
     * 
     * @param id 素材在每个广告主的素材idID
     * @return 结果
     */
    public int deleteThVideoMatterTodayById(Long id)
    {
        return thVideoMatterTodayMapper.deleteThVideoMatterTodayById(id);
    }
}
