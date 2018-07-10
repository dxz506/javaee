package com.wpx.spring.demo13;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("����ִ��ǰ...");
		Object obj = invocation.proceed();//ִ�з���
		System.out.println("����ִ�к�...");
		return  obj;
	}

}
