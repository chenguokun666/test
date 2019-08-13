package com.answer.service;

import com.answer.dao.AnswerDao;
import com.answer.pojo.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AnswerService {

	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private IdWorker idWorker;


	public void Addanswer(Answer answer) {
		String id = idWorker.nextId()+"";
		Date date = new Date();
		answer.setAnswerid(id);
		answer.setResplytime(date);
		mongoTemplate.save(answer);
//        answerDao.save(answer);
	}

	public Page<Answer> findAnser(String discussid, int page, int pagesize) {
		PageRequest pageRequest = PageRequest.of(page - 1, pagesize);
		return answerDao.findByDiscussidOrderByResplytime(discussid,pageRequest);
	}
}
