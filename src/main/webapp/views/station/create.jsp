<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加网点</title>
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link href="${ctx}/static/css/user.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form>
			<div class="input-group">
				<font>网点名称</font> <input type="text" class="form-control"
					name="stationName">
			</div>
			<div class="input-group">
				<font>省份：</font> <select class="form-control" name="provinceId"
					onchange="update()">
				</select>
			</div>

			<div class="input-group">
				<font>市区：</font> <select class="form-control" name="cityId"
					onchange="updateTo()">
				</select>
			</div>

			<div class="input-group">
				<font>县城：</font> <select class="form-control" name="countyId">
				</select>
			</div>
			<div class="input-group">
				<font>详细地址：</font> <input type="text" class="form-control"
					name="address">
			</div>
			<input type="button" value="提交 ">
			<button class="btn btn-info" onclick="window.history.back(-1);">返回</button>

		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.post("${ctx}/region/list.do", {
			regionId : 0
		}, function(region) {
			for ( let i in region) {
				var data = region[i]
				$("select[name=provinceId]").append(
						"<option value='"+data.regionId+"'>" + data.regionName
								+ "</option>")
			}
			update()
		})
	})

	function update() {
		$("select[name=cityId]").empty()
		let aim = $("select[name=provinceId]").val()
		$.post("${ctx}/region/list.do", {
			regionId : aim
		}, function(region) {
			for ( let i in region) {
				var data = region[i]
				$("select[name=cityId]").append(
						"<option value='"+data.regionId+"'>" + data.regionName
								+ "</option>")
			}
			updateTo()
		})
	}
	function updateTo() {
		$("select[name=countyId]").empty()
		let aim = $("select[name=cityId]").val()
		$.post("${ctx}/region/list.do", {
			regionId : aim
		}, function(region) {
			for ( let i in region) {
				var data = region[i]
				$("select[name=countyId]").append(
						"<option value='"+data.regionId+"'>" + data.regionName
								+ "</option>")
			}
		})
	}

	$("input[type=button]").click(
			function() {
				$.post("${ctx}/station/create.do", $("form").serialize(),
						function(obj) {
							if (obj) {
								alert("添加 成功")
								location.href = '${ctx}/station/list/page.do'
							} else {
								alert("添加失败")
							}
						})
			})
</script>
</html>