package com.aop.around_exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop.around_exception")
@EnableAspectJAutoProxy
public class SpringConfig {
}
