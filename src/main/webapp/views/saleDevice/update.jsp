<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加</title>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<link
	href="${ctx}/static/plugins/datetimepicker/bootstrap-datetimepicker.css"
	rel="stylesheet">
<style type="text/css">
font {
	font-size: 16px;
	line-height: 45px;
}
</style>
</head>
<body>
	<div class="container">

		<form id="form">
			<input type="hidden" name="recordId" value="${saleDevice.recordId}">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售设备：</font> <select name="deviceId">
						<c:forEach items="${deviceList}" var="device">
							<option ${device.deviceId == saleDevice.deviceId ? 'selected':''}
								value="${device.deviceId}">
								${device.deviceName}-${device.deviceModel}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售人员：</font> <select name="saleUser">
						<c:forEach items="${userList}" var="user">
							<option ${user.userId == saleDevice.saleUser ? 'selected':''}
								value="${user.userId}">${user.userName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>服务网点：</font> <select name="stationId">
						<c:forEach items="${stationList}" var="station">
							<option
								${station.stationId == saleDevice.stationId ? 'selected':''}
								value="${station.stationId}">${station.stationName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售数量：</font> <input type="text" class="form-control"
						name="saleNumber" value="${saleDevice.saleNumber}">
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售时间：</font>
					<div class="controls input-group">
						<span class="input-group date form_date"> <input
							class="form-control" autocomplete="off" name="saleTime"
							value="<fmt:formatDate value='${saleDevice.saleTime}' pattern='yyyy-MM-dd  HH:mm:ss'/>">
						</span>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>备注：</font>
					<textarea class="form-control" name="remark">${saleDevice.remark}</textarea>

				</div>
			</div>
			<input type="button" onclick="update()" value="提交数据"
				class="btn btn-info">
		</form>
	</div>
</body>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<script
	src="${ctx}/static/plugins/datetimepicker/bootstrap-datetimepicker.js"></script>
<script
	src="${ctx}/static/plugins/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	$(function() {

		$('[name=saleTime]').datetimepicker({
			forceParse : 0,//设置为0，时间不会跳转1899，会显示当前时间。
			language : 'zh-CN',//显示中文
			format : 'yyyy-mm-dd hh:ii:ss',//显示格式
			minView : "month",//设置只显示到月份
			initialDate : new Date(),//初始化当前日期
			autoclose : true,//选中自动关闭
			todayBtn : true,//显示今日按钮,
			minView : 0,//最小视图
			minuteStep : 5,//分钟步长
		})

	})
	function update() {
		$.post("${ctx}/saleDevice/update.do", $("form").serialize(), function(
				obj) {
			if (obj) {
				alert("修改成功")
				location.href = "${ctx}/saleDevice/list.do";
			} else {
				alert("修改失败")
			}
		})
	}
</script>
</html>