package com.wpx.springmvc.demo03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ͨ��PathVariable���Խ�URL��ռλ�������󶨵����ƴ������е������
 * @author wangpx
 */
@Controller
@RequestMapping("/spring-mvc/demo03")
public class PathVariableTest {
	
	@RequestMapping("/demo03/{id}")
	public void showPathVariable(@PathVariable("id") Integer id) {
		System.out.println("id  is "+ id);
	}
	
}
