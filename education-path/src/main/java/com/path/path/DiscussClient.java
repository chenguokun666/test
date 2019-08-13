package com.path.path;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "education-discuss")
//@Component
public interface DiscussClient {

    @RequestMapping(value = "/discuss/dis/{discusstypeid}/{orderType}/{sort}/{page}/{pageSize}",method = RequestMethod.GET)
    public Result findDisscussByDiscussTyeOrderByNew(@PathVariable int discusstypeid, @PathVariable int orderType, @PathVariable int sort, @PathVariable int page, @PathVariable int pageSize);
}
