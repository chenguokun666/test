package com.education.user.controller;

import com.education.user.pojo.Dept;
import com.education.user.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public List<Dept> deptList(){
        return deptService.deptList();
    }
}
