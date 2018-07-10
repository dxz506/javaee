package com.wpx.jdbc.demo05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * ͨ��java�������ݿ�
 * 
 * �޸�
 * 
 * @author wangpx
 */
public class Demo04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Ҫ���������
		Emp emp = new Emp(6, "ename6", 234d, 3);
		try {
			delete(emp);
			System.out.println("ɾ���ɹ�");
		} catch (Exception e) {
			System.out.println("ɾ��ʧ��");
			e.printStackTrace();
		}
	}
	public static void delete(Emp emp) throws Exception {
				// ����mysql����
				Class.forName("com.mysql.jdbc.Driver");
				//����Ҫ���ӵ����ݿ�,�˺�,���� 
				String url="jdbc:mysql:///jdbc";
				String username="root";
				String password="root";
				//��ȡ���Ӷ���
				Connection connection = DriverManager.getConnection(url, username, password);
				//Ҫִ�е�sql���
				String sql="delete from emp where eid=?   ";
				//ͨ��con����ȡprepareStatement�ӿڷ�ֹsqlע��
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setInt(1, emp.getEid());
				prepareStatement.executeUpdate();
				//�ͷ���Դ
				prepareStatement.close();
				connection.close();
	}
}
