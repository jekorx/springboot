package com.spring.boot.config.domains;

/**
 * 自定义异常
 * 继承RuntimeException，而不是Exception，否则导致spring事务无法回滚
 * @author wang_donggang
 */
public class WebException extends RuntimeException {
	
	private static final long serialVersionUID = -239689790668533135L;
	// 自定义错误码
	private int code;
	public WebException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
