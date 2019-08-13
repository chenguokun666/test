package com.education.user.service.iml;

import com.education.user.mapper.UserMapper;
import com.education.user.pojo.User;
import com.education.user.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.MD5Util;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public List<User> userLogin(String usermail, String userpwd) {
        return userMapper.userLogin(usermail,userpwd);
    }

    @Override
    public void userRegister(String code,User user) {
        String phonecode = (String) redisTemplate.opsForValue().get("sms_" + user.getUserphone());

        System.out.println(user.getUserphone()+"输入的验证码为>>>>>>"+code+"redis>>>>>里为"+phonecode);
        if(code.equals(phonecode)){
            String md5 = MD5Util.md5(user.getUserpwd());
            user.setUserpwd(md5);
            userMapper.save(user);
        }
        else{
            throw new RuntimeException("您输入的验证码有误！！！");
        }


    }

    @Override
    public void SendSms(String userphone) {
        Random random = new Random();
        int max=999999;
        int min=100000;
        int nextInt = random.nextInt();
//        String nexint=nextInt+"";
//        String random1 = RandomStringUtils.random(6);
        nextInt=nextInt< min ?(nextInt+min): nextInt;
        redisTemplate.opsForValue().set("sms_"+userphone,nextInt+"",900, TimeUnit.SECONDS);
        HashMap<String, String> map = new HashMap<>(2);
        map.put("userphone",userphone);
        map.put("code",nextInt+"");
        rabbitTemplate.convertAndSend("sms",map);
        System.out.println("验证码为code"+nextInt);
    }
}
