$.ajax({
	type : "GET",
	contentType : "application/json;charset=UTF-8",
	url : ctx + "/report/departmentApply.do",
	success : function(departmentApply) {
	let departmentNameData = []
	let roleDetail = []	

		for (let departmentName in departmentApply) {
			departmentNameData.push(departmentName)
			roleDetail.push({
				name:departmentName,
				value:departmentApply[departmentName]
			})
			console.log(roleDetail)
		}
		option = {
		    title: {
		        text: '公司部门人员统计',
		        left: 'center'
		    },
		    tooltip: {
		        trigger: 'item',
		        formatter: '{a} <br/>{b} : {c}人，占百分比 ({d}%)'
		    },
		    legend: {
		        left: 'center',
		        top: 'bottom',
		        data: roleDetail
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            mark: {show: true},
		            dataView: {show: true, readOnly: false},
		            magicType: {
		                show: true,
		                type: ['pie', 'funnel']
		            },
		            restore: {show: true},
		            saveAsImage: {show: true}
		        }
		    },
		    series: [
		        {
		            name: '',
		            type: 'pie',
		            radius: [20, 110],
		            center: ['25%', '50%'],
		            roseType: 'radius',
		            label: {
		                show: false
		            },
		            emphasis: {
		                label: {
		                    show: true
		                }
		            },
		            data:roleDetail
		        },
		      
		    ]
		};
		echarts.init(document.getElementById('departmentPieDiagramChar')).setOption(option);
	},
	error : function(err) {
		alert("请求失败")
	}
})
		
		















