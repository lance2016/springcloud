package com.springcloud.eureka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by lance on 2018/7/18.
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    String port;

    @RequestMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services+port);
        return services;
    }


    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        System.out.println("hi "+name+",i am from port:" +port);
        return "hi "+name+",i am from port:" +port;
    }


//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public String index(@RequestParam String name,@RequestParam String password){
//        if(name.equals("1") && password.equals("1"))
//            return "index";
//        else
//            return "failed";
//    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String indexs(@RequestParam String name,@RequestParam String password){
        if(name.equals("1") && password.equals("1"))
            return "{'index':'ads'}";
        else
            return "{'index':'fdsafds'}";
    }





}