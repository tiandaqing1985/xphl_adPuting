package com.ruoyi.web.controller.today;

import java.util.List;
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
import com.ruoyi.today.domain.ThToken;
import com.ruoyi.today.service.IThTokenService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * tokenController
 *
 * @author ruoyi
 * @date 2019-08-20
 */
@Controller
@RequestMapping("/today/token")
public class ThTokenController extends BaseController
{
    private String prefix = "today/token";

    @Autowired
    private IThTokenService thTokenService;

    @RequiresPermissions("today:token:view")
    @GetMapping()
    public String token()
    {
        return prefix + "/token";
    }

    /**
     * 查询token列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThToken thToken)
    {
        startPage();
        List<ThToken> list = thTokenService.selectThTokenList(thToken);
        return getDataTable(list);
    }

    /**
     * 导出token列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThToken thToken)
    {
        List<ThToken> list = thTokenService.selectThTokenList(thToken);
        ExcelUtil<ThToken> util = new ExcelUtil<ThToken>(ThToken.class);
        return util.exportExcel(list, "token");
    }

    /**
     * 新增token
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存token
     */
    @Log(title = "token", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThToken thToken)
    {
        return toAjax(thTokenService.insertThToken(thToken));
    }

    /**
     * 修改token
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ThToken thToken = thTokenService.selectThTokenById(id);
        mmap.put("thToken", thToken);
        return prefix + "/edit";
    }

    /**
     * 修改保存token
     */
    @Log(title = "token", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThToken thToken)
    {
        return toAjax(thTokenService.updateThToken(thToken));
    }

    /**
     * 删除token
     */
    @Log(title = "token", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(thTokenService.deleteThTokenByIds(ids));
    }
}
