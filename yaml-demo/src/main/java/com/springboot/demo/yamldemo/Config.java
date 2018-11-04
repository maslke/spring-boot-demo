package com.springboot.demo.yamldemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "my")
@Component
public class Config {

    private List<String> servers = new ArrayList<>();

    public List<String> getServers() {
        return this.servers;
    }

    private List<String> hosts = new ArrayList<>();

    public List<String> getHosts() {
        return this.hosts.subList(0, this.hosts.size());
    }

}
