package com.wpx.struts2.demo07;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * �Զ��������������ڼ̳�MethodFilterInterceptor
 * ��Ϊ�˷�������ָ����Щ������������
 * 
 * @author wangpx 
 */
public class MyInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//��ȡ��¼������
		String name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		if(name==null || !name.equals("wangpx")) {
			BookAction action = (BookAction) invocation.getAction();
			action.addActionError(" û�е�¼���߸��û���Ȩ�޲���! ");
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
