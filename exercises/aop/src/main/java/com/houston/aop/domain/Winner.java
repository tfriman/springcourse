package com.houston.aop.domain;

/**
 * TODO add javadoc.
 *
 * @author Timo Friman
 */
public class Winner implements Contestant {
    public void receiveAward() {
        System.out.println("Won a prize!");
    }
}
