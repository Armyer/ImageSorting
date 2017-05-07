<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理的页面</title>
</head>
<body>
    <center>
		<table border="1" cellpadding="5" cellspacing="1">
			<thead align="center">管理员信息表</thead>
			<tbody>
				<tr align="center">
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
				<c:forEach items="${requestScope.admins }" var="admin">
					<tr>
						<td>${admin.username }</td>
						<td>${admin.phone }</td>
						<td>${admin.password }</td>
						<td>${admin.email }</td>
						<td>${admin.registdate }</td>
						<td>${admin.sex }</td>
						<td>${admin.birthday }</td>
						<td>${admin.status }</td>
						<td><a href="">编辑</a></td>
					    <td><a href="">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>