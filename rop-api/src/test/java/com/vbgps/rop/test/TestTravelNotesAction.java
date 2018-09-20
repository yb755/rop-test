package com.vbgps.rop.test;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.rop.MessageFormat;
import com.rop.client.DefaultRopClient;

public class TestTravelNotesAction {

	public static final String SERVER_URL = "http://127.0.0.1:8080/rop-api/router";
    public static final String APP_KEY = "100001";
    public static final String APP_SECRET = "a4160d00-b083-40f9-a749-07aef8781d52";
    private DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET, MessageFormat.json);

    @org.junit.Test
    public void test_view_Travel(){
        MultiValueMap<String, String> paramValues = new LinkedMultiValueMap<String, String>();
           //系统级参数
           paramValues.add("method", "user.getSession");
           paramValues.add("appKey", APP_KEY);
           paramValues.add("appSecret", APP_SECRET);
           paramValues.add("v", "1.0");
           paramValues.add("format", "json");
          //String sign = CopUtils.sign(paramValues.toSingleValueMap(), APP_SECRET);
          paramValues.add("sign", "abc");
           //业务参数  不参与签名
           paramValues.add("travelPage", "3");

           String buildGetUrl = "http://127.0.0.1:8080/rop-api/router?appKey=100001&appSecret=asdfasdf&method=user.getSession&v=1.0&sign=abc&format=json";
           String responseContent = new RestTemplate().getForObject(buildGetUrl, String.class, paramValues);
           System.out.println(responseContent);
    }
}
