package com.example.testmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com")
public class TestmongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmongoApplication.class, args);
    }

}
