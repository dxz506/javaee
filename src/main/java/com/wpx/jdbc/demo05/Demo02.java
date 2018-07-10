package com.wpx.jdbc.demo05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * ͨ��java�������ݿ�
 * 
 * ����
 * 
 * @author wangpx
 */
public class Demo02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Ҫ���������
		Emp emp = new Emp(6, "ename5", 234d, 3);
		try {
			add(emp);
			System.out.println("��ӳɹ�");
		} catch (Exception e) {
			System.out.println("���ʧ��");
			e.printStackTrace();
		}
	}
	public static void add(Emp emp) throws Exception {
		// ����mysql����
				Class.forName("com.mysql.jdbc.Driver");
				//����Ҫ���ӵ����ݿ�,�˺�,���� 
				String url="jdbc:mysql:///jdbc";
				String username="root";
				String password="root";
				//��ȡ���Ӷ���
				Connection connection = DriverManager.getConnection(url, username, password);
				//Ҫִ�е�sql���
				String sql="insert into emp values(?,?,?,?)";
				//ͨ��con����ȡprepareStatement�ӿڷ�ֹsqlע��
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setInt(1, emp.getEid());
				prepareStatement.setString(2, emp.getEname());
				prepareStatement.setDouble(3, emp.getSalary());
				prepareStatement.setInt(4, emp.getDno());
				prepareStatement.executeUpdate();
				//�ͷ���Դ
				prepareStatement.close();
				connection.close();
	}
}
