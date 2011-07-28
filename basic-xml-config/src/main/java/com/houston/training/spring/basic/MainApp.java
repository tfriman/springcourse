package com.houston.training.spring.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Main application.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class MainApp implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);


    public static void main(String[] args) {
        String configLocation = "context.xml";
        LOGGER.info("using {} as appcontext.", configLocation);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        ExampleBean bean = (ExampleBean) applicationContext.getBean("exampleBean");
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MainApp(bean));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private ExampleBean bean;
    UUID uuid;

    public MainApp(ExampleBean bean) {
        this.bean = bean;
        this.uuid = UUID.randomUUID();
    }

    public void run() {
        LOGGER.info("{} thread {}", bean.timeConsumingTask(), uuid);
    }

}
