package com.lance.eurekaConsumer.controller;

import com.lance.eurekaConsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lance on 2018/7/18.
 */
@RestController
public class DcController {


    @Autowired
    HelloService helloService;

    @GetMapping("/consumer")
    public String dc() {
        return helloService.hiService();
    }
}