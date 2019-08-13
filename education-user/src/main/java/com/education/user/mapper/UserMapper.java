package com.education.user.mapper;

import com.education.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMapper extends JpaRepository<User,Integer> {

    @Query(value = "select * from user u where u.useremail=?1 and u.userpwd=?2",nativeQuery = true)
    List<User> userLogin(String useremail, String userpwd);


}
