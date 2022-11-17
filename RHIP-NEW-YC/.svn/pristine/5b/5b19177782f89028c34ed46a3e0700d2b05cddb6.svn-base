var epSamplingList = (function() {

	function del(obj, year, gbCode) {
		var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/ep/iodate/deleteSamplingRecord",
				param : {
					year : year,
					gbCode : gbCode
				},
				callback : submitCallback
			};
			//$(obj).html(loadingSource);
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}

	function detail(year, gbCode) {
		$.post(contextPath+"/ep/iodate/viewSamplingRecord",
			{
				year : year,
				gbCode : gbCode
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'viewSamplingDialog',
						area: ['400px', '300px'],
						title:"碘盐监测抽样登记",
						content: ret
					});
				});
			});
	}

	function submitCallback(result) {
		layer.alert(result.message, {icon:0,title:'提示'}, function(index){
			if (result.success) {
				epSamplingSearch.search($("#indexPage").val());
			}
			layer.close(index);
		});
	}

	return {
		detail : detail,
		del : del
	}
})();