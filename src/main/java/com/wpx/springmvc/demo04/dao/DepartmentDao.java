package com.wpx.springmvc.demo04.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wpx.springmvc.demo04.vo.Department;

/**
 * ���Žӿ���
 * 
 * @author wangpx
 */
@Repository
public class DepartmentDao {

	private static Map<Integer,Department> departments = null;
	
	/**
	 * ��ʼ������
	 */
	static {
	
		departments = new HashMap<Integer,Department>();
	
		departments.put(01, new Department(1, "Name-01"));
		departments.put(02, new Department(2, "Name-02"));
		departments.put(03, new Department(3, "Name-03"));
		departments.put(04, new Department(4, "Name-04"));		
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartmentById(Integer id) {
		return departments.get(id);
	}
}
