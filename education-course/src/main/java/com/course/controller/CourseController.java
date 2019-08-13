package com.course.controller;

import com.course.pojo.Course;
import com.course.service.CourseService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import util.FreeMarkerUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",courseService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true, StatusCode.OK,"查询成功",courseService.findById(id));
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
		Page<Course> pageList = courseService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Course>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",courseService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param course
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Course course  ){
		courseService.add(course);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param course
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Course course, @PathVariable int id ){
		course.setCourseid(id);
		courseService.update(course);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		courseService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	/**
	 * 根据标签ID查询课程列表
	 */
    @RequestMapping(value="/label/{courselabel}",method = RequestMethod.GET)
	public Result LabelId(@PathVariable Integer courselabel) throws Exception {
    	List<Course> courselist=courseService.CourseLabel(courselabel);
		HashMap map = new HashMap<>();
		System.out.println(courselist);
		map.put("itemList",courselist);
		FreeMarkerUtil.createHtmlByMode("infopub.ftl","course.html",map);
		return new Result(true,StatusCode.OK,"查询成功",courselist);
	}

	/**
	 * 课程修改上线状态
	 */
	@RequestMapping(value = "/courseInonline/{courseid}",method = RequestMethod.PUT)
	public Result CourseUpdate(@PathVariable int courseid){
       courseService.CourseUpdate(courseid);
       return new Result(true,StatusCode.OK,"课程修改成功");
	}

	
}
