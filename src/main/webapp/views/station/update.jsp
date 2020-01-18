<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ctx}/static/js/jquery-1.8.3.js"></script>
<link href="${ctx}/static/js/bootstrap.min.css" rel="stylesheet">
<script src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
font {
	line-height: 45px;
}

* {
	margin: 10px 10px;
}
</style>
</head>
<body>
	<div class="container">
		<form>
			
			<div class="input-group">
				<font>网点名称</font> <input type="text" class="form-control"
					name="stationName">
			</div>
			<div class="input-group">
				<select class="form-control" name="provinceId"
					onchange="provinceChange()">
				</select>
			</div>

			<div class="input-group">
				<select class="form-control" name="cityId" onchange="cityChange()">
				</select>
			</div>

			<div class="input-group">
				<select class="form-control" name="countyId">
				</select>
			</div>
			<div class="input-group">
				<input type="text" class="form-control" name="address">
			</div>

		</form>
		<input type="button" value="修改">
	</div>
</body>
<script type="text/javascript">
	var provinceId, cityId, countyId;

	$(function() {

		$("input[type=button]").click(
				function() {
					$.post("${ctx}/station/change.do", $("form").serialize(),
							function(station) {
								console.log(station)
							})

				});

		$.post("${ctx}/station/update.do", {
			stationId : "${param.stationId}"
		}, function(station) {
			console.log(station)
			$("input[name=stationName]").val(station.stationName);
			$("input[name=address]").val(station.address);

			provinceId = station.provinceId;
			cityId = station.cityId;
			countyId = station.countyId;

			$.post("${ctx}/region/create.do", {
				regionId : 0
			}, function(provinces) {
				for ( let i in provinces) {
					var province = provinces[i];
					var flag = province.regionId == provinceId ? "selected"
							: "";
					$("select[name=provinceId]").append(
							"<option "+flag+" value='"+province.regionId+"'>"
									+ province.regionName + "</option>")
				}
				provinceChange()

			});

		})

	})

	function provinceChange() {

		var provinceId = $("select[name=provinceId]").val()
		$.post("${ctx}/region/create.do", {
			regionId : provinceId
		}, function(citys) {
			$("select[name=cityId]").empty();
			for ( let i in citys) {
				var city = citys[i]
				var flag = city.regionId == cityId ? "selected" : "";
				$("select[name=cityId]").append(
						"<option " + flag + " value='"+city.regionId+"'>"
								+ city.regionName + "</option>")
			}

			cityChange()
		})
	}

	function cityChange() {
		$("select[name=countyId]").empty();
		var cityId = $("select[name=cityId]").val()
		$.post("${ctx}/region/create.do", {
			regionId : cityId
		}, function(countys) {
			for ( let i in countys) {
				var county = countys[i]
				var flag = county.regionId == countyId ? "selected" : "";

				$("select[name=countyId]").append(
						"<option " + flag + " value='"+county.regionId+"'>"
								+ county.regionName + "</option>")
			}
		})
	}
</script>
</html>