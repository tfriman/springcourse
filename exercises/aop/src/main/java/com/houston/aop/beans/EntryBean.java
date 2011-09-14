package com.houston.aop.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Simple example bean calling other bean.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class EntryBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntryBean.class);

    private OtherBean otherBean;

    public EntryBean(OtherBean otherBean) {
        this.otherBean = otherBean;
    }



    public void entryMethod() {
        String param = new Date().toString();
        LOGGER.info("calling doStuff with param:'{}'", param);
        otherBean.doStuff(param);
    }
}
