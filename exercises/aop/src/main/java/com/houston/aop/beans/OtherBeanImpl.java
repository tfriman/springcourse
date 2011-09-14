package com.houston.aop.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Very important biznes bean.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class OtherBeanImpl implements OtherBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(OtherBeanImpl.class);

    public void doStuff(String param) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            LOGGER.warn("TODO oops", e);
        }
        LOGGER.info("doStuff called with param:'{}'", param);
    }

}
