package com.wpx.spring.demo07;

import org.springframework.stereotype.Repository;
/**
 * ��UserDaoװ���һ��bean
 * 
 * @author wangpx
 */
@Repository("userDao")
public class UserDao {
	
	public void say() {
		System.out.println("say hello...");
	}
	
}
