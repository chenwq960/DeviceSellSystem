<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员列表</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/person.css" rel="stylesheet">
</head>
<body>
	<div>
		<table class="table table-hover table-bordered text-center">
			<tr>
				<td colspan="111">
					<form action="${ctx}/user/list/page.do" method="post">
						<div class="pull-left">
							<input type="text" name="seachKey" value="${searchParam.seachKey}"> <input
								type="submit" value="搜索" style="width: 50px;">
						</div>
						<div class="pull-right">
							<input type="text" name="startTime" value="${searchParam.startTime}">----
							<input type="text" name="endTime" value="${searchParam.endTime}">
						</div>
					</form>
				</td>
			</tr>
			<tr>
				<td>用户名称:</td>
				<td>登录账号:</td>
				<td>身份证号:</td>
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
					<td>${s.userName}</td>
					<td>${s.account}</td>
					<td>${s.idCard}</td>
					<td>${s.createUserObj.userName}</td>
					<td><fmt:formatDate value="${s.createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${s.updateUserObj.userName}</td>
					<td><fmt:formatDate value="${s.updateTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<a href="${ctx}/views/user/detail.jsp?userId=${s.userId}">查看详细</a><br/>
						<button onclick="userDelete(${s.userId})">删除</button>
						<button onclick="update(${s.userId})">修改</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="row">
			<div class="pull-right">
				<ul>
					<li>${pageInfo.pageNum }/${pageInfo.pages },共${pageInfo.pages }</li>
					<li onclick="getlimit('${pageInfo.prePage}')"><<</li>
					<li class="number" onclick="getlimit(1)">1</li>
					<li onclick="getlimit(${pageInfo.nextPage})">>></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function getlimit(id){
	location.href="${ctx}/user/list/page.do?pageNum="+id
}
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
//跳转修改的页面
	function update(userId){
		location.href='${ctx}/views/user/update.jsp?userId='+userId
}
</script>
</html>