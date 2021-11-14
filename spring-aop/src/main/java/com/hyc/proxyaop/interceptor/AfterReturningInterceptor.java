package com.hyc.proxyaop.interceptor;

import com.hyc.proxyaop.ReflectiveMethodInvocation;

public class AfterReturningInterceptor implements AopMethodInterceptor {


    @Override
    public Object invoke(ReflectiveMethodInvocation methodInvoker) throws Throwable {
        Object result = methodInvoker.process();
        System.out.println("after returning method...");
        return result;
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
