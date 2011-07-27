package com.houston.training.spring.basic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Aspect for tracing method calls.
 *
 * @author <a href="timo.friman@houston-inc.com">Timo Friman</a>
 */

public class TracingAspect {

    public Object enter(ProceedingJoinPoint pjp) throws Throwable {
        final Logger logger = LoggerFactory.getLogger(pjp.getSignature().getDeclaringType());
        Signature sig = pjp.getSignature();
        logger.debug("Entering [" + sig.toShortString() + "]");
        return pjp.proceed();
    }

    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        final Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());

        Class clazz = joinPoint.getTarget().getClass();
        String name = joinPoint.getSignature().getName();

        if (joinPoint.getSignature() instanceof MethodSignature) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Class returnType = signature.getReturnType();
            if (returnType.getName().compareTo("void") == 0) {
                logger.debug("Returning [" + signature.toShortString() + "]");
                return;
            } else {
                logger.debug("Returning [" + signature.toShortString() + "] with return value:'{}'", returnValue);
                return;
            }
        }

        logger.debug("jp:'{}' and retval:'{}'", joinPoint.getSignature().getClass().getCanonicalName(), returnValue);
        //logger.log(loggable.value(), clazz, null, AFTER_RETURNING, name, constructArgumentsString(clazz, returnValue));
    }
}
