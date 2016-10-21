package com.oracle.shop.order;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.shop.cart.Cart;
import com.oracle.shop.cart.CartItem;
import com.oracle.shop.user.User;
import com.oracle.shop.util.PaymentUtil;

@Scope("prototype")
@Controller("OrderAction")
public class OrderAction extends ActionSupport {

	private static final long serialVersionUID = -7659591521897196077L;
	@Resource(name = "orderServcieIMP")
	private OrderService orderService;

	private Order order;
	// ֧��ͨ������
	private String pd_FrpId;
	// ����֧���ɹ����ص�֧�����
	private String r3_Amt;
	// ����֧���ɹ����صĶ������
	private Integer r6_Order;

	private Integer oid;

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public void setR6_Order(Integer r6_Order) {
		this.r6_Order = r6_Order;
	}

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * ��֧��ǰȥ֧��
	 * 
	 * @return
	 */
	public String payPage() {
		order = orderService.findOrderByOid(oid);
		ActionContext.getContext().put("order", order);
		return "payPage";

	}

	public String saveOrder() {
		order = new Order();
		/**
		 * ��װ������Ϣ
		 */
		order.setOrdertime(new Date());
		order.setState(0);// 0 ��ʾ δ֧�� 1 ��ʾ֧��
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			ActionContext.getContext().put("cartMessage", "���ﳵΪ�� ���뷵����ҳ���й���");
			return "cartMessage";
		}
		// �ܽ��
		order.setTotal(cart.getTotal());
		// ��session ��ȡ�û�
		User userexist = (User) session.getAttribute("userbean");
		if (userexist == null) {
			// �û�δ��¼
			ActionContext.getContext().put("cartMessage", "����û�е�¼�����ȵ�¼");
			return "userMessage";
		}
		order.setUser(userexist);
		// �ӹ��ﳵ�л�ȡorderItem
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		// ���涩��
		Integer oid = orderService.saveOrder(order);
		order = orderService.findOrderByOid(oid);
		ActionContext.getContext().put("order", order);
		return "savaOrdersuccess";
	}

	/**
	 * ���ƶ����������֧��
	 * 
	 * @throws IOException
	 */

	public String payOrder() throws IOException {
		// ��ѯ����
		Order currentOrder = orderService.findOrderByOid(order.getOid());
		// �޸Ķ���
		currentOrder.setAddr(order.getUser().getAddr());
		currentOrder.setPhone(order.getUser().getPhone());
		currentOrder.setName(order.getUser().getName());
		// �����޸�
		orderService.updateOrder(currentOrder);
		// ֧������ �����������
		String p0_Cmd = "Buy";
		String p1_MerId = "10001126856";
		String p2_Order = order.getOid().toString();
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		String p8_Url = "http://172.17.18.246:8080/shop/order_callBack.action";
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		System.out.println(sb.toString());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect(sb.toString());
		return NONE;
	}

	/**
	 * 
	 * ����ɹ� �Ļص�����
	 */

	public String callBack() {
		Order currentOrder = orderService.findOrderByOid(r6_Order);
		// �޸�״̬״̬
		currentOrder.setState(1);
		orderService.updateOrder(currentOrder);
		ActionContext.getContext().put("payresult", "֧���ɹ���֧�����Ϊ��" + r3_Amt + "Ԫ");
		return "paySuccess";
	};

	/**
	 * ����id��ѯ��������
	 */
	public String findMyOrders() {
		User userexsit = (User) ServletActionContext.getRequest().getSession().getAttribute("userbean");
		List<Order> orders = null;
		if (userexsit != null) {
			orders = orderService.findOrderByUser(userexsit);
		} else {
			return "loginPage";
		}

		ActionContext.getContext().put("orders", orders);
		return "myorders";

	}

	/**
	 * �Ƴ�����
	 */
	public String removeOrder() {
		orderService.removeOrder(oid);
		return "deleteSuccess";

	}

}
