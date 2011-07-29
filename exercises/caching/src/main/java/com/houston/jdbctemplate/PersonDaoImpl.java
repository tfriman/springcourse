package com.houston.jdbctemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Implementation.
 */
public class PersonDaoImpl implements PersonDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDaoImpl.class);

    @Autowired
    private JdbcOperations jdbcOperations;

    @Value("${query.get}")
    private String querySql;

    public Person get(Long id) {
        LOGGER.warn("get('{}')", id);
        List<Person> persons = jdbcOperations.query(querySql, new RowMapper<Person>() {

            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long id = rs.getLong("ID");
                String name = rs.getString("NAME");
                return new Person(id, name);
            }
        }, id);
        if (persons.isEmpty()) {
            throw new PersonNotFoundException(id);
        }
        return persons.get(0);
    }
}
