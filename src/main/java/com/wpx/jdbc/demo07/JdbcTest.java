package com.wpx.jdbc.demo07;
/**
 * ������
 * 
 * @author wangpx
 */
public class JdbcTest {

	
	
	public static void main(String[] args) {
	
		AccountService accountService=new AccountServiceImpl();
		accountService.transfer("aaa", "bbb", 100);
	
	}
}
