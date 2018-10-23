package com.springboot.demo.ribbonclient.balancingclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author:maslke
 * @date:10/22/2018
 * @version:0.0.1
 */
@FeignClient(name = "client-load-balancing")
@RibbonClient(name = "client-load-balancing")
public interface GreetingServiceProxy {

    @GetMapping("/greeting")
    String greeting();
}
