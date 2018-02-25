package com.ros.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.ros.dao.LoginDao;
import com.ros.entity.User;
import com.ros.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean getUser(String username, String passwd) throws ApplicationException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int id = loginDao.getUserId(username);
		User user = loginDao.getUser(id);
		if (user == null) {
			throw new ApplicationContextException("用户名为空");
		}
		if (user.getPasswd().toString().equals(passwd.toString())) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int getUserId(String username) throws ApplicationException {
		// TODO Auto-generated method stub
		int id = loginDao.getUserId(username);
		return id;
	}

	@Override
	public boolean addUser(User user) throws ApplicationException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int id = loginDao.addUser(user);
		if (id >= 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int getUserType(String username) throws ApplicationException {
		// TODO Auto-generated method stub
		int id = loginDao.getUserId(username);
		if (id < 0) {
			throw new ApplicationContextException("此用户不合法");
		}
		return loginDao.getUserType(id);
	}

	@Override
	public List<String> getInterests() {
		// TODO Auto-generated method stub

		return loginDao.getInterests();
	}

	@Override
	public int addInterest(String name) {
		// TODO Auto-generated method stub
		return loginDao.addInterest(name);
	}

	@Override
	public boolean modifyInfo(String username,User user) throws ApplicationException, SQLException {
		// TODO Auto-generated method stub
		int id=loginDao.getUserId(username);
		user.setId(id);
		return loginDao.modifyBasicInfo(user);
	}

	@Override
	public boolean modifyInfo(int id, String qq, String wechat, String email) throws ApplicationException {
		// TODO Auto-generated method stub
		if (!loginDao.modifyAccount(id, qq, wechat, email)) {
			throw new ApplicationContextException("更新信息失败");
		}
		return loginDao.modifyAccount(id, qq, wechat, email);
	}
}
