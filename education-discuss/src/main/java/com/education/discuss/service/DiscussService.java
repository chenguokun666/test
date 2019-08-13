package com.education.discuss.service;

import com.education.discuss.dao.DiscussDao;
import com.education.discuss.pojo.Discuss;
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

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class DiscussService {

	@Autowired
	private DiscussDao discussDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Discuss> findAll() {
		return discussDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Discuss> findSearch(Map whereMap, int page, int size) {
		Specification<Discuss> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return discussDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Discuss> findSearch(Map whereMap) {
		Specification<Discuss> specification = createSpecification(whereMap);
		return discussDao.findAll(specification);
	}



	/**
	 * 修改
	 * @param discuss
	 */
	public void update(Discuss discuss) {
		discussDao.save(discuss);
	}



	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Discuss> createSpecification(Map searchMap) {

		return new Specification<Discuss>() {

			@Override
			public Predicate toPredicate(Root<Discuss> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 讨论标题
                if (searchMap.get("discusstitle")!=null && !"".equals(searchMap.get("discusstitle"))) {
                	predicateList.add(cb.like(root.get("discusstitle").as(String.class), "%"+(String)searchMap.get("discusstitle")+"%"));
                }
                // 讨论点击量
                if (searchMap.get("discusscount")!=null && !"".equals(searchMap.get("discusscount"))) {
                	predicateList.add(cb.like(root.get("discusscount").as(String.class), "%"+(String)searchMap.get("discusscount")+"%"));
                }
                // 查看量
                if (searchMap.get("checkcount")!=null && !"".equals(searchMap.get("checkcount"))) {
                	predicateList.add(cb.like(root.get("checkcount").as(String.class), "%"+(String)searchMap.get("checkcount")+"%"));
                }
                // 回复量
                if (searchMap.get("replycount")!=null && !"".equals(searchMap.get("replycount"))) {
                	predicateList.add(cb.like(root.get("replycount").as(String.class), "%"+(String)searchMap.get("replycount")+"%"));
                }
                // 来自地点
                if (searchMap.get("discussfrom")!=null && !"".equals(searchMap.get("discussfrom"))) {
                	predicateList.add(cb.like(root.get("discussfrom").as(String.class), "%"+(String)searchMap.get("discussfrom")+"%"));
                }
                // 发表图片
                if (searchMap.get("discussimg")!=null && !"".equals(searchMap.get("discussimg"))) {
                	predicateList.add(cb.like(root.get("discussimg").as(String.class), "%"+(String)searchMap.get("discussimg")+"%"));
                }
                // 讨论详细内容
                if (searchMap.get("discusscontent")!=null && !"".equals(searchMap.get("discusscontent"))) {
                	predicateList.add(cb.like(root.get("discusscontent").as(String.class), "%"+(String)searchMap.get("discusscontent")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};



	}

	public List findDisscussByDiscussTyeOrderByNew(int discusstypeid, int orderType, int sort, int page, int pageSize) {
		List discussList=new ArrayList();
		if(sort==1){//正序
	   	 if(orderType==1){//最新
			 discussList=discussDao.discussNew(discusstypeid,page,pageSize);
		 }
	   	 else if(orderType==2){//最热
	   	 	discussList=discussDao.discussHot(discusstypeid,page,pageSize);
		 }
	   	 else{//未回复
			 discussList=discussDao.discussRepy(discusstypeid,page,pageSize);
		 }
	   }
	   if(sort==0){
		   if(orderType==1){
			   discussList=discussDao.discussNewDesc(discusstypeid,page,pageSize);
		   }
		   else if(orderType==2){
			   discussList=discussDao.discussHotDesc(discusstypeid,page,pageSize);
		   }
		   else{
			   discussList=discussDao.discussRepyDesc(discusstypeid,page,pageSize);
		   }
	   }
		return discussList;
	}

}
