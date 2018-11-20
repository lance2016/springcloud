package com.lance.eurekaConsumer.common;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lance on 2018/11/14.
 */
@Configuration
public class FeignConfig {

        @Bean
        public Contract feignContract(){
            return new Contract.Default();
        }
}
