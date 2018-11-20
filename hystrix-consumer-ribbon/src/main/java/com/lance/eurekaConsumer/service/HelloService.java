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
    public String hiService(String name) {
        return restTemplate.getForObject("http://service-provider/users/list?name="+name, String.class);
    }

    //此处 出现过fallback method wasn't found
    //这是因为指定的 备用方法 和 原方法 的参数个数，类型不同造成的；
    // 所以需要统一参数的个数，类型：
    public String hiError(String name) {
        return "sorry,error!"+name;
    }
}
