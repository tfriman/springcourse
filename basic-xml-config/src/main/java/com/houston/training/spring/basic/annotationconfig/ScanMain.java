package com.houston.training.spring.basic.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO add javadoc.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class ScanMain {

    public static final String FOO_BEAN = "fooBean";

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "scan-context.xml");
        Foo foo = (Foo) ac.getBean(FOO_BEAN);
        foo.doSomething();
        // what if we want to inject something to autowired?
        Bar bar = (Bar) ac.getBean(Bar.class);
        bar.execute();

    }
}
