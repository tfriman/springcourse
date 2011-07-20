package com.houston.training.spring.basic.annotationconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(ScanMain.FOO_BEAN)
public class Foo {
    private static final Logger LOGGER = LoggerFactory.getLogger(Foo.class);

    @Value("#{commonBean.testValue}")
    private String value;

    public Foo() {
        LOGGER.info("constructed");
    }



    public void doSomething() {
        LOGGER.info("doSomething() called, testValue is:'{}'", value);
    }

}
