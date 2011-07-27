package com.houston.training.spring.basic.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Aspect for timing method execution times.
 *
 * @author <a href="timo.friman@houston-inc.com">Timo Friman</a>
 */

public class TimingAspect {

    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        final Logger logger = LoggerFactory.getLogger(pjp.getSignature().getDeclaringType());
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            logger.info(sw.prettyPrint());
        }
    }
}
