package com.spring.boot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.config.domains.Result;
import com.spring.boot.models.UserModel;
import com.spring.boot.services.UserService;
import com.spring.boot.utils.ResultUtil;

/**
 * app登录控制器
 * @author wang_donggang
 */
@RestController
@RequestMapping("/sign/v1")
public class SignController {
	
	@Autowired
	private UserService uService;
	
	/**
	 * app登录请求
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/appIn")
	public Result<String> loginApp(@Valid UserModel user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
		}
		String token = uService.login(user.getLogin(), user.getPwd());
		return ResultUtil.success(token);
	}
	
}
