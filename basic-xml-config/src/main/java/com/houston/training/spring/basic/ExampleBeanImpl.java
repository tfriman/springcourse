package com.houston.training.spring.basic;

import java.util.Date;
import java.util.UUID;

/**
 * Example bean.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class ExampleBeanImpl implements ExampleBean {

    UUID uuid;
    public ExampleBeanImpl() {
        // takes time to initiate.
        this.uuid = UUID.randomUUID();

    }

    public String timeConsumingTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.nanoTime() + " uuid:" + uuid.toString();
    }
}
