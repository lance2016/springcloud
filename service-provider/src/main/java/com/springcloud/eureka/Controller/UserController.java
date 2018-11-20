package com.springcloud.eureka.Controller;

import com.springcloud.eureka.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping(value="/users")
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @Value("${server.port}")
    String port;



    @RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public Map<String, String> list(@RequestParam("name") String name) throws InterruptedException{
//        response.setHeader("Access-Control-Allow-Origin", "*");
        LOG.log(Level.INFO,"list");
        Map<String,String> map = new HashMap();
        map.put("result",port);
        return map;
    }


    @RequestMapping(value="/list2",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public Map<String,String> list2(@RequestParam String name,@RequestParam String password) throws InterruptedException{
//        response.setHeader("Access-Control-Allow-Origin", "*");
        LOG.log(Level.INFO,"list2");
        Map<String,String> map = new HashMap();
        map.put("result",name.toUpperCase()+password.toLowerCase()+port);
        return map;
    }

    @RequestMapping(value="/list3",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public User getUser(@RequestParam String name,@RequestParam String password) throws InterruptedException{
//        response.setHeader("Access-Control-Allow-Origin", "*");

        User user=new User();
        user.setId(16L);
        user.setUsername(name+password+port);
        LOG.log(Level.INFO,user.toString());
//        System.out.println(user.toString());
        return user;
    }

//    @RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
//    public User list(@RequestBody User user) throws InterruptedException{
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        user.setId(new Long(request.getLocalPort()));
//        user.setUsername(user.getUsername().toUpperCase());
//        return user;
//    }


}
