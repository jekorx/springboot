package com.spring.boot.config.domains;

/**
 * 枚举：返回码-->返回信息
 * @author wang_donggang
 */
public enum ResultEnum {
	UNKNOW_ERROR(-1, "未知错误"),
	SUCCESS(0, "请求成功"),
	FAILED(1, "请求失败"),
	
	USER_NOT_LOGIN(10, "用户没有登录"),
	USER_NOT_EXISTS(11, "用户不存在"),
	USER_PWD_ERROR(12, "密码错误"),
	
	DATA_NOT_EXISTS(40, "数据不存在"),
	
	REDIS_ERROR(90, "缓存错误"),
	
	// 常用请求错误码，主要用于WebInterceptor请求拦截
	ERROR_CODE_400(400, "请求无效"),
	ERROR_CODE_401(401, "未授权"),
	ERROR_CODE_403(403, "禁止访问 "),
	ERROR_CODE_404(404, "请求不存在"),
	ERROR_CODE_405(405, "请求类型错误"),
	ERROR_CODE_500(500, "服务器错误"),
	ERROR_CODE_502(502, "错误网关"),
	ERROR_CODE_503(503, "无法获得服务"),

	;
	// 状态码
	private int code;
	// 返回信息
	private String msg;
	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
