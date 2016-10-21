<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<%@ include file="./header.jsp"%>
	<div class="container cart">

		<div class="span24">
			<div class="step step1">
				<ul>
					<li class="current"></li>
					<li>订单列表</li>
				</ul>
			</div>


			<table>
				<tbody>
					<c:forEach items="${orders}" var="order">
						<tr>
							<th colspan="2">订单编号：${order.oid }</th>
							<th >金额：${order.total}</th>
							<c:if  test="${ order.state==1}">
								<th colspan="2">状态：交易成功</th>
							</c:if>
							<c:if test="${ order.state==0}">
								<th colspan="2">状态：<a href="${pageContext.request.contextPath}/order_payPage.action?oid=${order.oid}">待支付</a></th>
							</c:if>
							<th><a href="${pageContext.request.contextPath}/order_removeOrder?oid=${order.oid}">删除订单</a></th>
						</tr>
						<tr>
							<th>图片</th>
							<th colspan="2">商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach var="orderItem" items="${order.orderItems }">
							<tr>
								<td width="60"><input type="hidden" name="id" value="22" />
									<img
									src="${pageContext.request.contextPath}/${orderItem.product.image }" />
								</td>
								<td colspan="2"><a target="_blank">${orderItem.product.pname }</a></td>
								<td>${orderItem.product.shop_price}</td>
								<td class="quantity" width="60"><input type="text"
									name="count" value="${orderItem.count }" disabled="disabled"
									onpaste="return false;" /></td>
								<td width="140"><span class="subtotal">￥${orderItem.subtotal }</span>
								</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="./image/r___________renleipic_01/footer.jpg" alt="我们的优势"
					title="我们的优势" height="52" width="950">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>SHOP++官网</a> |</li>
				<li><a>SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
		</div>
	</div>
</body>
</html>