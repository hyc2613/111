package com.hyc.proxyaop.interceptor;

import com.hyc.proxyaop.ReflectiveMethodInvocation;

public class BeforeInterceptor implements AopMethodInterceptor {

    @Override
    public Object invoke(ReflectiveMethodInvocation methodInvoker) throws Throwable {
        System.out.println("before invoke method...");
        return methodInvoker.process();
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
