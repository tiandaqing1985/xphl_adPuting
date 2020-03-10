package com.lhl;

import com.alibaba.fastjson.JSON;
import com.ruoyi.today.domain.response.ResponseVO;
import org.apache.http.entity.ContentType;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class demo {
    public static void main(String[] args) throws Exception {

        String imgUrl =  "http://192.168.88.192";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
//        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径
        String tracker = new File("E:\\xphl_adPuting\\RuoYi_online\\ruoyi-system\\src\\main\\resources\\tracker.conf").getAbsolutePath();// 获得配置文件的路径

        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 通过tracker获得一个Storage链接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);
        FileInputStream inputStream = null;
        try {

            int group1 = storageClient.download_file("group1", "M00/00/00/wKhYwF5l5TuAZi_kAACnamcASu8483.PNG", "d:/txt.png");

        } catch (Exception e) {
            throw e;
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
        }

    }
}
