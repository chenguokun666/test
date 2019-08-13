package com.education.discuss.pojo;

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
@Table(name="discusstype")
public class Discusstype implements Serializable{

	@Id
	private Integer discusstypeid;//讨论分类的主键id
	private String discussname;//讨论分类名称
	private java.util.Date createtime;//创建时间
	private java.util.Date updatetime;//修改时间
	private String discusstypeman;//讨论分类创建人

	
	public Integer getDiscusstypeid() {		
		return discusstypeid;
	}
	public void setDiscusstypeid(Integer discusstypeid) {
		this.discusstypeid = discusstypeid;
	}

	public String getDiscussname() {		
		return discussname;
	}
	public void setDiscussname(String discussname) {
		this.discussname = discussname;
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

	public String getDiscusstypeman() {		
		return discusstypeman;
	}
	public void setDiscusstypeman(String discusstypeman) {
		this.discusstypeman = discusstypeman;
	}


	
}
