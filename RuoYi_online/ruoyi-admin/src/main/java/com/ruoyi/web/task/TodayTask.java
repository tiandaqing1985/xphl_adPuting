package com.ruoyi.web.task;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.today.domain.ThToken;
import com.ruoyi.today.mapper.ThTokenMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("todayTask")
public class TodayTask {
	
    @Autowired
    private ThTokenMapper thTokenMapper;

	
	@Transactional
	public void refreshToken(){
		
		List<ThToken> list = thTokenMapper.selectThTokenList(null);
		
		if(list!=null && list.size()>0){
			ThToken thToken = list.get(0);
			JSONObject object = refreshAccessToken(thToken.getRefreshToken());
			JSONObject object1 = object.getJSONObject("data");
			ThToken thToken1 = new ThToken();
			
			thToken1.setCode(object.getString("code"));
			thToken1.setMessage(object.getString("message"));
			thToken1.setRequestId(object.getString("request_id"));
			
			thToken1.setAccessToken(object1.getString("access_token"));
			thToken1.setRefreshToken(object1.getString("refresh_token"));
			
			thTokenMapper.deleteThTokenById(null);
			thTokenMapper.insertThToken(thToken1);

//			ShiroUtils.getSession().setAttribute("token",object1.getString("access_token"));
			
//			{"code":0,"data":{"access_token":"fe101cab51a11a4dd9858d9ba12e290607882406","refresh_token_expires_in":2591948,"refresh_token":"b5651fbe59f24992cbb0905d169f8db4b8c51f51","expires_in":86348},"message":"OK","request_id":"20190819170855010008033045532BCB"}
			
		}
		
		
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
				put("auth_code", "f28072e8bb4290df3865d4bafb021ff089eaf2fc");
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
	public  JSONObject refreshAccessToken(String refresh_token) {

	    // 请求地址
	    String open_api_url_prefix = "https://ad.toutiao.com/open_api/";
	    String uri = "oauth2/refresh_token/";

	    // 请求参数
	    Long app_id = 1641099262856206L;
	    Map<String,Object>data = new HashMap<String,Object>() {
	        {
	            put("app_id", app_id);
	            put("secret", "d8d831d26a6f5b71eca765db44e9a39120f92a0f");
	            put("grant_type", "refresh_token");
	            put("refresh_token", refresh_token);
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

}
