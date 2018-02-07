package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序启动入口
 * @author wang_donggang
 */
@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {
	
	/*
	// springloaded配置
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
