package com.springcloud.eureka.Controller;

import com.springcloud.eureka.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value="/users")
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @Value("${server.port}")
    String port;

    @RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public String list(@RequestParam String name) throws InterruptedException{
//        response.setHeader("Access-Control-Allow-Origin", "*");
        LOG.log(Level.INFO,"list");
        return name.toUpperCase()+port;
    }

    @RequestMapping(value="/list2",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public String list(@RequestParam String name,@RequestParam String password) throws InterruptedException{
//        response.setHeader("Access-Control-Allow-Origin", "*");
        return name.toUpperCase()+password.toLowerCase()+port;
    }

    @ResponseBody
    @RequestMapping(value="/list3",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public User getUser(@RequestParam String name,@RequestParam String password) throws InterruptedException{
//        response.setHeader("Access-Control-Allow-Origin", "*");
        User user=new User();
        user.setId(16L);
        user.setUsername(name+password+port);
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
