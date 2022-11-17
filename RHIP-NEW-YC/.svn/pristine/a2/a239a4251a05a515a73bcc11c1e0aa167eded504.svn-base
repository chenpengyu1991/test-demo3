var mainPage = (function() {
	$(function() {
		$("#per_search_btn").click(function(e) {
			e.preventDefault();//防止整个页面刷新
			recordsPerform(1);
		});
		$("#enterpriseBtnSearch").onEnter(recordsPerform, 1);
		document.onkeydown = function (e) {
			var theEvent = window.event || e;
			var code = theEvent.keyCode || theEvent.which;
			if (code == 13) {
				recordsPerform(1);
			}
		};
		recordsPerform(1);
	});
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	
	function addRecord(){
		$.post(contextPath+"/oh/radiologicalProtectionReport/hospitalInfo/edit",
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'hospitalInfoEdit',
						area: ['650px', '400px'],
						title:"添加医院信息",
						content: ret
					});
				});
			});
	}

	function recordsPerform(indexPage) {
		var createBegin = new Date($("#startDate").val());
		var createEnd = new Date($("#endDate").val());

		if (createBegin > createEnd) {
			layui.alert("开始时间不能大于结束时间");
		} else {
			var searchObj = {
				url : "/oh/radiologicalProtectionReport/hospitalInfoRecords",
				insertDiv : "info_records",
				param : {
					indexPage : indexPage
				}
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}
	return {
		addRecord : addRecord,
		search : recordsPerform,
		toggle : toggle
	};
})();
