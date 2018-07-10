package com.wpx.hibernate.demo01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
/**
 * ������
 * ͨ��hibernateѧ���������������ɾ�Ĳ�
 * @author wangpx
 */
public class Hibernate01 {
	//��ӿͻ�
	@Test
	public void demo01() {
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
		
		Customer customer=new Customer(); 
		customer.setAge(21);
		customer.setName("wpx");
		session.save(customer);
		
		//�ύ����
		session.getTransaction().commit();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
		//���ҿͻ�
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
			
			Customer customer = session.get(Customer.class, 1);
			System.out.println(customer);
			
			//�ύ����
			session.getTransaction().commit();
			//�ر���Դ
			session.close();
			sessionFactory.close();
		}
			//�޸Ŀͻ�
			@Test
			public void demo03() {
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
				
				Customer customer = session.get(Customer.class, 1);
				System.out.println(customer);
				customer.setAge(customer.getAge()+1);
				session.save(customer);
				
				//�ύ����
				session.getTransaction().commit();
				//�ر���Դ
				session.close();
				sessionFactory.close();
			}
			//ɾ���ͻ�
			@Test
			public void demo04() {
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
				
				Customer customer = session.get(Customer.class, 1);
				if(customer!=null) {
					try {
						session.delete(customer);
						System.out.println("ɾ���ɹ�");
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("ɾ��ʧ��");
					}
				}
				
				//�ύ����
				session.getTransaction().commit();
				//�ر���Դ
				session.close();
				sessionFactory.close();
			}
}
