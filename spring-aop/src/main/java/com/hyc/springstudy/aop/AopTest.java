package com.hyc.springstudy.aop;

import com.hyc.springstudy.aop.aspect.MainConfig;
import com.hyc.springstudy.aop.business.Calculate;
import com.hyc.springstudy.aop.business.DefaultCalculate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Calculate calculate = (Calculate) ctx.getBean("calculate");
        int result = calculate.add(1, 2);
        System.out.println("add result is:"+result);
    }
}
