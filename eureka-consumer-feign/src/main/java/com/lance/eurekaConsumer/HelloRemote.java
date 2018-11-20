package com.lance.eurekaConsumer;

import com.lance.eurekaConsumer.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by lance on 2018/11/14.
 */
@Component
public class HelloRemote implements RemoteService {
    @Override
    public String getOwner(String name) {
        return "hello "+name+",this method get failed";
    }

    @Override
    public String getUP(String name, String password) {
        return "hello "+name+",this method get failed";

    }

    @Override
    public User getUser(String name, String password) {
        User u = new User();
        return u;
    }
}
