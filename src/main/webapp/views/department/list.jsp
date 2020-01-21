<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门表</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/static/css/department.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table table-hover table-bordered table-striped">
			<tr>
				<td colspan="111">
					<form action="${ctx}/department/list/page.do" method="post">
						<div class="pull-left">
							<input type="text" name="seachKey" width="100px;"
								value="${searchParam.seachKey}"> <input type="submit" value="搜索"
								style="width: 50px">
							</div>
							<div class="pull-right">
								<label> 开始： <input type="text" name="startTime"
								value="${searchParam.startTime}"> -- 结束 <input type="text"
								name="endTime" value="${searchParam.endTime}">
							</label>
						</div>
					</form>
				    </td>
				</tr>
			<tr>
				<td>部门名称：</td>
				<td>创建时间：</td>
				<td>创建人：</td>
				<td>修改时间：</td>
				<td>修改人：</td>
				<td>操作：
					<button
						onclick="location.href='${ctx}/views/department/create.jsp'"
						class="btn btn-info">添加</button>
				</td>
			</tr>
			<c:forEach items="${department}" var="s">
				<tr>
					<td>${s.departmentName}</td>
					<td><fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${s.createUserName}</td>
					<td><fmt:formatDate value="${s.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${s.updateUserName}</td>
					<td>
						<button onclick="departmentdel(${s.departmentId})">删除</button>
						<button onclick="location.href='${ctx}/views/department/update.jsp?id=${s.departmentId}'">修改</button>
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
	function pageInfo(id){
		location.href="${ctx}/department/list/page.do?pageNum="+id
	}
	function departmentdel(id) {
		if(confirm("确认要删除吗")==true){
			$.post(					
				"${ctx}/department/delete.do",
				{departmentId:id},
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