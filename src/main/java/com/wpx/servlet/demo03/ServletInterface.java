package com.wpx.servlet.demo03;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * ͨ��ʵ��Servlet�ӿ�����Ϊһ��Servlet
 * 
 * �������ڣ�ʵ���������������ṩ�������١�
	* Servlet��������Ȼ�����init�������г�ʼ��
		void init(ServletConfig config) 
	* �ӿͻ��˷������е�������service�������д���ġ�
		void service(ServletRequest req, ServletResponse res)  
	* �ӷ��������Ƴ����񣬵���destroy������
		void destroy()  

 	* Servlet���������ڣ���һ�������ʱ��Servletʵ������������������init�������г�ʼ����
						ʵ��ͨ��service�����ṩ���񡣷������رջ����Ƴ�����ʱ������destroy������������
						
						
		һ�γ���,һ������,��ι���				
		
 * @author wangpx
 */
public class ServletInterface implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet ��ʼ��");
	}

	@Override
	public ServletConfig getServletConfig() {
		 System.out.println("Servlet ��ȡ������Ϣ...");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		 System.out.println("Servlet ����...");
	}

	@Override
	public String getServletInfo() {
		 System.out.println("��ȡServlet ��Ϣ....");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("Servlet ����...");
	}

}
