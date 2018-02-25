package com.ros.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 何婷婷
 *
 */
public interface MailService {

	public JSONObject sendMail(String toName,String content) throws Exception;

}
