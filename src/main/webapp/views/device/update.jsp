<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改设备</title>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/device.css" rel="stylesheet">
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
</head>

<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<input type="hidden" name="deviceId">
				<div class="input-group">
					<font>设备名称：</font> 
					<input type="text" class="form-control"
						name="deviceName">
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>设备型号：</font> <input type="text" class="form-control"
						name="deviceModel">
				</div>
			</div><br/>
			<input type="button" value="提交数据" onclick="updateDevice()" class="btn btn-info">
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		//回显数据
		$.post(
			"${ctx}/device/detail.do",
			{deviceId:"${param.deviceId}"},
			function(device){
				$("input[name=deviceId]").val(device.deviceId)
				$("input[name=deviceName]").val(device.deviceName)
				$("input[name=deviceModel]").val(device.deviceModel)
			}
		)
	})
//修改数据
	function updateDevice(){
		$.post(
			"${ctx}/device/update.do",
			$("form").serialize(),
			function(obj){
				if(obj){
					alert("修改成功")
					location.href="${ctx}/device/list/page.do"
				}else{
					alert("修改失败")
				}
			}
		)
	}
	
	
</script>
</html>