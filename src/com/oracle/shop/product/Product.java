package com.oracle.shop.product;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.oracle.shop.categorysecond.CategorySecond;

/**
 * @Title:Product
 * @Description:商品实体类
 * @author:Rainbow.huahang.com
 * @date:2016年10月16日 下午5:01:05
 */
@Component("product")
public class Product {
	// 商品id
	private Integer pid;
	private String pname;// 商品名称
	private String image;// 商品图片
	private Double market_price;// 指导价格
	private Double shop_price;// 售价
	private String pdesc;// 商品详情
	private Integer is_hot;// 0 表示非热门 1 表示热门
	private Date pdate;// 商品日期
	private Integer num;//库存
	private CategorySecond categorySecond;// 所属的二级分类

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
