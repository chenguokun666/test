package com.page.listener;

import com.course.pojo.Course;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.FreeMarkerUtil;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@RabbitListener(queues = "page")
public class PageListener {

    @Autowired
    private FreeMarkerUtil freeMarkerUtil;
    @RabbitHandler
    public void PageFreeMaker(Course course) throws Exception {
        System.out.println("page监听到修改的信息为>>>>>>>>>>>>"+course);
        ArrayList<Course> list = new ArrayList<>();
        list.add(course);
        HashMap map = new HashMap<>();
        System.out.println(list);
        map.put("itemList",list);
        FreeMarkerUtil.createHtmlByMode("infopub.ftl","course.html",map);

    }
}
