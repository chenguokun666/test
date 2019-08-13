package com.education.user.mapper;

import com.education.user.pojo.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptMapper extends JpaRepository<Dept,Integer> {

}
