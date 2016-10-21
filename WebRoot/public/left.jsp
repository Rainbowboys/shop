<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>top</title>

</head>

<body>
	<div class="sidebar" id="sidebar">
		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
				<button class="btn btn-success">
					<i class="icon-signal"></i>
				</button>

				<button class="btn btn-info">
					<i class="icon-pencil"></i>
				</button>

				<button class="btn btn-warning">
					<i class="icon-group"></i>
				</button>

				<button class="btn btn-danger">
					<i class="icon-cogs"></i>
				</button>
			</div>

			<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
				<span class="btn btn-success"></span> <span class="btn btn-info"></span>

				<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
			</div>
		</div>
		<!-- #sidebar-shortcuts -->

		<ul class="nav nav-list">
			<li><a href="#" class="dropdown-toggle"> <i
					class="icon-desktop"></i> <span class="menu-text"> 用户管理 </span> <b
					class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">
					<li><a href="elements.html"> <i
							class="icon-double-angle-right"></i> 学籍异动申请
					</a></li>

					<li><a href="buttons.html"> <i
							class="icon-double-angle-right"></i> 辅修报名
					</a></li>

					<li><a href="treeview.html"> <i
							class="icon-double-angle-right"></i> 重修报名
					</a></li>

					<li><a href="jquery-ui.html"> <i
							class="icon-double-angle-right"></i> 学生转专业申请
					</a></li>

					<li><a href="nestable-list.html"> <i
							class="icon-double-angle-right"></i> 考试项目报名
					</a></li>
					<li><a href="nestable-list.html"> <i
							class="icon-double-angle-right"></i> 教学项目报名
					</a></li>
				</ul></li>

			<li><a href="#" class="dropdown-toggle"> <i
					class="icon-list"></i> <span class="menu-text"> 商品管理</span> <b
					class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">
					<li><a href="tables.html"> <i
							class="icon-double-angle-right"></i> 学生个人信息维护
					</a></li>

					<li><a href="jqgrid.html"> <i
							class="icon-double-angle-right"></i> 个人培养方案
					</a></li>
				</ul></li>

			<li><a href="#" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> 订单管理 </span> <b
					class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">
					<li><a href="form-elements.html"> <i
							class="icon-double-angle-right"></i> 学生课表查询
					</a></li>

					<li><a href="form-wizard.html"> <i
							class="icon-double-angle-right"></i> 自组选课
					</a></li>

					<li><a href="wysiwyg.html"> <i
							class="icon-double-angle-right"></i> 考试情况查询
					</a></li>
				</ul></li>
			<li><a href="#" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> 一级分类管理 </span> <b
					class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">
					<li><a href="${pageContext.request.contextPath}/category_findCategoryPage.action"> <i
							class="icon-double-angle-right"></i> 二级分类管理
					</a></li>

					<li><a href="form-wizard.html"> <i
							class="icon-double-angle-right"></i> 学籍预警查询
					</a></li>

					<li><a href="wysiwyg.html"> <i
							class="icon-double-angle-right"></i> 班级课表查询
					</a></li>
					<li><a href="wysiwyg.html"> <i
							class="icon-double-angle-right"></i> 学生课表查询
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/static/student/findSort.jsp"
						target="mainAction"> <i class="icon-double-angle-right"></i>
							学生成绩查询
					</a></li>
					<li><a href="wysiwyg.html"> <i
							class="icon-double-angle-right"></i> 考试信息查询
					</a></li>
					<li><a href="wysiwyg.html"> <i
							class="icon-double-angle-right"></i> 考试情况查询
					</a></li>
				</ul></li>
			<li><a href="#" class="dropdown-toggle"> <i class="icon-tag"></i>
					<span class="menu-text"> 二级分类管理 </span> <b
					class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">
					<li><a href="${pageContext.request.contextPath}/categorysecond_categorySecondPage.action"> <i
							class="icon-double-angle-right"></i> 二级信息管理
					</a></li>

					<li><a href="inbox.html"> <i
							class="icon-double-angle-right"></i> 收件箱
					</a></li>

					<li><a href="pricing.html"> <i
							class="icon-double-angle-right"></i> 售价单
					</a></li>

					<li><a href="invoice.html"> <i
							class="icon-double-angle-right"></i> 购物车
					</a></li>

					<li><a href="timeline.html"> <i
							class="icon-double-angle-right"></i> 时间轴
					</a></li>

					<li><a href="login.html"> <i
							class="icon-double-angle-right"></i> 登录 &amp; 注册
					</a></li>
				</ul></li>

			<li class="active open"><a href="#" class="dropdown-toggle">
					<i class="icon-file-alt"></i> <span class="menu-text"> 其他页面
						<span class="badge badge-primary ">5</span>
				</span> <b class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">
					<li><a href="faq.html"> <i class="icon-double-angle-right"></i>
							帮助
					</a></li>

					<li><a href="error-404.html"> <i
							class="icon-double-angle-right"></i> 404错误页面
					</a></li>

					<li><a href="error-500.html"> <i
							class="icon-double-angle-right"></i> 500错误页面
					</a></li>

					<li><a href="grid.html"> <i
							class="icon-double-angle-right"></i> 网格
					</a></li>

					<li class="active"><a href="blank.html"> <i
							class="icon-double-angle-right"></i> 空白页面
					</a></li>
				</ul></li>
		</ul>
		<!-- /.nav-list -->

		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
				data-icon2="icon-double-angle-right"></i>
		</div>

		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'collapsed')
			} catch (e) {
			}
		</script>
	</div>
</body>
</html>
