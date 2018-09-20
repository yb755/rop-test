package com.vbgps.rop.request;

import com.rop.AbstractRopRequest;
import com.rop.annotation.IgnoreSign;

public class TravelRequest extends AbstractRopRequest {

	// 用来标注该参数不需要进行签名
	@IgnoreSign
	private String travelPage;
	@IgnoreSign
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTravelPage() {
		return travelPage;
	}

	public void setTravelPage(String travelPage) {
		this.travelPage = travelPage;
	}
}
