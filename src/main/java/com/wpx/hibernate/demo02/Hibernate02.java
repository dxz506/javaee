package com.wpx.hibernate.demo02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * * Customer customer = session.get(Customer.class ,1);
	* Customer customer = session.load(Customer.class,1);

	***** get ��load������:
	* 1.����SQL��ʱ��:
	* load�������������һ������.lazy�ӳټ���(������).����ʹ�������������ݵ�ʱ��.(��������ݲ���������).
	* get�����������������.��ִ��session.get()������ʱ��,���Ϸ���SQL����ѯ.
	
	* 2.���صĶ���:
	* load�������ص��Ǵ������.
	* get�������ص�����ʵ�Ķ���.
	
	* 3.��ѯһ�������ڵ�����:
	* load�������쳣:ObjectNotFoundException.
	* get�������쳣:NullPointException./ 5�汾����null�������쳣
	 
	1.���غ��������ļ�:
		��������������:
		* hibernate.properties:
		* ����:
		* Configuration configuration = new Configuration();
		* hibernate.cfg.xml:
		* ����:
		* Configuration configuration = new Configuration().configure();
		
	2.����ӳ���ļ�:
		* ��һ��д��:
		* configuration.addResource("Customer.hbm.xml");
		* �ڶ���д��:(Ҫ��:ӳ���ļ�����Ҫ�淶,����ӳ����ͬһ������)
		* configuration.addClass(Customer.class);


	
 * 
 * @author wangpx
 */
public class Hibernate02 {

	//ͨ��get
	@Test
	public void demo01() {
		//��ȡ�����ļ�
		Configuration configure = new Configuration().configure("hibernate.cfg.xml").addClass(Customer.class);
		//ע���׼����
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
		//ͨ�������ļ�����SessionFactory
		SessionFactory sessionFactory = configure.buildSessionFactory(build);
		//����session �൱��jdbc��Connection
		Session session = sessionFactory.openSession();
		//��������
		session.beginTransaction();
		
		/**
		 * org.hibernate.ObjectNotFoundException: No row with the given identifier 
		 * exists: [com.wpx.hibernate.demo01.Customer#100]
		 */
		Customer customer = session.get(Customer.class, 100);
		System.out.println(customer);
		
		
		
		//�ύ����
		session.getTransaction().commit();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
	//ͨ��load����
	@Test
	public void demo02() {
		//��ȡ�����ļ�
		Configuration configure = new Configuration().configure("hibernate.cfg.xml").addResource("Customer01.hbm.xml");
		//ע���׼����
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
		//ͨ�������ļ�����SessionFactory
		SessionFactory sessionFactory = configure.buildSessionFactory(build);
		//����session �൱��jdbc��Connection
		Session session = sessionFactory.openSession();
		//��������
		session.beginTransaction();
		
		Customer customer = session.load(Customer.class, 100);
		System.out.println(customer);
		
		//�ύ����
		session.getTransaction().commit();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
}
