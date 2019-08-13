package com.answer.controller;

import com.answer.pojo.Answer;
import com.answer.service.AnswerService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	/**
	 *
	 * 添加到mongo中
	 * @param answer
	 * @return
	 */
	@RequestMapping(value = "/addanswer",method = RequestMethod.POST)
	public Result Addanswer(@RequestBody Answer answer){
          answerService.Addanswer(answer);
          return new Result(true, StatusCode.OK," 添加成功");
	}

	/**
	 * 查询回复列表
	 * @param discussid
	 * @param page
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value = "/reply/{discussid}/{page}/{pagesize}",method = RequestMethod.GET)
	public Result findAnser(@PathVariable String discussid,@PathVariable int page,@PathVariable int pagesize){
		Page<Answer> answerpage=answerService.findAnser(discussid,page,pagesize);
		PageResult<Answer> answerPageResult = new PageResult<>();
		answerPageResult.setTotal(answerpage.getTotalElements());
		answerPageResult.setRows(answerpage.getContent());
		return new Result(true, StatusCode.OK,"查询成功",answerPageResult);
	}

	


	


	
}
