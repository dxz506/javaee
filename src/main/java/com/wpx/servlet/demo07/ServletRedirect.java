package com.wpx.servlet.demo07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ͨ��Servlet�����ض���
 * 
 * @author wangpx
 */
public class ServletRedirect extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����ͷ
		resp.setContentType("text/html;charset=utf-8");
		//����״̬
		resp.setStatus(302);
		//Ҫ��ת�ĵ�ַ
		resp.setHeader("location", "servlet/302.jsp");
	}

}
