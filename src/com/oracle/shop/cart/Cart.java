package com.oracle.shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title:Cart
 * @Description:���ﳵʵ��
 * @author:Rainbow.huahang.com
 * @date:2016��10��17�� ����2:12:34
 */
public class Cart {
	// ���ﳵ�еĹ������
	private Map<Integer, CartItem> cartMap = new HashMap<Integer, CartItem>();

	private Collection cartItems;

	// ����Ʒ����ת�ɵ��м���
	public  Collection<CartItem> getCartItems() {
		return cartMap.values();

	}

	// �ܽ��
	private Double total = 0d;

	public Double getTotal() {
		return total;
	}

	/**
	 * ��װ����������ɲ���
	 */
	// ��ӹ�������ﳵ
	public void aadCartItem(CartItem cartItem) {
		// �жϹ��ﳵ�Ƿ����
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

	// �ӹ��ﳵ���Ƴ�
	public void removeCartItem(Integer pid) {
		// �жϹ��ﳵ�Ƿ��иù�����
		if (cartMap.containsKey(pid)) {
			CartItem cartItem = cartMap.remove(pid);
			total -= cartItem.getSubtotal();
		}

	}

	// ��չ��ﳵ
	public void clearCartItem() {
		// ���map����
		cartMap.clear();
		// �ܼ�����
		total = 0d;

	}

}
