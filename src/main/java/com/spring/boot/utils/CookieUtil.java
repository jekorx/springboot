package com.spring.boot.utils;

import javax.servlet.http.Cookie;

/**
 * cookie相关操作工具类
 * @author wang_donggang
 */
public class CookieUtil {

	/**
	 * 根据key获取cookie
	 * @param cookies
	 * @param key
	 * @return
	 */
	public static String getCookieByKey(Cookie[] cookies, String key) {
		String value = null;
		for (Cookie cookie : cookies) {
			if (key.equals(cookie.getName())) {
				value = cookie.getValue();
				break;
			}
		}
		return value;
	}
	
}
