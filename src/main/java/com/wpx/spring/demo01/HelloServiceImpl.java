package com.wpx.spring.demo01;
/**
 * ʵ�ֽӿ�
 * Ϊ����name�ṩset����
 * 
 * @author wangpx
 */
public class HelloServiceImpl implements HelloService{
	String name;
	public void setName(String name) {
		this.name = name;
	}
	public void say() {
		System.out.println("Hello "+name);
	}

}
