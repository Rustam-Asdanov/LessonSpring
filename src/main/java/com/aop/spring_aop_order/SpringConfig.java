package com.aop.spring_aop_order;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop.spring_aop_order")
@EnableAspectJAutoProxy
public class SpringConfig {
}
