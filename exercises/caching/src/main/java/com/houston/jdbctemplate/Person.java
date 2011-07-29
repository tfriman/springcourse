package com.houston.jdbctemplate;

import java.io.Serializable;

/**
 * Person domain object.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 12341555L;

    public final Long id;
    public final String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
