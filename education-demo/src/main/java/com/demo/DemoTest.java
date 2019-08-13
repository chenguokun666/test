package com.demo;

import entity.Result;
import entity.StatusCode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "education-user")
public interface DemoTest {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Result deptList();
//        return new Result(true, StatusCode.OK,"查询成功","调用成功");

}
