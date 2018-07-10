package com.wpx.struts2.demo04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * �Զ���ĵ�����ת����
 * 
 * 
 * ����һ����ʵ��TypeConverter�ӿ�.
 * 
	1.ʵ��TypeConverter��Ҫ��д
		public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName, Object value, Class toType);
		���ʵ�ֽӿڣ������������̫��(6��)
		
	2.���Ƽ�ʵ�ֽӿڣ����Լ̳� DefaultTypeConverter��
		�ŵ�:��д�ķ�������û����ô��
		 public Object convertValue(Map<String, Object> context, Object value, Class toType) {
				return convertValue(value, toType);
		}

	3. �̳�DefaultTypeConverter���һ������StrutsTypeConverter.
		ԭ��:��������н���ҳ�洫�ݵ�����������װ���Լ�action�е�����������ҳ������ʾ���˷���.
		
		  public abstract Object convertFromString(Map context, String[] values, Class toClass);
		  public abstract String convertToString(Map context, Object o);
		
 * 
 * ע��һ���Զ�������ת����.
				
				1.�ֲ�--�����action
					 �����ļ�����λ���Լ�����:  ��Action�����ڰ� ���� Action����-conversion.properties , 
					 �����ļ���д:    ��ʽ �� ��������=����ת������ȫ���� 
				2.�ֲ�--�����model
					 �����ļ�����λ���Լ�����:  ��model�����ڰ� ���� model����-conversion.properties , 
					 �����ļ���д:    ��ʽ �� ��������=����ת������ȫ���� 
				3.ȫ��
					�����ļ�����λ���Լ�����:��src�´���һ��xwork-conversion.properties
					�����ļ���д:  ��ʽ:  Ҫת��������ȫ��=����ת������ȫ���� 
 * 
 * 
 * @author wangpx
 */
public class MyTypeConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String value = values[0];
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

	@Override
	public String convertToString(Map context, Object o) {
		 
		return null;
	}

}
