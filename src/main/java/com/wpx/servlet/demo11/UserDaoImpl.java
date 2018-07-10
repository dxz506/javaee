package com.wpx.servlet.demo11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * �û��ӿ�ʵ��
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class UserDaoImpl implements UserDao{

	private Connection connection = null;
	
	@Override
	public void login(User user) {
		try {
			connection= JdbcUtils.getConnection();
			String sql="SELECT username,PASSWORD FROM t_user WHERE username=? AND PASSWORD= ? ";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			ResultSet rs = prepareStatement.executeQuery();
			if(rs.next()) {
				System.out.println("��½�ɹ�");
			}else {
				System.out.println("��½ʧ��");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
