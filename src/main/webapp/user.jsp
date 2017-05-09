<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
           var flag=confirm("确定要删除该用户的信息吗");
           return flag;
		});
	});
</script>
</head>
<body>
	<center>
		<table border="1" cellpadding="5" cellspacing="1">
			<thead align="center">用户信息表
			</thead>
			<tbody>
				<tr align="center">
					<td>序号</td>
					<td>姓名</td>
					<td>电话</td>
					<td>密码</td>
					<td>邮箱</td>
					<td>日期</td>
					<td>性别</td>
					<td>生日</td>
					<td>状态</td>
					<td colspan="2">操作</td>
				</tr>
				<c:forEach items="${requestScope.volunteers }" var="volunteer">
					<tr>
						<td>${volunteer.vid }</td>
						<td>${volunteer.username }</td>
						<td>${volunteer.phone }</td>
						<td>${volunteer.password }</td>
						<td>${volunteer.email }</td>
						<td>${volunteer.registdate }</td>
						<td>${volunteer.sex }</td>
						<td>${volunteer.birthday }</td>
						<td>${volunteer.status }</td>
						<td><a href="updatePassword.jsp">修改密码</a></td>
						<td><a class="delete"
							href="${pageContext.request.contextPath }/adminServlet?method=deleteUser&id=${volunteer.vid}">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>