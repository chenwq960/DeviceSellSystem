<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	font{
		font-size:16px;
		line-height:45px;
	}
</style>
</head>

<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>设备名称：</font> <input type="text" class="form-control"
						name="deviceName">
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>设备型号：</font> <input type="text" class="form-control"
						name="deviceModel">
				</div>
			</div>
			<input type="submit" value="提交数据" class="btn btn-info">
		</form>
	</div>
</body>
<script type="text/javascript">
	$("input[type=submit]").click(function(){
		$.post(
			"${ctx}/device/create.do",
			$("#form").serialize(),
			function(obj){
				if(obj){
					alert("添加成功")
					location.href="${ctx}/device/list.do"
				}else{
					alert("添加失败")
				}
			}
		)
	})
</script>

</html>