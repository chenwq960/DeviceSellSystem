<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/person.css" rel="stylesheet">
</head>
<body>
	<form action="${ctx}/user/update.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="userId">
		<div class="container">
			<div class="input-group">
				<font>账号：</font> <input type="text" class="form-control" name="account">
			</div>
			<div class="input-group">
				<font>人员：</font> <input type="text" class="form-control" name="userName">
			</div>
			<div class="input-group">
				<font>照片：</font> <img id="idCardFront" alt="号身份证" width="300" src=""> <br /> <span>重新上传身份证照片</span>
				<input type="file" name="idCardFile">
			</div>
			<div class="input-group">
				<font>担任角色：</font> <select name="roleId"></select>
			</div>
			<div class="input-group">
				<font>所属的部门</font> <select name="departmentId"></select>
			</div>
			<input type="submit" value="修改" class="btn btn-info"> <input type="button" value="返回"
				onclick="history.back()">
		</div>



	</form>
</body>
<script type="text/javascript">
	$(function() {
		$.post("${ctx}/user/detail.do", {
			userId : "${param.userId}"
		}, function(user) {
			console.log(user)
			$("[name=userId]").val(user.userId);
			$("[name=account]").val(user.account);
			$("[name=userName]").val(user.userName);
			$(".realName").html(user.realName);
			$("#idCardFront").attr("src", user.idCardFront);
		})
	})

	$(function() {
		$.post("${ctx}/department/list.do", function(departmentList) {
			for ( let i in departmentList) {
				var department = departmentList[i]
				$("[name=departmentId]").append(
						"<option value='"+department.departmentId+"'>"
								+ department.departmentName + "</option>")
			}
		});
		$.post("${ctx}/role/list.do", function(userList) {
			for ( let i in userList) {
				var role = userList[i]
				$("[name=roleId]").append(
						"<option value='"+role.roleId+"'>" + role.roleName
								+ "</option>")
			}
		});
	})
</script>
</html>