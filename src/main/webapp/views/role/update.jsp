<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改角色</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/user.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<input type="hidden" class="form-control" name="roleId">
		<div class="input-group">
			<font>用户姓名:</font> <input class="form-control" name="roleName">
		</div><br/>
		<button onclick="changerole()">修改</button>
		<button onclick="window.history.back(-1);">返回</button>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.post("${ctx}/role/detail.do", {
			roleId : "${param.roleId}"
		}, function(obj) {
			$("input[name=roleId]").val(obj.roleId)
			$("input[name=roleName]").val(obj.roleName)
		})

	})
	//修改的方法
	function changerole() {
		$.post("${ctx}/role/update.do", {
			roleName : $("input[name=roleName]").val(),
			roleId : $("input[name=roleId]").val()
		}, function(flag) {
			if (flag) {
				alert("修改成功")
				location.href = "${ctx}/role/list/page.do"
			} else {
				alert("修改失败")
			}
		})
	}
</script>
</html>