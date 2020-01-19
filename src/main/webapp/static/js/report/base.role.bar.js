// 请求数据，加载柱状图图
$.ajax({
	// 请求方式
	type : "GET",
	// 请求的媒体类型
	contentType : "application/json;charset=UTF-8",
	// 请求地址
	url : ctx + "/report/roleUser/data.do",
	// 数据，json字符串
	// data : JSON.stringify(list),
	// 请求成功
	success : function(roleData) {
		console.info(roleData)

		let roles = [];
		let roleUsers = [];
		for ( let roleName in roleData) {
			roles.push(roleName);
			roleUsers.push(roleData[roleName]);
		}

		var option = {
			color : [ '#3398DB' ],
			title : {
				text : '系统角色统计',
				// subtext : '纯属虚构',
				left : 'center'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : roles,
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '人员个数',
				type : 'bar',
				barWidth : '60%',
				data : roleUsers
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		echarts.init(document.getElementById('roleBarChar')).setOption(option);
	},

	error : function(err) {// 请求失败，包含具体的错误信息
		throw err;
	}
});
