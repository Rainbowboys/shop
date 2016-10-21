package com.oracle.shop.order;

import com.oracle.shop.product.Product;

/**
 * @Title:OrderItem
 * @Description:������Ŀ �м��
 * @author:Rainbow.huahang.com
 * @date:2016��10��17�� ����5:28:08
 */

// CREATE TABLE `orderitem` (
// `itemid` int(11) NOT NULL AUTO_INCREMENT,
// `count` int(11) DEFAULT NULL,
// `subtotal` double DEFAULT NULL,
// `pid` int(11) DEFAULT NULL,
// `oid` int(11) DEFAULT NULL,
// PRIMARY KEY (`itemid`),
// KEY `FKE8B2AB6166C01961` (`oid`),
// KEY `FKE8B2AB6171DB7AE4` (`pid`),
// CONSTRAINT `FKE8B2AB6166C01961` FOREIGN KEY (`oid`) REFERENCES `orders`
// (`oid`),
// CONSTRAINT `FKE8B2AB6171DB7AE4` FOREIGN KEY (`pid`) REFERENCES `product`
// (`pid`)
// ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

public class OrderItem {
	// ��������
	private Integer itemid;
	// �ܼƵ㵥����
	private Integer count;
	// С��
	private Double subtotal;
	// ��������Ʒ
	private Product product;
	// ��������
	private Order order;

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
