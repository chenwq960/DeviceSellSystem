<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设备列表</title>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link href="${ctx}/static/css/department.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<table
			class="table table-hover table-bordered table-striped text-center">
			<tr>
				<td colspan="111">
					<form action="${ctx}/device/list/page.do" method="post">
						<div class="pull-left">
							<input type="text" name="seachKey"
								value="${searchParam.seachKey}"> <input type="submit"
								value="搜索" style="width: 50px;">
						</div>
						<div class="pull-right">
							<input type="text" name="startTime"
								value="${searchParam.startTime}">---- <input type="text"
								name="endTime" value="${searchParam.endTime}">
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
							<button
								onclick="location.href='${ctx}/views/device/update.jsp?deviceId=${s.deviceId}'">修改</button>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<div class="row">
			<div class="pull-right">
				<ul>
					<li>${pageInfo.pageNum }/${pageInfo.pages },共${pageInfo.pages }</li>
					<li onclick="pageInfo'${pageInfo.prePage}')"><<</li>
					<li class="number" onclick="pageInfo(1)">1</li>
					<li onclick="pageInfo">>></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript">
//改变页数的
function pageInfo(id){
	location.href="${ctx}/device/list/page.do?pageNum="+id
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
					location.reload()
				}else{
					alert("删除失败")
				}
			}
		)
	}
	
}
</script>
</html>