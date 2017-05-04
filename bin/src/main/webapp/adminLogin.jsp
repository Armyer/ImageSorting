<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/index.js"></script>
</head>
<body class="loginpage">
	<div class="loginbox">
		<div class="loginboxinner">

			<div class="logo">
				<h1 class="logo">
					ImageSorting<span>Admin</span>
				</h1>
				<span class="slogan">后台管理系统</span>
				<div>
					<c:if test="${requestScope.errors !=null }">
						<font color="red">${requestScope.errors }</font>
					</c:if>
				</div>

			</div>
			<br clear="all" /> <br />

			<div class="nousername">
				<div class="loginmsg">
					<font color="red">密码不正确</font>
				</div>
			</div>
			<div class="nopassword">
				<div class="loginmsg">密码不正确.</div>
				<div class="loginf">
					<div class="thumb">
						<img alt="" src="images/thumbs/avatar1.png" />
					</div>
				</div>
			</div>

			<form id="login"
				action="${pageContext.request.contextPath }/adminServlet"
				method="post">

				<div class="username">
					<div class="usernameinner">
						<input type="text" name="username" id="username" />
					</div>
				</div>

				<div class="password">
					<div class="passwordinner">
						<input type="password" name="password" id="password" />
					</div>
				</div>

				<button>登录</button>

				<div class="keep">
					<input type="checkbox" /> 记住密码
				</div>
			</form>

		</div>
	</div>


</body>
</html>
