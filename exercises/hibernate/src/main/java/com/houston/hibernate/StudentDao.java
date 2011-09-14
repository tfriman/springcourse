package com.houston.hibernate;

import java.util.List;

/**
 * DO NOT EDIT
 */
public interface StudentDao {

	Student get(Long id);
	
	List<Student> list();
}
