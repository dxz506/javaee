package com.wpx.hibernate.demo04;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;

/**
 * Hibernate һ������
 * 
 * 	������ǽ����ݿ�/Ӳ���ļ��е�����,���뻺��(�����ڴ��е�һ��ռ�),���ٴ�ʹ�õ�ʱ��,�Ϳ��Դ��ڴ��л�ȡ
 * 	
 * 	����ĺô�: ���������Ч��,���漼����Hibernate��һ���Ż��ֶ�
 * 	
 * һ������Ϊsession����Ļ���,һ��������sessio����������һ��,�Դ��Ĳ���ж��
 * 
 * 
 * 
 * @author wangpx
 */
public class Hibernate04 {

	//����һ������
	@Test
	public void demo01() {
		//ͨ���ض���ָ��ӳ�������ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Person.class);
		//����Session
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction();
		Person p =new Person(1, "wnagpx", 22);
		session.save(p);
		
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
	
	
	//��ѯ���β鿴sql��ִ�д���
	@Test
	public void demo02() {
		//ͨ���ض���ָ��ӳ�������ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Person.class);
		//����Session
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction();
		
		Person person = session.get(Person.class, 1);
		System.out.println(person);
		Person person2 = session.get(Person.class, 1);
		System.out.println(person2);
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
	
	//��һ�������������ʱ��,����һ���������ͻ��������,��������һ�������ʱ��,
	//����һ���ύ,�ȶ�һ������Ϳ�����,�������һ�²�����,�����һ����������ݿ�
	@Test
	public void demo03() {
		//ͨ���ض���ָ��ӳ�������ļ�
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Person.class);
		//����Session
		Session session = sessionFactory.openSession();
		//��������
		Transaction transaction = session.beginTransaction();
		
		Person person = session.get(Person.class, 1);
		System.out.println(person);
		person.setName("wpx");
		session.save(person);
		Person person2 = session.get(Person.class, 1);
		System.out.println(person2);
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
	/**
	 * Hibernate����һ������
	 */
	@Test
	public void demo04() {
		//һ���������������һ��,session�������ڽ���,һ����������
		//����һ������
		//clear()  ���һ�������е����ж���
		//evict(Object obj) ���һ�������е�ĳ������
		//flush ˢ������
		//refresh(Object obj) �����������������¸�����һ�����������
	}
	/**
	 * Hibernateһ�������ˢ��ʱ��
	 */
	@Test
	public void demo05() {
		//FlushMode:
			//����:
			//AlWAYS: ÿ�β�ѯ��ʱ�򶼻�ˢ�� �ֶ�����flush,�����ύ��ʱ��
			//AUTO: Ĭ��ֵ,��Щ��ѯ��ˢ��.�ֶ�����flush,�����ύ��ʱ��
			//COMIT: �������ύ��ʱ���ֶ�����flush��ʱ��
			//MANAL: ֻ�����ֶ�����flush��ˢ��

	}
	
}
