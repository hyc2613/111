package com.hyc.proxyaop;


import com.hyc.proxyaop.interceptor.AopMethodInterceptor;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Method;
import java.util.List;

public class ReflectiveMethodInvocation {

    private Object target;
    private Method method;
    private Object[] args;
    private List<AopMethodInterceptor> chain;

    private int invokeIndex = -1;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args, List<AopMethodInterceptor> chain) {
        this.target = target;
        this.method = method;
        this.args = args;
        this.chain = chain;
    }

    public Object process() throws Throwable {
        if (invokeIndex == chain.size()-1) {
            return invokeTargetMethod();
        }
        AopMethodInterceptor aopMethodInterceptor = chain.get(++invokeIndex);
        return aopMethodInterceptor.invoke(this);
    }

    private Object invokeTargetMethod() throws Throwable {
        return AopUtils.invokeJoinpointUsingReflection(target, method, args);
    }

}
