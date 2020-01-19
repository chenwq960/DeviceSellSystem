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

		let legendData = [];
		let seriesData = [];
		var selected = {};
		for ( let roleName in roleData) {
			legendData.push(roleName);
			seriesData.push({
				name : roleName,
				value : roleData[roleName],
			});

			selected[roleName] = true;
		}

		var option = {
			title : {
				text : '系统角色统计',
				// subtext : '纯属虚构',
				left : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : '{a} <br/>{b} : {c}人  ({d}%)'
			},
			legend : {
				type : 'scroll',
				orient : 'vertical',
				right : 10,
				top : 20,
				bottom : 20,
				data : legendData,

				selected : selected
			},
			series : [ {
				name : '角色',
				type : 'pie',
				radius : '55%',
				center : [ '40%', '50%' ],
				data : seriesData,
				emphasis : {
					itemStyle : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		echarts.init(document.getElementById('rolePieChar')).setOption(option);
	},

	error : function(err) {// 请求失败，包含具体的错误信息
		throw err;
	}
});
