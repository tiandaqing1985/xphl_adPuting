package com.ruoyi.web.controller.system;

import com.mchange.lang.ShortUtils;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.ActorFile;
import com.ruoyi.system.domain.ActorInformation;
import com.ruoyi.system.service.IActorFileService;
import com.ruoyi.system.service.IActorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * 演员文件储存路径Controller
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
@Controller
@RequestMapping("/system/file")
public class ActorFileController extends BaseController
{
    private String prefix = "system/file";

    @Autowired
    private IActorFileService actorFileService;
    @Autowired
    private IActorInformationService actorInformationService;

    @GetMapping()
    public String file()
    {
        return prefix + "/file";
    }

    /**
     * 查询演员文件储存路径列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActorFile actorFile)
    {
        startPage();
        List<ActorFile> list = actorFileService.selectActorFileList(actorFile);
        return getDataTable(list);
    }

    /**
     * 导出演员文件储存路径列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActorFile actorFile)
    {
        List<ActorFile> list = actorFileService.selectActorFileList(actorFile);
        ExcelUtil<ActorFile> util = new ExcelUtil<ActorFile>(ActorFile.class);
        return util.exportExcel(list, "file");
    }

    /**
     * 新增演员文件储存路径
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存演员文件储存路径
     */

    @Log(title = "演员文件储存路径", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActorFile actorFile)
    {
        return toAjax(actorFileService.insertActorFile(actorFile));
    }

    /**
     * 修改演员文件储存路径
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ActorFile actorFile = actorFileService.selectActorFileById(id);
        mmap.put("actorFile", actorFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存演员文件储存路径
     */

    @Log(title = "演员文件储存路径", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActorFile actorFile)
    {
        return toAjax(actorFileService.updateActorFile(actorFile));
    }

    /**
     * 删除演员文件储存路径
     */
    @Log(title = "演员文件储存路径", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(actorFileService.deleteActorFileByIds(ids));
    }




    @Log(title = "下载图片")
    @GetMapping("/xaizai")
    @ResponseBody
    public void xaizai(@RequestParam("id") Long id, HttpServletResponse response) throws Exception {
        ActorInformation actorInformation =actorInformationService.selectActorInformationById(id);
        actorFileService.xaizaiIdnumber(actorInformation.getIdnumber());
        File file = null;
        String filePath = "/opt/toutiao/webapps/upload";
        file = new File(filePath+File.separator+actorInformation.getIdnumber()+"s"+File.separator+actorInformation.getIdnumber()+".zip");

        ServletOutputStream outputStream = null;
        try {
            // 下载名称
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName="+actorInformation.getIdnumber()+".zip");
            outputStream = response.getOutputStream();
            FileUtils.writeBytes(file.getAbsolutePath(), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    /**
     * 上传多张图片
     */
    @PostMapping("/uploadList")
    @ResponseBody
    public AjaxResult uploadList(MultipartFile file_data, String fileId) throws Exception {
        actorFileService.facuploadMateria(file_data, fileId, ShiroUtils.getUserId());
        return AjaxResult.error();
    }

    /** 验证图片是否上传 */
    @Log(title = "图片是否已经上传")
    @PostMapping("/ifPicUpload")
    @ResponseBody
    public String ifPicUpload(ActorInformation actorInformation) {
        boolean flag = actorFileService.ifPicUpload(ShiroUtils.getUserId(),actorInformation.getIdnumber());
        if(flag){
            return "1";
        }
        return "0";
    }
}
