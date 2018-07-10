package com.wpx.servlet.demo22;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ListenerSessionAttribute  implements  HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// se.getSession(); ��ȡ�¼�Դ��Ҳ���ǻ�ȡsession����.
		System.out.println(se.getName());
		System.out.println(se.getValue());
		System.out.println("��session���������");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("��session���Ƴ�����");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("��session�е������޸�");
	}

}
