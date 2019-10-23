package org.seckill.service.impl;

import java.security.MessageDigest;
import java.util.Date;

import org.seckill.dao.UserDao;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public boolean selectUserByUsernameAndPassword(String userName,String userPassword) {
		if(userDao.selectUserByUsernameAndPassword(userName,userPassword) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void recordUser(String userName,Date nowTime) {
		userDao.recordUser(userName, nowTime);
	}
	
}
