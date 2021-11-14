package com.hyc.proxyaop.interceptor;

import com.hyc.proxyaop.ReflectiveMethodInvocation;

public class AfterThrowingInterceptor implements AopMethodInterceptor {
    @Override
    public Object invoke(ReflectiveMethodInvocation methodInvoker) throws Throwable {
        try {
            return methodInvoker.process();
        } catch(Throwable t) {
            System.out.println("after throwing exception...");
            throw t;
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
