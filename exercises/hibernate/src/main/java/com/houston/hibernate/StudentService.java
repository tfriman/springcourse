package com.houston.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DO NOT EDIT
 */
@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Student get(Long id) {
		return studentDao.get(id);
	}

	public List<Student> list() {
		return studentDao.list();
	}
}
