package com.houston.training.spring.basic.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Simple jdbc template example
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class JdbcTemplateExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcTemplateExample.class);

    @Autowired
    private JdbcOperations jdbcOperations; // interface for the sake of testability

    @Autowired
    private RowMapper<TestDomainObject> rowMapper;

    @Value("${query.get}") // ooh SpEL!
    private String sql;


    public TestDomainObject get(long id) {

        List<TestDomainObject> result = jdbcOperations.query(sql, rowMapper, id);
        LOGGER.debug("got result:'{}'", result);
        if (result.isEmpty()) {
            return null; // bad baaaad baaaaaaaaAAAAAAAAAAAAAD practise
        }
        return result.get(0);

    }
}
