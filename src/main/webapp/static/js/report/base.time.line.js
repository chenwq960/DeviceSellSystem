
// 请求数据，加载柱状图图
$.ajax({
	// 请求方式
	type : "GET",
	// 请求的媒体类型
	contentType : "application/json;charset=UTF-8",
	// 请求地址
	url : ctx + "/report/userCreateTime.do",
	success : function(userCreateTIme) {
		
		option = {
				title : {
					text : '系统人员创建时间',
					left : 'center'
				},
				xAxis : {
					type : 'category',
					data : [ 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun' ]
				},
				yAxis : {
					type : 'value'
				},
				series : [ {
					data : [ 820, 932, 901, 934, 1290, 1330, 1320 ],
					type : 'line'
				} ]
			};

		echarts.init(document.getElementById('userCreateTimeLine')).setOption(option);
	},
	error:function(err){
		throw err//抛异常
		}
	})
