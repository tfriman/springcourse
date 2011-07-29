package com.houston.training.spring.basic.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps sql rows to objects.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class ExampleRowMapper implements RowMapper<TestDomainObject> {

    public static final String NAME = "NAME";
    public static final String ID = "ID";

    public TestDomainObject mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString(NAME);
        Long id = rs.getLong(ID);
        return new TestDomainObject(id, name);
    }
}
