package com.ruoyi.today.tools;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FTPTools {

    private static Logger logger = LoggerFactory.getLogger(FTPTools.class);

    public static FTPClient connectFtp(String addr, int port, String user, String pwd) throws Exception {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(addr, port);
            // 登录
            ftpClient.login(user, pwd);
            // 判断文件服务器是否可用
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                ftpClient.disconnect();
                logger.error("连接ftp" + addr + ":" + port + "被拒绝");
                return null;
            }
        } catch (Exception e) {
            logger.error("连接ftp" + addr + ":" + port + "出现错误：", e);
            throw e;
        }
        return ftpClient;
    }

    public static void uploadFileToFtp(FTPClient ftpClient, String remotePath, String filePath) throws Exception {
        File file = null;
        FileInputStream fileInputStream = null;
        try {
            file = new File(filePath);
            if (file.exists()) {
                logger.error("文件不存在");
            }
        } catch (Exception e) {
            logger.error("创建java文件对象出现错误：", e);
            throw e;
        }
        try {
            fileInputStream = new FileInputStream(file);
            ftpClient.makeDirectory(remotePath);
            ftpClient.changeWorkingDirectory(remotePath);
            ftpClient.storeFile(file.getName(), fileInputStream);
        } catch (Exception e) {
            logger.error("上传文件" + file.getName() + "出现错误", e);
            throw e;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    logger.error("关闭文件输入流时出现错误：", e);
                    throw e;
                }
            }
        }
    }

    public static void downloanFileFromFtp(FTPClient ftpClient, String remotePath, String localPath, String fileName) {

        File localFile = null;
        try {
            localFile = new File(localPath + File.separator + fileName);
            if (!localFile.exists()) {
                localFile.mkdirs();
            }
        } catch (Exception e) {
            logger.error("下载文件到本地的位置错误：", e);
            throw e;
        }
    }

    public static void downloanFileFromFtp(FTPClient ftpClient, String remotePath, FileOutputStream outputStream, String fileName) {



    }

}
