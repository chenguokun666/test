package com.education.practice.dao;

import com.education.practice.pojo.PracticeCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeDao extends JpaRepository<PracticeCourse,Integer> {
}
