package com.education.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="dept")
public class Dept {
    @Id
    private Integer deptid;
    private String deptname;
}
