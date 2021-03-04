package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FabricSdkDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FabricSdkDemoApplication.class, args);
    }

}
