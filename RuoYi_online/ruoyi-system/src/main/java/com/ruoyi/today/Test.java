package com.ruoyi.today;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.today.service.IThAdvertiserService;

public class Test {
	
    @Autowired
    private IThAdvertiserService thAdvertiserService;
    

	
    
    
    
	
	public static void main(String[] args) {
		
		System.out.println(refreshAccessToken().toJSONString()); //刷新token
		
//		System.out.println(getAdvertiserInfo("4d90d52905a63246a0ba9e8fe460a7db78e349d1",1631862587556876L) .toJSONString()); //获取广告主信息
		
//		JSONObject object = getAdvertiserInfo("4d90d52905a63246a0ba9e8fe460a7db78e349d1",1631862587556876L);
//		
//		JSONArray object2 = (JSONArray) object.get("data");
//		JSONObject object3 = (JSONObject) object2.get(0);
//		System.out.println(object3.getString("name"));
//		System.out.println(object3.getLong("id"));
//		System.out.println(object3.getString("status"));
		
		
		
//		System.out.println(selectAgentAdvertiser().toJSONString()); //获取广告主列表
		
//		JSONObject object = (JSONObject) selectAgentAdvertiser().get("data");
//		
//		JSONArray list = (JSONArray) object.get("list");
//		
//		
//	    String access_token = "4d90d52905a63246a0ba9e8fe460a7db78e349d1";
//		
//		for (int i=0;i<list.size();i++){
//			Long id = list.getLong(i);
//			JSONObject advertiserInfo = getAdvertiserInfo(access_token,id) ;
//		}
//		
//		System.out.println(list);
		
		
		
//		System.out.println(getCampaign().toJSONString());//获取广告组
		
//		System.out.println(createCampaign().toJSONString()); //创建广告组
//		System.out.println(getCampaign().toJSONString());//获取广告组
//		System.out.println(uploadAdImage().toJSONString());//上传图片
		
/*	
 * {"code":0,"data":{"access_token":"9af772189121e31a6d82913e4666caaf20f57356","refresh_token_expires_in":2591999,"refresh_token":"193708baaa99a0dda034f1d3d47cbf456bdbd932","expires_in":86399},"message":"OK","request_id":"20190814141043010008033076169812"}
*/
		
	}

	
	public static JSONObject getAccessToken() {
	    String access_token = "da921f925fff4f4af846c9c7ef0edd74e05702cb";

	    // 请求地址https://ad.toutiao.com/open_api/oauth2/access_token/
	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/";
	    String uri = "oauth2/access_token/";
	    
	    Long app_id = 1641099262856206L;

	    // 请求参数
	    Map data = new HashMap() {
	        {
	            put("app_id", app_id);
	            put("secret", "d8d831d26a6f5b71eca765db44e9a39120f92a0f");
	            put("grant_type", "auth_code");
	            put("auth_code", "c77182b37772521da004dd64272130e423f9d72d");
	        }
	    };

	    // 构造请求
	    HttpPost httpEntity = new HttpPost(open_api_url_prefix + uri);
	    
	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

	        response = client.execute(httpEntity);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while ((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	/**
	 * 刷新token
	 * @return
	 */
	public static JSONObject refreshAccessToken() {

	    // 请求地址 https://ad.toutiao.com/open_api/oauth2/refresh_token/
	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/";
	    String uri = "oauth2/refresh_token/";

	    // 请求参数
	    Long app_id = 1641099262856206L;
	    Map<String,Object>data = new HashMap<String,Object>() {
	        {
	            put("app_id", app_id);
	            put("secret", "d8d831d26a6f5b71eca765db44e9a39120f92a0f");
	            put("grant_type", "refresh_token");
	            put("refresh_token", "7bacba909511d6087cb8f2470c519613406be8d5");
	        }
	    };

	    // 构造请求
	    HttpPost httpEntity = new HttpPost(open_api_url_prefix + uri);

	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

	        response = client.execute(httpEntity);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while ((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	
	/**
	 * 获取广告主列表
	 * @return
	 */
	public static JSONObject selectAgentAdvertiser() {
	    String access_token = "9af772189121e31a6d82913e4666caaf20f57356";
	    final Long advertiser_id = 1630607157951491L;

	    // 请求地址 https://ad.toutiao.com/open_api/2/agent/advertiser/select/
	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
	    String uri = "agent/advertiser/select/";

	    // 请求参数
	    Map<String,Object> data = new HashMap<String,Object>(){
	        {
	            put("advertiser_id", advertiser_id);
	            put("page", 1);
	            put("page_size", 1000);
	        }
	    };

	    // 构造请求
	    HttpEntityEnclosingRequestBase httpEntity = new HttpEntityEnclosingRequestBase() {
	        @Override
	        public String getMethod() {
	            return "GET";
	        }
	    };

	    httpEntity.setHeader("Access-Token",access_token);

	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpEntity.setURI(URI.create(open_api_url_prefix + uri));
	        httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

	        response = client.execute(httpEntity);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	
	/**
	 * 获取账号管家列表
	 * @return
	 */
	public static JSONObject getAdvertiser() {
	    String access_token = "4d90d52905a63246a0ba9e8fe460a7db78e349d1";
	    final Long advertiser_id = 1630607157951491L;

	    // 请求地址
	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
	    String uri = "majordomo/advertiser/select/";

	    // 请求参数
	    Map<String,Object> data = new HashMap<String,Object>(){
	        {
	            put("advertiser_id", advertiser_id);
	        }
	    };

	    // 构造请求
	    HttpEntityEnclosingRequestBase httpEntity = new HttpEntityEnclosingRequestBase() {
	        @Override
	        public String getMethod() {
	            return "GET";
	        }
	    };

	    httpEntity.setHeader("Access-Token",access_token);

	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpEntity.setURI(URI.create(open_api_url_prefix + uri));
	        httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

	        response = client.execute(httpEntity);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	/**
	 * 获取广告主信息
	 * @return
	 */
	public static JSONObject getAdvertiserInfo(String access_token,Long advertiser_id) {
//	    String access_token = "4d90d52905a63246a0ba9e8fe460a7db78e349d1";
//	    final Long advertiser_id = 1641276744111108L;

	    // 请求地址
	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
	    String uri = "advertiser/info/";

	    // 请求参数
	    Map<String ,Object> data = new HashMap<String ,Object>(){
	        {
	            put("advertiser_ids", new Long[] {advertiser_id});
	            put("fields", new String[] {"id", "name", "email", "status"});
	        }
	    };

	    // 构造请求
	    HttpEntityEnclosingRequestBase httpEntity = new HttpEntityEnclosingRequestBase() {
	        @Override
	        public String getMethod() {
	            return "GET";
	        }
	    };

	    httpEntity.setHeader("Access-Token",access_token);

	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpEntity.setURI(URI.create(open_api_url_prefix + uri));
	        httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

	        response = client.execute(httpEntity);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	
	
	/**
	 * 获取广告组
	 * @return
	 */
	public static JSONObject getCampaign() {
	    String access_token = "4d90d52905a63246a0ba9e8fe460a7db78e349d1";
	    final Long advertiser_id = 1641276744111108L;  //操作的广告主id
	    final int page = 1;
	    final int page_size = 10;
	    final String landing_type = "APP";
	    final String status = "CAMPAIGN_STATUS_ENABLE";
	    final Long[] ids = new Long[]{0L, 1L};
	    final String[] fields = new String[]{"id", "name"};

	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
	    String uri = "campaign/get/";

	    // 请求参数
	    final Map filtering = new HashMap() {
	        {
//	        	put("campaign_create_time","2019-08-07");
//	            put("landing_type", landing_type);
//	            put("status", status);
//	            put("ids", ids);
	        }
	    };
	    Map<String,Object> data = new HashMap<String,Object>(){
	        {
	            put("advertiser_id", advertiser_id);
	            put("page", page);
	            put("page_size", page_size);
//	            put("filtering", filtering);
	            put("fields", fields);
	        }
	    };

	    // 构造请求
	    HttpEntityEnclosingRequestBase httpEntity = new HttpEntityEnclosingRequestBase() {
	        @Override
	        public String getMethod() {
	            return "GET";
	        }
	    };

	    httpEntity.setHeader("Access-Token",access_token);

	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpEntity.setURI(URI.create(open_api_url_prefix + uri));
	        httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

	        response = client.execute(httpEntity);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	/**
	 * 创建广告组
	 * @return
	 */
	public static JSONObject createCampaign() {
	    String access_token = "4d90d52905a63246a0ba9e8fe460a7db78e349d1";
	    final Long advertiser_id = 1641276744111108L;  //操作的广告主id 
	    final String campaign_name = "测试广告组001"; //广告组名称
	    final Float budget = 1200f;//广告组预算
	    final String landing_type = "LINK"; // 推广目的
	    final String budget_mode = "BUDGET_MODE_DAY"; //预算类型

	    // 请求地址https://test-ad.toutiao.com/open_api
	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/2/";
	    String uri = "campaign/create/";

	    // 请求参数
	    Map<String, Object> data = new HashMap<String, Object>(){
	        {
	            put("advertiser_id",advertiser_id);
	            put("campaign_name",campaign_name);
	            put("budget",budget);
	            put("landing_type", landing_type);
	            put("budget_mode", budget_mode);
	        }
	    };

	    // 构造请求
	    HttpPost httpEntity = new HttpPost(open_api_url_prefix + uri);

	    httpEntity.setHeader("Access-Token",access_token);

	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpEntity.setEntity(new StringEntity(JSONObject.toJSONString(data), ContentType.APPLICATION_JSON));

	        response = client.execute(httpEntity);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	/**
	 * 上传广告图片
	 * @return
	 */
	public static JSONObject uploadAdImage() {

	    // 请求地址
	    String open_api_url_prefix = "https://test-ad.toutiao.com/open_api/2/";
	    String uri = "file/image/ad/";

	    String image_file = "E:\\aaa.png";

	    // 构造请求
	    HttpPost httpPost = new HttpPost(open_api_url_prefix + uri);
	    httpPost.setHeader("Access-Token", "899931d441c56eabb1c3f1b5851f53dd508aefcb");

	    // 文件参数        
	    FileBody file = new FileBody(new File(image_file));
	    MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create()
	            .addPart("image_file", file);

	    // 其他参数
	    entityBuilder.addTextBody("advertiser_id", "3337720745703741");
	    entityBuilder.addTextBody("image_signature", "xphl");
	    HttpEntity entity = entityBuilder.build();

	    CloseableHttpResponse response = null;
	    CloseableHttpClient client = null;

	    try {
	        client = HttpClientBuilder.create().build();
	        httpPost.setURI(URI.create(open_api_url_prefix + uri));

	        httpPost.setEntity(entity);

	        response = client.execute(httpPost);
	        if (response != null && response.getStatusLine().getStatusCode() == 200) {
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while ((line = bufferedReader.readLine()) != null) {
	                result.append(line);
	            }
	            bufferedReader.close();
	            return JSONObject.parseObject(result.toString());
	        }

	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (response != null) {
	                response.close();
	            }
	            client.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
}
