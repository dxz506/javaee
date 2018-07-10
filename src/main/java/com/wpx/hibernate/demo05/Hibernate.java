package com.wpx.hibernate.demo05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import com.wpx.hibernate.demo03.HibernateUtils;
/**
 * Hibernate�й�ϵӳ��һ�Զ� ˫�����
 * 
 * @author wangpx
 */
public class Hibernate {

	/**
	 * ���Լ�������,���涩��ʱ���û�Ҳ����
	 * 
	 */
	@Test
	public void demo01() {
		//����ָ����ӳ���ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		//ʹ��sessionSessionFactory����session
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction(); 
		
		Customer customer = new Customer("wangpx", 21);
		Order order = new Order("GuangDong", customer);
		session.save(order);
		
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
	/**
	 * ���Լ���delete ɾ���ͻ�ʱ���䶩��Ҳɾ��
	 */
	@Test
	public void demo02() {
		//����ָ����ӳ���ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		//ʹ��sessionSessionFactory����session
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction(); 
		
		Customer customer = session.get(Customer.class, 1);
		session.delete(customer);
		
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	} 
}
