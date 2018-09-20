package com.vbgps.rop.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.rop.MessageFormat;
import com.rop.client.DefaultRopClient;
import com.rop.utils.RopUtils;

public class TestTravelNotesAction {

	public static final String SERVER_URL = "http://127.0.0.1:8080/rop-api/router";
	public static final String APP_KEY = "100001";
	public static final String APP_SECRET = "a4160d00-b083-40f9-a749-07aef8781d52";
	private DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET, MessageFormat.json);

	@org.junit.Test
	public void test_view_Travel() {
		Map<String, String> paramValues = new HashMap<String, String>();
		// 系统级参数
		paramValues.put("method", "user.getSession");
		paramValues.put("appKey", APP_KEY);
		paramValues.put("appSecret", APP_SECRET);
		paramValues.put("v", "1.0");
		paramValues.put("format", "json");
		paramValues.put("userName", "3");
		String sign = RopUtils.sign(paramValues, APP_SECRET);
		paramValues.put("sign", sign);
		// 业务参数 不参与签名
		System.out.println(sign);
		String buildGetUrl = builtUrl(SERVER_URL, paramValues);
		String responseContent = new RestTemplate().getForObject(buildGetUrl, String.class, paramValues);
		System.out.println(responseContent);
	}

	private String builtUrl(String url, Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		sb.append("?");
		Set<String> keys = params.keySet();
		for (String key : keys) {
			sb.append(key);
			sb.append("=");
			sb.append(params.get(key));
			sb.append("&");
		}
		if (!keys.isEmpty()) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
