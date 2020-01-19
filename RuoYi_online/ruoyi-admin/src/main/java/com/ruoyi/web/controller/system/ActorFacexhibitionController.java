package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.ActorFacexhibition;
import com.ruoyi.system.service.IActorFacexhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 财务查看Controller
 *
 * @author ruoyi
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/system/facExhibition")
public class ActorFacexhibitionController extends BaseController {
    private String prefix = "system/facExhibition";

    @Autowired
    private IActorFacexhibitionService actorFacexhibitionService;


    @GetMapping()
    public String facExhibition() {
        return prefix + "/facExhibition";
    }


    /**
     * 查询财务查看列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorFacexhibition actorFacexhibition) {
        startPage();
        actorFacexhibition.setIspayment("1");
        List<ActorFacexhibition> list = actorFacexhibitionService.selectActorFacexhibitionList(actorFacexhibition);
        return getDataTable(list);
    }

    /**
     * 查询财务查看列表
     */

    @PostMapping("/listess")
    @ResponseBody
    public TableDataInfo listess(ActorFacexhibition actorFacexhibition) {
        startPage();
        actorFacexhibition.setIspayment("0");
        List<ActorFacexhibition> list = actorFacexhibitionService.selectActorFacexhibitionList(actorFacexhibition);
        return getDataTable(list);
    }

    /**
     * 批量修改财务审批
     */
    @GetMapping("/approvalModer")
    public String PLshenpi(String ids, ModelMap map) {
        map.put("actorName", ids);
        map.put("approvalId", ids);
        return prefix + "/approvalModer";
    }

    @GetMapping("/facExhibitioness")
    public String fac() {
        return prefix + "/facExhibitioness";
    }

    /**
     * 批量财务审批
     */
    @Log(title = "批量财务审批", businessType = BusinessType.UPDATE)
    @PostMapping("/approvalModer")
    @ResponseBody
    public AjaxResult PLshenpi(ActorFacexhibition actorFacexhibition) {

        List<ActorFacexhibition> list = actorFacexhibitionService.selectApprovalByIds(actorFacexhibition.getActorName());
        if (list != null && list.size() > 0) {
            for (ActorFacexhibition f : list) {
                f.setIspayment("0");
                actorFacexhibitionService.updateActorFacexhibition(f);
            }
        }
        return toAjax(1);
    }


    /**
     * 导出财务查看列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorFacexhibition actorFacexhibition) {
        List<ActorFacexhibition> list = actorFacexhibitionService.selectActorFacexhibitionList(actorFacexhibition);
        ExcelUtil<ActorFacexhibition> util = new ExcelUtil<ActorFacexhibition>(ActorFacexhibition.class);
        return util.exportExcel(list, "facExhibition");
    }

    /**
     * 新增财务查看
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存财务查看
     */

    @Log(title = "财务查看", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorFacexhibition actorFacexhibition) {
        return toAjax(actorFacexhibitionService.insertActorFacexhibition(actorFacexhibition));
    }

    /**
     * 修改财务查看
     */
    @GetMapping("/edit")
    public String edit(Long id, ModelMap mmap) {
        ActorFacexhibition actorFacexhibition = actorFacexhibitionService.selectActorFacexhibitionById(id);
        mmap.put("actorFacexhibition", actorFacexhibition);
        return prefix + "/edit";
    }

    /**
     * 修改保存财务查看
     */

    @Log(title = "财务查看", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorFacexhibition actorFacexhibition) {
        actorFacexhibition.setIspayment("0");
        return toAjax(actorFacexhibitionService.updateActorFacexhibition(actorFacexhibition));
    }

    /**
     * 删除财务查看
     */

    @Log(title = "财务查看", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(actorFacexhibitionService.deleteActorFacexhibitionByIds(ids));
    }


    /**
     * 批量修改财务审批
     */
    @GetMapping("/exls")
    public String exls(String ids, ModelMap map) {
        map.put("actorName", ids);
        map.put("approvalId", ids);
        return prefix + "/exls";
    }


    /**
     * 批量财务审批
     */
    @PostMapping("/exls")
    @ResponseBody
    public AjaxResult exls(String ids) {

        List<ActorFacexhibition> list = actorFacexhibitionService.selectApprovalByIds(ids);

        ExcelUtil<ActorFacexhibition> util = new ExcelUtil<ActorFacexhibition>(ActorFacexhibition.class);
        return util.exportExcel(list, "facExhibition");
    }

}
