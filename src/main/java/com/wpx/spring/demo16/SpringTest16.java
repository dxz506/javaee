package com.wpx.spring.demo16;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext16.xml")
public class SpringTest16 {
	
	@Test
	public void demo01() {
		// �������ӳ�:
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//��������Դ
		dataSource.setUrl("jdbc:mysql:///spring_demo16");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//�½�jdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("create table user (id int primary key auto_increment,name varchar(20))");
	}
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Test
	public void demo02() {
		jdbcTemplate.execute("INSERT INTO USER VALUES(NULL,\"wpx\");");
	}
	
}
