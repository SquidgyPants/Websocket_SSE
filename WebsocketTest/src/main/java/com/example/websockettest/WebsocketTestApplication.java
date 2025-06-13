package com.example.websockettest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan({"com.example.websockettest.Config", "com.example.websockettest.Controller"})
public class WebsocketTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketTestApplication.class, args);
    }
}
