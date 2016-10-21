package com.oracle.shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title:Cart
 * @Description:购物车实体
 * @author:Rainbow.huahang.com
 * @date:2016年10月17日 下午2:12:34
 */
public class Cart {
	// 购物车中的购物项集合
	private Map<Integer, CartItem> cartMap = new HashMap<Integer, CartItem>();

	private Collection cartItems;

	// 将商品集合转成单列集合
	public  Collection<CartItem> getCartItems() {
		return cartMap.values();

	}

	// 总金额
	private Double total = 0d;

	public Double getTotal() {
		return total;
	}

	/**
	 * 封装三个方法完成操作
	 */
	// 添加购物项到购物车
	public void aadCartItem(CartItem cartItem) {
		// 判断购物车是否存在
		Integer pid = cartItem.getProduct().getPid();
		if (cartMap.containsKey(pid)) {
			CartItem _cartItem = cartMap.get(pid);
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());

		} else {
			cartMap.put(pid, cartItem);
		}
		;
		total += cartItem.getSubtotal();
	}

	// 从购物车中移除
	public void removeCartItem(Integer pid) {
		// 判断购物车是否有该购物项
		if (cartMap.containsKey(pid)) {
			CartItem cartItem = cartMap.remove(pid);
			total -= cartItem.getSubtotal();
		}

	}

	// 清空购物车
	public void clearCartItem() {
		// 清空map集合
		cartMap.clear();
		// 总计清零
		total = 0d;

	}

}
