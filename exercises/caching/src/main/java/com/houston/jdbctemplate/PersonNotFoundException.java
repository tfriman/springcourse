package com.houston.jdbctemplate;

/**
 * Specific exception for this exercise.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class PersonNotFoundException extends RuntimeException {


    public PersonNotFoundException(Long id) {
        super("Id '" + id + "' not found");
    }


}
