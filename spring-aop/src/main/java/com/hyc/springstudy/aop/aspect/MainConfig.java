package com.hyc.springstudy.aop.aspect;

import com.hyc.springstudy.aop.business.Calculate;
import com.hyc.springstudy.aop.business.DefaultCalculate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class MainConfig {

    @Bean(name = "calculate")
    public Calculate getCalculate() {
        return new DefaultCalculate();
    }

    @Bean
    public CalculateAspect getCalculateAspect() {
        return new CalculateAspect();
    }
}
