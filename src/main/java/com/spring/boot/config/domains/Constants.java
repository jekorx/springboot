package com.spring.boot.config.domains;

import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.spring.boot.utils.ResultUtil;

/**
 * 常量
 * @author wang_donggang
 */
public class Constants {
	
	// 拦截路径
	public final static String[] INTERCEPTOR_URLS = {"/app/"};
	// 请求拦截的返回json
	public final static String USER_NOT_LOGIN = JSON.toJSONString(ResultUtil.error(ResultEnum.USER_NOT_LOGIN));
	
	// 用户token key
	public final static String USER_TOKEN = "__UTOKEN__";
	
	// redis中保存用户信息变量
	// 保存时长
	public final static int REDIS_EXPIRE = 300;
	// 单位
	public final static TimeUnit REDIS_EXPIRE_UNIT = TimeUnit.MINUTES;
	
}
