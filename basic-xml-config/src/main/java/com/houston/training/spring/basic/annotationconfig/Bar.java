package com.houston.training.spring.basic.annotationconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bar {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bar.class);

    @Autowired
    private Foo foo;

    public Bar() {
        LOGGER.info("constructed");
    }

    public void execute() {
        LOGGER.info("execute() called");
        foo.doSomething();
    }
}
