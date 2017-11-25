package com.basic.cms.core;

/**
 * 
 * @description 请求响应对象 并包含快速构建响应对象的静态方法
 *
 * @author YG
 *
 *         2017年7月5日
 */
public class ResponseModel {
	// 响应状态码
	private Integer status;
	// 响应数据
	private Object data;
	// 响应消息
	private String msg;

	/**
	 * 用于创建一个自定义的响应对象
	 * 
	 * @param status
	 *            响应状态码
	 * @param msg
	 *            响应消息
	 * @param data
	 *            响应数据
	 * @return 自定义的响应对象
	 */
	public static ResponseModel build(Integer status, String msg, Object data) {
		return new ResponseModel(status, data, msg);
	}

	/**
	 * 用于创建一个不包含响应数据的响应对象
	 * 
	 * @param status
	 *            响应状态码
	 * @param msg
	 *            响应消息
	 * @return 不包含响应数据的响应对象
	 */
	public static ResponseModel build(Integer status, String msg) {
		return new ResponseModel(status, null, msg);
	}

	/**
	 * 用于创建一个自定义响应数据的响应对象，默认响应状态码为200，响应消息为OK
	 * 
	 * @param data
	 *            响应数据
	 * @return 一个自定义响应数据的响应对象，默认响应状态码为200，响应消息为OK
	 */
	public static ResponseModel ok(Object data) {
		return new ResponseModel(data);
	}

	/**
	 * 用于创建一个自定义响应数据的响应对象，默认响应状态码为200，响应消息为OK，没有响应数据
	 * 
	 * @return 一个自定义响应数据的响应对象，默认响应状态码为200，响应消息为OK，没有响应数据
	 */
	public static ResponseModel ok() {
		return new ResponseModel(null);
	}

	public ResponseModel() {
	}

	public ResponseModel(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public ResponseModel(Integer status, Object data, String msg) {
		super();
		this.status = status;
		this.data = data;
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
