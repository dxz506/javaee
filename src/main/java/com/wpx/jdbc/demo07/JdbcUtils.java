package com.wpx.jdbc.demo07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
  	use jdbc;
  	
	CREATE TABLE account(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME CHAR(20),
	money INT
)
	INSERT INTO account VALUE(NULL,'aaa',1000);
	INSERT INTO account VALUES(NULL,'bbb',1000);

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

