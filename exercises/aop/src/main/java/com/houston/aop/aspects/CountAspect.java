package com.houston.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect for storing counts...
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
@Aspect
@Component
public class CountAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountAspect.class);

    @Pointcut("within(com.houston.aop.beans.*Impl)")
    private void pointCut() {
    }

    @DeclareParents(value = "com.houston.aop.beans.OtherBean+",
            defaultImpl = CounterImpl.class)
    public static Counter mixin;

    @Before("pointCut() &&" +
            "this(usageTracked)")
    public void recordUsage(Counter usageTracked) {
        LOGGER.debug("recordUsage");
        usageTracked.incrementCount();
    }

}
