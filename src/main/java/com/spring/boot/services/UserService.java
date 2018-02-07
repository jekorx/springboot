package com.spring.boot.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSON;
import com.spring.boot.config.domains.Constants;
import com.spring.boot.config.domains.ResultEnum;
import com.spring.boot.config.domains.WebException;
import com.spring.boot.entities.User;
import com.spring.boot.repositories.UserRepository;
import com.spring.boot.utils.MD5Util;
import com.spring.boot.utils.StringUtil;

/**
 * 用户业务逻辑处理
 * @author wang_donggang
 */
@Service
public class UserService {
	
	
	
	@Autowired
	private UserRepository userReponsitory;
	
	// redis
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username, String password) {
		User loginUser = userReponsitory.findByULogin(username);
		if (loginUser == null) {
			throw new WebException(ResultEnum.USER_NOT_EXISTS);
		} else {
			String pwd = MD5Util.MD5(password);
			if (pwd.equals(loginUser.getuPwd())) {
				String uuid = UUID.randomUUID().toString();
				String token = Base64Utils.encodeToString(uuid.getBytes());
				// 将<token, 用户信息>保存到redis
				// TODO
				String userJson = JSON.toJSONString(loginUser);
				redisTemplate.opsForValue().set(token, userJson, Constants.REDIS_EXPIRE, Constants.REDIS_EXPIRE_UNIT);
				return token;
			} else {
				throw new WebException(ResultEnum.USER_PWD_ERROR);
			}
		}
	}
	
	/**
	 * 登录用户的每次操作更新redis中保存的登录信息的有效期
	 * @param token
	 */
	private void reSaveLoginExpire(String token) {
		try {
			redisTemplate.expire(token, Constants.REDIS_EXPIRE, Constants.REDIS_EXPIRE_UNIT);
		} catch (Exception e) {
			throw new WebException(ResultEnum.REDIS_ERROR);
		}
	}
	
	/**
	 * 登录用户信息是否存在于redis
	 * @param token
	 * @return
	 */
	public boolean isLogin(String token) {
		String userJson = null;
		try {
			// 从redis中获取保存的登录用户信息
			userJson = redisTemplate.opsForValue().get(token);
		} catch (Exception e) {
			throw new WebException(ResultEnum.REDIS_ERROR);
		}
		if (StringUtil.nullOrBlank(userJson)) {
			return false;
		}
		// 登录用户的每次操作更新redis中保存的登录信息的有效期
		reSaveLoginExpire(token);
		return true;
	}
	
}
