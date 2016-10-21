package com.oracle.shop.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.oracle.shop.user.User;

/**
 * @Title:Order
 * @Description:订单实体
 * @author:Rainbow.huahang.com
 * @date:2016年10月17日 下午4:56:33
 */
public class Order {

	private Integer oid;// 订单编号
	private Double total;// 总金额
	private Date ordertime;// 创建时间
	private Integer state;// 支付状态
	private String addr;// 配送地址
	private String phone;// 用户手机号
	private String name;//用户名
	private User user;// 所属用户
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();// 订到包含的订单项

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
