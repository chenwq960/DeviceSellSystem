<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员表</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet" />
<script src="${ctx}/javascript/jquery.cookie.js"></script>
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

.number {
	color: blue;
}

input {
	width: 150px;
}
</style>
</head>
<body>
	<div class="container">
		<table class="table table-hover table-bordered table-striped">
			<tr>
				<form action="${ctx}/department/list.do" method="post">
					<td colspan="111">
						<div class="pull-left">
							<input type="text" name="searchKey" width="100px;"
								value="${searchKey}"> <input type="submit" value="搜索"
								style="width: 50px">
						</div>
						<div class="pull-right">
							<label> 开始： <input type="text" name="startTime"
								value="${starttime}"> -- 结束 <input type="text"
								name="endTime" value="${endTime}">
							</label>
						</div>
					</td>
				</form>
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
					<li>${limitmodel.pageNum }/${limitmodel.pages },共${limitmodel.pages }</li>
					<li onclick="getlimit(${limitmodel.prePage})"><<</li>
					<li class="number" onclick="getlimit(1)">1</li>
					<li onclick="getlimit(${limitmodel.nextPage})">>></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function getlimit(id){
		location.href="${ctx}/department/list.do?pageNum="+id
	}
	function departmentdel(id) {
		if(confirm("确认要删除吗")==true){
			$.post(					
				"${ctx}/department/departmentdel.do",
				{UserId:id},
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