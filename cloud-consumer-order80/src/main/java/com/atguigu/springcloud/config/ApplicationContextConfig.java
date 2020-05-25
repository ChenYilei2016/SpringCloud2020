package com.atguigu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther zzyy
 * @create 2020-02-18 17:27
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    public IRule myRule()
    {
        System.err.println("1");
        return new RandomRule();//定义为随机
    }
//    @Bean
//    public IRule myRule2()
//    {
//        System.err.println("2");
//        return new RandomRule();//定义为随机
//    }
}
//applicationContext.xml <bean id="" class="">