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

		// ②-1 访问业务级参数：通过类属性
		String userName1 = request.getUserName();
		// ②-2 访问业务级参数：通过RopRequestContext获取
		String userName2 = request.getRopRequestContext().getParamValue("userName");

		// ③获取其它信息
		String ip = request.getRopRequestContext().getIp();

		return new Response();
	}
}
