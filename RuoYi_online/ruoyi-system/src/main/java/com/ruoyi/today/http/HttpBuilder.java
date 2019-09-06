package com.ruoyi.today.http;

import com.ruoyi.today.domain.ThToken;
import com.ruoyi.today.service.IThTokenService;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class HttpBuilder {

    @Autowired
    private IThTokenService thTokenService;

    public HttpHeaders buildTouTiaoHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("Access-Token", token);
        return headers;
    }

    public HttpHeaders buildTouTiaoHeader() {

        List<ThToken> thTokens = thTokenService.selectThTokenList(new ThToken());

        return buildTouTiaoHeader(thTokens.get(0).getAccessToken());
    }

    public RestTemplate buildRestTemplate() {
        return new RestTemplate();
    }

}
