package com.wpx.spring.demo11;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * ǰ����ǿ
 * @author wangpx
 */
public class MyBeforeAdvice implements MethodBeforeAdvice{

	/**
	 * method :ִ�з���
	 * args:   ����
	 * target: Ŀ�����
	 */
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ǰ����ǿ.....");
	}

}
