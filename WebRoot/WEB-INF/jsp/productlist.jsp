<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>蔬菜 - Powered By Mango Team</title>
		<meta name="author" content="Mango Team">
		<meta name="copyright" content="Mango">
		<meta name="keywords" content="蔬菜">
		<meta name="description" content="蔬菜">
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@ include file="./header.jsp" %>
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
			 <c:forEach  var="categroy" items="${catagorylists}" >
			            <dl>
							<dt>
								<a href="${pageContext.request.contextPath }/product_findProductBycid.action?cid=${categroy.cid }&page=1">${categroy.cname}</a>
							</dt>
							<c:forEach items="${categroy.categorySecond}" var="categorySecond">
							          <dd>
										<a  href="${pageContext.request.contextPath }/product_findProductBycsid.action?csid=${categorySecond.csid }&page=1" >${categorySecond.csname}</a>
									</dd>
							
							</c:forEach>
						</dl>
			 </c:forEach>
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="./image/蔬菜 - Powered By Mango Team.htm" method="get">
				<input type="hidden" id="brandId" name="brandId" value="">
				<input type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">
				<!-- 商品显示 -->	
				<div id="result" class="result table clearfix">
						<ul>
						 <c:forEach var="product" items="${pagebean.list}">
						 
						    <li>
										<a href="${pageContext.request.contextPath}/product_findProductByPid?pid=${product.pid}">
											<img src="${pageContext.request.contextPath}/${product.image}" width="170" height="170"  style="display: inline-block;">
											   
											<span style='color:green'>
											${product.pname}
											</span>
											<span class="price">
												优惠价： ￥${product.shop_price }/份
											</span>
											 
										</a>
									</li>
						   </c:forEach> 
						</ul>
				</div>
	<div class="pagination">
			第${pagebean.current_page}/${pagebean.totalPage}页
			<c:if test="${pagebean.totalPage!=1}">
			  	<a href="${ pageContext.request.contextPath }/product_findProductBycid.action?cid=${catagorylists[0].cid }&page=1" class="firstPage">&nbsp;</a>		
				<a href="${ pageContext.request.contextPath }/product_findProductBycid.action?cid=${catagorylists[0].cid }&page=${pagebean.current_page-1}" class="previousPage">&nbsp;</a>
			</c:if>
			<c:forEach var="i" begin="1" end="${pagebean.totalPage}" step="1">
			   <c:if test="${pagebean.current_page==i}">
			      <span class="currentPage">${i}</span>
			   </c:if>
			   <c:if test="${pagebean.current_page!=i}">
			     <a href="${ pageContext.request.contextPath }/product_findProductBycid.action?cid=${catagorylists[0].cid }&page=${i}">${i }</a>
			   </c:if>
			</c:forEach>
			<c:if test="${pagebean.totalPage!=pagebean.current_page }">
				<a class="nextPage" href="${ pageContext.request.contextPath }/product_findProductBycid.action?cid=${catagorylists[0].cid }&page=${pagebean.current_page+1}">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/product_findProductBycid.action?cid=${catagorylists[0].cid }&page=${pagebean.current_page+1}">&nbsp;</a>
			</c:if>
	</div>
			</form>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="./image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
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
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a >SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
	</div>
</div>
</body></html>