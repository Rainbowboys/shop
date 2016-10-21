package com.oracle.shop.cart;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.shop.product.Product;
import com.oracle.shop.product.ProductService;

/**
 * @Title:CartAction
 * @Description:购物车action
 * @author:Rainbow.huahang.com
 * @date:2016年10月17日 下午2:43:59
 */
@Scope("prototype")
@Controller(value = "CartAction")
public class CartAction extends ActionSupport {

	private static final long serialVersionUID = 9165427322371781332L;

	@Resource(name = "productService")
	private ProductService productService;
	// 接收商品pid
	@SuppressWarnings("unused")
	private Integer pid;

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	// 接收商品数量
	@SuppressWarnings("unused")
	private Integer quantity;

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 从session 中获取购物车
	 */
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 创建购物车
			cart = new Cart();
			// 将购物车对象放进session
			request.getSession().setAttribute("cart", cart);
		}
		return cart;

	}

	/**
	 * 添加购物项到购物车
	 * 
	 * @return
	 */

	public String addCart() {
		// 查询商品
		Product product = productService.findProductByPid(pid);
		// 创建购物项
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setCount(quantity);
		// 获取购物车对象
		Cart cart = getCart(request);
		// 将购物项添加到购物车
		cart.aadCartItem(cartItem);
		return "addCartSuccess";

	}

	/**
	 * 清空购物车
	 */
	public String clearCart() {
		Cart cart = getCart(request);
		cart.clearCartItem();
		return "clearCartSuccess";
	}

	/**
	 * 从购物车中移除
	 */
	public String romoveCart() {
		Cart cart = getCart(request);
		cart.removeCartItem(pid);
		return "removeCartSuccess";
	}

	/**
	 * 查看购物车
	 */
	public String lookCart() {
		return "lookCart";
	}

}
