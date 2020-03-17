package com.ruoyi.today.tools;

import org.apache.http.entity.ContentType;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PmsUploadUtil {

    public static String downLoadFile(String remoteFilename,String fileName) throws IOException, MyException {

        String imgUrl =  "http://192.168.88.192";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
//        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径
        String tracker = new File("config/tracker.conf").getAbsolutePath();// 获得配置文件的路径

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
        try {
            File file = new File(fileName);
            storageClient.download_file("group1",remoteFilename.split("/group1/")[1],file.getAbsolutePath());
            imgUrl = file.getAbsolutePath();
        } catch (Exception e) {
            throw e;
        }
        return imgUrl;
    }

    public static String uploadImage(File multipartFile) throws IOException, MyException {

        String imgUrl =  "http://192.168.88.192";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
//        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径
        String tracker = new File("config/tracker.conf").getAbsolutePath();// 获得配置文件的路径

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

            inputStream = new FileInputStream(multipartFile);

            MultipartFile partFile = new MockMultipartFile(multipartFile.getName(), multipartFile.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);

            byte[] bytes = partFile.getBytes();

            // 获得文件后缀名
            String originalFilename = multipartFile.getName();
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i+1);

            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

            for (String uploadInfo : uploadInfos) {
                imgUrl += "/"+uploadInfo;
            }
        } catch (Exception e) {
            throw e;
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
        }
        return imgUrl;
    }

    public static String uploadImage(MultipartFile multipartFile) throws IOException, MyException {

        String imgUrl =  "http://192.168.88.192";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
//        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径
        String tracker = new File("config/tracker.conf").getAbsolutePath();// 获得配置文件的路径

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

        try {

            byte[] bytes = multipartFile.getBytes();// 获得上传的二进制对象

            // 获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();// a.jpg
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i+1);

            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

            for (String uploadInfo : uploadInfos) {
                imgUrl += "/"+uploadInfo;
            }
        } catch (Exception e) {
            throw e;
        }
        return imgUrl;
    }

}
