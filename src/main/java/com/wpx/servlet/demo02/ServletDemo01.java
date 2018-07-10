package com.wpx.servlet.demo02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
	web.xml����������
	��ʾ:
	���ص�����urlΪ/servletDemo01��ύ��Servlet��ΪServletDemo01��Servlet����
	
	��ΪServletDemo01��Servlet���ҵ��ض�������д���
		Ҫ���������Ϊȫ·��,�̳�HttpServlet,��дdoGet,doPost����
	
	
 	<servlet>
		<servlet-name>ServletDemo01</servlet-name>
		<servlet-class>com.wpx.servlet.demo02.ServletDemo01</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>ServletDemo01</servlet-name>
		<url-pattern>/servletDemo01</url-pattern>
	</servlet-mapping>
	
 * @author wangpx
 */
public class ServletDemo01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet .....");
	}

}
