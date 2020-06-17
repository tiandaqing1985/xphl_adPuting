package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.ActorAppname;
import com.ruoyi.system.domain.ActorShotApply;
import com.ruoyi.system.domain.ActorSysuserapproval;
import com.ruoyi.system.service.IActorAppnameService;
import com.ruoyi.system.service.IActorDetailsService;
import com.ruoyi.system.service.IActorShotApplyService;
import com.ruoyi.system.service.IActorSysuserapprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 演员审批Controller
 *
 * @author ruoyi
 * @date 2020-01-09
 */
@Controller
@RequestMapping("/system/sysUserApproval")
public class ActorSysuserapprovalController extends BaseController {
    private String prefix = "system/sysUserApproval";

    @Autowired
    private IActorSysuserapprovalService actorSysuserapprovalService;

    @Autowired
    private IActorShotApplyService actorShotApplyService;

    @Autowired
    private IActorAppnameService actorAppnameService;

    @Autowired
    private IActorDetailsService actorDetailsService;

    @GetMapping()
    public String sysUserApproval() {
        return prefix + "/sysUserApproval";
    }

    /**
     * 查询演员审批列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorSysuserapproval actorSysuserapproval) {
        startPage();
        if (ShiroUtils.getUserName().equals("若依")) {
            actorSysuserapproval.setApprovalSight("1");
            actorSysuserapproval.setApprovalState("1");
        } else {
            actorSysuserapproval.setApproverName(ShiroUtils.getUserName());
            actorSysuserapproval.setApprovalSight("1");
            actorSysuserapproval.setApprovalState("1");

        }

        List<ActorSysuserapproval> list = actorSysuserapprovalService.selectActorSysuserapprovalList(actorSysuserapproval);
        return getDataTable(list);
    }


    /**
     * 查询演员审批列表
     */

    @PostMapping("/endlist")
    @ResponseBody
    public TableDataInfo endlist(ActorSysuserapproval actorSysuserapproval) {
        startPage();
        if (ShiroUtils.getUserName().equals("若依")) {
            actorSysuserapproval.setApprovalState("3");
        } else {
            actorSysuserapproval.setApproverName(ShiroUtils.getUserName());
            actorSysuserapproval.setApprovalState("3");
        }

        List<ActorSysuserapproval> list = actorSysuserapprovalService.selectList(actorSysuserapproval);
        return getDataTable(list);
    }


    /**
     * 导出演员审批列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorSysuserapproval actorSysuserapproval) {
        List<ActorSysuserapproval> list = actorSysuserapprovalService.selectActorSysuserapprovalList(actorSysuserapproval);
        ExcelUtil<ActorSysuserapproval> util = new ExcelUtil<ActorSysuserapproval>(ActorSysuserapproval.class);
        return util.exportExcel(list, "sysUserApproval");
    }

    /**
     * 新增演员审批
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存演员审批
     */

    @Log(title = "演员审批", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorSysuserapproval actorSysuserapproval) {
        return toAjax(actorSysuserapprovalService.insertActorSysuserapproval(actorSysuserapproval));
    }

    /**
     * 修改演员审批
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ActorSysuserapproval actorSysuserapproval = actorSysuserapprovalService.selectActorSysuserapprovalById(id);
        ActorShotApply actorShotApply = actorShotApplyService.selectActorShotApplyById(actorSysuserapproval.getApplyId());
        mmap.put("appnameId", actorShotApply.getAppnameId());
        mmap.put("applyId", actorSysuserapproval.getApplyId());
        mmap.put("actorSysuserapproval", actorSysuserapproval);
        return prefix + "/addAppName";
    }


    /**
     * 修改演员审批
     */
    @GetMapping("/details")
    public String details(Long id, ModelMap map) {
        ActorAppname actorAppname = actorAppnameService.selectActorAppnameById(id);
        map.put("detailid", actorAppname.getDetailid());
        return prefix + "/details";
    }


    /**
     * 修改演员审批
     */
    @GetMapping("/chakan")
    public String chakan(Long id, ModelMap mmap) {
        ActorSysuserapproval actorSysuserapproval = actorSysuserapprovalService.selectActorSysuserapprovalById(id);
        ActorShotApply actorShotApply = actorShotApplyService.selectActorShotApplyById(actorSysuserapproval.getApplyId());
        mmap.put("appnameId", actorShotApply.getAppnameId());
        mmap.put("applyId", actorSysuserapproval.getApplyId());
        mmap.put("actorSysuserapproval", actorSysuserapproval);
        return prefix + "/chakan";
    }

    /**
     * 修改保存演员审批
     */

    @Log(title = "演员审批", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorSysuserapproval actorSysuserapproval) {
        return toAjax(actorSysuserapprovalService.updateActorSysuserapproval(actorSysuserapproval));
    }

    /**
     * 删除演员审批
     */

    @Log(title = "演员审批", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(actorSysuserapprovalService.deleteActorSysuserapprovalByIds(ids));
    }


    /**
     * 批量修改财务审批
     */
    @GetMapping("/approvalModer")
    public String PLshenpi(String ids, ModelMap map) {
        map.put("applicantName", ids);
        map.put("approvalId", ids);
        return prefix + "/approvalModer";
    }


    /**
     * 批量财务审批
     */
    @Log(title = "批量财务审批", businessType = BusinessType.UPDATE)
    @PostMapping("/approvalModer")
    @ResponseBody
    public AjaxResult PLshenpi(ActorSysuserapproval actorSysuserapproval) {
        List<ActorSysuserapproval> list = actorSysuserapprovalService.selectListPliang(actorSysuserapproval.getApplicantName());

        for (ActorSysuserapproval a : list) {
            a.setOpi(actorSysuserapproval.getOpi());
            a.setApprovalState(actorSysuserapproval.getApprovalState());
            actorSysuserapprovalService.updateActorSysuserapproval(a);
        }

        return toAjax(1);
    }

}
