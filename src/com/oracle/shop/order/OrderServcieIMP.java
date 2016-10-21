package com.oracle.shop.order;

import java.util.List;

import javax.annotation.Resource;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.shop.user.User;

@Service("orderServcieIMP")
@Transactional
public class OrderServcieIMP implements OrderService {
	@Resource(name = "orderDaoIMP")
	private OrderDao orderdao;

	@Override
	public Integer saveOrder(Order order) {
		Integer oid = orderdao.saveOrder(order);
		return oid;
		
	}

	@Override
	public Order findOrderByOid(Integer oid) {
		return orderdao.findOrderByOid(oid);
	}

	@Override
	public void updateOrder(Order currentOrder) {
		orderdao.updateOrder(currentOrder);
		
	}

	@Override
	public List<Order> findOrderByUser(User userexsit) {
		return	orderdao.findOrderByUser(userexsit);
	}

	@Override
	public void removeOrder(Integer oid) {
		orderdao.removeOrder(oid);
		
	}

}
