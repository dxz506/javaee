package com.wpx.servlet.demo13;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet ����������
 * 
 * @author wangpx
 */
public class ServletCharset extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//demo01(resp);
		demo02(resp);
	}
	/**
	 * �ַ���
	 * @throws IOException 
	 */
	public void demo01(HttpServletResponse resp) throws IOException {
		//resp.setContentType("text/html;charset=utf-8");
		//���û���������
		resp.setCharacterEncoding("utf-8");
		//������������ļ������õı���
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		resp.getWriter().print("����");
	}
	/**
	 * �ֽ���
	 * @throws IOException 
	 */
	public void demo02(HttpServletResponse resp) throws IOException {
		//������������ļ�ʱ����
		resp.setContentType("text/html;charset=utf-8");
		//ͨ��response ��ȡ�����
		ServletOutputStream outputStream = resp.getOutputStream();
		//ͨ���ֽ�����ӡ���� �����ַ���Ϊutf-8
		outputStream.write("����".getBytes("utf-8"));
	}
	
	

}
