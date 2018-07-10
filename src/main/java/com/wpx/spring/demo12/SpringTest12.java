package com.wpx.spring.demo12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author wangpx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest12 {
	
	@Autowired(required=true)
	@Qualifier("orderDaoProxy")
	private OrderDao orderDao;
	
	@Test
	public void demo01() {
		orderDao.add();
		orderDao.delete();
		orderDao.update();
		orderDao.find();
	}
}
