package com.wpx.servlet.demo22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
/**
 * ���ڼ���ServletContext�Ĵ���������
 * 
 * @author wangpx
 */
public class ListenerServletContext implements ServletContextListener{

	//�̰߳�ȫ��list����
	private List<HttpSession> sessions=Collections.synchronizedList(new ArrayList<HttpSession>());
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//��Ŀ����ʱִ��,�õ�ServletContext
		ServletContext servletContext = sce.getServletContext();
		//�����ϱ��浽session��
		servletContext.setAttribute("sessions", sessions);
		//����Timer����
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("��ʼɨ�� Session.... ");
				//�ж�session�Ƿ���� session���3����û��ʹ�ã���������.
				for(Iterator<HttpSession> it= sessions.iterator();it.hasNext();) {
					HttpSession session = it.next();
					if(System.currentTimeMillis()-session.getLastAccessedTime() > 3000) {
						System.out.println(session.getId()+" ��ʱ");
						it.remove();
						session.invalidate();
					}
				}
			}
		}, 1000,3000);
		
		System.out.println("ServletContext Initialized ....");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext has Destoryed....");
		
	}

}
