package com.oracle.shop.order;

import java.util.List;

import com.oracle.shop.user.User;

public interface OrderDao {

	public Integer saveOrder(Order order);

	public Order findOrderByOid(Integer oid);

	public void updateOrder(Order currentOrder);

	public List<Order> findOrderByUser(User userexsit);

	public void removeOrder(Integer oid);

}
