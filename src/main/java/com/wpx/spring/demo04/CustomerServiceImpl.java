package com.wpx.spring.demo04;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
@SuppressWarnings("all")
public class CustomerServiceImpl implements CustomerService,BeanNameAware,
	ApplicationContextAware,InitializingBean,DisposableBean{
	
	private String name;
	public void add() {
		 System.out.println("add customer ....");
	}

	public void find() {
		System.out.println("find customer ....");
	}
	public CustomerServiceImpl() {
		super();
		System.out.println("��һ��:ʵ������...");
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("�ڶ���:���Ե�ע��...");
	}
	public void setBeanName(String name) {
		 System.out.println("������:ע�����õ��������"+name);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("���Ĳ�:ע��applicationContext "+applicationContext);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("������:�������ú�ִ��...");
	}
	public void setup(){
		System.out.println("���߲�:�����ֶ����õĳ�ʼ������....");
	}
	public void destroy() throws Exception {
		System.out.println("��ʮ��:�������ٵķ���....");
	}
	public void teardown() {
		System.out.println("��ʮһ��:�����ֶ����ٵķ���....");
	}


}
