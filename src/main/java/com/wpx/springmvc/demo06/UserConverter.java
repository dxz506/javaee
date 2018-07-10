package com.wpx.springmvc.demo06;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.wpx.springmvc.User;

/**
 *  �Զ�������ת����
 * 	ͨ��ʵ��Converter�ӿ�
 * 	��String���ַ�������Ϊ User����
 * 
 * @author wangpx
 */
@Component
public class UserConverter implements Converter<String, User>{

	@SuppressWarnings("null")
	@Override
	public User convert(String source) {
		if(source == null && source.trim().length()<=0) {
			return null;
		}
		String[] us = source.split("-");
		if(us.length == 3) {
			User user =new User(Integer.valueOf(us[0]),us[1],Integer.valueOf(us[2]));
			return user;
		}
		return null;
	}

}
