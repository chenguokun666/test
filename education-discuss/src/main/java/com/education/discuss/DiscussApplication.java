package com.education.discuss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import util.IdWorker;


@SpringBootApplication
@EnableEurekaServer
public class DiscussApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscussApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

}
