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
				<td>省份:</td>
				<td>市区：:</td>
				<td>县城:</td>
				<td>创建人:</td>
				<td>创建时间:</td>
				<td>
				</td>
			</tr>
			
		</table>
		${list }
	</div>
</body>
<script type="text/javascript">
/* //删除的方法
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
	} */
</script>
</html>