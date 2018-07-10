package com.wpx.servlet.demo21;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * �ͻ�������
 * 
 * @author wangpx
 */
public class CustomerService {

	private CustomerDao customerDao=new CustomerDao();

	//��ѯ�ܼ�¼��
	public int getCustomerCount() throws SQLException {
		 Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDao.findAllCount(connection);
	}
	
	//����û�
	public void addCustomer(Customer customer) throws SQLException {
		 Connection connection = null;
			try {
				connection = JdbcUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		customerDao.add(connection, customer);
	}
	
	//��ҳ��ѯ�ͻ���Ϣ
	public PageBean findCustomerByPage(int pageNum,int currentPage) throws SQLException, ParseException{
		 Connection connection = null;
			try {
				connection = JdbcUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		//��ѯ�ܼ�¼��
		 int count = customerDao.findAllCount(connection);
		 //��ѯ��ǰҳ��
		List<Customer> customerList=customerDao.findAll(connection, pageNum, currentPage);
		 //��ѯ��ҳ��
		int totalPage = (int) Math.ceil(count*1.0 / pageNum);
		PageBean pageBean=new PageBean();
		pageBean.setCsList(customerList);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(count);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
}
