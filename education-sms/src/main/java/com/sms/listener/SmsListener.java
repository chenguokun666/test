package com.sms.listener;

import com.sms.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

   @Value("${aliyun.sms.accessKeyId}")
   private String accessKeyId;
   @Value("${aliyun.sms.accessKeySecret}")
   private String accessKeySecret;

   @Value("${aliyun.sms.template_code}")
    private String template_code;

   @Value("${aliyun.sms.sign_name}")
   private String sign_name;

    @RabbitHandler
    public void receiveSms(Map<String,String> map){
        String phone=map.get("userphone");
        String code=map.get("code");
        System.out.println("receive+"+phone+code);
        SmsUtil.sendSms(phone,code,sign_name,template_code,accessKeyId,accessKeySecret);
    }

}
