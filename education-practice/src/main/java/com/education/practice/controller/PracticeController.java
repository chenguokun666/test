package com.education.practice.controller;

import com.education.practice.service.PracticeService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practice")
public class PracticeController {
    @Autowired
    private PracticeService practiceService;

    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",practiceService.findAll());
    }
}
