package com.wpx.struts2.demo09;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * ��ֵջ��ֵ
 * 
 * @author wangpx
 */
public class OgnlAction02 extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//��ȡֵջ
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//Ϊֵջ��ֵ
		valueStack.set("name", "wangpx");
		//ѹջ
		valueStack.push("Hello ValueStack");
		return SUCCESS;
	}
}
