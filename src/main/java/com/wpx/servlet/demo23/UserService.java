package com.wpx.servlet.demo23;
/**
 * �û�������
 * 
 * @author wangpx
 */
public class UserService {

	public User login(String username,String password) {
		if(username.equals("wangpx") && password.equals("123")) {
			User user=new User("wangpx", "123");
			return user;
		}
		return null;
	}
}
