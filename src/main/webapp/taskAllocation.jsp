<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>控制台页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.slimscroll.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/dashboard.js"></script>
</head>
<body class="withvernav">
	<div class="topheader">
		<div class="left">
			<h1 align="center" class="logo">后台管理系统</h1>
			<br clear="all" />
		</div>
		<!--left-->
		<div class="right">
			<div class="userinfo">
				<img src="images/thumbs/avatar.png" alt="" /> <span>管理员</span>
			</div>
			<!--userinfo-->
			<div class="userinfodrop">
				<div class="avatar">
					<a href=""><img src="images/thumbs/avatarbig.png" /></a>
				</div>
				<!--avatar-->
				<div class="userdata">
					<h4>${sessionScope.admin.username }</h4>
					<br /> <span class="email">${sessionScope.admin.email }</span>
					<ul>
						<li><a href="${pageContext.request.contextPath }/editor.jsp">编辑资料</a></li>
						<li><a href="index.jsp">退出</a></li>
					</ul>
				</div>
				<!--userdata-->
			</div>
			<!--userinfodrop-->
		</div>
		<!--right-->
	</div>
	<!--topheader-->
	<div class="header">
		<ul class="headermenu">
			<li class="current"><a href="welcome.jsp"><span
					class="icon icon-flatscreen"></span>首页</a></li>
		</ul>
	</div>
	<!--左侧  -->
	<div class="vernav2 iconmenu">
		<ul>
			<li><a href="taskAllocation.jsp">任务分配系统</a></li>
			<li><a href="labelDecision.jsp">标签判定系统</a></li>
			<li><a href="pictureIndex.jsp">图片存储索引系统</a></li>
			<li><a class="more"
				href="${pageContext.request.contextPath }/adminServlet?method=user">查看更多用户</a></li>
			<li><a
				href="${pageContext.request.contextPath }/adminServlet?method=adminInfo">查看其他的管理员</a></li>
			<li><a href="#error" class="error">错误页面</a> <span class="arrow"></span>
				<ul id="error">
					<li><a href="error.jsp">错误页面</a></li>
				</ul></li>
		</ul>
	</div>
	<!--leftmenu-->
	<div class="centercontent">
		<div id="contentwrapper" class="contentwrapper">

			<div id="updates" class="subcontent">

				<div class="two_third dashboard_left">
					<ul class="shortcuts">
						<li><a
							href="${pageContext.request.contextPath }/adminServlet?method=user"
							class="users"><span>用户设置</span></a></li>
						<li><a href="pictureIndex.jsp" class="gallery"><span>图册信息</span></a></li>
						<li><a href="" class="analytics"><span>统计信息</span></a></li>
					</ul>

					<br clear="all" />

					<div class="contenttitle2 nomargintop">
						<h3>历史记录</h3>
					</div>
					<br clear="all" /> <br clear="all" /> <br clear="all" /> <br />

				</div>
				<!--two_third dashboard_left -->
			</div>
		</div>
	</div>
</body>
</html>
