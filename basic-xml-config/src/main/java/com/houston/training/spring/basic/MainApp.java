package com.houston.training.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Main application.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class MainApp implements Runnable {

    public static void main(String[] args) {
        String configLocation = "context.xml";
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
        System.out.println(bean.timeConsumingTask() + " thread " + uuid);
    }

}
