package com.hyc.proxyaop;

public interface AopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);

}
