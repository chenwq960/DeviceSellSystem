<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增部门</title>
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
			<font>部门名称：</font>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<input type="text" class="form-control" name="departmentName"><br />
				</div>
			</div>
			<br /> <input type="button" onclick="create()" value="提交数据"
				class="btn btn-info">
		</form>
	</div>
</body>
<script type="text/javascript">
	function create() {
		$.post("${ctx}/department/create.do", $("#form").serialize(), function(
				obj) {
			if (obj) {
				alert("添加成功")
				location.href = "${ctx}/department/list/page.do"
			} else {
				alert("添加失败")
			}
		})
	}
</script>
</html>