package com.education.discuss.controller;

import com.education.discuss.pojo.Discuss;
import com.education.discuss.service.DiscussService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/discuss")
public class DiscussController {

	@Autowired
	private DiscussService discussService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",discussService.findAll());
	}
	


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Discuss> pageList = discussService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Discuss>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",discussService.findSearch(searchMap));
    }

	/**
	 * 按照条件查询讨论列表
	 * @param
	 * @param orderType
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/dis/{discusstypeid}/{orderType}/{sort}/{page}/{pageSize}",method = RequestMethod.GET)
	public Result findDisscussByDiscussTyeOrderByNew(@PathVariable int discusstypeid,@PathVariable int orderType,@PathVariable int sort,@PathVariable int page,@PathVariable int pageSize){
		List discussList=discussService.findDisscussByDiscussTyeOrderByNew(discusstypeid,orderType,sort,page,pageSize);
		return new Result(true, StatusCode.OK,"查询成功",discussList);
	};
}
