package com.wpx.hibernate.demo08;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;

/**
 * 
 * 
 * @author wangpx
 */
@SuppressWarnings("unchecked")
public class Hibernate02 {

	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction transaction=null;
	
	@Before
	public void before() {
		//����ָ����ӳ���ļ�
		 sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		//ʹ��sessionSessionFactory����session
		 session = sessionFactory.openSession();
		//��������
		 transaction = session.beginTransaction(); 
	}
	@After
	public void after() {
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
	
	
	/*
	 * <set>û������fetch ��lazy���
	 */
	@Test
	public void demo01() {
		Customer customer = session.get(Customer.class, 1);//���Ͳ�ѯ�ͻ���SQL
		System.out.println(customer.getOrders().size()); //�ٴη���һ��SQL
	}
	
	/**
	 * <set>����fetch="join" lazy�ᱻ����
	 * 
	 */
	@Test
	public void demo02() {
		Customer customer = session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}
	
	/*
	 * 	 ��<set>����������
	 * 	 fetch="select" lazy="true"
	 * 	 lazy:true-ʹ���ӳټ��� 
	 * 	 ���Ͷ���SQL,��ѯ��������
	 */
	@Test
	public void demo03() {
		Customer customer = session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}

	 /**
	 * ��<set>����������
	 * 	 fetch="select" lazy="false"
	 * 	 lazy:false:��������ļ�����ʹ���ӳ�
	 */

	@Test
	public void demo04() {
		Customer customer = session.get(Customer.class, 9);
		System.out.println(customer.getOrders().size());
	}
	
	/**
	 * ����ץȡ
	 * 	ͨ����������ץȡ�ͻ�:
	 * 		��Ҫ�ڿͻ�һ��<class>��ǩ������batch-size
	 */
	@Test
	public void demo05() {
		List<Order> list = session.createQuery("from Order").list();
		for(Order order : list) {
			System.out.println(order.getCustomer().getName());
		}
	}
	
	/**
	 * ����ץȡ
	 * �ڿͻ�һ������
	 * <set> ����������batch-size="3"
	 */
	@Test
	public void demo06() {
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer c :list) {
			for(Order o: c.getOrders()) {
				System.out.println(o.getAddr());
			}
		}
	}
	
	/**
	 * 
	 * ��<many-to-one> ��ǩ������
	 * fetch="select" lazy="proxy"
	 */
	@Test
	public void demo07() {
		Order order = session.get(Order.class,1);
		System.out.println(order.getCustomer().getName());
	}
	
	
}
