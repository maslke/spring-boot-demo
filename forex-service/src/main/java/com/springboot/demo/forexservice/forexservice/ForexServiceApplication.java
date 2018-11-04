package com.springboot.demo.forexservice.forexservice;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableScheduling
public class ForexServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ForexServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ForexServiceApplication.class, args);
    }

    /**
     * 定时任务，支持cron表达式
     */
    @Scheduled(fixedRate = 5000)
    public void scheduler() {
        logger.info("sccc...");
    }
}
