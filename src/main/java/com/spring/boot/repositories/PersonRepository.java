package com.spring.boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.entities.Person;

/**
 * 人员-数据库访问组件接口
 * @author wang_donggang
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	public List<Person> findByNameLike(String name);
	
}
