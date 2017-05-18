<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Editor</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/plugins/charCount.js"></script>
<script type="text/javascript" src="js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/forms.js"></script>
</head>

<body class="withvernav">
	<div class="topheader">
		<div class="left">
			<h1 align="center" class="logo">后台管理系统</h1>
			<br clear="all" />
		</div>
		<!--left-->
	</div>
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
			<li><a href="exportLabel.jsp" class="gallery">导出标签结果</a></li>
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
	<div class="centercontent">
		<div id="contentwrapper" class="contentwrapper">
			<div id="basicform" class="subcontent">
				<div class="two_third dashboard_left">
					<ul class="shortcuts">
						<li><a
							href="${pageContext.request.contextPath }/adminServlet?method=user"
							class="users"><span>用户设置</span></a></li>
						<li><a href="uploadImageResult.jsp" class="gallery"><span>上传图片</span></a></li>
						<li><a href="" class="analytics"><span>统计信息</span></a></li>
					</ul>

					<br clear="all" />

					<div class="contenttitle2 nomargintop">
						<h3>任务分配</h3>
					</div>
					<div>
						<form
							action="${pageContext.request.contextPath }/adminServlet?method=updateAdmin"
							method="post">
							<p>
								<label>姓名</label> <span class="field"><input type="text"
									name="input1" class="smallinput" /></span>
							</p>

							<p>
								<label>密码</label> <span class="field"><input
									type="password" name="input2" class="mediuminput" /></span>
							</p>

							<p>
								<label>邮箱</label> <span class="field"><input type="text"
									name="input3" class="longinput" /></span>
							</p>

							<p>
								<label>性别</label> <span class="field"><input type="text"
									name="input4" id="firstname2" class="longinput" /></span>
							</p>

							<p class="stdformbutton">
								<button class="submit radius2">修改</button>
								<input type="reset" class="reset radius2" value="重置" />
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>