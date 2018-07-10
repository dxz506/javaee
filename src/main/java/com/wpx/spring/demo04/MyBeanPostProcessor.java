package com.wpx.spring.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		 System.out.println("���岽:��ʼ��֮ǰִ��....");
		return bean;
	}

	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		 System.out.println("�ڰ˲�:��ʼ����ִ��....");
			// ��̬����:
		 if(beanName.equals("customerService")) {
			 Object proxy =Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
				// ����Ŀ�귽����ʱ��,����invoke����.
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					if("add".equals(method.getName())) {
						System.out.println("Ȩ��У��...");
						Object result=method.invoke(bean, args);
						return result;
					}
					return method.invoke(bean, args);
				}
			});
			 return proxy;
		 }
		return bean;
	}

}
