package com.wpx.servlet.demo21;

import java.util.Date;

/**
 * �ͻ���
 * 
 * @author wangpx
 */
public class Customer {

	private String id;		//���
	private String name;  	//�ͻ�����
	private String gender;  //�Ա�
	private Date birthday;  //����
	
	private String cellphone;  //�ֻ�
	private String email;	//����
	private String preference; //�ͻ�����
	private String type;	 //�ͻ�����
	
	private String description; //��ע
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer() {
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", cellphone=" + cellphone + ", email=" + email + ", preference=" + preference + ", type=" + type
				+ ", description=" + description + "]";
	}
	
}
