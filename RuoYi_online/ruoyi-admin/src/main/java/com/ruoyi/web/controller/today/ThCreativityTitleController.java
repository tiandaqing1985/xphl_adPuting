package com.ruoyi.web.controller.today;

import java.util.List;

import com.ruoyi.today.domain.ThCreativityTitle;
import com.ruoyi.today.service.IThCreativityTitleService;
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
 * 程序化创意标题Controller
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
@Controller
@RequestMapping("/system/title")
public class ThCreativityTitleController extends BaseController
{
    private String prefix = "system/title";

    @Autowired
    private IThCreativityTitleService thCreativityTitleService;

    @RequiresPermissions("system:title:view")
    @GetMapping()
    public String title()
    {
        return prefix + "/title";
    }

    /**
     * 查询程序化创意标题列表
     */
    @RequiresPermissions("system:title:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThCreativityTitle thCreativityTitle)
    {
        startPage();
        List<ThCreativityTitle> list = thCreativityTitleService.selectThCreativityTitleList(thCreativityTitle);
        return getDataTable(list);
    }

    /**
     * 导出程序化创意标题列表
     */
    @RequiresPermissions("system:title:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThCreativityTitle thCreativityTitle)
    {
        List<ThCreativityTitle> list = thCreativityTitleService.selectThCreativityTitleList(thCreativityTitle);
        ExcelUtil<ThCreativityTitle> util = new ExcelUtil<ThCreativityTitle>(ThCreativityTitle.class);
        return util.exportExcel(list, "title");
    }

    /**
     * 新增程序化创意标题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存程序化创意标题
     */
    @RequiresPermissions("system:title:add")
    @Log(title = "程序化创意标题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThCreativityTitle thCreativityTitle)
    {
        return toAjax(thCreativityTitleService.insertThCreativityTitle(thCreativityTitle));
    }

    /**
     * 修改程序化创意标题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ThCreativityTitle thCreativityTitle = thCreativityTitleService.selectThCreativityTitleById(id);
        mmap.put("thCreativityTitle", thCreativityTitle);
        return prefix + "/edit";
    }

    /**
     * 修改保存程序化创意标题
     */
    @RequiresPermissions("system:title:edit")
    @Log(title = "程序化创意标题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThCreativityTitle thCreativityTitle)
    {
        return toAjax(thCreativityTitleService.updateThCreativityTitle(thCreativityTitle));
    }

    /**
     * 删除程序化创意标题
     */
    @RequiresPermissions("system:title:remove")
    @Log(title = "程序化创意标题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thCreativityTitleService.deleteThCreativityTitleByIds(ids));
    }
}
