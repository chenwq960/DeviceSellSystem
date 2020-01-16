<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<%-- ${list } --%>
	<div>
		
		<table class="table table-hover table-bordered text-center">
			<tr>
				<td>角色名称:</td>
				<td>创建人:</td>
				<td>修改时间：:</td>
				<td>修改人:</td>
				<td>修改时间:</td>
				<td>
					<button onclick="location.href='${ctx}/views/user/create.jsp'">增加</button>
				</td>
			</tr>
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.account}</td>
					<td>${s.createUserObj.userName}</td>
					<td><fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${s.updateUserObj.userName}</td>
					<td><fmt:formatDate value="${s.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<a href="${ctx}/views/user/detailed.jsp?userId=${s.userId}">查看详细</a>
						<button onclick="userDelete(${s.userId})">删除</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
//删除的方法
	function userDelete(id){
		if(confirm("确定要删除吗")==true){
			$.post(
				"${ctx}/user/delete.do",
				{userId:id},
				function(obj){
					if(obj){
						alert("删除成功")
						location.href="${ctx}/user/list.do"
					}else{
						alert("删除失败")
					}
				}
			)
		}
	}
</script>
</html>