package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 演员拍摄汇总Controller
 *
 * @author ruoyi
 * @date 2020-01-06
 */
@Controller
@RequestMapping("/system/apply")
public class ActorShotApplyController extends BaseController {
    private String prefix = "system/apply";


    @Autowired
    private IActorFacexhibitionService actorFacexhibitionService;

    @Autowired
    private IActorShotApplyService actorShotApplyService;

    @Autowired
    private IActorAppnameService actorAppnameService;

    @Autowired
    private IActorNumberService actorNumberService;

    @Autowired
    private IActorInformationService actorInformationService;

    @Autowired
    private IActorSysuserapprovalService actorSysuserapprovalService;

    @GetMapping()
    public String apply() {
        return prefix + "/apply";
    }

    /**
     * 查询演员拍摄汇总列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorShotApply actorShotApply) {
        startPage();

        List<ActorShotApply> list = actorShotApplyService.selectActorShotApplyList(actorShotApply);
        for (ActorShotApply v : list) {
            ActorSysuserapproval ac = actorSysuserapprovalService.selectApplyById(v.getId());
            if (v.getStart().equals("1")&&ac!=null) {

                if (ac.getApprovalState().equals("3")) {//审批成功
                    v.setStart("3");
                } else if (ac.getApprovalState().equals("2")) {//审批驳回
                    v.setStart("2");
                } else {//待审批
                    v.setStart("1");
                }
            }
        }
        return getDataTable(list);
    }



    @PostMapping("/listuser")
    @ResponseBody
    public TableDataInfo listuser(Long id) {
        startPage();
        ActorShotApply actorShotApply =new ActorShotApply();
        actorShotApply.setId(id);
        List<ActorShotApply> list = actorShotApplyService.selectActorShotApplyList(actorShotApply);
        return getDataTable(list);
    }



    /**
     * 导出演员拍摄汇总列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorShotApply actorShotApply) {
        List<ActorShotApply> list = actorShotApplyService.selectActorShotApplyList(actorShotApply);
        ExcelUtil<ActorShotApply> util = new ExcelUtil<ActorShotApply>(ActorShotApply.class);
        return util.exportExcel(list, "apply");
    }

    /**
     * 新增演员拍摄汇总
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("appNameId", actorNumberService.selectId().getAppnameId());
        ActorNumber actorNumber = new ActorNumber();
        actorNumber.setAppnameId(actorNumberService.selectId().getAppnameId() + 1);
        actorNumberService.insertActorNumber(actorNumber);
        return prefix + "/add";
    }

    /**
     * 新增保存演员拍摄汇总
     */

    @Log(title = "演员拍摄汇总", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorShotApply actorShotApply) {
        actorShotApply.setUsername(ShiroUtils.getUserName());
        actorShotApply.setStartTime(new Date());
        ActorInformation actorInformation = actorInformationService.selectActorname(actorShotApply.getActorName());
        if (actorInformation == null) {
            return AjaxResult.success("此演员信息尚未录入");
        }
        actorShotApply.setPhoneNumber(Long.valueOf(actorInformation.getTelephone()));
        List<ActorAppname> actorAppname = actorAppnameService.selectAppname(actorShotApply.getAppNameId());

        Long a = 0L;
        for (ActorAppname v : actorAppname) {
            a = a + v.getAppNumber();
        }
        actorShotApply.setShotsNumber(a);
        actorShotApply.setStart("4");//未提交
        actorShotApply.setSingleAmount(actorShotApply.getAmount() / actorShotApply.getShotsNumber());
        actorShotApply.setNum(actorInformation.getNum());
        actorShotApply.setIsReceipt("是");
        actorShotApply.setIsReimbur("是");
        return toAjax(actorShotApplyService.insertActorShotApply(actorShotApply));
    }

    /**
     * 修改演员拍摄汇总
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ActorShotApply actorShotApply = actorShotApplyService.selectActorShotApplyById(id);
        mmap.put("actorShotApply", actorShotApply);
        return prefix + "/edit";
    }


    /**
     * 修改演员拍摄汇总
     */
    @GetMapping("/chaName")
    public String chaName(Long id, ModelMap mmap) {
        ActorShotApply actorShotApply = actorShotApplyService.selectActorShotApplyById(id);
        mmap.put("actorShotApply", actorShotApply);
        return prefix + "/addAppName";
    }


    /**
     * 审批提交
     */
    @GetMapping("/tijiao")
    public String tiJiao(Long id, ModelMap mmap) {
        ActorShotApply actorShotApply = actorShotApplyService.selectActorShotApplyById(id);
        mmap.put("actorShotApply", actorShotApply);
        return prefix + "/tijiao";
    }


