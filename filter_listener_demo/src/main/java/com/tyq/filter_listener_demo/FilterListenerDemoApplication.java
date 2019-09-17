package com.tyq.filter_listener_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FilterListenerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterListenerDemoApplication.class, args);
    }

}
