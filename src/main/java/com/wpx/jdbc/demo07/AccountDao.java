package com.wpx.jdbc.demo07;

import java.sql.Connection;

/**
 * ����ת�˵Ľӿ�
 * @author wangpx
 */
public interface AccountDao {
	/**
	 * 
	 * @param to
	 * @param money
	 */
	void in(Connection con,String to,int money);
	/**
	 * 
	 * @param from 
	 * @param money
	 */
	void out(Connection con,String from,int money);
}