    /**
     * 修改审批状态
     */


    @PostMapping("/tijiao2")
    @ResponseBody
    public AjaxResult tiJiao2(ActorShotApply actorShotApply) {
        actorShotApply.setStart("1");

        ActorShotApply actorShot = actorShotApplyService.selectActorShotApplyById(actorShotApply.getId());
        ActorSysuserapproval actor = new ActorSysuserapproval();
        actor.setApplyId(actorShot.getId());
        actor.setApplicantName(actorShot.getUsername());//审请人姓名
        actor.setApproverName("马俊");
        actor.setApprovalSight("1");
        actor.setApprovalLevel(1);
        actor.setApprovalState("1");
        actorSysuserapprovalService.insertActorSysuserapproval(actor);
        actor.setApproverName("孙庆");
        actor.setApprovalSight("0");
        actor.setApprovalLevel(2);
        actorSysuserapprovalService.insertActorSysuserapproval(actor);
        actor.setApproverName("穆凌强");
        actor.setApprovalSight("0");
        actor.setApprovalLevel(3);
        actorSysuserapprovalService.insertActorSysuserapproval(actor);

        return toAjax(actorShotApplyService.updateActorShotApply(actorShotApply));
    }

    /**
     * 审批付款
     */
    @GetMapping("/fukuan")
    public String fuKuan(Long id, ModelMap mmap) {
        ActorShotApply actorShotApply = actorShotApplyService.selectActorShotApplyById(id);
        mmap.put("actorShotApply", actorShotApply);
        return prefix + "/fukuan";
    }


    /**
     * 提交财务查看
     */


    @PostMapping("/fukuan1")
    @ResponseBody
    public AjaxResult fuKuan(ActorShotApply actorShotApply) {
        ActorShotApply actor = actorShotApplyService.selectActorShotApplyById(actorShotApply.getId());
        ActorInformation actorInformation = actorInformationService.selectActorname(actor.getActorName());
        ActorFacexhibition actorFacexhibition = new ActorFacexhibition();
        actorFacexhibition.setActorName(actorInformation.getName());
        actorFacexhibition.setAddName(ShiroUtils.getUserName());
        actorFacexhibition.setAddTime(new Date());
        actorFacexhibition.setAmount(actor.getAmount());
        actorFacexhibition.setDocumenttype(actorInformation.getAffiliatedbank());
        actorFacexhibition.setShotTime(actor.getShotTime());
        actorFacexhibition.setOpi(actorInformation.getDocumenttype());//备注
        actorFacexhibition.setIdnumber(actorInformation.getIdnumber());
        actorFacexhibition.setNumber(Long.valueOf(actorInformation.getNumber()));
        actorFacexhibition.setTelephone(Long.valueOf(actorInformation.getTelephone()));
        actorFacexhibition.setActualPaymentTime(actor.getActualPaymentTime());
        actorFacexhibition.setIspayment("1");
        actorFacexhibitionService.insertActorFacexhibition(actorFacexhibition);
        actor.setStart("6");
        actorShotApplyService.updateActorShotApply(actor);
        return toAjax(1);
    }

    /**
     * 修改保存演员拍摄汇总
     */

    @Log(title = "演员拍摄汇总", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorShotApply actorShotApply) {
        actorShotApply.setUpdatename(ShiroUtils.getUserName());
        return toAjax(actorShotApplyService.updateActorShotApply(actorShotApply));
    }

    /**
     * 删除演员拍摄汇总
     */

    @Log(title = "演员拍摄汇总", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(actorShotApplyService.deleteActorShotApplyByIds(ids));
    }


    /**
     * 删除演员拍摄汇总
     */

    @Log(title = "演员拍摄汇总", businessType = BusinessType.DELETE)
    @PostMapping("/tijiao")
    @ResponseBody
    public AjaxResult tijiao(Long id) {
        ActorShotApply actorShotApply = actorShotApplyService.selectActorShotApplyById(id);
//        ActorSysuserapproval actor = new ActorSysuserapproval();
//        actor.setApplyId(actorShotApply.getId());
//        actor.setApplicantName(actorShotApply.getUsername());//审请人姓名
//        actor.setApproverName("1");
//        actorSysuserapprovalService.insertActorSysuserapproval(actor);
//        actor.setApproverName("2");
//        actorSysuserapprovalService.insertActorSysuserapproval(actor);
//        actor.setApproverName("3");
//        actorSysuserapprovalService.insertActorSysuserapproval(actor);
        return toAjax(0);
    }


}
