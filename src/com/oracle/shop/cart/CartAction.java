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
 * @Description:���ﳵaction
 * @author:Rainbow.huahang.com
 * @date:2016��10��17�� ����2:43:59
 */
@Scope("prototype")
@Controller(value = "CartAction")
public class CartAction extends ActionSupport {

	private static final long serialVersionUID = 9165427322371781332L;

	@Resource(name = "productService")
	private ProductService productService;
	// ������Ʒpid
	@SuppressWarnings("unused")
	private Integer pid;

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	// ������Ʒ����
	@SuppressWarnings("unused")
	private Integer quantity;

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * ��session �л�ȡ���ﳵ
	 */
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// �������ﳵ
			cart = new Cart();
			// �����ﳵ����Ž�session
			request.getSession().setAttribute("cart", cart);
		}
		return cart;

	}

	/**
	 * ��ӹ�������ﳵ
	 * 
	 * @return
	 */

	public String addCart() {
		// ��ѯ��Ʒ
		Product product = productService.findProductByPid(pid);
		// ����������
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setCount(quantity);
		// ��ȡ���ﳵ����
		Cart cart = getCart(request);
		// ����������ӵ����ﳵ
		cart.aadCartItem(cartItem);
		return "addCartSuccess";

	}

	/**
	 * ��չ��ﳵ
	 */
	public String clearCart() {
		Cart cart = getCart(request);
		cart.clearCartItem();
		return "clearCartSuccess";
	}

	/**
	 * �ӹ��ﳵ���Ƴ�
	 */
	public String romoveCart() {
		Cart cart = getCart(request);
		cart.removeCartItem(pid);
		return "removeCartSuccess";
	}

	/**
	 * �鿴���ﳵ
	 */
	public String lookCart() {
		return "lookCart";
	}

}
