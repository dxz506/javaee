package com.wpx.spring.demo02;
/**
 * ʹ�þ�̬�����ķ�ʽʵ����
 * @author wangpx
 */
public class BeanFactory02 {
	public static Bean02 getInstance() {
		System.out.println("ʹ�þ�̬����������Bean02....");
		return new Bean02();
	}
}
