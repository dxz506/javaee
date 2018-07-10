package com.wpx.struts2.demo09;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * @author wangpx
 */
public class OgnlAction03 extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//����ѧ������
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "wangpx01"));
		studentList.add(new Student(2, "wangpx02"));
		studentList.add(new Student(3, "wangpx03"));
		//��ȡֵջ
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//push��ֵջ
		valueStack.push(studentList);
		//�����ݴ洢��ֵջ��
		valueStack.set("studentList", studentList);
	
		return SUCCESS;
	}
}
