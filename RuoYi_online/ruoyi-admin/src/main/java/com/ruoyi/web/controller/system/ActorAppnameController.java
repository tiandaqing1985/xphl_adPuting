package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.ActorNumber;
import com.ruoyi.system.service.IActorNumberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ActorAppname;
import com.ruoyi.system.service.IActorAppnameService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 拍摄app数量统计Controller
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Controller
@RequestMapping("/system/appName")
public class ActorAppnameController extends BaseController
{
    private String prefix = "system/appName";

    @Autowired
    private IActorAppnameService actorAppnameService;
    @Autowired
    private IActorNumberService actorNumberService;


    @GetMapping()
    public String appName()
    {
        return prefix + "/appName";
    }

    /**
     * 查询拍摄app数量统计列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorAppname actorAppname)
    {
        startPage();
        List<ActorAppname> list = actorAppnameService.selectActorAppnameList(actorAppname);
        return getDataTable(list);
    }




    @PostMapping("/listAppNameId")
    @ResponseBody
    public TableDataInfo listAppNameId(Long appNameId)
    {
        startPage();
        List<ActorAppname> list = actorAppnameService.selectAppname(appNameId);
        return getDataTable(list);
    }




    /**
     * 导出拍摄app数量统计列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorAppname actorAppname)
    {
        List<ActorAppname> list = actorAppnameService.selectActorAppnameList(actorAppname);
        ExcelUtil<ActorAppname> util = new ExcelUtil<ActorAppname>(ActorAppname.class);
        return util.exportExcel(list, "appName");
    }

    /**
     * 新增拍摄app数量统计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存拍摄app数量统计
     */

    @Log(title = "拍摄app数量统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorAppname actorAppname)
    {
        return toAjax(actorAppnameService.insertActorAppname(actorAppname));
    }

    /**applyId
     * 新增拍摄app数量统计
     */
    @GetMapping("/addName")
    public String addName(@RequestParam("id") Long id, ModelMap map)
    {
        map.put("applyId",id);
        map.put("detailid", actorNumberService.selectId().getAppnameId());
        ActorNumber actorNumber = new ActorNumber();
        actorNumber.setAppnameId(actorNumberService.selectId().getAppnameId() + 1);
        actorNumberService.insertActorNumber(actorNumber);
        return prefix + "/add";
    }


    @Log(title = "拍摄app数量统计", businessType = BusinessType.INSERT)
    @PostMapping("/addName")
    @ResponseBody
    public AjaxResult addName(ActorAppname actorAppname)
    {
        return toAjax(actorAppnameService.insertActorAppname(actorAppname));
    }



    /**
     * 修改拍摄app数量统计
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ActorAppname actorAppname = actorAppnameService.selectActorAppnameById(id);
        mmap.put("actorAppname", actorAppname);
        mmap.put("detailid", actorAppname.getDetailid());
        return prefix + "/edit";
    }

    /**
     * 修改保存拍摄app数量统计
     */

    @Log(title = "拍摄app数量统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorAppname actorAppname)
    {
        return toAjax(actorAppnameService.updateActorAppname(actorAppname));
    }

    /**
     * 删除拍摄app数量统计
     */

    @Log(title = "拍摄app数量统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(actorAppnameService.deleteActorAppnameByIds(ids));
    }
}
