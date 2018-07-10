package com.wpx.spring.demo03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean�����÷�Χ
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest03 {
	// ����Scope
	@Test
	public void demo01() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer01=(Customer) applicationContext.getBean("customer");
		Customer customer02=(Customer) applicationContext.getBean("customer");
		System.out.println(customer01==customer02);
	}
	//����spring����������
	@Test
	public void demo02() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Product product=(Product) applicationContext.getBean("product");
		product.destory();
	}
	
}
