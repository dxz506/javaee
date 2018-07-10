package com.wpx.spring.demo15;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ������
 * @author wangpx
 */
public class MyAspect {

	public void before() {
		System.out.println("ǰ��֪ͨ...");
	}
	public void afterReturning(Object returnVal) {
		System.out.println("����֪ͨ..."+returnVal);
	}
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("����ǰ֪ͨ...");
		Object result=proceedingJoinPoint.proceed();
		System.out.println("���ƺ�֪ͨ...");
		return result;
	}
	public void afterThrowable(Throwable e) {
		System.out.println("�쳣֪ͨ"+e.getMessage());
	}
	public void after() {
		System.out.println("����֪ͨ...");
	}
}
