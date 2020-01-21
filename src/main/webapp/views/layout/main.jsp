<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${ctx}/static/plugins/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/static/css/style.css" rel="stylesheet">
<script src="${ctx}/static/plugins/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript">
	//通过Iframe的title设置当前窗口的标题
	function iframeLoad() {
		document.title = this.contentDocument.title;
	}

	$(function() {
		$("iframe[name=myIframe]").attr("src",
				$("a[target=myIframe]:first").attr("href"));

		var iframe = $("iframe[name=myIframe]")[0];
		if (iframe.attachEvent) {
			iframe.attachEvent("onload", iframeLoad);
		} else {
			iframe.onload = iframeLoad;
		}

	})
</script>
</head>
<body>
	<div>
		<nav>
			<div class="container">
				<div class="pull-left col-md-10 text-left">
					<h3>销售管理系统</h3>
				</div>
				<div class="pull-right col-md-2" id="userModel">
					欢迎：${currentUser.userName}&nbsp;&nbsp;<a href="${ctx}/views/user/login.jsp"
						style="color: white; font-size: 12px">退出登录</a>
				</div>
			</div>

		</nav>
		<div class="container">
			<div class="row">
				<div class="col-md-2 pull-left text-center left">
					<div class="row">
						<a href="${ctx}/user/list/page.do" target="myIframe">人员管理</a>
					</div>
					<div class="row">
						<a href="${ctx}/role/list/page.do" target="myIframe">角色管理</a>
					</div>
					<div class="row">
						<a href="${ctx}/department/list/page.do" target="myIframe">部门管理</a>
					</div>
					<div class="row">
						<a href="${ctx}/device/list/page.do" target="myIframe">设备管理</a>
					</div>
					<div class="row">
						<a href="${ctx}/station/list/page.do" target="myIframe">服务网点</a>
					</div>
					<div class="row">
						<a href="${ctx}/saleDevice/list/page.do" target="myIframe">设备销售</a>
					</div>
					<div class="row">
						<a href="${ctx}/page/report/baseReport.do" target="_block">基础报表</a>
					</div>
				</div>
				<div class="col-md-9 pull-left right">
					<iframe name="myIframe" class="col-md-12"></iframe>
				</div>
			</div>

		</div>
	</div>
</body>

</html>