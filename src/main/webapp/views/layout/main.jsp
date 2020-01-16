<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${ctx}/javascript/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/javascript/style.css" rel="stylesheet">
<script src="${ctx}/javascript/jquery-1.8.3.js"></script>
</head>
<body>
	<div>
		<nav>
			<div class="container">
				<div class="pull-left col-md-10 text-left">
					<h3>销售管理系统</h3>
				</div>
				<div class="pull-right col-md-2" id="userModel">欢迎：${currentUser.userName}</div>
			</div>

		</nav>
		<div class="container">
			<div class="row">
				<div class="col-md-2 pull-left text-center left">
					<div class="row">
						<a href="${ctx}/user/list.do" target="myIframe">人员管理</a>
					</div>
					<div class="row">
						<a href="${ctx}/role/list.do" target="myIframe">角色管理</a>
					</div>
					<div class="row">
						<a href="${ctx}/department/list.do" target="myIframe">部门管理</a>
					</div>
					<div class="row">
						<a href="${ctx}/device/list.do" target="myIframe">销售管理</a>
					</div>
				</div>
				<div class="col-md-9 pull-left right">
					<iframe name="myIframe" class="col-md-12" src="${ctx}/device/list.do"></iframe>
				</div>
			</div>

		</div>
	</div>
	</div>
	</div>
</body>

</html>