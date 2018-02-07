package com.spring.boot.configurations;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.HttpPutFormContentFilter;

/**
 * 通过过滤器启用put请求
 * @author wang_donggang
 */
@Component
public class PutRequestFilter extends HttpPutFormContentFilter {
}
