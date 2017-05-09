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
	<div class="centercontent">
		<div id="contentwrapper" class="contentwrapper">
			<div id="basicform" class="subcontent">
				<form class="stdform"
					action="${pageContext.request.contextPath }/adminServlet?method=updatePwd"
					method="post">
					<p>
						<label>ID</label> <span class="field"><input type="text"
							name="id" class="mediuminput" /></span>
					</p>
					<p>
						<label>新密码</label> <span class="field"><input type="text"
							name="password" class="mediuminput" /></span>
					</p>
					<p>
						<label>旧密码</label> <span class="field"><input
							type="password" name="input2" class="mediuminput" /></span>
					</p>
					<p class="stdformbutton">
						<button class="submit radius2">修改</button>
						<input type="reset" class="reset radius2" value="重置" />
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>