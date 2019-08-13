package com.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.FreeMarkerUtil;

@SpringBootApplication
public class PageApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageApplication.class,args);
    }
    @Bean
    public FreeMarkerUtil freeMarkerUtil(){
        return new FreeMarkerUtil();
    }
}
