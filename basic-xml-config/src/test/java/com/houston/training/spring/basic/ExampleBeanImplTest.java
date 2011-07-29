package com.houston.training.spring.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.springframework.util.Assert.notNull;

/**
 * Example test case.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class ExampleBeanImplTest {

    @Autowired
    ExampleBeanImpl exampleBean;

    @Test
    public void foo() {
        String result = exampleBean.timeConsumingTask();
        assertNotNull("Result should not be null", result);
        //fail("no way");
    }
}
