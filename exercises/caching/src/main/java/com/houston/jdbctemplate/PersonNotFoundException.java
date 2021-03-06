package com.houston.jdbctemplate;

/**
 * Specific exception for this exercise.
 *
 * @author Timo Friman
 */
public class PersonNotFoundException extends RuntimeException {


    public PersonNotFoundException(Long id) {
        super("Id '" + id + "' not found");
    }


}
