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
			<font>账号：</font> 
			<span class="account"></span>
		</div>
		<div class="input-group">
			<font>人员：</font> 
			<span class="userName"></span>
		</div>

		<div class="input-group">
			<font>姓名：</font> <span class="realName"></span>
		</div>
		<div class="input-group">
			<font>性别：</font> 
			<span class="sex"></span>
		</div>

		<div class="input-group">
			<font>民族：</font>
			<span class="nation"></span>
		</div>

		<div class="input-group">
			<font>生日：</font>
			<span class="birthday"></span>
		</div>

		<div class="input-group">
			<font>照片：</font> <img id="idCardFront" alt="号身份证" width="300" src="">
		</div>

		<div class="input-group">
			<font>籍贯：</font>
			<span class="address"></span>
		</div>
		<div class="input-group">
			<font>创建时间</font>
			<span class="createTime"></span>
		</div>
		<div class="input-group">
			<font>修改时间</font> 
			<span class="updateTime"></span>
		</div>
		<div class="input-group">
			<font>所属的部门:</font> 
			<span class="departmentId"></span>
			<a href="${ctx}/views/department/create.jsp">编辑部门</a>
		</div>
		<div class="input-group">
			<font>角色：</font> 
			
			<span class="roleId"></span>
			<a href="${ctx}/views/role/create.jsp">编辑角色</a>
		</div>
		<input	type="button" value="返回" onclick="history.back()">
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.post("${ctx}/user/detailed.do", {
			userId : "${param.userId}"
		}, function(user) {
			console.log(user)
			$(".account").html(user.account)
			$(".userName").html(user.userName)
			$(".realName").html(user.realName)
			$(".sex").html(user.sex == "1" ? "男" : "女")
			$(".nation").html(user.nation)
			$(".birthday").html(user.birthday)
			$(".address").html(user.address)
			$("#idCardFront").attr("src", user.idCardFront)
			$(".createTime").html(user.createTime)
			$(".updateTime").html(user.updateTime)
			$(".departmentId").html(user.ofThereDepartment)
			$(".roleId").html(user.createUserName)
		})
	})
</script>
</html>