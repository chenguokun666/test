package com.education.discuss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="discuss")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discuss implements Serializable{

	@Id
	private Integer discussid;//讨论的主键id
    private String discusstitle;
    private String discusscontent;
    private int checkcount;
    private int replycount;
    private Date discusstime;
    private String discussname;
    private String usernick;
}
