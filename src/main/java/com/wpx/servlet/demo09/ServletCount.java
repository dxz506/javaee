package com.wpx.servlet.demo09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * ����ͳ����վ�ķ��ʴ���
 * 
 * 
 * @author wangpx
 */
public class ServletCount extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("count", 0);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	/**
	 * ÿһ�η��ʣ�����ִ�и÷�����
	 * �ó�count�ı�����ֵ���������뵽�������
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer count = (Integer) getServletContext().getAttribute("count");
		getServletContext().setAttribute("count", ++count);
		// ��ҳ���������
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("��"+count+"�η���");
	}
}

