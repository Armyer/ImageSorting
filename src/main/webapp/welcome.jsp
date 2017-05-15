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
			<li><a href="#" class="gallery">导出标签结果</a></li>
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
						<li><a href="#" class="gallery"><span>上传图片</span></a></li>
						<li><a href="" class="analytics"><span>统计信息</span></a></li>
					</ul>

					<br clear="all" />

					<div class="contenttitle2 nomargintop">
						<h3>历史记录</h3>
					</div>
					<!--contenttitle-->

					<div class="overviewhead">
						<div class="overviewselect">
							<select id="overviewselect" name="select">
								<option value="">1小时前</option>
								<option value="">5小时前</option>
								<option value="">今天</option>
								<option value="">昨天</option>
								<option value="">这一周</option>
								<option value="">上一周</option>
								<option value="">这个月</option>
								<option value="">上个月</option>
							</select>
						</div>
						<!--floatright-->
						From: &nbsp;<input type="text" id="datepickfrom" /> &nbsp; &nbsp;
						To: &nbsp;<input type="text" id="datepickto" />
					</div>
					<!--overviewhead-->

					<br clear="all" />

					<table cellpadding="0" cellspacing="0" border="0"
						class="stdtable overviewtable">
						<colgroup>
							<col class="con0" width="20%" />
							<col class="con1" width="20%" />
							<col class="con0" width="20%" />
							<col class="con1" width="20%" />
							<col class="con0" width="20%" />
						</colgroup>
						<thead>
							<tr>
								<th class="head0">打标签的总数</th>
								<th class="head1">正确率</th>
								<th class="head0">积分</th>
								<th class="head1">兴趣指数</th>
								<th class="head0">等级</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="progress progress150">
										<div class="bar">
											<div style="width: 60%;" class="value bluebar"></div>
										</div>
									</div>
								</td>
								<td>67.3%</td>
								<td>856, 220</td>
								<td class="center">32, 012</td>
								<td class="center">20.5</td>
							</tr>
						</tbody>
					</table>

					<br clear="all" />

					<div id="chartplace" style="height: 300px;"></div>

					<br clear="all" />

					<table cellpadding="0" cellspacing="0" border="0"
						class="stdtable stdtablecb overviewtable2">
						<colgroup>
							<col class="con0" style="width: 4%" />
							<col class="con1" />
							<col class="con0" />
							<col class="con1" />
							<col class="con0" />
							<col class="con1" />
						</colgroup>
						<thead>
							<tr>
								<th class="head0"><input type="checkbox" class="checkall" /></th>
								<th class="head1">1</th>
								<th class="head0">2</th>
								<th class="head1">3</th>
								<th class="head0">4</th>
								<th class="head1">5</th>
							</tr>
						</thead>
					</table>

					<br />

				</div>
				<!--two_third dashboard_left -->

				<div class="one_third last dashboard_right">
					<div class="widgetbox">
						<div class="title">
							<h3>最近活跃用户</h3>
						</div>
						<div class="widgetoptions">
							<a
								href="${pageContext.request.contextPath }/adminServlet?method=userSorting">刷新</a>
						</div>
						<div class="widgetcontent userlistwidget nopadding">
							<ul>
								<c:forEach items="${requestScope.volunteers }" var="volunteer">
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar1.png" />
										</div>

										<div class="info">
											${volunteer.username} <br /> ${volunteer.registdate} <br />
										</div> <!--info-->
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--bodywrapper-->
</body>
</html>