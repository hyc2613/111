package com.hyc.springstudy.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
public class CalculateAspect {

    @Pointcut("execution(* com.hyc.springstudy.aop.business.DefaultCalculate.*(..))")
    public void pointCut() {}

    @Before(value = "pointCut()")
    public void beforeLog(JoinPoint point) {
        String methodName = point.getSignature().getName();
        System.out.println(String.format("执行目标方法：【%s】的前置通知，方法参数为：%s", methodName, point.getArgs().toString()));
    }

    /**
     * after一定会执行，因为他是在finally块中的。详见：AspectJAfterAdvice
     * @param point
     */
    @After(value = "pointCut()")
    public void afterLog(JoinPoint point) {
        String methodName = point.getSignature().getName();
        System.out.println(String.format("执行目标方法：【%s】的后置通知，方法参数为：%s", methodName, point.getArgs().toString()));
    }

    /**
     * afterReturning 不一定会执行，比如目标方法出现异常，则不会执行后续的代码，详见：AfterReturningAdviceInterceptor
     * @param point
     */
    @AfterReturning(pointcut = "pointCut()")
    public void afterReturnLog(JoinPoint point) {
        String methodName = point.getSignature().getName();
        System.out.println(String.format("执行目标方法：【%s】的后置返回通知，方法参数为：%s", methodName, point.getArgs().toString()));
    }

    @AfterThrowing(pointcut = "pointCut()")
    public void throwLog(JoinPoint point) {
        String methodName = point.getSignature().getName();
        System.out.println(String.format("执行目标方法：【%s】的后置返回通知，方法参数为：%s", methodName, point.getArgs().toString()));
    }
}
