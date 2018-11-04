package com.springboot.demo.yamldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YamlDemoApplication implements CommandLineRunner {
    @Autowired
    private Config config;

    @Autowired
    private Name name;

    @Autowired
    private Name2 name2;

    @Bean
    public Name2 getName2() {
        return new Name2();
    }

    private static final Logger logger = LoggerFactory.getLogger(YamlDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YamlDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("spring boot has started");
        logger.info("yaml configs:");
        for (String server : config.getServers()) {
            logger.info("server : {}", server);
        }
        for (String host : config.getHosts()) {
            logger.info("host : {}", host);
        }

        logger.info("firstName: {}", name.getFirstName());
        logger.info("lastName: {}", name.getLastName());

        logger.info("firstName: {}", name2.getFirstName());
        logger.info("lastName: {}", name2.getLastName());


    }
}
