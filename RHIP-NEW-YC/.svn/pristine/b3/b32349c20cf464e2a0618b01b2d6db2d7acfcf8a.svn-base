var epSamplingSearch = (function() {
	$(function() {
		$("#addBtn").click(function() {
			edit("add");
		});
		$("#searchBtn").click(function(e) {
			e.preventDefault();//防止整个页面刷新
			search(1);
		});
		$("#searchForm").onEnter(search, 1);
		search(1);
	});

	function search(indexPage) {
		var option = {
			url : "/ep/iodate/samplingList",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(option);
	}

	function edit(type, year, gbCode) {
		var title;
		if (type == "add") {
			title = "新建碘盐监测抽样登记";
		} else {
			title = "修改碘盐监测抽样登记";
		}
		$.post(contextPath+"/ep/iodate/editSamplingRecord",
			{
				year : year,
				gbCode : gbCode
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'editSamplingDialog',
						area: ['500px', '360px'],
						title:title,
						content: ret
					});
				});
			});
	}

	return {
		search : search,
		edit : edit
	}
})();