<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/javascript/jquery-1.8.3.js"></script>
<link href="${ctx}/javascript/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
	font {
		line-height: 40px;
	}
</style>
</head>
<script type="text/javascript"> 
	if(window.top != window.self){
		top.location = this.location;
	}
</script>
<body>
	<div class="container">
		<div class="col-md-6 col-md-offset-5">
			<h1>${msg}</h1>
			<form action="${ctx}/user/login.do" method="post">
				<div class="input-group">
					<font>用户名：</font>
					<input type="text" class="form-control"  name="account">
				</div>
				<div class="input-group">
					<font>密码：</font>
					<input type="password" class="form-control" name="password">
				</div>
				<input type="checkbox">记住密码<br/>
				<input type="submit" value="提交" class="btn btn-info">
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	/* $("input[type='button']").click(function(){
		$.post(
			"${ctx}/login.do",
			$("form").serialize(),
			function(obj){
				if(obj == 1){
					var flag = $("input[type=checkbox]").prop("checked")
					if(flag){
						remomber()
					}
					location.href="${ctx}/jsp/first.jsp?username="+$("input[name='login_user']").val()
				}
			}
		)
	})
	function remomber(){
		let username = $("input[name='login_user']").val()
		let password = $("input[name='login_pwd']").val()
		$.cookie("user",username,{expires:7})
		$.cookie("pass",password,{expires:7})
	} */
</script>
</html>