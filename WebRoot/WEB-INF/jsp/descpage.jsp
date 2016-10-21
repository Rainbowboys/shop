<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>商城${productdesc.pname}</title>
	<meta name="author" content="Mango Team">
	<meta name="copyright" content="Mango">
	<meta name="keywords" content="京华亿家--大冬瓜">
	<meta name="description" content="京华亿家--大冬瓜">
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">

</head>
<body>

<%@ include file="./header.jsp" %>
<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
					 <c:forEach  var="categroy" items="${catagorylists}" >
			            <dl>
							<dt>
								<a href="${pageContext.request.contextPath }/product_findProductBycid.action?cid=${categroy.cid }&page=1">${categroy.cname}</a>
							</dt>
							<c:forEach items="${categroy.categorySecond}" var="categorySecond">
							          <dd>
										<a href="${pageContext.request.contextPath }/product_findProductBycsid.action?csid=${categorySecond.csid }&page=1" >${categorySecond.csname}</a>
									</dd>
							
							</c:forEach>
						</dl>
			 </c:forEach>
			</div>
			

		</div>
		<div class="span18 last">
			<form action="${pageContext.request.contextPath }/cart_addCart.action" method="post">
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="${pageContext.request.contextPath }/${productdesc.image }" rel="gallery">
						<div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${pageContext.request.contextPath }/${productdesc.image }"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow"><div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<div class="name">${productdesc.pname }</div>
			<div class="sn">
				<div>编号：${productdesc.pid }<input type="text"  hidden="hidden" name="pid" value="${productdesc.pid }"></div>
			</div>
			<div class="info">
				<dl>
					<dt>优惠价:</dt>
					<dd>
						<strong>￥：${productdesc.shop_price }元/份</strong>
							参 考 价：
							<del>￥${productdesc.market_price }元/份</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
				<div class="action">
					
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
								<input id="quantity" name="quantity" value="1" maxlength="4" onpaste="return false;" type="text">
								<div>
									<span id="increase" class="increase">&nbsp;</span>
									<span id="decrease" class="decrease">&nbsp;</span>
								</div>
							</dd>
							<dd>
								件
							</dd>
						</dl>
					<div class="buy">
							<input id="addCart" class="addCart" value="加入购物车" type="submit">
				
					</div>
				</div>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">商品介绍</a>
						</li>
						
				</ul>
			</div>
				
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>商品介绍</strong>
					</div>
					<div>
					  <p>${productdesc.pdesc }</p>  
					</div>
				</div>
			</form>	
				
				
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
	</div>
</div>
</body>
</html>