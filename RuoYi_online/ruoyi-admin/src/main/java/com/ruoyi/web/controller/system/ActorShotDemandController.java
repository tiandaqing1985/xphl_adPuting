package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.system.domain.ActorShotDemand;
import com.ruoyi.system.service.IActorShotDemandService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 拍摄需求单Controller
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
@Controller
@RequestMapping("/system/demand")
public class ActorShotDemandController extends BaseController
{
    private String prefix = "system/demand";

    @Autowired
    private IActorShotDemandService actorShotDemandService;


    @GetMapping()
    public String demand()
    {
        return prefix + "/demand";
    }

    /**
     * 查询拍摄需求单列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorShotDemand actorShotDemand)
    {
        startPage();
        List<ActorShotDemand> list = actorShotDemandService.selectActorShotDemandList(actorShotDemand);
        return getDataTable(list);
    }

    /**
     * 导出拍摄需求单列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorShotDemand actorShotDemand)
    {
        List<ActorShotDemand> list = actorShotDemandService.selectActorShotDemandList(actorShotDemand);
        ExcelUtil<ActorShotDemand> util = new ExcelUtil<ActorShotDemand>(ActorShotDemand.class);
        return util.exportExcel(list, "demand");
    }

    /**
     * 新增拍摄需求单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存拍摄需求单
     */

    @Log(title = "拍摄需求单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorShotDemand actorShotDemand)
    {
        actorShotDemand.setUsername(ShiroUtils.getUserName());
        actorShotDemand.setCreateTime(new Date());
        return toAjax(actorShotDemandService.insertActorShotDemand(actorShotDemand));
    }

    /**
     * 修改拍摄需求单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ActorShotDemand actorShotDemand = actorShotDemandService.selectActorShotDemandById(id);
        mmap.put("actorShotDemand", actorShotDemand);
        return prefix + "/edit";
    }

    /**
     * 修改保存拍摄需求单
     */

    @Log(title = "拍摄需求单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorShotDemand actorShotDemand)
    {
        actorShotDemand.setUpdatename(ShiroUtils.getUserName());
        actorShotDemand.setUpdateTime(new Date());
        return toAjax(actorShotDemandService.updateActorShotDemand(actorShotDemand));
    }

    /**
     * 删除拍摄需求单
     */

    @Log(title = "拍摄需求单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(actorShotDemandService.deleteActorShotDemandByIds(ids));
    }
}
