package com.education.practice.pojo;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="practice")
public class PracticeCourse {
    @Id
    private Integer practiceid;    //训练营逐渐ID
    private String practicetitle;//标题
    private String practicedescription;//描述
    private String recommendids;//推荐先学课程列表集合
    private int practiceprice;//价格
    private String practiceoimage;//图片
    private int practiceattention;//关注
    private String packagecourse;
    private int practicedescid;//打包课程

    @ManyToOne
    @JoinColumn(name="teacherid")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="practicedescid",insertable = false,updatable = false)
    private Description description;
}
