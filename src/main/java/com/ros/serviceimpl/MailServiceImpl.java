package com.ros.serviceimpl;


import java.util.Properties;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ros.service.MailService;
/**
 * @author 何婷婷
 *
 */
@Service
public class MailServiceImpl implements MailService {
	 @Autowired
	 private JavaMailSender mailSender;
	 @Value("${spring.mail.username}")
	 private String fromName;
	 @Value("${spring.mail.host}")
	 private String host;


	@Override
	public JSONObject sendMail(String toName,String content) throws Exception {
		// TODO Auto-generated method stub
		JSONObject jsonObject= new JSONObject();
		if (toName==null) 
			jsonObject.put("邮件不能为空", 1);
	    else {
	    	 SimpleMailMessage send =  new SimpleMailMessage();
	 	    send.setFrom(fromName);
	 	    send.setTo(toName);
	 	    send.setSubject("ROS课程网站");
	 	    send.setText(content);
	 	    mailSender.send(send);
	 	    jsonObject.put("发送邮件成功 ", 0);
		}
		return jsonObject;
	}
	

}
