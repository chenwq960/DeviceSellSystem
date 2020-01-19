<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<style>
table {
	width: 100%;
}
</style>
<body>

	<table>
		<tr>
			<td width="30%">
				<div id="rolePieChar" style="width: 100%; height: 400px;"></div>
			</td>
			<td width="40%">
				<div id="roleBarChar" style="width: 100%; height: 400px;"></div>
			</td>
			<td></td>
		</tr>
	</table>

	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
</body>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<script src="${ctx}/static/plugins/echarts/echarts.min.js"></script>
<script src="${ctx}/static/js/report/base.role.pie.js"></script>
<script src="${ctx}/static/js/report/base.role.bar.js"></script>

</html>