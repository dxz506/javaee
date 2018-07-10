package com.wpx.hibernate.demo08;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;

/**
 * 
 *Hibernate�������֧��
 * 
 * @author wangpx
 */
public class Hibernate03 {

	@Test
	public void demo01() {
		//����ָ����ӳ���ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		System.out.println(session1 == session2);
		
		/**
		  ��cfg�ļ�������
		  <!-- ʹ�õ�ǰ�߳��е�session -->
			<property name="hibernate.current_session_context_class">thread</property>
		 */
		Session session3 = HibernateUtils.getCurrentSession();
		Session session4 = HibernateUtils.getCurrentSession();
		System.out.println(session3 == session4);
	}
	/**
	 * ͨ���������ļ������ø��뼶��
	 * 
	 * <!-- 
		1��Read uncommitted isolation
		2��Read committed isolation
		4��Repeatable read isolation
		8��Serializable isolation
	 -->
	<property name="hibernate.connection.isolation">1</property>
	 * 
	 */
	@Test
	public void demo02() {
		SessionFactory  sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		
		Order order = session.get(Order.class, 1, LockMode.UPGRADE_NOWAIT);
		order.setAddr("����");
		session.save(order);
		
		transaction.commit();
		session.close();
		
	}
	
	
}
