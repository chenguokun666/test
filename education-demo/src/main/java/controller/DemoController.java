package controller;

import com.demo.DemoTest;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DemoController {
    @Autowired
    private DemoTest demoTest;
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public Result Demo(){
        demoTest.deptList();
        return new Result(true, StatusCode.OK,"调用成功","成功");
    }

}
