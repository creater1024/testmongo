package com.example.testmongo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.example.testmongo.dao")
public class TestmongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmongoApplication.class, args);
    }

}
