package com.houston.training.spring.basic.annotationconfig;

/**
 * TODO add javadoc.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */

import org.springframework.stereotype.Component;

@Component
public class CommonBean {
    private String testValue = "testvalue 1333";

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}
