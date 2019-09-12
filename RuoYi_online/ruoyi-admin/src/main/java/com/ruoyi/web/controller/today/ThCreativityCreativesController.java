package com.ruoyi.web.controller.today;

import java.util.List;

import com.ruoyi.today.domain.ThCreativityCreatives;
import com.ruoyi.today.service.IThCreativityCreativesService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 创意Controller
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
@Controller
@RequestMapping("/system/creatives")
public class ThCreativityCreativesController extends BaseController
{
    private String prefix = "system/creatives";

    @Autowired
    private IThCreativityCreativesService thCreativityCreativesService;

    @RequiresPermissions("system:creatives:view")
    @GetMapping()
    public String creatives()
    {
        return prefix + "/creatives";
    }

    /**
     * 查询创意列表
     */
    @RequiresPermissions("system:creatives:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThCreativityCreatives thCreativityCreatives)
    {
        startPage();
        List<ThCreativityCreatives> list = thCreativityCreativesService.selectThCreativityCreativesList(thCreativityCreatives);
        return getDataTable(list);
    }

    /**
     * 导出创意列表
     */
    @RequiresPermissions("system:creatives:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThCreativityCreatives thCreativityCreatives)
    {
        List<ThCreativityCreatives> list = thCreativityCreativesService.selectThCreativityCreativesList(thCreativityCreatives);
        ExcelUtil<ThCreativityCreatives> util = new ExcelUtil<ThCreativityCreatives>(ThCreativityCreatives.class);
        return util.exportExcel(list, "creatives");
    }

    /**
     * 新增创意
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存创意
     */
    @RequiresPermissions("system:creatives:add")
    @Log(title = "创意", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThCreativityCreatives thCreativityCreatives)
    {
        return toAjax(thCreativityCreativesService.insertThCreativityCreatives(thCreativityCreatives));
    }

    /**
     * 修改创意
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ThCreativityCreatives thCreativityCreatives = thCreativityCreativesService.selectThCreativityCreativesById(id);
        mmap.put("thCreativityCreatives", thCreativityCreatives);
        return prefix + "/edit";
    }

    /**
     * 修改保存创意
     */
    @RequiresPermissions("system:creatives:edit")
    @Log(title = "创意", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThCreativityCreatives thCreativityCreatives)
    {
        return toAjax(thCreativityCreativesService.updateThCreativityCreatives(thCreativityCreatives));
    }

    /**
     * 删除创意
     */
    @RequiresPermissions("system:creatives:remove")
    @Log(title = "创意", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thCreativityCreativesService.deleteThCreativityCreativesByIds(ids));
    }
}
