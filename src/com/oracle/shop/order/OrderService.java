package com.oracle.shop.order;

import java.util.List;

import com.oracle.shop.user.User;

public interface OrderService {

	public Integer saveOrder(Order order);

	public Order findOrderByOid(Integer oid);

	/**
	 * ÐÞ¸Ä¶©µ¥
	 * @param currentOrder
	 */
	public void updateOrder(Order currentOrder);

	public List<Order> findOrderByUser(User userexsit);

	public void removeOrder(Integer oid);

}
