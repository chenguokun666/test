package com.education.practice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    private Integer teacherid;
    private String teachername;
    private String teachersex;
    private String teacherphone;
    private String teacheraddress;
}
