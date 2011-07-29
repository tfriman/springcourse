package com.houston.training.spring.basic.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for JdbcTemplateExample.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class JdbcTemplateExampleTest {


    @Autowired
    JdbcTemplateExample jdbcTemplateExample;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getObjectForId() throws Exception {
        long id = 2L;
        TestDomainObject result = jdbcTemplateExample.get(id);
        Assert.assertEquals("ids should match", id, result.getId());
        Assert.assertTrue("name should match...", result.getName().contains("work"));
    }
}
