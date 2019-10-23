package org.seckill.dao;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.UserDao;
import org.seckill.entity.Seckill;
import org.seckill.entity.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaotest {
	
	@Resource
	private UserDao userDao;
	
//	@Test
//	public void testQueryUser() throws Exception {
//		String name = "学生甲";
//		String password = "7c4a8d09ca3762af61e59520943dc26494f8941b";
//		User user = userDao.selectUserByUsernameAndPassword(name, password);
//		System.out.println(user.getUserName());
//		System.out.println(user.getUserPassword());
//		System.out.println(user.getUserId());
//	}
	
	@Test
	public void testQueryUser() throws Exception {
		String name = "学生甲";
		Date nowTime = new Date();
		userDao.recordUser(name, nowTime);
		System.out.println("success");
	}

}


