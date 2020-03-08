package com.ruoyi.today.service;

import org.springframework.web.multipart.MultipartFile;

public interface IThFileService {
    //接受上传的文件，并将其传到文件服务器中
    String receiveFile(MultipartFile multipartFile) throws Exception;
}
