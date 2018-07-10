package com.wpx.servlet.demo11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * @author wangpx
 */
public class JdbcUtils {
	
	/**
	 * �������ݿ�
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		// ����mysql����
		Class.forName("com.mysql.jdbc.Driver");
		//����Ҫ���ӵ����ݿ�,�˺�,���� 
		String url="jdbc:mysql:///jdbc";
		String username="root";
		String password="root";
		//��ȡ���Ӷ���
		Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
	}
	/**
	 * �ر�����
	 * @param con
	 * @throws SQLException
	 */
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}

