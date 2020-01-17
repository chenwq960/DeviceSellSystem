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
				<font>网点名称</font>
				<input type="text" class="form-control" name="stationName">
			</div>
			<div class="input-group">
				<select class="form-control" name="provinceId" onchange="update()">
				</select>
			</div>

			<div class="input-group">
				<select class="form-control" name="cityId" onchange="updateTo()">
				</select>
			</div>

			<div class="input-group">
				<select class="form-control" name="countyId">
				</select>
			</div>
			<div class="input-group">
				<input type="text" class="form-control" name="address">
			</div>
			<input type="button" value="提交 ">
			
		</form>
	</div>
</body>
<script type="text/javascript">
	$.ajaxSettings.async = false
	$(function(){
		$.post(
			"${ctx}/region/create.do",
			{regionId:0},
			function(region){
				for(let i in region){
					var data = region[i]
					$("select[name=provinceId]").append("<option value='"+data.regionId+"'>"+data.regionName+"</option>")
				}
				update()
			}
		)
	})
	
	function update(){
		$("select[name=cityId]").empty()
		let aim = $("select[name=provinceId]").val()
		$.post(
			"${ctx}/region/create.do",
			{regionId:aim},
			function(region){
				for(let i in region){
					var data = region[i]
					$("select[name=cityId]").append("<option value='"+data.regionId+"'>"+data.regionName+"</option>")
				}
				updateTo()
			}
		)
	}
	function updateTo(){
		$("select[name=countyId]").empty()
		let aim = $("select[name=cityId]").val()
		$.post(
			"${ctx}/region/create.do",
			{regionId:aim},
			function(region){
				for(let i in region){
					var data = region[i]
					$("select[name=countyId]").append("<option value='"+data.regionId+"'>"+data.regionName+"</option>")
				}
				hx()
			}
		)
	}
	
	$("input[type=button]").click(function(){
		$.post(
			"${ctx}/station/create.do",
			$("form").serialize(),
			function(obj){
				if(obj){
					alert("添加 成功")
					location.href='${ctx}/station/list.do'
				}else{
					alert("添加失败")
				}
			}
		)
	})
	function hx(){
		$.post(
			"${ctx}/station/update.do",
			{stationId:"${param.stationId}"},
			function(station){
				console.log(station)
				$("input[name=stationName]").val(station.stationName)
				$("select[name=provinceId]").append("<option selected>"+station.provinceName+"</option>")
				$("select[name=cityId]").append("<option selected>"+station.cityName+"</option>")
				$("select[name=countyId]").append("<option selected>"+station.countyName+"</option>")
				$("input[name=address]").val(station.address)
			}
		)
	}
	
</script>
</html>