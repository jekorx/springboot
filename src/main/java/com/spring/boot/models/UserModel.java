package com.spring.boot.models;

import javax.validation.constraints.NotNull;

/**
 * 用户模型
 * @author wang_donggang
 */
public class UserModel {
	@NotNull(message = "帐号不能为空")
	private String login;
	@NotNull(message = "密码不能为空")
	private String pwd;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
