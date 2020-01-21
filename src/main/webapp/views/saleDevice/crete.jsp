<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>销售设备增加</title>

<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link href="${ctx}/static/css/user.css" rel="stylesheet">
<link
	href="${ctx}/static/plugins/datetimepicker/bootstrap-datetimepicker.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<form id="form">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售设备：</font> <select name="deviceId"></select>
				</div>
			</div>

			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售人员：</font> <select name="saleUser"></select>
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售数量：</font> <input type="text" class="form-control"
						name="saleNumber">
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>服务网点：</font> <select name="stationId"></select>
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>销售时间：</font>
					<div class="controls input-group">
						<span class="input-group date form_date"> <input
							class="form-control" autocomplete="off" name="saleTime">
						</span>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<font>备注：</font>
					<textarea class="form-control" name="remark"></textarea>
				</div>
			</div>
			<input type="button" onclick="create()" value="提交数据"
				class="btn btn-info">
			<button class="btn btn-info" onclick="window.history.back(-1);">返回</button>
		</form>
	</div>
</body>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<script
	src="${ctx}/static/plugins/datetimepicker/bootstrap-datetimepicker.js"></script>
<script
	src="${ctx}/static/plugins/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	//
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

		//查询所有的设备
		$.post("${ctx}/device/list.do", function(device) {
			console.log(device)
			for ( let i in device) {
				var devices = device[i]
				$("select[name=deviceId]").append(
						"<option value='"+devices.deviceId+"'>"
								+ devices.deviceName + "</option>")
			}
		});
		//查询所有网点
		$.post("${ctx}/station/list.do", function(station) {
			console.log(station)
			for ( let i in station) {
				var stations = station[i]
				$("select[name=stationId]").append(
						"<option value='"+stations.stationId+"'>"
								+ stations.stationName + "</option>")
			}
		})
		//查询所有的销售人
		$.post("${ctx}/role/list.do", function(roleName) {
			console.log(roleName)
			for ( let i in roleName) {
				var roleNames = roleName[i]
				$("select[name=saleUser]").append(
						"<option value='"+roleNames.roleId+"'>"
								+ roleNames.roleName + "</option>")
			}
		})

	})
	function create() {
		$.post("${ctx}/saleDevice/create.do", $("form").serialize(), function(
				obj) {
			if (obj) {
				alert("添加成功")
				location.href = "${ctx}/saleDevice/list/page.do";
			} else {
				alert("添加失败")
			}
		})
	}
</script>
</html>