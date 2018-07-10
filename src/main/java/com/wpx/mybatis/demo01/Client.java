package com.wpx.mybatis.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wpx.mybatis.demo01.vo.Person;

public class Client {
	
	//�Ự����
	private SqlSessionFactory sqlSessionFactory;
	//��������
	@Before
	public void init() throws IOException {
		//�����ļ�
		String resource = "mybatis/SqlMapConfig.xml";
		//���������ļ���������
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * �������ݲ��ύ
	 */
	@Test
	public void testInsertUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person person = new Person();
		person.setId(3);
		person.setName("wangpx");
		person.setBirthday(new Date());
		person.setSex("��");
		person.setAddress("�й�");
		
		try {
			sqlSession.insert("demo01.insertUser", person);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	/**
	 *ͨ��id��ѯ����
	 */
	@Test
	public void testFindUserById() {
		//ͨ��sqlSession��������sqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person person=null;
		try {
			person=sqlSession.selectOne("demo01.findUserById",2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(person);
	}
	/**
	 * �����û�����ѯ
	 */
	@Test
	public void testFindByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Person> list=new ArrayList<Person>();
		try {
			list = sqlSession.selectList("demo01.findUserByName", "%ang%");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		for (Person person : list) {
			System.out.println(person);
		}
	}
	
	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person p=null;
		try {
			
			p = sqlSession.selectOne("findUserById", 1);
			p.setName("������");
			sqlSession.update("demo01.updateUserById", p);
			sqlSession.commit();
			p = sqlSession.selectOne("findUserById", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(p);
	}
	
	@Test
	public void deleteUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("demo01.deleteUserById", 1);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
}
