package com.houston.aop.aspects;

/**
 * Counter implementation.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class CounterImpl implements Counter {

    private long count;

    public void incrementCount() {
        count++;//thread safety etc
    }

    public long getCount() {
        return count;
    }
}
