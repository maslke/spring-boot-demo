package com.springboot.demo.ribbon.clientloadbalancing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClientLoadBalancingApplication {

    @Autowired
    private Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(ClientLoadBalancingApplication.class);
    @GetMapping("/greeting")
    public String greeting() {
        logger.info("access /greeting");
        return "greeting," + environment.getProperty("server.port");
    }

    @GetMapping("/")
    public String home() {
        logger.info("access /");
        return "home";
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientLoadBalancingApplication.class, args);
    }
}
