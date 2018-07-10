package com.wpx.hibernate.demo06;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;
import com.wpx.hibernate.demo05.Customer;
import com.wpx.hibernate.demo05.Order;

/**
 * ��Զ��ϵ˫�� һ������
 * 
 * @author wangpx
 */
public class Hibernate {

	@Test
	public void demo01() {
		//�����ض���ӳ���ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Course.class,Student.class);
		//����session
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction(); 
		
		Student student = new Student("wpx");
		Course course01 = new Course("java");
		Course course02 = new Course("C++");
		HashSet<Course> hashSet = new HashSet<Course>();
		hashSet.add(course01);
		hashSet.add(course02);
		student.setCourses(hashSet);

		session.save(student);
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
}
