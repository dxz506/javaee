package com.wpx.struts2.demo06;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ���ʻ�
 * 
 * @author wangpx
 */
public class ActionI18n extends ActionSupport{
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//��̬�ı�
		System.out.println(this.getText("message", new String[] {"Tom","jack"}));
		return SUCCESS;
	}

}
