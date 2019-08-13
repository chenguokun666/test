package com.path.controller;

import com.path.path.DiscussClient;
import com.path.pojo.Path;
import com.path.service.PathService;
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
@RequestMapping("/path")
public class PathController {

	@Autowired
	private PathService pathService;

	@Autowired
	private DiscussClient discussClient;
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",pathService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",pathService.findById(id));
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
		Page<Path> pageList = pathService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Path>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",pathService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param path
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Path path  ){
		pathService.add(path);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param path
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Path path, @PathVariable int pathid ){
		path.setPathid(pathid);
		pathService.update(path);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		pathService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	/**
	 *
	 * 路径列表查询功能(按照等级leval)
	 */
	@RequestMapping(value = "/path/{orderNum}",method = RequestMethod.GET)
	public Result pathLeval(@PathVariable int orderNum){
      List<Path> pathList = pathService.pathLeval(orderNum);
      return new Result(true,StatusCode.OK,"查询成功",pathList);
	}
	/**
	 *
	 * 路径列表查询功能(按照pathjoincount加入路径人数)
	 */
	@RequestMapping(value = "/pathcount/{orderNum}",method = RequestMethod.GET)
	public Result pathjoinCount(@PathVariable int orderNum){
      List<Path> pathList = pathService.pathjoinCount(orderNum);
      return new Result(true,StatusCode.OK,"查询成功",pathList);
	}

	/**
	 * 测试eureka feign
	 * @return
	 */
	@RequestMapping(value = "/feign",method = RequestMethod.GET)
	public Result feign(){
        return new Result(true,StatusCode.OK,"feign调用成功",discussClient.findDisscussByDiscussTyeOrderByNew(1,1,1,0,2));
	}


}
