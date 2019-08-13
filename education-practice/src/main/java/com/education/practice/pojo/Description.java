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
@Table(name = "practicedesc")
public class Description {
    @Id
    private int practicedescid;
    private String practicedesccontent;
    private String stagedesc;
}
