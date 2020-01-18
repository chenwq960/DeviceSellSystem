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
</head>
<body>
	<div>
		<table class="table table-hover table-bordered text-center">
			<tr>
				<td colspan="1111">
					<input type="text">
				</td>
			</tr>
			<tr>
				<td>服务网点:</td>
				<td>省份:</td>
				<td>市区：:</td>
				<td>县城:</td>
				<td>创建人:</td>
				<td>创建时间:</td>
				<td>
					操作：
					<button onclick="location.href='${ctx}/views/station/create.jsp'">添加</button>
				</td>
			</tr>
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.stationName}</td>
					<td>${s.provinceName}</td>
					<td>${s.cityName}</td>
					<td>${s.countyName}</td>
					<td>${s.createUserName}</td>
					<td>
						<fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						<button onclick="stationDelete(${s.stationId})">删除</button>
						<button onclick="location.href='${ctx}/views/station/update.jsp?stationId=${s.stationId}'">修改</button>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
//删除的方法
	function stationDelete(id){
		if(confirm("确定要删除吗")==true){
			$.post(
				"${ctx}/station/delete.do",
				{stationId:id},
				function(station){
					if(station){
						alert("删除成功")
						location.href="${ctx}/station/list.do"
					}else{
						alert("删除失败")
					}
				}
			)
		}
	}
</script>
</html>