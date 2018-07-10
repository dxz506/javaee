package com.wpx.spring.demo17;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext17.xml")
public class SpringTest17 {

	@Resource
	private UserDao userDao;
	//����û�
	@Test
	public void demo01() {
		User user=new User("С��");
		userDao.add(user);
	}
	//ͨ��id��ѯ�û�
	@Test
	public void demo02() {
		User user = userDao.findById(1);
		System.out.println(user);
		userDao.delete(user);
	}
	//ͨ���û�id��ѯ����
	@Test
	public void demo03() {
		String name = userDao.findNameById(3);
		System.out.println(name);
	}
	//��ѯ�����û�
	@Test
	public void demo04() {
		List<User> findAll = userDao.findAll();
		for (User user : findAll) {
			System.out.println(user);
		}
	}
	//�����û�
	@Test
	public void demo06() {
		User user = userDao.findById(2);
		user.setName("wangpx");
		userDao.update(user);
	}
}
