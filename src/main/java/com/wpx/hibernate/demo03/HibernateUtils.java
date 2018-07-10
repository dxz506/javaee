package com.wpx.hibernate.demo03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * hiberna�ķ�װ
 * @author wangpx
 */
@SuppressWarnings("all")
public class HibernateUtils {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionSessionFactory(Class<?>... clazz) {
		if(sessionFactory == null) {
			synchronized (clazz) {
				if(sessionFactory == null) {
					//���������ļ�
					Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
					for (Class<?> class1 : clazz) {
						configuration.addClass(class1);
					}
					
					//ע���׼����
					StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
					//ͨ�����ô���sessionFactory
					sessionFactory = configuration.buildSessionFactory(standardServiceRegistry);
				}
			}
		}
		return sessionFactory;
	}
	
	public static  Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
