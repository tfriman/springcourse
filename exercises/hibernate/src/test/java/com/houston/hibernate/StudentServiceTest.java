package com.houston.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context.xml")
public class StudentServiceTest {

	@Autowired
	StudentService studentService;
	
	@Test
	public void list() {
		assertEquals(3, studentService.list().size());
	}
	
	@Test
	public void get() {
		assertEquals("Henri", studentService.get(2L).getName());
	}
}
