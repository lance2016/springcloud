package com.lance.eurekaConsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lance on 2018/7/20.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService() {
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String hiError() {
        return "sorry,error!";
    }
}
