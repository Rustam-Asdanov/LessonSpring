package com.aop.around_simple;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop.around_simple")
@EnableAspectJAutoProxy
public class SpringConfig {
}
