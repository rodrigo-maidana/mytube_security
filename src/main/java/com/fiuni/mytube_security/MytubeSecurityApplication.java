package com.fiuni.mytube_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.fiuni.mytube.domain")
public class MytubeSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytubeSecurityApplication.class, args);
    }

}
