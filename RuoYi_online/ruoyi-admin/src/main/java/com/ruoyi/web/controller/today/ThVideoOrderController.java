package com.ruoyi.web.controller.today;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysDictTypeService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.today.domain.ThVideoNeed;
import com.ruoyi.today.domain.ThVideoOrder;
import com.ruoyi.today.domain.enums.VideoOrderStatusEnum;
import com.ruoyi.today.service.IThVideoOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.TableHeaderUI;

/**
 * 视频订单Controller
 *
 * @author ruoyi
 * @date 2020-03-02
 */
@Controller
@RequestMapping("/today/video")
public class ThVideoOrderController extends BaseController {
    private String prefix = "today/video";

    @Autowired
    private IThVideoOrderService thVideoOrderService;
    @Autowired
    private ISysDictDataService dictDataService;

    @RequiresPermissions("today:materia:view")
    @GetMapping("/materia")
    public String materia(ModelMap modelMap) {
        ThVideoOrder thVideoOrder = new ThVideoOrder();
        ThVideoNeed need = new ThVideoNeed();
        thVideoOrder.setNeed(need);
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        List<ThVideoOrder> list = new ArrayList<>();
        //是否有视频组角色
        for (SysRole role : roles) {
            if (role.getRoleKey().equals("videogroup")) {
                //视频组看指定给本组的
                SysDictData sysDictData = dictDataService.selectDictDataByDictValue(ShiroUtils.getLoginName());
                thVideoOrder.getNeed().setGroup(sysDictData.getDictType());
                list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
            }
            if (role.getRoleKey().equals("admin")) {
                //管理员
                list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
            }
            if (role.getRoleKey().equals("yunying")) {
                //运营
                thVideoOrder.setCreateBy(ShiroUtils.getLoginName());
                list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
            }
        }
        modelMap.put("videoMateria",list);
        return prefix + "/materia";
    }

    @RequiresPermissions("today:order:view")
    @GetMapping()
    public String order(ModelMap modelMap) {

        modelMap.put("userId", ShiroUtils.getUserId());

        return prefix + "/order";
    }

    /**
     * 查询视频订单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThVideoOrder thVideoOrder) {
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        //是否有视频组角色
        for (SysRole role : roles) {
            if (role.getRoleKey().equals("videogroup")) {
                //视频组看指定给本组的
                SysDictData sysDictData = dictDataService.selectDictDataByDictValue(ShiroUtils.getLoginName());
                thVideoOrder.getNeed().setGroup(sysDictData.getDictType());
                startPage();
                List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
                return getDataTable(list);
            }
            if (role.getRoleKey().equals("admin")) {
                //管理员
                startPage();
                List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
                return getDataTable(list);
            }
            if (role.getRoleKey().equals("yunying")) {
                //运营
                thVideoOrder.setCreateBy(ShiroUtils.getLoginName());
                startPage();
                List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
                return getDataTable(list);
            }
        }
        return getDataTable(new ArrayList<ThVideoOrder>());
    }

    /**
     * 查询视频订单列表
     */
    @PostMapping("/dictGetType")
    @ResponseBody
    public List<SysDictData> dictGetType(String type) {
        List<SysDictData> list = dictDataService.selectDictDataByType(type);
        return list;
    }

    /**
     * 导出视频订单列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThVideoOrder thVideoOrder) {
        List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
        ExcelUtil<ThVideoOrder> util = new ExcelUtil<ThVideoOrder>(ThVideoOrder.class);
        return util.exportExcel(list, "order");
    }

    @PostMapping("/updateStatus")
    @ResponseBody
    public AjaxResult updateStatus(@RequestParam("statusName") String statusName, ThVideoOrder thVideoOrder) {
        int i = 0;
        try {
            i = thVideoOrderService.updateOrderStatus(thVideoOrder, statusName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toAjax(i);
    }

    /**
     * 新增视频订单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 交付视频素材
     */
    @Log(title = "视频订单", businessType = BusinessType.INSERT)
    @PostMapping("/delivery")
    @ResponseBody
    public AjaxResult delivery(MultipartFile file_data, ThVideoOrder thVideoOrder) {
        thVideoOrder.setScript(file_data);
        try {
            thVideoOrderService.orderDelivery(thVideoOrder);
        } catch (Exception e) {
            return toAjax(0);
        }
        return toAjax(1);
    }

    /**
     * 新增保存视频订单
     */
    @Log(title = "视频订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("logoFile") MultipartFile logoUrl, @RequestParam("videoScriptFile") MultipartFile videoScript, ThVideoOrder thVideoOrder) {
        thVideoOrder.setLogo(logoUrl);
        thVideoOrder.setScript(videoScript);
        thVideoOrder.setCreateBy(ShiroUtils.getLoginName());
        try {
            thVideoOrder.setStatus(VideoOrderStatusEnum.ORDER.getValue());
            thVideoOrderService.insertThVideoOrder(thVideoOrder);
        } catch (Exception e) {
            return toAjax(0);
        }
        return toAjax(1);
    }

    /**
     * 查看视频订单
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/detail";
    }

    /**
     * 交付视频订单
     */
    @GetMapping("/delivery/{id}")
    public String delivery(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/delivery";
    }
    /**
     * 投放视频
     */
    @GetMapping("/putIn/{id}")
    public String putIn(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/putIn";
    }

    /**
     * 修改视频订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存视频订单
     */
    @Log(title = "视频订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam("videoScriptFile") MultipartFile videoScript, ThVideoOrder thVideoOrder) {
        thVideoOrder.setScript(videoScript);

        try {
            thVideoOrderService.updateThVideoOrder(thVideoOrder);
        } catch (Exception e) {
            return toAjax(0);
        }
        return toAjax(1);

    }

    /**
     * 删除视频订单
     */
    @Log(title = "视频订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long ids) {
        return toAjax(thVideoOrderService.deleteThVideoOrderById(ids));
    }

//    /**
//     * 删除视频订单
//     */
//    @Log(title = "视频订单", businessType = BusinessType.DELETE)
//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids) {
//        return toAjax(thVideoOrderService.deleteThVideoOrderByIds(ids));
//    }
}
