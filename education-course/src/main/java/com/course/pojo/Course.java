package com.course.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="course")
@Data
public class Course implements Serializable{

	@Id
	private Integer courseid;//课程的id
	private String coursename;//课程名称
	private String courseattention;//课程关注量
	private String coursetype;//课程类型 0 免费 1 限免 2 会员
	private java.util.Date releasetime;//课程上线时间
	private java.util.Date logouttime;//课程下线时间
	private Integer inonline;//课程是否上线 0 已上线 1 即将上线
	private Integer courselabel;//课程标签 与标签表通过id关联
	private String coursecomment;//课程简介
	private String coursehits;//课程点击量
	private Integer userid;//上传课程的用户
	private Integer teacherid;//制作课程的老师


}
