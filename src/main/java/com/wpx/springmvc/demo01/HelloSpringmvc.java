package com.wpx.springmvc.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ���/spring-mvc/demo01�µ�demo01.jspҳ����
 * �ĳ�������ת��success ҳ��
 * 
 * @author wangpx
 */
@Controller
@RequestMapping("/spring-mvc/demo01")
public class HelloSpringmvc {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello springmvc");
		return "success";
	}
}
