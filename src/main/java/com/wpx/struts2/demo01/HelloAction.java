package com.wpx.struts2.demo01;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * struts2��Ĭ��ִ�з���Ϊexecute����
 * 
 * ͨ���̳�ActionSupport ��Ϊһ��
 * 
 * @author wangpx
 */
public class HelloAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	
}
