package com.vbgps.rop.service;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.vbgps.rop.request.TravelRequest;
import com.vbgps.rop.response.Response;

@ServiceMethodBean
public class DemoService {

	@ServiceMethod(method = "user.getSession", version = "1.0", needInSession = NeedInSessionType.NO)
	public Response getSession(TravelRequest request) {

		// ①访问系统级参数
		String appKey = request.getRopRequestContext().getAppKey();
		System.out.println(appKey);
		// ②-1 访问业务级参数：通过类属性
		String userName1 = request.getUserName();
		System.out.println(userName1);
		// ②-2 访问业务级参数：通过RopRequestContext获取
		String userName2 = request.getRopRequestContext().getParamValue("userName");
		System.out.println(userName2);
		// ③获取其它信息
		String ip = request.getRopRequestContext().getIp();
		System.out.println(ip);
		Response response=new Response();
		response.setData("asbc");
		return response;
	}
}
