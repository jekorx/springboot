package com.spring.boot.utils;

/**
 * String 工具方法
 * @author wang_donggang
 */
public class StringUtil {

	/**
	 * 空判断
	 * @param str
	 * @return
	 */
	public static boolean nullOrBlank(String str) {
		if (str == null || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

}
