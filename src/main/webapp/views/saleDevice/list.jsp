<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>销售设备</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/user.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<table class="table table-hover table-striped table-bordered">
			<tr>
				<td colspan="111">
					<form action="${ctx}/saleDevice/list/page.do" method="post">
						<div class="row">
							<div class="pull-left">
								<input type="text" name="seachKey" value="${searchParcm.seachKey}" style="width:100px">
								<input type="submit" value="查找" style="width:50px;">
							</div>
							<div class="pull-right">
								<input name="startTime" value="${searchParcm.startTime}">--
								<input name="endTime" value="${searchParcm.endTime}">
							</div>
						</div>
					</form>
				</td>
			</tr>
			<tr>
				<td>名称：</td>
				<td>型号：</td>
				<td>人员</td>
				<td>网点</td>
				<td>数量</td>
				<td>销售时间</td>
				<td>创建人</td>
				<td>创建时间</td>
				<td>
					操作
					<button class="" onclick="location.href='${ctx}/views/saleDevice/crete.jsp'">添加</button>
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
						<button onclick="location.href='${ctx}/saleDevice/updateDevice.do?saleDeviceId=${s.recordId}'">修改</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="row">
			<div class="pull-right">
				<ul>
					<li>${pageInfo.pageNum }/${pageInfo.pages },共${pageInfo.pages }</li>
					<li onclick="pageInfo(${pageInfo.prePage})"><<</li>
					<li class="number" onclick="pageInfo(1)">1</li>
					<li onclick="pageInfo(${pageInfo.nextPage})">>></li>
				</ul>
			</div>
		</div>
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
//分页的方法
function pageInfo(pageNum){
	location.href="${ctx}/saleDevice/list/page.do?pageNum="+pageNum
}
</script>
</html>