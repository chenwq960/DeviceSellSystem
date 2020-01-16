<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% String path = request.getContextPath(); %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	登陆已经过期，请重新登陆<a href="<%=path%>/views/user/login.jsp">登陆</a>
</body>
</html>