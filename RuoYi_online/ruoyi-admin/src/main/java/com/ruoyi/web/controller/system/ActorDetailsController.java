package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.ActorDetails;
import com.ruoyi.system.domain.ActorNumber;
import com.ruoyi.system.service.IActorDetailsService;
import com.ruoyi.system.service.IActorNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 视频拍摄详情Controller
 *
 * @author ruoyi
 * @date 2020-05-18
 */
@Controller
@RequestMapping("/system/details")
public class ActorDetailsController extends BaseController {
    private String prefix = "system/details";

    @Autowired
    private IActorDetailsService actorDetailsService;


    @Autowired
    private IActorNumberService actorNumberService;

    @GetMapping()
    public String details() {
        return prefix + "/details";
    }

    /**
     * 查询视频拍摄详情列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorDetails actorDetails) {
        startPage();
        List<ActorDetails> list = actorDetailsService.selectActorDetailsList(actorDetails);
        return getDataTable(list);
    }

    /**
     * 导出视频拍摄详情列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorDetails actorDetails) {
        List<ActorDetails> list = actorDetailsService.selectActorDetailsList(actorDetails);
        ExcelUtil<ActorDetails> util = new ExcelUtil<ActorDetails>(ActorDetails.class);
        return util.exportExcel(list, "details");
    }

    /**
     * 新增视频拍摄详情
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("applyId", actorNumberService.selectId().getAppnameId());
        ActorNumber actorNumber = new ActorNumber();
        actorNumber.setAppnameId(actorNumberService.selectId().getAppnameId() + 1);
        actorNumberService.insertActorNumber(actorNumber);
        return prefix + "/add";
    }

    /**
     * 新增保存视频拍摄详情
     */
    @Log(title = "视频拍摄详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorDetails actorDetails) {
        return toAjax(actorDetailsService.insertActorDetails(actorDetails));
    }

    /**
     * 修改视频拍摄详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ActorDetails actorDetails = actorDetailsService.selectActorDetailsById(id);
        mmap.put("actorDetails", actorDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存视频拍摄详情
     */
    @Log(title = "视频拍摄详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorDetails actorDetails) {
        return toAjax(actorDetailsService.updateActorDetails(actorDetails));
    }

    /**
     * 删除视频拍摄详情
     */
    @Log(title = "视频拍摄详情", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(actorDetailsService.deleteActorDetailsByIds(ids));
    }

    /**
     * 新增拍摄app数量统计
     */
    @GetMapping("/addName")
    public String addName(@RequestParam("id") Long id, ModelMap map) {
        map.put("applyId", id);
        return prefix + "/add";
    }


    @Log(title = "拍摄app数量统计", businessType = BusinessType.INSERT)
    @PostMapping("/addName")
    @ResponseBody
    public AjaxResult addName(ActorDetails actorDetails) {
        return toAjax(actorDetailsService.insertActorDetails(actorDetails));
    }


    @PostMapping("/listApplyId")
    @ResponseBody
    public TableDataInfo listAppNameId(Long applyId) {
        startPage();
        List<ActorDetails> list = actorDetailsService.selectDetailsList(applyId);
        return getDataTable(list);
    }

}
