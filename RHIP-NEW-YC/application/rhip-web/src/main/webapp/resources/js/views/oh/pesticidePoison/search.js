var mainPage = (function() {
	$(function() {
		$("#per_search_btn").click(function(e) {
			e.preventDefault();//防止整个页面刷新
			recordsPerform(1);
		});
		$("#form_search").onEnter(function() {
			recordsPerform(1);
		});
   		recordsPerform(1);
	});
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	
	function add(){
		$.post(contextPath+"/oh/poisonReport/edit",
			{
				operationType : '3'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'editDialog',
						area: ['900px', '490px'],
						title:"农药中毒报告",
						content: ret
					});
				});
			});

	}

	function recordsPerform(indexPage) {
		var createBegin = new Date($("#startDate").val());
		var createEnd = new Date($("#endDate").val());

		if (createBegin > createEnd) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
		} else {
			var searchObj = {
				url : "/oh/poisonReport/records",
				insertDiv : "info_records",
				param : {
					indexPage : indexPage
				},
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}
	function test(){
		var option = {
				url : "/oh/poisonReport/test",
				callback : function(data){
					alert(data[1].id);
				}
		};
		$.loadHtmlByUrl(option);
	}
	return {
		add : add,
		search : recordsPerform,
		test:test,
		toggle : toggle
	};
})();
