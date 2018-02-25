package com.ros.service;

import java.sql.SQLException;
import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.alibaba.fastjson.JSONObject;
import com.ros.entity.User;

public interface LoginService {
	/**
	 * @param id
	 * @return
	 */
public boolean getUser( String username , String passwd)  throws ApplicationException;
/**
 * 通过其用户名获取其id
 * @param username
 * @return
 * @throws ApplicationException
 */
public int getUserId(String username) throws ApplicationException;
/**
 * 增加一个用户
 * @param user
 * @return
 * @throws ApplicationException
 */
public boolean addUser(User user) throws ApplicationException;
/**
 * 判断是管理员学生老师
 * @param id
 * @return
 * @throws ApplicationException
 */
public int getUserType(String username) throws ApplicationException;
/**
 * 获取所有的兴趣
 * @return
 */
public List<String> getInterests();
/**
 * 新增用户兴趣
 * @param name
 * @return
 */
public int addInterest(String name);
/**
 * 修改用户基础信息
 * @param user
 * @return
 */
public boolean modifyInfo(String username,User user)  throws ApplicationException , SQLException;
/**
 * 更新账号信息
 * @param id
 * @param qq
 * @param wechat
 * @param email
 * @return
 */
public boolean modifyInfo(int id,String qq,String wechat,String email)  throws ApplicationException ;
}
