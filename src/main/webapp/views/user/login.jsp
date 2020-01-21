<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>登陆</title>
<style type="text/css">
.easyui-panel {
	margin: 0 auto;
}
</style>

<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/jquery-easyui-1.7.0/themes/icon.css">
</head>
<script type="text/javascript">
	if (window.top != window.self) {
		top.location = this.location;
	}
</script>
<style>
.panel-htop {
	margin: 0 auto;
}
</style>
<body>
	<div class="easyui-panel" title="用户登录" style="width: 400px; height: 300px; padding: 10px;">
		<h1>${msg}</h1>
		<form action="${ctx}/user/login.do" method="post">
			<div class="input-group">
				<font>用户名：</font><input type="text" class="form-control" name="account">

			</div>
			<div class="input-group">
				<font>密码：</font> <input type="password" class="form-control" name="password">
			</div>
			<input type="checkbox">记住密码<br /> <input type="submit" value="提交" class="btn btn-info">
		</form>
	</div>
</body>
<script type="text/javascript" src="${ctx}/static/plugins/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugins/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>

</html>