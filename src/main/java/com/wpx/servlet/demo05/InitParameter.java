package com.wpx.servlet.demo05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <servlet>
		<servlet-name>InitParameter</servlet-name>
		<servlet-class>com.wpx.servlet.demo05.InitParameter</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>InitParameter</servlet-name>
		<url-pattern>/initParameter</url-pattern>
	</servlet-mapping>
 * 
 * ����һЩ�ض�������,�粻��Ҫ�޸ĵ�һЩ�˵�����,����ϣ�����ڳ�ʼ����ʱ��ͱ����ض����ǵ�һ�η��ʵ�ʱ��
 * 
 * @author wangpx
 */
public class InitParameter extends HttpServlet{

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
		//ͨ��MenuDao��������
		
		//...
		
		//ͨ��responseд��ҳ��
		resp.setCharacterEncoding("gbk");
		resp.getWriter().write("�˵�һ");
		resp.getWriter().write("�˵�һ");
		
	}

	@Override
	public void init() throws ServletException {
		//��ʼ����Ҫ�Ĳ�����
		System.out.println("init  ....");
	}

	
	
}
