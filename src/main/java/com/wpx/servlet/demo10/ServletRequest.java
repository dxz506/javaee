package com.wpx.servlet.demo10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����Request����API
 * 
 * @author wangpx
 */
public class ServletRequest extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ip
		String ip=req.getRemoteAddr();
		System.out.println(ip);
		//����ʽ
		String method = req.getMethod();
		System.out.println(method);
		//��ȡ·��
		String contextPath = req.getContextPath();
		System.out.println(contextPath);
		//������ͷ��Դ
		String header = req.getHeader("referer");
		System.out.println(header);
		//��ȡ�û�����/�����
		String user_agent = req.getHeader("user-agent");
		System.out.println(user_agent);
	}

}
