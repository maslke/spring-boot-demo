package com.springboot.demo.ribbonclient.balancingclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class BalancingClientApplication {

    private String restart;

    private static final Logger logger = LoggerFactory.getLogger(BalancingClientApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GreetingServiceProxy proxy;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/greeting")
    public String greeting() {
        String greeting = restTemplate.getForObject("http://127.0.0.1:8000/greeting", String.class);
        return greeting;
    }

    @RequestMapping("/greeting2")
    public String greeting2() {
        String greeting = proxy.greeting();
        return greeting;
    }

    public static void main(String[] args) {
        SpringApplication.run(BalancingClientApplication.class, args);
    }
}
