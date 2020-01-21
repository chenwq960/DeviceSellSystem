<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	后台发生异常：${error}
</body>
</html>