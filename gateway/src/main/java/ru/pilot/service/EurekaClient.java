package ru.pilot.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-eureka-client")
public interface EurekaClient {
    @RequestMapping("/greeting")
    String greeting();
}