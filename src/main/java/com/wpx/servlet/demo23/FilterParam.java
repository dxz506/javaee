package com.wpx.servlet.demo23;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Filter��
 * 
 * @author wangpx
 */
public class FilterParam implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter init ...");
		//��ȡFilter����
		String filterName = filterConfig.getFilterName();
		System.out.println(filterName);
		//��ȡ��ʼ��������
		Enumeration<String> names = filterConfig.getInitParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		//��ȡServletContext����
		filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("Filter ��ʼִ�� .....");
			//�ж�
			if(1<0) {
				request.getRequestDispatcher("ת�����µ�ҳ��");
			}
			//����
			chain.doFilter(request, response);
			
	}
	

	@Override
	public void destroy() {
		 System.out.println("Filter destoy .....");
	}

}
