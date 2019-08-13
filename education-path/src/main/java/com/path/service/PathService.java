package com.path.service;

import com.path.dao.PathDao;
import com.path.pojo.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class PathService {

	@Autowired
	private PathDao pathDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Path> findAll() {
		return pathDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Path> findSearch(Map whereMap, int page, int size) {
		Specification<Path> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return pathDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Path> findSearch(Map whereMap) {
		Specification<Path> specification = createSpecification(whereMap);
		return pathDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Path findById(String id) {
		return pathDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param path
	 */
	public void add(Path path) {
		Random random = new Random();
		int max=10;
		int min=1;
		int i = random.nextInt();
		path.setPathid( i );
		pathDao.save(path);
	}

	/**
	 * 修改
	 * @param path
	 */
	public void update(Path path) {
		pathDao.save(path);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		pathDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Path> createSpecification(Map searchMap) {

		return new Specification<Path>() {

			@Override
			public Predicate toPredicate(Root<Path> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 路径名称
                if (searchMap.get("pathname")!=null && !"".equals(searchMap.get("pathname"))) {
                	predicateList.add(cb.like(root.get("pathname").as(String.class), "%"+(String)searchMap.get("pathname")+"%"));
                }
                // 路径简介
                if (searchMap.get("pathcomment")!=null && !"".equals(searchMap.get("pathcomment"))) {
                	predicateList.add(cb.like(root.get("pathcomment").as(String.class), "%"+(String)searchMap.get("pathcomment")+"%"));
                }
                // 路径头像
                if (searchMap.get("pathimg")!=null && !"".equals(searchMap.get("pathimg"))) {
                	predicateList.add(cb.like(root.get("pathimg").as(String.class), "%"+(String)searchMap.get("pathimg")+"%"));
                }
                // 路径详情
                if (searchMap.get("pathdetails")!=null && !"".equals(searchMap.get("pathdetails"))) {
                	predicateList.add(cb.like(root.get("pathdetails").as(String.class), "%"+(String)searchMap.get("pathdetails")+"%"));
                }
                // 路径创建人
                if (searchMap.get("pathman")!=null && !"".equals(searchMap.get("pathman"))) {
                	predicateList.add(cb.like(root.get("pathman").as(String.class), "%"+(String)searchMap.get("pathman")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

	public List<Path> pathLeval(int orderNum) {
		if(orderNum==0){
			return  pathDao.pathLevalDesc();
		}
		else if(orderNum==1){
			return pathDao.pathLevalAsec();
		}
		else{
			new Exception("参数有误");
             return null;
		}
	}

	public List<Path> pathjoinCount(int orderNum) {
		if(orderNum==0){
			return  pathDao.pathjoinCountDesc();
		}
		else if(orderNum==1){
			return pathDao.pathjoinCountAsec();
		}
		else{
			new Exception("参数有误");
			return null;
		}
	}
}
