<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
font {
	line-height: 45px;
}
</style>
</head>
<body>
	<div class="container">
		<form action="${ctx}/user/create.do" method="post"
			enctype="multipart/form-data">
			<div class="input-group">
				<font>用户名：</font> <input type="text" class="form-control"
					name="userName">
			</div>
			<div class="input-group">
				<font>登陆账号：</font> <input type="text" class="form-control"
					name="account">
			</div>

			<div class="input-group">
				<font>登陆密码：</font> <input type="text" class="form-control"
					name="password">
			</div>

			<div class="input-group">
				<font>身份证正面</font> <input type="file" name="idCardFile">
			</div>
			<div class="input-group">
				<font>身份证反面</font> <input type="file" name="">
			</div>
			<div class="input-group">
				<font>担任角色：</font> <select name="roleId"></select>
			</div>
			<div class="input-group">
				<font>所属的部门</font> <select name="departmentId"></select>
			</div>
			<input type="submit" value="提交" class="btn btn-info"> <input
				type="button" value="返回" onclick="history.back()">
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.post("${ctx}/department/departmentfind.do", function(departmentList) {
			for ( let i in departmentList) {
				var department = departmentList[i]
				$("[name=departmentId]").append(
						"<option value='"+department.departmentId+"'>"
								+ department.departmentName + "</option>")
			}
		});
		$.post("${ctx}/role/roleName.do", function(roleList) {
			for ( let i in roleList) {
				var role = roleList[i]
				$("[name=roleId]").append(
						"<option value='"+role.roleId+"'>" + role.roleName
								+ "</option>")
			}
		});
	})
</script>
</html>