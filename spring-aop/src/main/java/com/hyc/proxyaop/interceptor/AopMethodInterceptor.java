package com.hyc.proxyaop.interceptor;

import com.hyc.proxyaop.ReflectiveMethodInvocation;
import org.springframework.core.Ordered;

public interface AopMethodInterceptor extends Ordered {

    Object invoke(ReflectiveMethodInvocation methodInvocation) throws Throwable;

}
