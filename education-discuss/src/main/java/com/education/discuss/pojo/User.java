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
@Table(name="user")
public class User implements Serializable{

	@Id
	private Integer userid;//用户的id
	private String username;//用户名称
	private String userpwd;//用户密码
	private String usernick;//用户昵称
	private String userphone;//用户手机号
	private String useremail;//用户邮箱
	private java.util.Date registertime;//注册时间
	private Integer roleid;//通过角色id关联角色
	private String birthday;//用户生日
	private String sex;//用户性别
	private String image;//用户头像
	private Integer balance;//账户余额

	
	public Integer getUserid() {		
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {		
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {		
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsernick() {		
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}

	public String getUserphone() {		
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUseremail() {		
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public java.util.Date getRegistertime() {		
		return registertime;
	}
	public void setRegistertime(java.util.Date registertime) {
		this.registertime = registertime;
	}

	public Integer getRoleid() {		
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getBirthday() {		
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {		
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getImage() {		
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Integer getBalance() {		
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	
}
