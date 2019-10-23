package org.seckill.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit����ʱ����springIOC����
@RunWith(SpringJUnit4ClassRunner.class)

//����JUnit spring�����ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class SeckillDaoTest {

	//ע��DAOʵ��������
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testQueryById() throws Exception {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
		/*
		 * 6666Ԫ��ɱiPhoneXS
			Seckill 
			[
			seckillId=1000, 
			name=6666Ԫ��ɱiPhoneXS, 
			number=50, 
			startTime=Sun Apr 14 00:00:00 CST 2019, 
			endTime=Mon Apr 15 00:00:00 CST 2019, 
			createTime=Sat Apr 13 14:46:37 CST 2019]
		 *  */
	}

	@Test
	public void testQueryAll() throws Exception {
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for(Seckill seckill : seckills) {
			System.out.println(seckill);
		}
	}
	
	@Test
	public void testReduceNumber() throws Exception {
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		System.out.println("updateCount = " + updateCount);
	}


}