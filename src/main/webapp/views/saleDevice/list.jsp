<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<table class="table table-hover table-striped table-bordered">
			<tr>
				<td>设备名称：</td>
				<td>设备型号：</td>
				<td>销售人员</td>
				<td>服务网点</td>
				<td>销售数量</td>
				<td>销售时间</td>
				<td>创建人</td>
				<td>创建时间</td>
				<td>
					操作
					<button onclick="location.href='${ctx}/views/saleDevice/crete.jsp'">添加</button>
				</td>
			</tr>
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.saleDeviceName}</td>
					<td>${s.saleDeviceModel}</td>
					<td>${s.roleName}</td>
					<td>${s.stationName}</td>
					<td>${s.saleNumber}</td>
					<td>
						<fmt:formatDate value="${s.saleTime}" pattern="yyyy-MM-dd  HH:mm:ss"/>
					</td>
					<td>${s.createUserName}</td>
					<td>
						<fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd  HH:mm:ss"/>
					</td>
					<td>
						<button onclick="saleDelete(${s.recordId})">删除</button>
						<button onclick="location.href='${ctx}/saleDevice/toUpdate.do?recordId=${s.recordId}'">修改</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
//删除的方法
function saleDelete(id){
	if(confirm("确定要删除吗")==true){
		$.post(
			"${ctx}/saleDevice/delete.do",
			{stationId:id},
			function(station){
				if(station){
					alert("删除成功")
					location.href="${ctx}/saleDevice/list.do"
				}else{
					alert("删除失败")
				}
			}
		)
	}
}
</script>
</html>