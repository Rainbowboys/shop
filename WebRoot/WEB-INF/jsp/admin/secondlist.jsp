<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>商城后台系统</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->

<link
	href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/css/ui.jqgrid.css" />

<!-- fonts -->

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

<!-- ace styles -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/assets/css/ace-skins.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- ace settings handler -->
<script
	src="${pageContext.request.contextPath}/static/assets/js/ace-extra.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath}/static/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath}/static/assets/js/respond.min.js"></script>
		<![endif]-->
<script src="${pageContext.request.contextPath}/static/js/jquery.validate.js" type="text/javascript"></script>
	

</head>

<body>

	<jsp:include page="/public/top.jsp"></jsp:include>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<jsp:include page="/public/left.jsp"></jsp:include>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">Home</a>
						</li>
						<li><i class="active"></i> <a href="#">欢迎页面</a></li>
					</ul>
					<!-- .breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>

				<div class="page-content">

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->


							<div class="alert alert-info">
								<i class="icon-hand-right"></i> Please note that demo server is
								not configured to save the changes, therefore you may get an
								error message.
								<button class="close" data-dismiss="alert">
									<i class="icon-remove"></i>
								</button>
							</div>
							<table id="grid-table"></table>

							<div id="grid-pager"></div>

							<script type="text/javascript">
								var $path_base = "${pageContext.request.contextPath}/";//this will be used in gritter alerts containing images
							</script>

							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<jsp:include page="/public/container.jsp"></jsp:include>
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->


	<!-- <![endif]-->

	<!--[if IE]>
<![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script
		src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<script
		src="${pageContext.request.contextPath}/static/assets/js/date-time/bootstrap-datepicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/assets/js/jqGrid/i18n/grid.locale-en.js"></script>

	<!-- ace scripts -->

	<script
		src="${pageContext.request.contextPath}/static/assets/js/ace-elements.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/assets/js/ace.min.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/JqgridSecond.js"></script>

	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>
