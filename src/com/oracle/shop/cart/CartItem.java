package com.oracle.shop.cart;

import com.oracle.shop.product.Product;

/**
 * @Title:CartItem
 * @Description:购物项实体
 * @author:Rainbow.huahang.com
 * @date:2016年10月17日 下午2:08:02
 */
public class CartItem {
	// 购物项实体
	private Product product;

	// 小计数量
	private Integer count;
	// 总结金额
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
