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
        Ehcache cache = ehCacheFactoryBean.getObject();
        Object[] args = invocation.getArguments();
        Object key = args[0];
        Element cached = cache.get(key);
        if (cached == null) {
            Object obj = invocation.proceed();
            cache.put(new Element(key, obj));
            return obj;
        }
        return cached.getValue();
    }

    private String generateCacheKey(Object... args){
        return "";
    }
}
