package com.wpx.servlet.demo22;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * ���ڼ���Session�Ĵ���������
 * 
 * @author wangpx
 */
public class ListenerSession implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(" Session Created ...");
		//���Դ��л�ȡsession����
		HttpSession session = se.getSession();
		//��������ServletContext�д洢�ģ�����ֻ��Ҫ��ServletContext�л�ȡ�Ϳ��ԡ�
		ServletContext context = session.getServletContext();
		List<HttpSession> sessions=(List<HttpSession>) context.getAttribute("sessions");
		sessions.add(session);
		System.out.println(session.getId() +"  ��ӵ��˼�����");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(" Session Destroyed ...");
	}

}
