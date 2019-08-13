package com.freemarker;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class Test {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDirectoryForTemplateLoading(new File("C:/Users/CGK/Desktop/education-parent/education-freemarkerdTest/src/main/resources/static"));
        configuration.setDefaultEncoding("UTF-8");
        Template template = configuration.getTemplate("test.ftl");
        HashMap map = new HashMap();
        map.put("name","陈国昆");
        map.put("message","欢迎来到德莱联盟");
        FileWriter out = new FileWriter(new File("d:\\\\test.html"));
        template.process(map,out);
        out.close();


    }

}
