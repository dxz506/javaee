package com.wpx.spring.demo02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring��ʵ����
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest02 {

	//// �޲����Ĺ��췽����ʵ����
	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean01 bean01=(Bean01) applicationContext.getBean("bean01");
		System.out.println(bean01);
	}
	// ��̬����ʵ����
	@Test
	public void demo02(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean02 bean02=(Bean02) applicationContext.getBean("bean02");	
		System.out.println(bean02);
	}
	// ʵ������ʵ����
	@Test
	public void demo03() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Bean03 bean03 = (Bean03) applicationContext.getBean("bean03");
		System.out.println(bean03);
	}
}
