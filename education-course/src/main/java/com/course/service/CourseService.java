package com.course.service;

import com.course.dao.CourseDao;
import com.course.pojo.Course;
import com.search.pojo.EsCourse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private IdWorker idWorker;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Course> findSearch(Map whereMap, int page, int size) {
		Specification<Course> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return courseDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Course> findSearch(Map whereMap) {
		Specification<Course> specification = createSpecification(whereMap);
		return courseDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Course findById(String id) {
		return courseDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param course
	 */
	public void add(Course course) {
		course.setCourseid( (int)idWorker.nextId() );
		courseDao.save(course);
	}

	/**
	 * 修改
	 * @param course
	 */
	public void update(Course course) {
		courseDao.save(course);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		courseDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Course> createSpecification(Map searchMap) {

		return new Specification<Course>() {

			@Override
			public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 课程名称
                if (searchMap.get("courseName")!=null && !"".equals(searchMap.get("courseName"))) {
                	predicateList.add(cb.like(root.get("courseName").as(String.class), "%"+(String)searchMap.get("courseName")+"%"));
                }
                // 课程关注量
                if (searchMap.get("courseAttention")!=null && !"".equals(searchMap.get("courseAttention"))) {
                	predicateList.add(cb.like(root.get("courseAttention").as(String.class), "%"+(String)searchMap.get("courseAttention")+"%"));
                }
                // 课程类型 0 免费 1 限免 2 会员
                if (searchMap.get("courseType")!=null && !"".equals(searchMap.get("courseType"))) {
                	predicateList.add(cb.like(root.get("courseType").as(String.class), "%"+(String)searchMap.get("courseType")+"%"));
                }
                // 课程标签 与标签表通过id关联
                if (searchMap.get("courseLabel")!=null && !"".equals(searchMap.get("courseLabel"))) {
                	predicateList.add(cb.like(root.get("courseLabel").as(String.class), "%"+(String)searchMap.get("courseLabel")+"%"));
                }
                // 课程简介
                if (searchMap.get("courseComment")!=null && !"".equals(searchMap.get("courseComment"))) {
                	predicateList.add(cb.like(root.get("courseComment").as(String.class), "%"+(String)searchMap.get("courseComment")+"%"));
                }
                // 课程点击量
                if (searchMap.get("courseHits")!=null && !"".equals(searchMap.get("courseHits"))) {
                	predicateList.add(cb.like(root.get("courseHits").as(String.class), "%"+(String)searchMap.get("courseHits")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

	public List<Course> CourseLabel(Integer courselabel) {
		return courseDao.CourseLabel(courselabel);
	}


	@Transactional
    public void CourseUpdate(int courseid) {
		courseDao.CourseUpdate(courseid);
		Course course=courseDao.SYNQurey(courseid);
		EsCourse esCourse = new EsCourse();
		esCourse.setId(UUID.randomUUID().toString());
		esCourse.setCourseid(course.getCourseid());
		esCourse.setCoursename(course.getCoursename());
		esCourse.setCourseattention(course.getCourseattention());
		esCourse.setCoursetype(course.getCoursetype());
		esCourse.setReleasetime(course.getReleasetime());
		esCourse.setLogouttime(course.getLogouttime());
		esCourse.setInonline(course.getInonline());
		esCourse.setCourselabel(course.getCourselabel());
		esCourse.setCoursecomment(course.getCoursecomment());
		esCourse.setCoursehits(course.getCoursehits());
		esCourse.setUserid(course.getUserid());
		esCourse.setTeacherid(course.getTeacherid());
		System.out.println(course);
//		Map map = new HashMap<>();
//		map.put("course",esCourse);
//		System.out.println(course);
        rabbitTemplate.convertAndSend("es",esCourse);
        rabbitTemplate.convertAndSend("page",course);
    }


}
