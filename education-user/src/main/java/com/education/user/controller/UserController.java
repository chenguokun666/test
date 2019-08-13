package com.education.user.controller;

import com.education.user.pojo.User;
import com.education.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.ThirdLoginUtil;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ThirdLoginUtil thirdLoginUtil;
    @Autowired
    private UserService userService;
    /**
     * CGK
     * 登录
     */

    @RequestMapping(value ="/userLogin/{useremail}/{userpwd}",method = RequestMethod.GET)
    public Result userLogin(User user){

        System.out.println(user.getUseremail()+user.getUserpwd());
        List<User> users = userService.userLogin(user.getUseremail(), user.getUserpwd());
        users.forEach(System.out::println);
        if(users!=null){
            return new Result(true, StatusCode.OK,"查询成功",users);
        }
        else{
            return new Result(true,StatusCode.OK,"查询失败");
        }

    }
    /**
     * 注册
     */

    @RequestMapping(value = "/userRegister/{code}",method = RequestMethod.PUT)
    public Result userRegister(@PathVariable String code,@RequestBody User user){
        System.out.println(code+">>>>>"+user.getUseremail()+user.getUserpwd()+">>>>>>"+user.getUserpwd());
          userService.userRegister(code,user);
          return new Result(true,StatusCode.OK,"注册成功");
    }
    /**
     * 发送消息
     */

    @RequestMapping(value = "sendsms/{userphone}",method = RequestMethod.POST)
    public Result SendSms(@PathVariable String userphone){
        String of = String.valueOf(userphone);
        userService.SendSms(userphone);
        return  new Result(true,StatusCode.OK,"发送成功");
    }
    /**
     * 百度code
     */
    @RequestMapping("baiduCode")
    public String CheckCode(String code){
        System.out.println("code为"+code);
        String user = thirdLoginUtil.getUserid(code);
        System.out.println(user);
        if(user==null){
            return "登录失败";
        }
        else{
            return "登录成功";
        }

    }
}
