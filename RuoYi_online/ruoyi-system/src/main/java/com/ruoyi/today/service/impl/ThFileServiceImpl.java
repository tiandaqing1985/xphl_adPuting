package com.ruoyi.today.service.impl;

import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.today.service.IThFileService;
import com.ruoyi.today.tools.PmsUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ThFileServiceImpl implements IThFileService {

    public static String tempPath = "temp";
    private static Logger logger = LoggerFactory.getLogger(ThFileServiceImpl.class);

    //接受上传的文件，并将其传到文件服务器中
    @Override
    public String receiveFile(MultipartFile multipartFile) throws Exception {
        String localPath = null;
        String url = null;
        try {
            //文件保存到临时目录
            logger.info("开始接受文件" + multipartFile.getOriginalFilename() + "到暂存目录" + tempPath);
            localPath = FileUploadUtils.upload(tempPath, multipartFile, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
            logger.info("文件" + multipartFile.getOriginalFilename() + "已经保存到暂存目录" + tempPath);
        } catch (IOException e) {
            logger.error("接收文件" + multipartFile.getOriginalFilename() + "到暂存目录中断：", e);
            throw e;
        } catch (InvalidExtensionException e) {
            logger.error("不合法的文件类型：" + multipartFile.getOriginalFilename(), e);
            throw e;
        }
        try {
            File file = new File(localPath.replace("/profile/",""));
            url = PmsUploadUtil.uploadImage(file);
            file.delete();
            return url;
        } catch (Exception e) {
            logger.error(multipartFile.getOriginalFilename() + "上传文件服务器出现异常：", e);
            throw e;
        }

    }

}
