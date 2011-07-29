package com.houston.jdbctemplate;

import org.springframework.jdbc.core.JdbcOperations;

/**
 * Person dao interface. Very simple.
 *
 */
public interface PersonDao {
    /**
     * Get Person by id.
     *
     * @param id to be searched.
     * @return Person if id was found or PersonNotFoundException
     */
    Person get(Long id);

}
