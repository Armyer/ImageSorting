<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>控制台页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.flot.resize.min.js"></script>
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
						<div class="changetheme">
							切换主题: <br /> <a class="default"></a> <a class="blueline"></a> <a
								class="greenline"></a> <a class="contrast"></a> <a
								class="custombg"></a>
						</div>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>Juan</h4>
						<span class="email">youremail@yourdomain.com</span>
						<ul>
							<li><a href="html/editor.html">编辑资料</a></li>
							<li><a href="html/accountsettings.html">账号设置</a></li>
							<li><a href="html/help.html">帮助</a></li>
							<li><a href="html/index.html">退出</a></li>
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
				<li><a href="taskAllocation.jsp"><span
						class="icon icon-pencil"></span>任务分配系统</a></li>
				<li><a href="labelDecision.jsp"><span
						class="icon icon-message"></span>标签判定系统</a></li>
				<li><a href="pictureIndex.jsp"><span
						class="icon icon-chart"></span>图片存储索引系统</a></li>
			</ul>
		</div>
		<div class="centercontent">
			<div id="contentwrapper" class="contentwrapper">

				<div id="updates" class="subcontent">
					<!-- notification announcement -->

					<div class="two_third dashboard_left">
						<ul class="shortcuts">
							<li><a href="" class="users"><span>用户信息</span></a></li>
							<li><a href="" class="gallery"><span>图册信息</span></a></li>
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
							From: &nbsp;<input type="text" id="datepickfrom" /> &nbsp;
							&nbsp; To: &nbsp;<input type="text" id="datepickto" />
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
								<h3>新注册的用户</h3>
							</div>
							<div class="widgetoptions">
								<div class="right">
									<a href="">查看所有用户</a>
								</div>
								<a href="">添加管理员</a>
							</div>
							<div class="widgetcontent userlistwidget nopadding">
								<ul>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar1.png" />
										</div>
										<div class="info">
											<a href="">张三</a> <br /> 软工程师 <br /> 18
											分钟以前
										</div> <!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar2.png" />
										</div>
										<div class="info">
											<a href="">李四</a> <br /> 李四 <br />
											18 分钟以前
										</div> <!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar1.png" />
										</div>
										<div class="info">
											<a href="">王五</a> <br /> 系统设计师 <br />
											18 分钟以前
										</div> <!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar2.png" />
										</div>
										<div class="info">
											<a href="">刘六</a> <br /> 系统设计师 <br /> 18
											分钟以前
										</div> <!--info-->
									</li>
								</ul>
								<a class="more" href="">查看更多用户</a>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
	<!--bodywrapper-->

</body>
</html>