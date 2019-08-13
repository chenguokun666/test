package com.course.dao;

import com.course.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface CourseDao extends JpaRepository<Course,String>,JpaSpecificationExecutor<Course>{

    @Query(value = "select * from course where courselabel=?1",nativeQuery = true)
    List<Course> CourseLabel(Integer courselabel);

    @Modifying
    @Query(value = "update course set inonline=1 where courseid=?1",nativeQuery = true)
    void CourseUpdate(int courseid);

    @Query(value = "select * from course where courseid=?1",nativeQuery = true)
    Course SYNQurey(int courseid);
}
