package com.aop.after_returning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.aop.after_returning")
@EnableAspectJAutoProxy
public class SpringConfig {
}
