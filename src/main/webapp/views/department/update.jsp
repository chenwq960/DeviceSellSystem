<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet" />
<script src="${ctx}/javascript/jquery.cookie.js"></script>
<script src="${ctx}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>部门名称</font>
					<input type="text" class="form-control" id="sel" name="departmentName">
				</div>

				<input type="hidden" class="form-control" name="departmentId">
			</div>
			<input type="button" onclick="updatedepartment()" value="提交数据"
				class="btn btn-info">
		</form>
	</div>
</body>
<script type="text/javascript">
	 $(function() {
		$.post("${ctx}/department/departmenthx.do", {
			id : "${param.id}"
		}, function(obj) {
			console.log(obj)
			$("input[name=departmentId]").val(obj.departmentId)
			$("#sel").val(obj.departmentName)
		})
	})
	//修改数据的提交
	function updatedepartment() {
		$.post(
			"${ctx}/department/update.do",
			$("form").serialize(),
			function(obj) {
				if(obj){
					alert("修改成功")
					console.log("obj")
					location.href="${ctx}/department/list.do"
				}else{
					alert("修改失败")
				}
			})
		}
</script>
</html>