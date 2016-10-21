package com.oracle.shop.product;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.oracle.shop.categorysecond.CategorySecond;

/**
 * @Title:Product
 * @Description:��Ʒʵ����
 * @author:Rainbow.huahang.com
 * @date:2016��10��16�� ����5:01:05
 */
@Component("product")
public class Product {
	// ��Ʒid
	private Integer pid;
	private String pname;// ��Ʒ����
	private String image;// ��ƷͼƬ
	private Double market_price;// ָ���۸�
	private Double shop_price;// �ۼ�
	private String pdesc;// ��Ʒ����
	private Integer is_hot;// 0 ��ʾ������ 1 ��ʾ����
	private Date pdate;// ��Ʒ����
	private Integer num;//���
	private CategorySecond categorySecond;// �����Ķ�������

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getShop_price() {
		return shop_price;
	}

	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Integer getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

}
