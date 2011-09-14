package com.houston.aop;

import com.houston.aop.beans.EntryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class, loads contexts etc.
 *
 * @author Timo Friman
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        EntryBean entryBean = (EntryBean) applicationContext.getBean("entryBean");
        for (int i = 0; i < 10; i++) {
            entryBean.entryMethod();
        }
    }
}
