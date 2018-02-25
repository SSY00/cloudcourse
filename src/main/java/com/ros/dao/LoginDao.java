package com.ros.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ros.entity.User;

/**
 * @author 何婷婷
 *
 */
public interface LoginDao {
	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	public User getUser(@Param("id") int id);
	/**
	 * 获取用户id
	 * @param username
	 * @return
	 */
	public int getUserId(String username);
	/**
	 * 增加一个用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);

	/**
	 * 获取用户的类型：管理员还是学生
	 * @param id
	 * @return
	 */
	public int getUserType(int id);
	
     /**
      * 获取所有的兴趣
      * @return
      */
	public List<String> getInterests();
	/**
	 * 添加兴趣标签
	 * @param name
	 * @return
	 */
	public int addInterest(String name);
	/**
	 * 更新用户基础性信息
	 * @param user
	 * @return
	 */
	public  boolean modifyBasicInfo(User user );
	/**
	 * 更新用户账号信息
	 * @param user
	 * @return
	 */
	public  boolean modifyAccount(@Param("id") int id,@Param("qq") String qq,@Param("wechat") String wechat,@Param("email") String email);
}
