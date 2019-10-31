package com.ruoyi.web.controller.today;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.today.domain.ThCreativity;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThCreativityService;
import com.ruoyi.today.service.impl.TouTiaoAdCenterServiceImpl;
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
 * 创意公共属性Controller
 *
 * @author ruoyi
 * @date 2019-09-09
 */
@Controller
@RequestMapping("/today/creativity")
public class ThCreativityController extends BaseController {
    private String prefix = "today/creativity";

    @Autowired
    private IThCreativityService thCreativityService;

    @RequiresPermissions("system:creativity:view")
    @GetMapping("/{id}")
    public String creativity(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("id", id);
        return prefix + "/creativity";
    }

    /**
     * 查询创意公共属性列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThCreativity thCreativity) {
        startPage();
        List<ThCreativity> list = thCreativityService.selectThCreativityList(thCreativity);
        return getDataTable(list);
    }

    /**
     * 导出创意公共属性列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThCreativity thCreativity) {
        List<ThCreativity> list = thCreativityService.selectThCreativityList(thCreativity);
        ExcelUtil<ThCreativity> util = new ExcelUtil<ThCreativity>(ThCreativity.class);
        return util.exportExcel(list, "creativity");
    }

    /**
     * 新增创意公共属性
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存创意公共属性
     */
    @Log(title = "创意公共属性", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThCreativity thCreativity) {
        return toAjax(thCreativityService.insertThCreativity(thCreativity));
    }

    /**
     * 修改创意公共属性
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ThCreativity thCreativity = thCreativityService.selectThCreativityById(id);
        mmap.put("thCreativity", thCreativity);
        return prefix + "/edit";
    }
    /**
     * 启用广告计划
     */
    @Log(title = "广告创意")
    @PostMapping("/startCreativity")
    @ResponseBody
    public AjaxResult startPlan(String ids) {
        String[] idArray = Convert.toStrArray(ids);
        StringBuilder msg = new StringBuilder();
        for (String id : idArray) {
            try {

                int i = thCreativityService.startCreativityById(id);
            } catch (Exception e) {
                logger.error("启用广告创意出现错误：", e);
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
     * 修改保存创意公共属性
     */
    @Log(title = "创意公共属性", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThCreativity thCreativity) {
        return toAjax(thCreativityService.updateThCreativity(thCreativity));
    }

    /**
     * 删除创意公共属性
     */
    @Log(title = "创意公共属性", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(thCreativityService.deleteThCreativityByIds(ids));
    }
}
