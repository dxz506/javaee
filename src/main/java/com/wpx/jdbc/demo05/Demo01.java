package com.wpx.jdbc.demo05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * ͨ��java�������ݿ�
 * 
 * ��ѯ
 * 
 * @author wangpx
 */
public class Demo01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����mysql����
		Class.forName("com.mysql.jdbc.Driver");
		//����Ҫ���ӵ����ݿ�,�˺�,���� 
		String url="jdbc:mysql:///jdbc";
		String username="root";
		String password="root";
		//��ȡ���Ӷ���
		Connection connection = DriverManager.getConnection(url, username, password);
		//ͨ�����Ӷ����ȡ����sql���Statement
		Statement statement = connection.createStatement();
		//Ҫִ�е�sql���
		String sql="select * from emp";
		//��sql���в���
		ResultSet resultSet = statement.executeQuery(sql);
		//��������
		ArrayList<Emp> empList = new ArrayList<Emp>();
		//���������
		while(resultSet.next()) { //�ж��Ƿ�����һ��Ԫ��
			Emp e=new Emp();//����empʵ��,���ڽ��ܱ������Ľ����
			e.setEid(resultSet.getInt("eid"));
			e.setEname(resultSet.getString("ename"));
			e.setSalary(resultSet.getDouble("salary"));
			e.setDno(resultSet.getInt("dno"));
			empList.add(e);
		}
		//��ӡ����
		empList.forEach(System.out::println);
		//�ͷ���Դ
		resultSet.close();
		statement.close();
		connection.close();
	}
}
