package com.spring.boot.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* 模版时使用
@Controller
*/
@RestController
@RequestMapping("/app/v1")
public class HelloController {
	
	@GetMapping("/hello/{id}")
	public String hello(@PathVariable(value = "id") int id,
						@RequestParam(value = "lang", defaultValue="0") String lang) {
		return "Hello Spring Boot! --> ";
		/* thymeleaf模版 参数：Model model
		model.addAttribute("person", person);
		return "index";
		*/
	}
}
