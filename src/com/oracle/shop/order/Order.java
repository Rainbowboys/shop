package com.oracle.shop.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.oracle.shop.user.User;

/**
 * @Title:Order
 * @Description:����ʵ��
 * @author:Rainbow.huahang.com
 * @date:2016��10��17�� ����4:56:33
 */
public class Order {

	private Integer oid;// �������
	private Double total;// �ܽ��
	private Date ordertime;// ����ʱ��
	private Integer state;// ֧��״̬
	private String addr;// ���͵�ַ
	private String phone;// �û��ֻ���
	private String name;//�û���
	private User user;// �����û�
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();// ���������Ķ�����

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
