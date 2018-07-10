package com.wpx.spring.demo01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * ������ ����spring�����ļ���name����ֵע��
 * @author wangpx
 */
@SuppressWarnings("all")
public class SpringTest01 {
	//��ͳ��ʽ
	@Test
	public void demo01() {
		HelloServiceImpl helloSeriviceImpl = new HelloServiceImpl();
		helloSeriviceImpl.setName("wpx");
		helloSeriviceImpl.say();
	}
	//Springͨ������applicationContext�ļ�ע��
	@Test
	public void demo02() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService helloSerivice=(HelloService) applicationContext.getBean("helloService");
		helloSerivice.say();
	}
	// ���ش���·���µ������ļ�:
	@Test
	public void demo03() {
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("D:\\nodejs\\javaee\\src\\main\\resources/applicationContext.xml");
		HelloService helloService=(HelloService) applicationContext.getBean("helloService");
		helloService.say();
	}
	
}
