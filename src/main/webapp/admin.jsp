<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<title>气体污染扩散模拟及其可视化_后台管理</title>
<link href="css/basic.css" rel="stylesheet" />
<link href="css/admin.css" rel="stylesheet" />
</head>
<body>
	<!-- 网页头部-->
	<div id="header">
		<div class="title">
			<i class="icon"></i>
		</div>
	</div>
	<div id="menu">
		<div class="content">
			<a><span id="welcome"></span>，<span class="username"></span>!
				现在是：<span id="time"></span> </a> [<a id="logout">退出</a>]
		</div>
	</div>
	<div id="container">
		<div id="left">
			<div>
				<div id="userManage" class="title selected">用户管理</div>
			</div>
			<div>
				<div id="config" class="title">数据配置</div>
				<div class="content">
					<div id="constant">常量配置</div>
					<div id="database">数据库配置</div>
					<div id="evaluation">评价标准配置</div>
				</div>
			</div>
			<div>
				<div id="history" class="title">历史查询</div>
				<div class="content">
					<div id="modalHistory">模型使用情况</div>
					<div id="queryData">历史数据查询</div>
				</div>
			</div>
		</div>
		<div id="center">
			<div id="innerContent"></div>
		</div>
		<div id="shad_h"></div>

	</div>

	<script src="js/jquery-1.8.3.min.js"></script>
	<script>
		if (typeof JSON == 'undefined') {
			$('head').append($("<script src='js/json2.js'>"));
		}
	</script>
	<script src="js/echarts.js"></script>
	<script src="js/base.js"></script>
	<script src="js/admin.js"></script>
</body>
</html>