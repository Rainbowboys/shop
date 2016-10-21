package com.oracle.shop.cart;

import com.oracle.shop.product.Product;

/**
 * @Title:CartItem
 * @Description:������ʵ��
 * @author:Rainbow.huahang.com
 * @date:2016��10��17�� ����2:08:02
 */
public class CartItem {
	// ������ʵ��
	private Product product;

	// С������
	private Integer count;
	// �ܽ���
	@SuppressWarnings("unused")
	private Double subtotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return count * product.getShop_price();
	}


}
