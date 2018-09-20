package com.vbgps.rop;

import java.util.HashMap;
import java.util.Map;

import com.rop.security.AppSecretManager;

public class SimpleAppSecretManager implements AppSecretManager {

	private static Map<String, String> appKeySecretMap = new HashMap<String, String>();

	// TODO
	static {
		// 自用 这些应该从数据库查询出来 这里先写死了 用来和测试（接口调用）的时候传递的秘钥进行比对
		appKeySecretMap.put("100001", "a4160d00-b083-40f9-a749-07aef8781d52");
		// 第三方
		// appKeySecretMap.put("200001", "f7140046-c46f-443d-a151-00e3b8bb5924");
	}

	public String getSecret(String appKey) {
		System.out.println("use SimpleAppSecretManager!");
		return appKeySecretMap.get(appKey);
	}

	public boolean isValidAppKey(String appKey) {
		//return getSecret(appKey) != null;
		 return true;
	}

}
