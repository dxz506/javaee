package com.wpx.springmvc.demo06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wpx.springmvc.User;

/**
 * 
 * ConversionService ��Spring����ת����ϵ�ĺ��Ľӿ�
 * 
 * ��������ConversionServiceFactoryBean��Spring��IOC�����ж���ConversionService
 * 
 * Spring���Զ�ʶ���IOC�����е�ConversionService,����Bean�������ü�Spring MVC��������ΰ󶨵ȳ���
 * 
 * ʹ�ý������ݵ�ת��
 * 
 * @author wangpx
 */
@Controller
@RequestMapping("/spring-mvc/demo06")
public class TestConversionService {

	private static final String SUCCESS ="success";
	
	@RequestMapping("/testUserConverter")
	public String testUserConverter(@RequestParam("user") User user) {
		System.out.println(user);
		return SUCCESS;
	}
}
