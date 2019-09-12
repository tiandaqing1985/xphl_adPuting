package com.ruoyi.web.controller.today;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.today.domain.ThAdMateria;
import com.ruoyi.today.service.AdCenterService;
import com.ruoyi.today.service.IThAdMateriaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/today/upload")
public class ThUploadController {

    private String prefix = "/today/upload";

    @Autowired
    private IThAdMateriaService thAdMateriaService;
    @Autowired
    private AdCenterService touTiaoAdCenterService;

    @RequiresPermissions("today:upload:view")
    @GetMapping()
    public String upload()
    {
        return prefix + "/campaign";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MultipartFile file_data, String fileId) throws Exception {
//        上传素材
        Long id = thAdMateriaService.uploadMateria(file_data,fileId);

        return AjaxResult.error();
    }

}
