package org.seckill.service;

import java.util.Date;

import org.seckill.entity.User;

public interface UserService {
	
	public boolean selectUserByUsernameAndPassword(String userName,String userPassword);
	
	public void recordUser(String userName,Date nowTime);

}
