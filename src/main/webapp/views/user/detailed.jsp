<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
font {
	line-height: 40px;
	padding-left: 20px;
}
</style>
</head>
<body>

	<div class="container">
		<div class="input-group">
			<font>账号：</font> <input type="text" class="form-control"
				name="account">
		</div>
		<div class="input-group">
			<font>人员：</font> <input type="text" class="form-control"
				name="userName">
		</div>

		<div class="input-group">
			<font>姓名：</font> <input type="text" class="form-control"
				name="realName">
		</div>
		<div class="input-group">
			<font>性别：</font> <input type="text" class="form-control" name="sex">
		</div>

		<div class="input-group">
			<font>民族：</font> <input type="text" class="form-control"
				name="nation">
		</div>

		<div class="input-group">
			<font>生日：</font> <input title="生日" type="text" class="form-control"
				name="birthday">
		</div>

		<div class="input-group">
			<font>照片：</font> <img id="idCardFront" alt="号身份证" width="300" src="">
		</div>

		<div class="input-group">
			<font>籍贯：</font> <input type="text" class="form-control"
				name="address">
		</div>
		<div class="input-group">
			<font>创建时间</font> <input type="text" class="form-control"
				name="createTime">
		</div>
		<div class="input-group">
			<font>创建人</font> <input type="text" class="form-control"
				name="createUser">
		</div>
		<div class="input-group">
			<font>修改时间</font> <input type="text" class="form-control"
				name="updateTime">
		</div>
		<div class="input-group">
			<font>修改人：</font> <input type="text" name="updateUser">
		</div>
		<div class="input-group">
			<font>所属的部门</font> <input type="text" name="departmentId">
		</div>
		<div class="input-group">
			<font>角色</font> <input type="text" name="roleId">
		</div>
		<input type="submit" value="提交" class="btn btn-info"> <input
			type="button" value="返回" onclick="history.back()">


	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.post("${ctx}/user/detailed.do", {
			userId : "${param.userId}"
		}, function(user) {
			console.log(user)
			$("input[name=account]").val(user.account)
			$("input[name=userName]").val(user.userName)
			$("input[name=realName]").val(user.realName)
			$("input[name=sex]").val(user.sex == "2" ? "男" : "女")
			$("input[name=nation]").val(user.nation)
			$("input[name=birthday]").val(user.birthday)
			$("input[name=address]").val(user.address)
			$("#idCardFront").attr("src", user.idCardFront)
			$("input[name=createTime]").val(user.createTime)
			$("input[name=createUser]").val(user.createUser)
			$("input[name=updateTime]").val(user.updateTime)
			$("input[name=updateUser]").val(user.updateUser)
			$("input[name=departmentId]").val(user.departmentId)
			$("input[name=roleId]").val(user.roleId)
		})
	})
</script>
</html>