package com.path.pojo;

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
@Table(name="path")
public class Path implements Serializable{

	@Id
	private Integer pathid;//路径的主键id


	
	private String pathname;//路径名称
	private Integer pathcount;//路径包含课程数量
	private String pathcomment;//路径简介
	private String pathimg;//路径头像
	private String pathdetails;//路径详情
	private Integer pathlevel;//路径等级
	private java.util.Date createtime;//创建时间
	private java.util.Date updatetime;//修改时间
	private String pathman;//路径创建人
	private Integer pathjoincount;//加入路径人数
	private java.util.Date pathfinishtime;//路径预计学习时间

	
	public Integer getPathid() {		
		return pathid;
	}
	public void setPathid(Integer pathid) {
		this.pathid = pathid;
	}

	public String getPathname() {		
		return pathname;
	}
	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public Integer getPathcount() {		
		return pathcount;
	}
	public void setPathcount(Integer pathcount) {
		this.pathcount = pathcount;
	}

	public String getPathcomment() {		
		return pathcomment;
	}
	public void setPathcomment(String pathcomment) {
		this.pathcomment = pathcomment;
	}

	public String getPathimg() {		
		return pathimg;
	}
	public void setPathimg(String pathimg) {
		this.pathimg = pathimg;
	}

	public String getPathdetails() {		
		return pathdetails;
	}
	public void setPathdetails(String pathdetails) {
		this.pathdetails = pathdetails;
	}

	public Integer getPathlevel() {		
		return pathlevel;
	}
	public void setPathlevel(Integer pathlevel) {
		this.pathlevel = pathlevel;
	}

	public java.util.Date getCreatetime() {		
		return createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getUpdatetime() {		
		return updatetime;
	}
	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getPathman() {		
		return pathman;
	}
	public void setPathman(String pathman) {
		this.pathman = pathman;
	}

	public Integer getPathjoincount() {		
		return pathjoincount;
	}
	public void setPathjoincount(Integer pathjoincount) {
		this.pathjoincount = pathjoincount;
	}

	public java.util.Date getPathfinishtime() {		
		return pathfinishtime;
	}
	public void setPathfinishtime(java.util.Date pathfinishtime) {
		this.pathfinishtime = pathfinishtime;
	}


	
}
