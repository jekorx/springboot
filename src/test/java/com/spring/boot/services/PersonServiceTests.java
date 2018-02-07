package com.spring.boot.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.entities.Person;
import com.spring.boot.services.PersonService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTests {
	@Autowired
	private PersonService ps;
	
	@Test
	public void test1() {
		Person person = ps.findOne(1);
		TestCase.assertEquals(new Integer(25), new Integer(person.getAge()));
	}
}
