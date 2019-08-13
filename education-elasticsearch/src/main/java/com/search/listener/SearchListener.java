package com.search.listener;

import com.search.dao.SearchDao;
import com.search.pojo.EsCourse;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "es")
public class SearchListener {
    @Autowired
    private SearchDao searchDao;
    @RabbitHandler
    public void Search(EsCourse esCourse){
        System.out.println("es监听到的信息为>>>>>>>"+esCourse);
//        System.out.println(map);
//        Course course = new Course();
//        course= (Course) map.get("course");
//        System.out.println(course);
        searchDao.save(esCourse);
    }
}
