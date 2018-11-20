package com.lance.eurekaConsumer;

/**
 * Created by lance on 2018/11/11.
 */


import com.lance.eurekaConsumer.common.FeignConfig;
import com.lance.eurekaConsumer.entity.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "service-provider", configuration = FeignConfig.class,fallback = HelloRemote.class)
public interface RemoteService {


    @RequestLine("GET /users/list?name={name}")
    String getOwner(@Param(value = "name") String name);



    @RequestLine("GET /users/list2?name={name}&password={password}")
    String getUP(@Param(value = "name") String name, @Param(value = "password") String password);


    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @RequestLine("GET /users/list3?name={name}&password={password}")
    User getUser(@Param(value = "name") String name, @Param(value = "password") String password);
}
