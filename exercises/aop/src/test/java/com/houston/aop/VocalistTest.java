package com.houston.aop;

import com.houston.aop.domain.Performer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context.xml")
public class VocalistTest {
     private static final Logger LOGGER = LoggerFactory.getLogger(VocalistTest.class);

    @Autowired
    private Performer performer;

    @Test
    public void perform() {
        performer.perform();
    }
}
