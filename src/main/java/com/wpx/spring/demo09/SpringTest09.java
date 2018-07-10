package com.wpx.spring.demo09;

import org.junit.Test;

/**
 * 
 * @author wangpx
 */
public class SpringTest09 {
	
	//��ͳ��ʽ�����־
	@Test
	public void demo01() {
		UserDao userDao = new UserDaoImpl();
		userDao.add();
		System.out.println("log4j:add....");
		userDao.update();
	}
	//ͨ���������
	@Test
	public void demo02() {
		//������Ķ���
		UserDao userDao=new UserDaoImpl();
		//�����������
		UserDao proxy=new JDKProxy(userDao).createProxy();
		proxy.add();
		proxy.update();
	}
}
