package com.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.entities.Person;
import com.spring.boot.repositories.PersonRepository;

/**
 * 人员业务逻辑处理
 * @author wang_donggang
 */
@Service
public class PersonService {
	
	@Autowired
	private PersonRepository pr;
	
	/**
	 * 事务
	 */
	@Transactional
	public void insertTwo() {
		Person person = new Person();
		person.setName("张三");
		person.setAge(21);
		person.setSex("man");
		
		Person person1 = new Person();
		person1.setName("李四");
		person1.setAge(25);
		person1.setSex("womenwomenwomenwomen");
		
		pr.save(person);
		
		pr.save(person1);
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Person findOne(int id) {
		return pr.findOne(id);
	}
}
