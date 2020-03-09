package com.ruoyi.web.controller.today;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.today.domain.ThUserAdvertiser;
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
import com.ruoyi.today.domain.ThAdvertiser;
import com.ruoyi.today.service.IThAdvertiserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 广告主Controller
 *
 * @author ruoyi
 * @date 2019-08-12
 */
@Controller
@RequestMapping("/today/advertiser")
public class ThAdvertiserController extends BaseController {
    private String prefix = "today/advertiser";

    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private IThUserAdvertiserService thUserAdvertiserService;

    @RequiresPermissions("today:advertiser:view")
    @GetMapping()
    public String advertiser() {
//        return prefix + "/advertiser";
        return prefix + "/tabs_panels";
    }

    /**
     * 查询广告主列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThAdvertiser thAdvertiser) {
        ThUserAdvertiser thUserAdvertiser = new ThUserAdvertiser();
        thUserAdvertiser.setUserName(ShiroUtils.getLoginName());
        //查询当前登录用户被分配的广告主
        List<ThUserAdvertiser> thUserAdvertisers = thUserAdvertiserService.selectThUserAdvertiserList(thUserAdvertiser);
        List<String> advertiesIds = new ArrayList<>();
        for (ThUserAdvertiser userAdvertiser : thUserAdvertisers) {
            advertiesIds.add(userAdvertiser.getAdvertiserId());
        }
        thAdvertiser.setAdvertiesIds(advertiesIds);
        startPage();
        List<ThAdvertiser> list = thAdvertiserService.selectThAdvertiserList(thAdvertiser);
        return getDataTable(list);
    }

    /**
     * 导出广告主列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThAdvertiser thAdvertiser) {
        List<ThAdvertiser> list = thAdvertiserService.selectThAdvertiserList(thAdvertiser);
        ExcelUtil<ThAdvertiser> util = new ExcelUtil<ThAdvertiser>(ThAdvertiser.class);
        return util.exportExcel(list, "advertiser");
    }

    /**
     * 新增广告主
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存广告主
     */
    @Log(title = "广告主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThAdvertiser thAdvertiser) {
        return toAjax(thAdvertiserService.insertThAdvertiser(thAdvertiser));
    }

    /**
     * 修改广告主
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ThAdvertiser thAdvertiser = thAdvertiserService.selectThAdvertiserById(id);
        mmap.put("thAdvertiser", thAdvertiser);
        return prefix + "/edit";
    }

    /**
     * 修改保存广告主
     */
    @Log(title = "广告主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThAdvertiser thAdvertiser) {
        return toAjax(thAdvertiserService.updateThAdvertiser(thAdvertiser));
    }

    /**
     * 删除广告主
     */
    @Log(title = "广告主", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(thAdvertiserService.deleteThAdvertiserByIds(ids));
    }


    /**
     * 同步广告主
     */
    @Log(title = "广告主", businessType = BusinessType.OTHER)
    @PostMapping("/adMutual")
    @ResponseBody
    public AjaxResult adMutual() {
        return toAjax(thAdvertiserService.adMutual(ShiroUtils.getSysUser().getUserName()));
    }
}
