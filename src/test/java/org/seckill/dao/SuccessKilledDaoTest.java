package org.seckill.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)

//告诉JUnit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class SuccessKilledDaoTest {
	
	@Resource
	private SuccessKilledDao successKilledDao;

	@Test
	public void testInsertSuccessKilled() {
		long id = 1001L;
		long phone = 12345678901L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount = " + insertCount);
	}

	@Test
	public void testQueryByIdWithSeckill() {
		long id = 1001L;
		long phone = 12345678901L;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
		/*
		 * SuccessKilled [seckillId=1001, userPhone=12345678901, state=0, createTime=Thu Apr 18 20:21:56 CST 2019]
		   Seckill [seckillId=1001, name=2000元秒杀ipad mini 2019, number=200, startTime=Sun Apr 14 00:00:00 CST 2019, endTime=Mon Apr 15 00:00:00 CST 2019, createTime=Sat Apr 13 14:46:37 CST 2019]
*/
		
	}

}
