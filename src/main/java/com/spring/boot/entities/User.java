package com.spring.boot.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表实体类
 * @author wang_donggang
 */
@Entity
@Table(name = "t_users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int uid;
	@Column(name = "ulogin")
	private String uLogin;
	@Column(name = "upwd")
	private String uPwd;
	@Column(name = "uname")
	private String uName;
	@Column(name = "age")
	private int age;
	public User() {
		
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getuLogin() {
		return uLogin;
	}
	public void setuLogin(String uLogin) {
		this.uLogin = uLogin;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
