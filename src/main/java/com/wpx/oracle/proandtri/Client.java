package com.wpx.oracle.proandtri;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Test;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
/**
 * java����Oracle��procedure
 * 
 * @author wangpx
 */
public class Client {
	/**
	 *  create or replace procedure query_emp_infomation_procedure(
                                                            eno in number,
                                                            pname out varchar2,
                                                            psal out number,
                                                            pjob out varchar2)
		is
		begin
		  select ename,sal,job into pname,psal,pjob from emp where empno = eno;
		end query_emp_infomation_procedure;
	 */
	@Test
	public void testProcedure() {
		String sql = "{ call query_emp_infomation_procedure(?,?,?,?)}";
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = JdbcUtils.getConnection();
			call = conn.prepareCall(sql);
			//��in������ֵ
			call.setInt(1, 7839);
			//��out��������
			call.registerOutParameter(2,OracleTypes.VARCHAR);
			call.registerOutParameter(3, OracleTypes.NUMBER);
			call.registerOutParameter(4, OracleTypes.VARCHAR);
			//ִ��
			call.execute();
			//���
			String name=call.getString(2);
			double sal=call.getDouble(3);
			String job=call.getString(4);
			System.out.println(name+"\t"+sal+"\t"+job);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, call, null);
		}
	}
	/**
	 * create or replace function queryEmpInCome(eno in number)
	   return number
	 */
	@Test
	public void testFucntion() {
		String sql="{?= call queryEmpInCome(?) }";
		Connection conn=null;
		CallableStatement call=null;
		try {
			conn = JdbcUtils.getConnection();
			call = conn.prepareCall(sql);
			//��ֵ
			call.registerOutParameter(1, OracleTypes.NUMBER);
			call.setInt(2,7839);
			//ִ��
			call.execute();
			//ȡֵ
			double income = call.getDouble(1);
			System.out.println(income);
			
		} catch (Exception e) {
			
		}finally {
			JdbcUtils.release(conn, call, null);
		}
	}
	/**
	 *create or replace package mypackage is

       type empcursor is ref cursor;
       procedure queryEmpList(dno in number,empList out empcursor);

	  end mypackage; 
	 */
	@Test
	public void testPackage() {
		String sql="{call mypackage.QUERYEMPLIST(?,?)}";
		CallableStatement call=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn = JdbcUtils.getConnection();
			call = conn.prepareCall(sql);
			//������ֵ
			call.setInt(1, 20);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//ִ��
			call.execute();
			//ȡֵ
			rs = ((OracleCallableStatement)call).getCursor(2);
			while(rs.next()) {
				//ȡ��һ��Ա��
				String name = rs.getString("ename");
				double sal = rs.getDouble("sal");
				System.out.println(name+":\t"+sal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, call, rs);
		}
		
	}
}
