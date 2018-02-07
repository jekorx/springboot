package com.spring.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.entities.User;

/**
 * 用户-数据库访问组件接口
 * @author wang_donggang
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByULogin(String uLogin);
	
}
