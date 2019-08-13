package com.answer.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */

@Data
@Document(collection = "education")
public class Answer implements Serializable{


	private String answerid;
	private String replycontext;
	private Date resplytime;
	private String discussid;
	private String userid;
	private String username;

}
