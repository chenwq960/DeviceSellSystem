<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门修改</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">
font {
	line-height: 45px;
}
</style>
</head>
<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>部门名称</font> <input type="text" class="form-control" id="sel"
						name="departmentName">
				</div>
				<input type="hidden" class="form-control" name="departmentId">
			</div>
			<br /> <input type="button" onclick="update()" value="提交数据"
				class="btn btn-info">

		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.post("${ctx}/department/detail.do", {
			departmentId : "${param.id}"
		}, function(department) {
			console.log(department)
			$("input[name=departmentId]").val(department.departmentId)
			$("#sel").val(department.departmentName)
		})
	})
	//修改数据的提交
	function update() {
		$.post("${ctx}/department/update.do", $("form").serialize(), function(
				obj) {
			if (obj) {
				alert("修改成功")
				console.log("obj")
				location.href = "${ctx}/department/list/page.do"
			} else {
				alert("修改失败")
			}
		})
	}
</script>
</html>