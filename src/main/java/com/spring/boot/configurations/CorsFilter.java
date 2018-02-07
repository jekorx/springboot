package com.spring.boot.configurations;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 跨域访问过滤器
 * @author wang_donggang
 */
@Component
public class CorsFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;

		HttpServletRequest request = (HttpServletRequest) req;
		
		// 从request中的header中获取Origin，来做配置
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		// 是否允许浏览器发送Cookie
		response.setHeader("Access-Control-Allow-Credentials", "true");
		// 客户端所要访问的资源允许使用的方法或方法列表
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		// 正式请求的首部信息
		// x-requested-with：ajax请求
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		// preflight request （预检请求）的返回结果
		//（即 Access-Control-Allow-Methods 和Access-Control-Allow-Headers 提供的信息）
		// 可以被缓存多久
		response.setHeader("Access-Control-Max-Age", "3600");
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
