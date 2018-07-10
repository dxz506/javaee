package com.wpx.hibernate.demo03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * ���ֳ־�̬˵��
 * 
 * 
 * OID	���뵽session����	�����״̬
 *  ��		��			   ˲ʱ̬
 *  ��		��			   �־�̬			 
 *  ��		��			   ����̬
 * 
 * 
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Hibernate03 {

	@Test
	public void demo01() {
		//���������ļ�
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addClass(Student.class);
		//ע���׼����
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		//ͨ�����û�ȡsessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//ͨ��sessionFactory ��ȡSession
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction();
		/**
		 * ͨ��session�����ݿ���в���
		 */
		Student student =new Student(1, "wangpx", 22);  //˲ʱ̬ seesion����ǰ
		session.save(student);//�־�̬ session����ʱ  �־�̬�иı����ݿ������
		
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		
		student.setAge(student.getAge()+1);  //�й�̬(����̬) session������
	}
}
