package com.hyc.springstudy.aop.business;


import org.springframework.aop.framework.AopContext;

public class DefaultCalculate implements Calculate {
    @Override
    public int add(int a, int b) {
        System.out.println("invoke add method...");
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int divide(int a, int b) {
        return a/b;
    }

    @Override
    public int multi(int a, int b) {
        return a*b;
    }

    @Override
    public int mod(int a, int b) {
        System.out.println("测试exposeProxy");
        // 这样直接调用add，add方法是不会生成代理的
        int result = add(a, b);
        // 用 这种方式 并结合 @EnableAspectJAutoProxy(exposeProxy = true)，才会返回add的代理类
//        int result = ((Calculate) AopContext.currentProxy()).add(a, b);
        System.out.println("即将返回结果："+result);
        return result;
    }
}
