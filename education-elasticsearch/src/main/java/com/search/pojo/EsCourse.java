package com.search.pojo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName = "es",type = "courseInonline")
@Data
public class EsCourse implements Serializable {

    private static final long serialVersionUID = -4361354237155634824L;
    @Id
    private String id;//课程的id
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private Integer courseid;//课程名称
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursename;//课程名称
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String courseattention;//课程关注量
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursetype;//课程类型 0 免费 1 限免 2 会员
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private java.util.Date releasetime;//课程上线时间
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private java.util.Date logouttime;//课程下线时间
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private Integer inonline;//课程是否上线 0 已上线 1 即将上线
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private Integer courselabel;//课程标签 与标签表通过id关联
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursecomment;//课程简介
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursehits;//课程点击量
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private Integer userid;//上传课程的用户
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private Integer teacherid;//制作课程的老师


}
