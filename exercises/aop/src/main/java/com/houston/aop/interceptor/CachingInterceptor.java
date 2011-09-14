package com.houston.aop.interceptor;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheFactoryBean;

/**
 * Caches method calls.
 *
 * @author Author
 */
public class CachingInterceptor implements MethodInterceptor {

    @Autowired
    private EhCacheFactoryBean ehCacheFactoryBean;


    public Object invoke(MethodInvocation invocation) throws Throwable {
        // implement me!
        return invocation.proceed();
    }
}
