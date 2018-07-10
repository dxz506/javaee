package com.wpx.springmvc.demo09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterceptorTest implements HandlerInterceptor{

	/**
	 * ���������DispatherServlet��ȫ�����������ִ��,�����ڸ÷����н���һЩ��Դ����Ĳ���
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		 
		
	}

	/**
	 * ���������ҵ�����������������,DispatcherServlet��ͻ��˷�����Ӧǰ������
	 * �ڸ÷����ж��û�����request����
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		 
		
	}
	/**
	 * ���������ҵ��������������ǰ������,�ڸ÷����ж��û�����request���д���
	 * �����Ҫ��������������,����ҵ���������д���,����true
	 * ���������Ҫ���������������������,�򷵻�false
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		 
		return false;
	}

}
