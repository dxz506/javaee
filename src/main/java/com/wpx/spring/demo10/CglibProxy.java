package com.wpx.spring.demo10;



import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib����
 * 
 * @author wangpx
 */
public class CglibProxy implements MethodInterceptor{

	private ProductDao productDao;

	public CglibProxy(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public ProductDao createProxy() {
		// ʹ��CGLIB���ɴ���:
		// 1.����������:
		Enhancer enhancer=new Enhancer();
		// 2.Ϊ�����ø���:
		enhancer.setSuperclass(productDao.getClass());
		// 3.���ûص�:
		enhancer.setCallback(this);
		// 4.��������:
		return (ProductDao)enhancer.create();
	}
	
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if("delete".equals(method.getName())) {
			System.out.println("log4j: delete ....");
			Object obj=methodProxy.invokeSuper(proxy, args);
			return obj;
		}
		return methodProxy.invokeSuper(proxy, args);
	}
	
	
}
