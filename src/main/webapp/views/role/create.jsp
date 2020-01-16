<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加角色</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
font {
	font-size: 16px;
	line-height: 45px;
}
</style>
</head>
<script type="text/javascript">
	function createRole() {
		$.post("${ctx}/role/create.do", $("#form").serialize(), function(obj) {
			if (obj) {
				alert("添加成功")
				location.href = "${ctx}/role/list.do"
			} else {
				alert("添加失败")
			}
		});

		return false;
	}
</script>
<body>
	<div class="container">
		<form id="form" onsubmit="return createRole()">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>角色名称</font> <input type="text" class="form-control"
						name="roleName">
				</div>
			</div>
			<button class="btn btn-info">提交数据</button>
		</form>
	</div>
</body>
</html>