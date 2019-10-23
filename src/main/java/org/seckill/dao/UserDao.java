package org.seckill.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.User;

public interface UserDao {
	
	User selectUserByUsernameAndPassword(@Param("userName")String userName,@Param("userPassword")String userPassword);
	
	void recordUser(@Param("userName")String userName,@Param("nowTime") Date nowTime);

}
