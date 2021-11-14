package com.hyc.proxyaop;

import com.hyc.mockaop.invocationhandler.InvocationTargetInfo;
import com.hyc.mockaop.invocationhandler.MockDynamicAopProxy;
import com.hyc.proxyaop.interceptor.*;
import com.hyc.springstudy.aop.business.Calculate;
import com.hyc.springstudy.aop.business.DefaultCalculate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AopProxyTest {

    public static void main(String[] args) throws NoSuchMethodException {
        Calculate calculate = new DefaultCalculate();

        AopMethodInterceptor[] interceptors = {new BeforeInterceptor(), new AfterInterceptor(), new AfterReturningInterceptor(), new AfterThrowingInterceptor()};
        List<AopMethodInterceptor> mockMethodInterceptors = Arrays.asList(interceptors);
        mockMethodInterceptors.sort(new Comparator<AopMethodInterceptor>() {
            @Override
            public int compare(AopMethodInterceptor o1, AopMethodInterceptor o2) {
                return Integer.compare(o1.getOrder(), o2.getOrder());
            }
        });

        JdkDynamicProxy invocationTargetInfo = new JdkDynamicProxy(calculate, mockMethodInterceptors);
        Object proxy = invocationTargetInfo.getProxy();
        int result = ((Calculate) proxy).add(1, 2);
        System.out.println("result = "+result);

//        IMockMethodInvoker invoker = new DefaultMockMethodInvoker(calculate, addMethod, methodArgs, mockMethodInterceptors);
//        invoker.invoke();
    }
}
