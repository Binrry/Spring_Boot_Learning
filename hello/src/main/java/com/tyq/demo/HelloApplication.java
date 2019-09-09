package com.tyq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloApplication {
    @RequestMapping("/hello")
    public String hello() {
        return "I'm Binrry,hello for mac";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
