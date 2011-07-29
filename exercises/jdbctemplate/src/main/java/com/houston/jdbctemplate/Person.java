package com.houston.jdbctemplate;

/**
 * Person domain object.
 */
public class Person {

    public final Long id;
    public final String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
