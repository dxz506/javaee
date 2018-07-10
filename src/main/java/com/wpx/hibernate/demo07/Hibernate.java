package com.wpx.hibernate.demo07;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;


/**
 * һ��һ��ϵӳ��
 * 
 * @author wangpx
 */
public class Hibernate {

	@Test
	public void demo01() {
		//�����ض���ӳ���ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Dep.class,Manager.class);
		//����session
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction(); 
		

		Manager manager = new Manager("wangpx");
		Dep dep = new Dep("������");
		dep.setManager(manager);
		session.save(dep);
		
		
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
}
