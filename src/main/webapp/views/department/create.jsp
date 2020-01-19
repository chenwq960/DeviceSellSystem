<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet"/>
<script src="${ctx}/javascript/jquery.cookie.js"></script>
</head>
<style>
	span{
		color:red;
		display: none;
	}
</style>
<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
				  <font>部门名称</font>
				  <input type="text" class="form-control" name="departmentName"><br/>
				  <span>部门不可为空</span>
				</div>
			</div>
			<input type="button" onclick="createdepartment()" value="提交数据" class="btn btn-info" >
		</form>
	</div>
</body>
<script type="text/javascript">
	function  createdepartment() {
		let aim = $("input[name=departmentName]").val()
		if(aim != null && aim != ""){
			$.post(
					"${ctx}/department/createdepartment.do",
					$("#form").serialize(),
					function(obj){
						if(obj){
							alert("添加成功")
							$("span").css("display","none")
							location.href="${ctx}/department/list.do"
						}else{
							alert("添加失败")
						}
					}
				)
		}
		else{
			$("span").css("display","inline")
		}
		
		
	}
</script>
</html>