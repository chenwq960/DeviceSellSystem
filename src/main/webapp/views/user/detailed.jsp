<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	font{
		line-height: 40px;
		padding-left:20px;
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
			<font>性别：</font> <input type="text" class="form-control"
				name="sex">
		</div>

		<div class="input-group">
			<font>民族：</font> <input type="text" class="form-control"
				name="nation">
		</div>

		<div class="input-group">
			<font>生日：</font> <input type="text" class="form-control"
				name="birthday">
		</div>

		<div class="input-group">
			<font>照片：</font> <input type="text" class="form-control"
				name="idCardFront">
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
			<font>创建人</font> 
			<input type="text" class="form-control"
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
			<font>所属的部门</font> <input type="text"  name="departmentId">
		</div>
		<div class="input-group">
			<font>角色</font>
			<input type="text"  name="roleId">
		</div>
		<input type="submit" value="提交" class="btn btn-info"> <input
			type="button" value="返回" onclick="history.back()">


	</div>
</body>
<script type="text/javascript">
	$(function() {
			alert("${param.UserId}")
			$.post("${ctx}/user/detailed.do",
			{UserId : "${param.UserId}"},
			function(obj) {
				console.log(obj)
				$("input[name=account]").val(obj.account)
				$("input[name=userName]").val(obj.userName)
				$("input[name=realName]").val(obj.realName)
				$("input[name=sex]").val(obj.sex=="2"?"男":"女")
				$("input[name=nation]").val(obj.nation)
				$("input[name=birthday]").val(obj.birthday)
				$("input[name=address]").val(obj.address)
				$("input[name=idCardFront]").val(obj.idCardFront)
				$("input[name=createTime]").val(obj.createTime)
				$("input[name=createUser]").val(obj.createUser)
				$("input[name=updateTime]").val(obj.updateTime)
				$("input[name=updateUser]").val(obj.updateUser)
				$("input[name=departmentId]").val(obj.departmentId)
				$("input[name=roleId]").val(obj.roleId)
			}
		)
	})
</script>
</html>