<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增设备</title>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/device.css" rel="stylesheet">
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
</head>
<script type="text/javascript">
	function create() {
		$.post("${ctx}/device/create.do", 
				$("#form").serialize(),
				function(obj) {
					if (obj) {
						alert("添加成功")
						location.href = "${ctx}/device/list/page.do"
					} else {
						alert("添加失败")
					}
				});
	}
</script>
<body>
	<div class="container">
		<form id="form" onsubmit="return submitDeviceForm()">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>设备名称：</font> 
					<input type="text" class="form-control"	name="deviceName">
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>设备型号：</font> 
					<input type="text" class="form-control" name="deviceModel">
				</div>
			</div><br/>
			<input onclick="create()" type="button" value="提交数据" class="btn btn-info">
		</form>
	</div>
</body>
</html>