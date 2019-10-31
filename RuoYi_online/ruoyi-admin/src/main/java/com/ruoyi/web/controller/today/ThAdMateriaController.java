package com.ruoyi.web.controller.today;

import java.util.List;

import com.ruoyi.today.domain.ThAdMateria;
import com.ruoyi.today.service.IThAdMateriaService;
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
 * 素材Controller
 * 
 * @author ruoyi
 * @date 2019-09-23
 */
@Controller
@RequestMapping("/today/materia")
public class ThAdMateriaController extends BaseController
{
    private String prefix = "today/materia";

    @Autowired
    private IThAdMateriaService thAdMateriaService;

    @RequiresPermissions("today:materia:view")
    @GetMapping()
    public String materia()
    {
        return prefix + "/materia";
    }

    /**
     * 查询素材列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThAdMateria thAdMateria)
    {
        startPage();
        List<ThAdMateria> list = thAdMateriaService.selectThAdMateriaList(thAdMateria);
        for(ThAdMateria materia:list){
            materia.setLocalPath(materia.getLocalPath().split("//")[1]);
        }
        return getDataTable(list);
    }

    /**
     * 导出素材列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThAdMateria thAdMateria)
    {
        List<ThAdMateria> list = thAdMateriaService.selectThAdMateriaList(thAdMateria);
        ExcelUtil<ThAdMateria> util = new ExcelUtil<ThAdMateria>(ThAdMateria.class);
        return util.exportExcel(list, "materia");
    }

    /**
     * 新增素材
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存素材
     */
    @Log(title = "素材", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThAdMateria thAdMateria)
    {
        return toAjax(thAdMateriaService.insertThAdMateria(thAdMateria));
    }

    /**
     * 修改素材
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ThAdMateria thAdMateria = thAdMateriaService.selectThAdMateriaById(id);
        mmap.put("thAdMateria", thAdMateria);
        return prefix + "/edit";
    }

    /**
     * 修改保存素材
     */
    @Log(title = "素材", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThAdMateria thAdMateria)
    {
        return toAjax(thAdMateriaService.updateThAdMateria(thAdMateria));
    }

    /**
     * 删除素材
     */
    @Log(title = "素材", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thAdMateriaService.deleteThAdMateriaByIds(ids));
    }
}
