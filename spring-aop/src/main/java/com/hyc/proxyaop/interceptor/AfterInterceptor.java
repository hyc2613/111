package com.hyc.proxyaop.interceptor;

import com.hyc.proxyaop.ReflectiveMethodInvocation;

public class AfterInterceptor implements AopMethodInterceptor {
    @Override
    public Object invoke(ReflectiveMethodInvocation methodInvoker) throws Throwable {
        try {
            return methodInvoker.process();
        } finally {
            System.out.println("after method invoker...");
        }
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
