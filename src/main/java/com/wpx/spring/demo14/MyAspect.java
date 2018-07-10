package com.wpx.spring.demo14;
/**
 * ������:�����е�����ǿ���
 * 
 * @author wangpx
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class MyAspect {

	//ǰ��֪ͨ
	@Before("execution(* com.wpx.spring.demo14.PersonDao.add(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("ǰ��֪ͨ  "+joinPoint);
	}
	//����֪ͨ
	@AfterReturning(value="execution(* com.wpx.spring.demo14.PersonDao.update(..))",returning="returnVal")
	public void afterReturning(Object returnVal) {
		System.out.println("����֪ͨ  "+returnVal);
	}
	//����֪ͨ
	@Around(value="MyAspect.myPointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("����ǰ֪ͨ...");
		Object obj=proceedingJoinPoint.proceed();
		System.out.println("���ƺ�֪ͨ...");
		return obj;
	}
	//�쳣����
	@AfterThrowing(value="execution(*  com.wpx.spring.demo14.PersonDao.ex(..))",throwing="e")
	public void ex(Throwable e) {
		System.out.println("�쳣  "+e.getMessage());
	}
	//����֪ͨ
	@After("MyAspect.myPointcut()")
	public void after() {
		System.out.println("����֪ͨ");
	}
	
	//�е�
	@Pointcut("execution(* com.wpx.spring.demo14.PersonDao.find(..))")
	private void myPointcut() {	}
}
