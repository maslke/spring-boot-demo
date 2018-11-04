package com.springboot.demo.eurekaclilent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClilentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClilentApplication.class, args);
    }


}
