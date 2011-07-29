package com.houston.jdbctemplate;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheFactoryBean;

/**
 * Aspect taking care of caching.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class CacheAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheAspect.class);

    @Autowired
    private EhCacheFactoryBean ehCacheFactoryBean;

    public Object doCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Ehcache cache = ehCacheFactoryBean.getObject();
        Object[] args = proceedingJoinPoint.getArgs();
        Object key = args[0];
        Element cached = cache.get(key);
        if (cached == null) {
            Object obj = proceedingJoinPoint.proceed();
            cache.put(new Element(key, obj));
            return obj;
        }
        return cached.getValue();
    }

}
