package com.wpx.servlet.demo21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * �����ڸ�ʽ��Ϊ�ַ���
	 * 
	 * @param Ҫת��������
	 * @return 
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date);
		return format;
	}
	/**
	 * ���ַ���ת��Ϊ����
	 * @param Ҫת�����ַ���
	 * @return
	 * @throws ParseException 
	 */
	public static Date formatString(String str) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.parse(str);
	}
}
