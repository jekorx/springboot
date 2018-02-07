package com.spring.boot.utils;

import java.util.List;

/**
 * List 工具方法
 * @author wang_donggang
 */
public class ListUtil {

	/**
	 * 判断list是否为空
	 * @param list
	 * @return
	 */
	public static boolean nullorBlank(List<?> list) {
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

}
