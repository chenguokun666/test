package com.education.practice.service;

import com.education.practice.dao.PracticeDao;
import com.education.practice.pojo.PracticeCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {
    @Autowired
    private PracticeDao practiceDao;

    public List<PracticeCourse> findAll() {
        return practiceDao.findAll();
    }
}
