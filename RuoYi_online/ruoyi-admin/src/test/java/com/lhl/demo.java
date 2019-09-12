package com.lhl;

import com.alibaba.fastjson.JSON;
import com.ruoyi.today.domain.response.ResponseVO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;

public class demo {
    public static void main(String[] args) throws Exception {
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\测试.mp4");
        String s = DigestUtils.md5DigestAsHex(new FileInputStream(file1));
        System.out.println(s);


        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        headers.set("Access-Token", "7facda5edd92593d99d23bd486d0497d7d296317");

        //设置请求体，注意是LinkedMultiValueMap
        FileSystemResource fileSystemResource = new FileSystemResource(file1);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("video_file", fileSystemResource);
        form.add("advertiser_id","1641276744111108");
        form.add("video_signature",s);

        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);

        RestTemplate restTemplate = new RestTemplate();
        long l1 = System.currentTimeMillis();
        ResponseVO response = restTemplate.postForObject("https://ad.toutiao.com/open_api/2/file/video/ad/", files, ResponseVO.class);
        long l2 = System.currentTimeMillis();
        System.out.println("耗时："+(l2-l1)+"ms");
        System.out.println("上传视频响应报文：" + JSON.toJSONString(response));


//        String access_token = "7facda5edd92593d99d23bd486d0497d7d296317";
//
//        // 请求地址
//        String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
//        String uri = "file/video/ad/";
//
//
//        // 构造请求
//        HttpPost httpPost = new HttpPost(open_api_url_prefix + uri);
//        httpPost.setHeader("Access-Token", access_token);
//
//        // 文件参数
//        FileBody file = new FileBody(file1);
//        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create()
//                .addPart("video_file", file);
//
//        // 其他参数
//        entityBuilder.addTextBody("advertiser_id", "1641276744111108");
//        entityBuilder.addTextBody("video_signature", s);
//        HttpEntity entity = entityBuilder.build();
//        CloseableHttpResponse response = null;
//        CloseableHttpClient client = null;
//
//        try {
//            client = HttpClientBuilder.create().build();
//            httpPost.setURI(URI.create(open_api_url_prefix + uri));
//
//            httpPost.setEntity(entity);
//            long l1 = System.currentTimeMillis();
//            response = client.execute(httpPost);
//            long l2 = System.currentTimeMillis();
//            System.out.println("耗时：" + (l2 - l1) + "ms");
//            if (response != null && response.getStatusLine().getStatusCode() == 200) {
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//                StringBuffer result = new StringBuffer();
//                String line = "";
//                while ((line = bufferedReader.readLine()) != null) {
//                    result.append(line);
//                }
//                bufferedReader.close();
//                System.out.println(JSONObject.parseObject(result.toString()));
//            }
//
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (response != null) {
//                    response.close();
//                }
//                client.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
