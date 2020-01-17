<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
ul li {
	list-style: none;
	float: left;
	border: 1px solid gray;
	padding: 0px 5px;
	cursor: pointer;
	background-color: #EEEEEE;
	border-radius: 5px;
}
input {
	width: 150px;
}
.number {
	color: blue;
}
</style>
</head>
<body>
	<div class="container">
		<table
			class="table table-hover table-bordered table-striped text-center">
			<tr>
				<td colspan="111">
					<form action="${ctx}/device/list.do" method="post">
						<div class="pull-left">
							<input type="text" name="seachKey" value="${seachKey}">
							<input type="submit" value="搜索" style="width:50px;">
						</div>
						<div class="pull-right">
							<input type="text" name="startTime" value="${startTime}">----
							<input type="text" name="endTime" value="${endTime}">
						</div>
					</form>
				</td>
			</tr>
			
			<tr>
				<td>设备名称：</td>
				<td>设备编号：</td>
				<td>设备型号：</td>
				<td>创建人：</td>
				<td>创建时间：</td>
				<td>操作：
					<button class="btn btn-info"
						onclick="location.href='${ctx}/views/device/create.jsp'">添加</button>
				</td>
			</tr>
			<tr>
				<c:forEach items="${list}" var="s">
					<tr>
						<td>${s.deviceName}</td>
						<td>${s.deviceCode}</td>
						<td>${s.deviceModel}</td>
						<td>${s.createUserName}</td>
						<td><fmt:formatDate value="${s.createTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<button onclick="deviceDel(${s.deviceId})">删除</button>
							<button onclick="location.href='${ctx}/views/device/update.jsp?id=${s.deviceId}&name=${s.deviceName}&model=${s.deviceModel}'">修改</button>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<div class="row">
			<div class="pull-right">
				<ul>
					<li>${limitmodel.pageNum }/${limitmodel.pages },共${limitmodel.pages }</li>
					<li onclick="getlimit('${limitmodel.prePage}')"><<</li>
					<li class="number" onclick="getlimit(1)">1</li>
					<li onclick="getlimit(${limitmodel.nextPage})">>></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
//改变页数的
function getlimit(id){
	location.href="${ctx}/device/list.do?pageNum="+id
}
//删除的
function deviceDel(id){
	if(confirm("确定要删除吗")==true){
		$.post(
			"${ctx}/device/delete.do",
			{deviceId:id},
			function(obj){
				if(obj){
					alert("删除成功")
					location.href="${ctx}/device/list.do"
				}else{
					alert("删除失败")
				}
			}
		)
	}
	
}
</script>
</html>