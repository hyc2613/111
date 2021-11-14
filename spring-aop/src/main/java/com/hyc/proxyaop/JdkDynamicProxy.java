package com.hyc.proxyaop;

import com.hyc.proxyaop.interceptor.AopMethodInterceptor;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class JdkDynamicProxy implements AopProxy, InvocationHandler {

    private Object target;
    private List<AopMethodInterceptor> chain;

    public JdkDynamicProxy(Object target, List<AopMethodInterceptor> chain) {
        this.target = target;
        this.chain = chain;
    }

    @Override
    public Object getProxy() {
        return getProxy(ClassUtils.getDefaultClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader, target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ReflectiveMethodInvocation methodInvocation = new ReflectiveMethodInvocation(target, method, args, chain);
        return methodInvocation.process();
    }
}
