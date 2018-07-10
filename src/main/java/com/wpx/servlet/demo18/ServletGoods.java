package com.wpx.servlet.demo18;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��Ʒ�Ĵ�����
 * ���ڼ�¼��Ʒ�������Ϣ
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ServletGoods extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���Խ�cookie����Map�����鼯��
		//��ȡǰ�˴���Ĳ���
		String id = req.getParameter("id");
		//��ȡ����cookie���в����ض���cookie
		Cookie[] cookies = req.getCookies();
		//��ȡ���ض���cookie
		Cookie cookieByName = MyCookieUtils.getCookieByName(cookies, "javaee_goods");
		//�ж�cookie�Ƿ�Ϊ��
		if(cookieByName==null) {
			//û�����½�cookie
			Cookie cookie = new Cookie("javaee_goods", id);
			//������Ч��
			cookie.setMaxAge(60*60*24);
			//����path
			cookie.setPath("/");
			//��дcookie
			resp.addCookie(cookie);
		}else {
			//������ǵ�һ�η�����,��ȡ��ֵ
			String value = cookieByName.getValue();
			//��valueֵͨ��,�ָ��
			String[] splitValue = value.split(",");
			if(!isContain(splitValue, id)) {
			//����������������
			cookieByName.setValue(value+","+id);
			//������Ч��
			cookieByName.setMaxAge(24*60*60);
			//����·��
			cookieByName.setPath("/");
			//��д
			resp.addCookie(cookieByName);
			}
		}
		resp.sendRedirect("servlet/goodsList.jsp");
	
	}
	private boolean isContain (String[] values,String id) {
		for (String string : values) {
			if(string.equals(id)) {
				return true;
			}
		}
		return false;
	}

}
