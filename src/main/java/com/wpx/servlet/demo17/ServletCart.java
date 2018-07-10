package com.wpx.servlet.demo17;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ͨ��Session ��ʵ�ֹ��ﳵ����
 * ��������������
 * @author wangpx
 */
public class ServletCart extends HttpServlet{

	private static final long serialVersionUID = -1229999864730298789L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ܺ�̨����
		String id = req.getParameter("id");
		// �����б�
		String[] names = {"���빽","�²�","�ʼ���","���⴮","ţ�⴮"};
		//���ݲ�����ȡ������Ʒ
		String productName = names[Integer.parseInt(id)];
		//��session �л�ȡ���ﳵ
		HttpSession session = req.getSession();
		Map<String,Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		if(cart ==null){
			//��һ�����½����ﳵ
			cart=new HashMap<String,Integer>();
			cart.put(productName, 1);
			//���뵽session��
			session.setAttribute("cart", cart);
		}else {
			//������ǵ�һ�η������ж��ǹ�������Ʒ
			//�������
			if(cart.containsKey(productName)) {
				//��ȡ��Ʒ����
				Integer count = cart.get(productName);
				//����Ʒ������1
				count++;
				//���¹��ﳵ
				cart.put(productName, count);
				//�����ﳵ�ŵ�session��
				session.setAttribute("cart", cart);
			}else {//���������
				cart.put(productName, 1);
				session.setAttribute("cart", cart);
			}
		}
		//�����������ȥ����
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("������ѡ��  <a href='servlet/Cart.jsp'>��������</a>  ����   <a href='servlet/pay.jsp'>ȥ����</a>");
	}

}
