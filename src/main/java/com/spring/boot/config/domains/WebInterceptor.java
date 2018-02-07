package com.spring.boot.config.domains;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.spring.boot.services.UserService;
import com.spring.boot.utils.ArrayUtil;
import com.spring.boot.utils.CookieUtil;
import com.spring.boot.utils.ResultUtil;
import com.spring.boot.utils.SpringBeanUtil;

/**
 * 拦截器实现类
 * @author wang_donggang
 */
public class WebInterceptor implements HandlerInterceptor {
	
	// 通过SpringUtil中ApplicationContext获取userService bean
    private UserService userService = SpringBeanUtil.getBean("userService", UserService.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
			throws Exception {
		
		// 响应编码utf-8
		response.setCharacterEncoding("UTF-8");
		// 响应数据类型为json
		response.setContentType("application/json; charset=utf-8");
		
		// 响应失败处理
		boolean noError = errorHandler(response);
		if (!noError) {
			return false;
		}
		
		// 指定拦截地址
		for (String url : Constants.INTERCEPTOR_URLS) {
			if (!request.getServletPath().startsWith(url)) {
				return true;
			}
		}
		// 当前页面使用的协议
		//request.getScheme();
		
		if ("GET".equals(request.getMethod())) {
			// GET请求不拦截，正常访问
			return true;
		}
		// 获取所有cookie
		Cookie[] cookies = request.getCookies();
		if (ArrayUtil.nullorBlank(cookies)) {
			// 如果cookie为空
			response.getWriter().write(Constants.USER_NOT_LOGIN);
			return false;
		}
		// 否则获取token
		String token = CookieUtil.getCookieByKey(cookies, Constants.USER_TOKEN);
		// 获取用户登录状态
		boolean isLogin = userService.isLogin(token);
		if (isLogin) {
			// 存在该用户，正常访问
			return true;
		} else {
			// 如果不存在该用户，拦截
			response.getWriter().write(Constants.USER_NOT_LOGIN);
			return false;
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
	}
	
	/**
	 * 响应错误处理
	 * @param response
	 */
	private boolean errorHandler(HttpServletResponse response) throws Exception {
		// 响应状态码
		int statusCode = response.getStatus();
		// 响应失败直接拦截
		if (statusCode == 400) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_400)));
			return false;
		}
		if (statusCode == 401) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_401)));
			return false;
		}
		if (statusCode == 403) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_403)));
			return false;
		}
		if (statusCode == 404) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_404)));
			return false;
		}
		if (statusCode == 405) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_405)));
			return false;
		}
		if (statusCode == 500) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_500)));
			return false;
		}
		if (statusCode == 502) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_502)));
			return false;
		}
		if (statusCode == 503) {
			response.getWriter().write(JSON.toJSONString(ResultUtil.error(ResultEnum.ERROR_CODE_503)));
			return false;
		}
		return true;
	}

}
