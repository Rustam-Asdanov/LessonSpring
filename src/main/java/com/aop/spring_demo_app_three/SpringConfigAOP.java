package com.aop.spring_demo_app_three;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop.spring_demo_app_three")
@EnableAspectJAutoProxy
public class SpringConfigAOP {
}
