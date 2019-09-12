package com.ruoyi.web.controller.today;

import java.util.List;

import com.ruoyi.today.domain.ThCreativityImage;
import com.ruoyi.today.service.IThCreativityImageService;
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
 * 程序化创意素材Controller
 * 
 * @author ruoyi
 * @date 2019-09-09
 */
@Controller
@RequestMapping("/system/image")
public class ThCreativityImageController extends BaseController
{
    private String prefix = "system/image";

    @Autowired
    private IThCreativityImageService thCreativityImageService;

    @RequiresPermissions("system:image:view")
    @GetMapping()
    public String image()
    {
        return prefix + "/image";
    }

    /**
     * 查询程序化创意素材列表
     */
    @RequiresPermissions("system:image:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThCreativityImage thCreativityImage)
    {
        startPage();
        List<ThCreativityImage> list = thCreativityImageService.selectThCreativityImageList(thCreativityImage);
        return getDataTable(list);
    }

    /**
     * 导出程序化创意素材列表
     */
    @RequiresPermissions("system:image:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThCreativityImage thCreativityImage)
    {
        List<ThCreativityImage> list = thCreativityImageService.selectThCreativityImageList(thCreativityImage);
        ExcelUtil<ThCreativityImage> util = new ExcelUtil<ThCreativityImage>(ThCreativityImage.class);
        return util.exportExcel(list, "image");
    }

    /**
     * 新增程序化创意素材
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存程序化创意素材
     */
    @RequiresPermissions("system:image:add")
    @Log(title = "程序化创意素材", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThCreativityImage thCreativityImage)
    {
        return toAjax(thCreativityImageService.insertThCreativityImage(thCreativityImage));
    }

    /**
     * 修改程序化创意素材
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ThCreativityImage thCreativityImage = thCreativityImageService.selectThCreativityImageById(id);
        mmap.put("thCreativityImage", thCreativityImage);
        return prefix + "/edit";
    }

    /**
     * 修改保存程序化创意素材
     */
    @RequiresPermissions("system:image:edit")
    @Log(title = "程序化创意素材", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThCreativityImage thCreativityImage)
    {
        return toAjax(thCreativityImageService.updateThCreativityImage(thCreativityImage));
    }

    /**
     * 删除程序化创意素材
     */
    @RequiresPermissions("system:image:remove")
    @Log(title = "程序化创意素材", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thCreativityImageService.deleteThCreativityImageByIds(ids));
    }
}
