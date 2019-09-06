package com.ruoyi.web.controller.today;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.today.domain.ThAdShow;
import com.ruoyi.today.service.IThAdShowService;
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
 * 广告计划显示字段方案Controller
 *
 * @author ruoyi
 * @date 2019-09-04
 */
@Controller
@RequestMapping("/today/show")
public class ThAdShowController extends BaseController {
    private String prefix = "today/show";

    @Autowired
    private IThAdShowService thAdShowService;

    @RequiresPermissions("system:show:view")
    @GetMapping()
    public String show() {
        return prefix + "/show";
    }

    /**
     * 查询广告计划显示字段方案列表
     */
    @PostMapping("/list")
    @ResponseBody
    public List<ThAdShow> list(ThAdShow thAdShow) {
        startPage();
        thAdShow.setCreateBy(ShiroUtils.getLoginName());
        List<ThAdShow> list = thAdShowService.selectThAdShowList(thAdShow);
        return list;
    }

    /**
     * 导出广告计划显示字段方案列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThAdShow thAdShow) {
        List<ThAdShow> list = thAdShowService.selectThAdShowList(thAdShow);
        ExcelUtil<ThAdShow> util = new ExcelUtil<ThAdShow>(ThAdShow.class);
        return util.exportExcel(list, "show");
    }

    /**
     * 新增保存广告计划显示字段方案
     */
    @Log(title = "广告计划显示字段方案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThAdShow thAdShow) {
        String count = thAdShowService.selectCountByCreateBy(ShiroUtils.getLoginName());
        if (count != null) {
            int countNum = Integer.parseInt(count);
            if (countNum >= 5) {
                return AjaxResult.error("最多保存5个方案！！");
            } else {
                thAdShow.setName("方案"+(countNum+1));
                thAdShow.setCreateBy(ShiroUtils.getLoginName());
                return toAjax(thAdShowService.insertThAdShow(thAdShow));
            }
        } else {
            return AjaxResult.error();
        }
    }

    /**
     * 修改广告计划显示字段方案
     */
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ThAdShow thAdShow = thAdShowService.selectThAdShowById(id);
        mmap.put("thAdShow", thAdShow);
        return prefix + "/edit";
    }

    /**
     * 修改保存广告计划显示字段方案
     */
    @Log(title = "广告计划显示字段方案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThAdShow thAdShow) {
        return toAjax(thAdShowService.updateThAdShow(thAdShow));
    }

    /**
     * 删除广告计划显示字段方案
     */
    @Log(title = "广告计划显示字段方案", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(thAdShowService.deleteThAdShowByIds(ids));
    }
}
