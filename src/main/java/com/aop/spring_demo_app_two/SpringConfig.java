package com.aop.spring_demo_app_two;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop.spring_demo_app_two")
@EnableAspectJAutoProxy
public class SpringConfig {
}
