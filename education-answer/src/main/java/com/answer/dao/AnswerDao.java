package com.answer.dao;

import com.answer.pojo.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AnswerDao extends MongoRepository<Answer,String> {
   public Page<Answer> findByDiscussidOrderByResplytime(String discussid, Pageable pageable);
}
