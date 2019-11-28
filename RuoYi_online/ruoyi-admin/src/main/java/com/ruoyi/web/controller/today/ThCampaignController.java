package com.ruoyi.web.controller.today;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.today.domain.ThAd;
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.domain.ThUserAdvertiser;
import com.ruoyi.today.service.IThAdService;
import com.ruoyi.today.service.IThAdvertiserService;
import com.ruoyi.today.service.IThUserAdvertiserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.today.domain.ThCampaign;
import com.ruoyi.today.service.IThCampaignService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 广告组Controller
 *
 * @author ruoyi
 * @date 2019-08-14
 */
@Controller
@RequestMapping("/today/campaign")
public class ThCampaignController extends BaseController {
    private String prefix = "today/campaign";

    @Autowired
    private IThCampaignService thCampaignService;
    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private IThAdService thAdService;
    @Autowired
    private IThUserAdvertiserService thUserAdvertiserService;

    @RequiresPermissions("today:campaign:view")
    @GetMapping()
    public String campaign() {
        return prefix + "/campaign";
    }

    /**
     * 复制广告组
     */
    @PostMapping("/copy")
    @ResponseBody
    public AjaxResult copy(String id, String level, Integer num, String name) {

        //判断是复制广告计划还是广告组
        if (level == null || num == null || id == null || num <= 0) {
            return AjaxResult.error("参数错误");
        }
        ThCampaign copyCampaign = null;
        List<ThAd> copyThAds = null;
        String baseName = name;
        try {
            for (int i = 1; i <= num; i++) {
                name = baseName + i;
                if (level.equals("campaign")) {
                    //查出要复制的广告组
                    copyCampaign = thCampaignService.selectThCampaignById(Long.valueOf(id));
                    copyCampaign.setOperation("disable");
                    copyCampaign.setCampaignName(name);
                    copyCampaign.setCampaignId(null);
                    //查询要复制的广告组下面的计划
                    ThAd thAd = new ThAd();
                    thAd.setCampaignId(Long.valueOf(id));
                    copyThAds = thAdService.selectThAdList(thAd);
                } else if (level.equals("plan")) {
                    //查出要复制的广告计划
                    copyThAds = new ArrayList<>();
                    ThAd selectThAd = new ThAd();
                    selectThAd.setAdId(Long.valueOf(id));
                    List<ThAd> thAds = thAdService.selectThAdList(selectThAd);
                    for(ThAd d:thAds){
                        d.setName(name);
                    }
                    copyThAds.addAll(thAds);
                } else {
                    return AjaxResult.error("参数错误");
                }
                thCampaignService.copy(copyCampaign, copyThAds);
            }
        } catch (Exception e) {
            logger.error("id=" + id + ",复制时出现错误", e);
            return AjaxResult.error("复制时出现错误:" + e.getMessage());
        }


        return AjaxResult.success("复制成功");
    }

    /**
     * 查询广告组列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThCampaign thCampaign) {
        ThUserAdvertiser thUserAdvertiser = new ThUserAdvertiser();
        thUserAdvertiser.setUserName(ShiroUtils.getLoginName());
        List<ThUserAdvertiser> thUserAdvertisers = thUserAdvertiserService.selectThUserAdvertiserList(thUserAdvertiser);
        List<String> advertiesIds = new ArrayList<>();
        for (ThUserAdvertiser userAdvertiser : thUserAdvertisers) {
            advertiesIds.add(userAdvertiser.getAdvertiserId());
        }
        startPage();
        thCampaign.setAdvertiesIds(advertiesIds);
        List<ThCampaign> list = thCampaignService.selectThCampaignList(thCampaign);
        return getDataTable(list);
    }

    /**
     * 导出广告组列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThCampaign thCampaign) {
        List<ThCampaign> list = thCampaignService.selectThCampaignList(thCampaign);
        ExcelUtil<ThCampaign> util = new ExcelUtil<ThCampaign>(ThCampaign.class);
        return util.exportExcel(list, "campaign");
    }

    /**
     * 新增广告组
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存广告组
     */
    @Log(title = "广告组", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThCampaign thCampaign) {
        return toAjax(thCampaignService.insertThCampaign(thCampaign));
    }

    /**
     * 同步广告组
     *
     * @return
     */
    @PostMapping("/syncCampaign")
    @ResponseBody
    public AjaxResult syncCampaign(String ids) {

        StringBuilder msg = new StringBuilder();
        ThAdvertiser thAdvertiser = new ThAdvertiser();
        thAdvertiser.setStatus("STATUS_ENABLE");
        if (ids != null && !ids.equals("")) {
            thAdvertiser.setId(Long.valueOf(ids));
        }
        List<ThAdvertiser> thAdvertisers = thAdvertiserService.selectThAdvertiserList(thAdvertiser);
        for (ThAdvertiser advertiser : thAdvertisers) {
            try {
                thCampaignService.syncCampaign(advertiser);
            } catch (Exception e) {
                logger.error("出现错误：", e);
                msg.append(e.getMessage());
            }
        }
        if (msg.length() == 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error(msg.toString());
        }
    }

    /**
     * 修改广告组
     */
    @GetMapping("/edit/{campaignId}")
    public String edit(@PathVariable("campaignId") Long campaignId, ModelMap mmap) {
        ThCampaign thCampaign = thCampaignService.selectThCampaignById(campaignId);
        mmap.put("thCampaign", thCampaign);
        return prefix + "/edit";
    }

    /**
     * 修改保存广告组
     */
    @Log(title = "广告组", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThCampaign thCampaign) {
        return toAjax(thCampaignService.updateThCampaign(thCampaign));
    }

    /**
     * 删除广告组
     */
    @Log(title = "广告组", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(thCampaignService.deleteThCampaignByIds(ids));
    }
}
