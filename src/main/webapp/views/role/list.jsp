<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员表</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/user.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<table
			class="table table-hover table-striped table-bordered text-center">
			<tr>
				<td colspan="99">
					<form action="${ctx}/role/list/page.do" method="post">
						<div class="pull-left">
							<input name="seachKey" value="${searchParam.seachKey}"> <input
								type="submit" value="寻找" style="width: 50px;">
						</div>
						<div class="pull-right">
							起始：<input name="startTime" value="${searchParam.startTime }"> 终止：<input
								name="endTime" value="${searchParam.endTime }">
						</div>
					</form>
				</td>
			</tr>
			<tr>
				<td>角色名称：</td>
				<td>创建时间：</td>
				<td>创建人：</td>
				<td>修改时间：</td>
				<td>修改人：</td>
				<td>操作：
					<button class="btn btn-info" onclick="location.href='${ctx}/views/role/create.jsp'">增加</button>
				</td>
			</tr>
			<c:forEach items="${role}" var="s">
				<tr>
					<td>${s.roleName}</td>
					<td><fmt:formatDate value="${s.createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${s.createUserName}</td>
					<td><fmt:formatDate value="${s.updateTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>

					<td>${s.updateUserName}</td>
					<td>
						<button onclick="delrole(${s.roleId})">删除</button>
						<button
							onclick="location.href='${ctx}/views/role/update.jsp?roleId=${s.roleId}'">修改</button>

					</td>
				</tr>
			</c:forEach>


		</table>
		<div class="row">
			<div class="pull-right">
				<ul>
					<li>${pageInfo.pageNum }/${pageInfo.pages },共${pageInfo.pages }</li>
					<li onclick="pageInfo('${pageInfo.prePage}')"><<</li>
					<li class="number" onclick="pageInfo(1)">1</li>
					<li onclick="pageInfo(${pageInfo.nextPage})">>></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function roledelete(id){
		$.post(
			"${ctx}/role/delete.do",
			{roleId:id},
			function(obj){
				if(obj != 0){
					location.reload()
				}
			}
		)
	}
//改变页数的
	function pageInfo(id){
		location.href="${ctx}/role/list/page.do?pageNum="+id
	}
//删除的方法
	function delrole(id) {
		if(confirm("确认要删除吗")==true){
			$.post(
				"${ctx}/role/delete.do",
				{roleId:id},
				function(obj){
					if(obj){
						alert("删除成功")
						location.reload()
					}else{
						alert("删除失败")
					}
				}
			)
		}else{
		}
	}
</script>
</html>