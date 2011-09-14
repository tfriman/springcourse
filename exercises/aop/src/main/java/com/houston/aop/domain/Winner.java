package com.houston.aop.domain;

/**
 * TODO add javadoc.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class Winner implements Contestant {
    public void receiveAward() {
        System.out.println("Won a prize!");
    }
}
