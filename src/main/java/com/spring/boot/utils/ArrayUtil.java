package com.spring.boot.utils;

/**
 * 数组工具类
 * @author wang_donggang
 */
public class ArrayUtil {
	
	/**
	 * 数组是否为空
	 * @param array
	 * @return
	 */
	public static <T> boolean nullorBlank(T[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}
	
}
