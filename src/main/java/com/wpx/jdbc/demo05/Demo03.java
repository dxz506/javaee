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
public class Demo03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Ҫ���������
		Emp emp = new Emp(6, "ename6", 234d, 3);
		try {
			update(emp);
			System.out.println("�޸ĳɹ�");
		} catch (Exception e) {
			System.out.println("�޸�ʧ��");
			e.printStackTrace();
		}
	}
	public static void update(Emp emp) throws Exception {
		// ����mysql����
				Class.forName("com.mysql.jdbc.Driver");
				//����Ҫ���ӵ����ݿ�,�˺�,���� 
				String url="jdbc:mysql:///jdbc";
				String username="root";
				String password="root";
				//��ȡ���Ӷ���
				Connection connection = DriverManager.getConnection(url, username, password);
				//Ҫִ�е�sql���
				String sql="update emp set ename = ?,salary = ?,dno=?  where eid=?   ";
				//ͨ��con����ȡprepareStatement�ӿڷ�ֹsqlע��
				PreparedStatement prepareStatement = connection.prepareStatement(sql);

				prepareStatement.setString(1, emp.getEname());
				prepareStatement.setDouble(2, emp.getSalary());
				prepareStatement.setInt(3, emp.getDno());
				prepareStatement.setInt(4, emp.getEid());
				prepareStatement.executeUpdate();
				//�ͷ���Դ
				prepareStatement.close();
				connection.close();
	}
}
