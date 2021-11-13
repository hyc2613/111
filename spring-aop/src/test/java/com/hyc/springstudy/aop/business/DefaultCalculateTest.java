package com.hyc.springstudy.aop.business;


import com.hyc.springstudy.aop.aspect.MainConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootApplication
public class DefaultCalculateTest {

    private Calculate calculate;

    @Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        calculate = (Calculate) ctx.getBean(Calculate.class);
    }

    @Test
    public void add() {
        int result = calculate.add(1, 2);
        System.out.println("add result is "+result);
    }

    @Test
    public void sub() {
    }

    @Test
    public void divide() {
        int result = calculate.divide(2, 3);
        System.out.println("add result is "+result);
    }

    @Test
    public void multi() {
    }

    @Test
    public void mod() {
        int result = calculate.mod(1, 2);
    }
}
