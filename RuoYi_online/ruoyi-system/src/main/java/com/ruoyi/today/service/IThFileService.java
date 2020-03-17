package com.ruoyi.today.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IThFileService {
    //接受上传的文件，并将其传到文件服务器中
    String receiveAndUploadFile(MultipartFile multipartFile) throws Exception;

    //接受上传的文件，并将其传到文件服务器中
    String uploadFile(File file) throws Exception;

    //接受上传的文件，并将其传到文件服务器中
    File receiveFile(MultipartFile multipartFile) throws Exception;
}
