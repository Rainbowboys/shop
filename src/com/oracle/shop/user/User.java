package com.oracle.shop.user;

/**
 * @Title:User
 * @Description:�û�ģ���ʵ����
 * @author:Rainbow.huahang.com
 * @date:2016��10��15�� ����12:42:34
 */
public class User {
	private Integer uid;// �û�id
	private String username;// �û���(��¼��)
	private String password;// ����
	private String name;// ��ʵ����
	private String email;// ����
	private String phone;// �绰����
	private String addr;// ��ַ
	private String sex;// �Ա�
	private Integer status;// ����״̬
	private String code;//������

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
