package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.ActorInformation;
import com.ruoyi.system.service.IActorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 演员信息Controller
 *
 * @author ruoyi
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/system/information")
public class ActorInformationController extends BaseController {
    private String prefix = "system/information";

    @Autowired
    private IActorInformationService actorInformationService;


    @GetMapping()
    public String information() {
        return prefix + "/information";
    }

    /**
     * 查询演员信息列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorInformation actorInformation) {
        startPage();
        List<ActorInformation> list = actorInformationService.selectActorInformationList(actorInformation);
       for(ActorInformation v:list){
           if(ShiroUtils.getUserName().equals("若依")){
               if(v.getIsfile()!=null&&v.getIsfile().equals("1")){
                   v.setIsfile("3");
               }
           }
       }
        return getDataTable(list);
    }

    /**
     * 导出演员信息列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorInformation actorInformation) {
        List<ActorInformation> list = actorInformationService.selectActorInformationList(actorInformation);
        ExcelUtil<ActorInformation> util = new ExcelUtil<ActorInformation>(ActorInformation.class);
        return util.exportExcel(list, "information");
    }

    /**
     * 新增演员信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存演员信息
     */

    @Log(title = "演员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorInformation actorInformation) {

        actorInformation.setAddTime(new Date());
        actorInformation.setAddUser(ShiroUtils.getUserName());
        actorInformation.setIsfile("1");//1没有归档   0归档
        return toAjax(actorInformationService.insertActorInformation(actorInformation));
    }

    /**
     * 修改演员信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ActorInformation actorInformation = actorInformationService.selectActorInformationById(id);
        mmap.put("actorInformation", actorInformation);
        return prefix + "/edit";
    }


    /**
     * 修改演员信息
     */
    @GetMapping("/isfile")
    public String isfile(Long id, ModelMap mmap) {
        ActorInformation actorInformation = actorInformationService.selectActorInformationById(id);
        mmap.put("actorInformation", actorInformation);
        return prefix + "/isfile";
    }

    /**
     * 修改保存演员信息
     */

    @Log(title = "演员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/isfile")
    @ResponseBody
    public AjaxResult isfileSave(ActorInformation actorInformation) {
        actorInformation.setUpdateUser(ShiroUtils.getUserName());
        actorInformation.setUpdateTime(new Date());
        return toAjax(actorInformationService.updateActorInformation(actorInformation));
    }




    /**
     * 修改保存演员信息
     */

    @Log(title = "演员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorInformation actorInformation) {
        actorInformation.setUpdateUser(ShiroUtils.getUserName());
        actorInformation.setUpdateTime(new Date());
        return toAjax(actorInformationService.updateActorInformation(actorInformation));
    }

    /**
     * 删除演员信息
     */

    @Log(title = "演员信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(actorInformationService.deleteActorInformationByIds(ids));
    }

    /**
     * 获取用户数据
     */
    @GetMapping("/userModel")
    @ResponseBody
    public AjaxResult userModel() {
        List<ActorInformation> sysUsers = actorInformationService.selectAllUserModel();
        AjaxResult ajax = new AjaxResult();
        ajax.put("code", 200);
        ajax.put("value", sysUsers);
        return ajax;
    }


}
