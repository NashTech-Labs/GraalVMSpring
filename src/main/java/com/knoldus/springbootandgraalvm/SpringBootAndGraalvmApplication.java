package com.knoldus.springbootandgraalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class SpringBootAndGraalvmApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndGraalvmApplication.class, args);
    }
    
}
