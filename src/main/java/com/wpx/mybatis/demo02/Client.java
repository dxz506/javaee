package com.wpx.mybatis.demo02;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wpx.mybatis.demo01.vo.Person;
import com.wpx.mybatis.demo02.dao.PersonDao;
import com.wpx.mybatis.demo02.dao.impl.PersonDaoImpl;

public class Client {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException {
		//�����ļ�
		String resource = new String("mybatis/SqlMapConfig.xml");
		//��ȡ�����ļ���������
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindPersonById() {
		PersonDao personDao = new PersonDaoImpl(sqlSessionFactory);
		Person person = personDao.findUserById(2);
		System.out.println(person);
	}
}
