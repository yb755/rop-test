package com.vbgps.rop.response;

import java.io.Serializable;

import com.rop.security.MainError;

public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Result result = new Result();
	private Object data;

	public Response() {
		super();
	}

	public Response(MainError mainError) {
		this.result.setResult("0");
		this.result.setMessage(mainError.getMessage());
		this.result.setErrorCode(mainError.getCode());
	}

	public Response(Result result, Object data) {
		super();
		this.result = result;
		this.data = data;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 对服务名进行标准化处理：如book.upload转换为book-upload，
	 *
	 * @param method
	 * @return
	 */
	protected String transform(String method) {
		if (method != null) {
			method = method.replace(".", "-");
			return method;
		} else {
			return "LACK_METHOD";
		}
	}
}
