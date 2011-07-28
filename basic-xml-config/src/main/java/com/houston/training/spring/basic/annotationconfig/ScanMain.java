package com.houston.training.spring.basic.annotationconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example of... context scanning.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class ScanMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScanMain.class);

    public static final String FOO_BEAN = "fooBean";

    public static void main(String[] args) {
        String configLocation = "scan-context.xml";
        LOGGER.info("using {} as appcontext.", configLocation);
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                configLocation);
        Foo foo = (Foo) ac.getBean(FOO_BEAN);
        foo.doSomething();
        // what if we want to inject something to autowired?
        Bar bar = (Bar) ac.getBean(Bar.class);
        bar.execute();

    }
}
