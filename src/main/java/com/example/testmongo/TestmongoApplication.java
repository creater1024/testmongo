package com.example.testmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication
public class TestmongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmongoApplication.class, args);
    }

}
