package com.wpx.struts2.demo09;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class OgnlAction01 extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//��ȡֵջ
		//ͨ��request
		ValueStack valueStack = (ValueStack) ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		System.out.println(valueStack);
		//ͨ��ActionContext
		ValueStack vs = ActionContext.getContext().getValueStack();
		System.out.println(vs);
		return SUCCESS;
	}
}
