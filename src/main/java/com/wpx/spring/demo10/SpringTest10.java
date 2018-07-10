package com.wpx.spring.demo10;

import org.junit.Test;

/**
 * ����cglib����
 * ��jdk����ͬ,cglib������Ҫ���������ʵ�ֽӿ�
 * @author wangpx
 */
public class SpringTest10 {

	@Test
	public void demo01() {
		ProductDao productDao = new ProductDao();
		ProductDao proxy=new CglibProxy(productDao).createProxy();
		proxy.add();
		proxy.delete();
	}
}
