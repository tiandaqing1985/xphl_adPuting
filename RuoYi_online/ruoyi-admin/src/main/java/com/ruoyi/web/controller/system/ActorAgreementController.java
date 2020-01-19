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
import com.ruoyi.system.domain.ActorAgreement;
import com.ruoyi.system.service.IActorAgreementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 演员协议帐Controller
 * 
 * @author ruoyi
 * @date 2020-01-09
 */
@Controller
@RequestMapping("/system/agreement")
public class ActorAgreementController extends BaseController
{
    private String prefix = "system/agreement";

    @Autowired
    private IActorAgreementService actorAgreementService;


    @GetMapping()
    public String agreement()
    {
        return prefix + "/agreement";
    }

    /**
     * 查询演员协议帐列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorAgreement actorAgreement)
    {
        startPage();
        List<ActorAgreement> list = actorAgreementService.selectActorAgreementList(actorAgreement);
        return getDataTable(list);
    }

    /**
     * 导出演员协议帐列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorAgreement actorAgreement)
    {
        List<ActorAgreement> list = actorAgreementService.selectActorAgreementList(actorAgreement);
        ExcelUtil<ActorAgreement> util = new ExcelUtil<ActorAgreement>(ActorAgreement.class);
        return util.exportExcel(list, "agreement");
    }

    /**
     * 新增演员协议帐
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存演员协议帐
     */

    @Log(title = "演员协议帐", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorAgreement actorAgreement)
    {
        actorAgreement.setAddTime(new Date());
        actorAgreement.setAddUser(ShiroUtils.getUserName());
        return toAjax(actorAgreementService.insertActorAgreement(actorAgreement));
    }

    /**
     * 修改演员协议帐
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ActorAgreement actorAgreement = actorAgreementService.selectActorAgreementById(id);
        mmap.put("actorAgreement", actorAgreement);
        return prefix + "/edit";
    }

    /**
     * 修改保存演员协议帐
     */

    @Log(title = "演员协议帐", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorAgreement actorAgreement)
    {
        actorAgreement.setUpdateTime(new Date());
        actorAgreement.setUpdateUser(ShiroUtils.getUserName());
        return toAjax(actorAgreementService.updateActorAgreement(actorAgreement));
    }

    /**
     * 删除演员协议帐
     */

    @Log(title = "演员协议帐", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(actorAgreementService.deleteActorAgreementByIds(ids));
    }
}
