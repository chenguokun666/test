package com.education.user.service;


import com.education.user.pojo.User;

import java.util.List;


public interface UserService {

    List<User> userLogin(String usermail,String userpwd);

    void userRegister(String code,User user);

    void SendSms(String userphone);
}
