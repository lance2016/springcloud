package com.lance.eurekaConsumer.controller;


import com.lance.eurekaConsumer.RemoteService;
import com.lance.eurekaConsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by lance on 2018/11/7.
 */
@RestController
@RequestMapping("/test")
public class LoginController {


    Logger logger;

    @Autowired
    RemoteService service;
//RemoteService service = Feign.builder()
//        .options(new Request.Options(1000, 3500))
//        .retryer(new Retryer.Default(5000, 5000, 3))
//        .target(RemoteService.class, "http://127.0.0.1:6002");
//
//    RemoteService service = Feign.builder().client(RibbonClient.create()).encoder(new JacksonEncoder())
//            .decoder(new JacksonDecoder()).target(RemoteService.class, "http://sample-client/gradle-web");


    @RequestMapping(value = "/test",method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    public String login(String name){
        logger.info("/test "+name);
         return service.getOwner(name);
    }


    @RequestMapping(value = "/test2",method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    public String login2(String name,String password){
        logger.info("/test2 "+name+password);
        return service.getUP(name,password);
    }


    @RequestMapping(value = "/test3",method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    public User login3(String name,String password){
        logger.info("/test3 "+name+" "+password);
        return service.getUser(name,password);
    }

}
