package com.wpx.spring.demo12;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ����֪ͨ
 * 
 * @author wangpx
 */
public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("����ִ��ǰ.....");
		Object obj=invocation.proceed();//ִ��Ŀ�귽��
		System.out.println("����ִ�к�......");
		return obj;
	}



}
