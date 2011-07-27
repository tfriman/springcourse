package com.houston.training.spring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Example bean.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class ExampleBeanImpl implements ExampleBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleBeanImpl.class);
    private UUID uuid;

    public ExampleBeanImpl() {
        // takes time to initiate.
        this.uuid = UUID.randomUUID();

    }

    public String timeConsumingTask() {
        LOGGER.debug("started timeConsumingTask with uuid:'{}'", uuid);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.nanoTime() + " uuid:" + uuid.toString();
    }
}
