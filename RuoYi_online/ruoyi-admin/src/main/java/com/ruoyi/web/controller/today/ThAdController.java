package com.ruoyi.web.controller.today;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.today.domain.*;
import com.ruoyi.today.service.IThAdvertiserService;
import com.ruoyi.today.service.IThCreativityService;
import com.ruoyi.today.service.IThUserAdvertiserService;
import com.ruoyi.web.controller.tool.HlExcelUtils;
import org.apache.poi.ss.formula.functions.T;
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
import com.ruoyi.today.service.IThAdService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 广告计划Controller
 *
 * @author ruoyi
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/today/ad")
public class ThAdController extends BaseController {
    private String prefix = "today/ad";

    @Autowired
    private IThAdService thAdService;
    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private IThCreativityService thCreativityService;
    @Autowired
    private IThUserAdvertiserService thUserAdvertiserService;

    @RequiresPermissions("today:upload:view")
    @GetMapping("up")
    public String upload() {
        return prefix + "/upload";
    }

    @RequiresPermissions("today:ad:view")
    @GetMapping()
    public String ad() {
        return prefix + "/update";
    }

    @GetMapping("/newAddManager")
    public String adNewAdd() {
        return prefix + "/newAddManager";
    }

    /**
     * 查询广告计划列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThAd thAd, String opt) {
        List<ThAd> list = null;
        ThUserAdvertiser thUserAdvertiser = new ThUserAdvertiser();
        thUserAdvertiser.setUserName(ShiroUtils.getLoginName());
        List<ThUserAdvertiser> thUserAdvertisers = thUserAdvertiserService.selectThUserAdvertiserList(thUserAdvertiser);
        List<String> advertiesIds = new ArrayList<>();
        for (ThUserAdvertiser userAdvertiser : thUserAdvertisers) {
            advertiesIds.add(userAdvertiser.getAdvertiserId());
        }
        thAd.setAdvertiesIds(advertiesIds);
        if ("normal".equals(opt)) {
            startPage();
            list = thAdService.selectSyncThAdList(thAd);
        } else {
            startPage();
            list = thAdService.selectThAdList(thAd);
        }
        return getDataTable(list);
    }

    /**
     * 导入
     *
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "广告计划", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        HlExcelUtils<ThAdCreativityImport> util = new HlExcelUtils<ThAdCreativityImport>(ThAdCreativityImport.class);
        List<ThAdCreativityImport> thAdCreativityImoprts = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = thAdService.importThAdAndThCreativity(thAdCreativityImoprts, true, operName, file.getOriginalFilename());
        return AjaxResult.success(message);
    }

    /**
     * 导入模板
     *
     * @return
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<ThAdCreativityImport> util = new ExcelUtil<ThAdCreativityImport>(ThAdCreativityImport.class);
        return util.importTemplateExcel("广告计划");
    }

    /**
     * 导出广告计划列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThAd thAd) {
        List<ThAd> list = thAdService.selectThAdList(thAd);
        ExcelUtil<ThAd> util = new ExcelUtil<ThAd>(ThAd.class);
        return util.exportExcel(list, "ad");
    }

    /**
     * 新增广告计划
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存广告计划
     */
    @Log(title = "广告计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThAd thAd) {
        return toAjax(thAdService.insertThAd(thAd));
    }

    /**
     * 修改广告计划
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ThAd thAd = thAdService.selectThAdById(id);
        mmap.put("thAd", thAd);
        return prefix + "/edit";
    }

    /**
     * 修改广告计划
     */
    @GetMapping("/editMultiple/{ids}")
    public String editMultiple(@PathVariable("ids") String ids, ModelMap mmap) {
//        mmap.put("thAd", thAd);
        mmap.put("ids", ids);
        return prefix + "/editMultiple";
    }

    /**
     * 修改保存广告计划
     */
    @Log(title = "广告计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThAd thAd) {
        if (thAd.getIds() == null || "".equals(thAd.getIds())) {
            return toAjax(thAdService.updateThAd(thAd));
        } else {
            int num = 0;
            String[] ids = Convert.toStrArray(thAd.getIds());
            for (String id : ids) {
                thAd.setId(Long.valueOf(id));
                num = num + thAdService.updateThAd(thAd);
            }
            return toAjax(num);
        }
    }

    /**
     * 删除广告计划
     */
    @Log(title = "广告计划", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(thAdService.deleteThAdByIds(ids));
    }

    /**
     * 停用广告计划
     */
    @Log(title = "广告计划")
    @PostMapping("/stopPlan")
    @ResponseBody
    public AjaxResult stopPlan(String ids) {
        String[] idArray = Convert.toStrArray(ids);
        StringBuilder msg = new StringBuilder();
        for (String id : idArray) {
            try {

                int i = thAdService.stopPlanById(id);
            } catch (Exception e) {
                logger.error("停用广告计划出现错误：", e);
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
     * 启用广告计划
     */
    @Log(title = "广告计划")
    @PostMapping("/startPlan")
    @ResponseBody
    public AjaxResult startPlan(String ids, String opt) {
        String[] idArray = Convert.toStrArray(ids);
        StringBuilder msg = new StringBuilder();
        for (String id : idArray) {
            try {

                int i = thAdService.startPlanById(id);
                //如果是新增界面发送的请求，则同时创建广告创意
                if ("add".equals(opt)) {
                    thCreativityService.createCreativity(id);
                }
            } catch (Exception e) {
                logger.error("启用广告计划出现错误：", e);
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
     * 更新广告计划
     */
    @Log(title = "广告计划")
    @PostMapping("/updatePlan")
    @ResponseBody
    public AjaxResult updatePlan(String ids) {
        String[] idArray = Convert.toStrArray(ids);
        StringBuilder msg = new StringBuilder();
        for (String id : idArray) {
            try {

                int i = thAdService.updateTouTiaoPlanById(id);

            } catch (Exception e) {
                logger.error("更新广告计划出现错误：", e);
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
     * 同步广告计划
     */
    @Log(title = "广告计划")
    @PostMapping("/syncPlan")
    @ResponseBody
    public AjaxResult syncPlan(String advertiserId, String campaignId) {
//        String[] idArray = Convert.toStrArray(ids);
        StringBuilder msg = new StringBuilder();
        ThAdvertiser thAdvertiser = new ThAdvertiser();
        thAdvertiser.setStatus("STATUS_ENABLE");
        if (advertiserId != null && !advertiserId.equals("")) {
            thAdvertiser.setId(Long.valueOf(advertiserId));
        }
        if (campaignId != null && !campaignId.equals("")) {
            thAdvertiser.setCampaignId(Long.valueOf(campaignId));
        }
        List<ThAdvertiser> thAdvertisers = thAdvertiserService.selectThAdvertiserList(thAdvertiser);
        for (ThAdvertiser advertiser : thAdvertisers) {
            try {
                advertiser.setCampaignId(thAdvertiser.getCampaignId());
                thAdService.synchronizedPlan(advertiser);
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


}
