var healthEducationSupervisorSearch = (function() {
	$(function() {
		var wgzx = $("#wgzx").val();
		if(wgzx == '04'){
			$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
		}

            /*健康督查查询*/
            $("#healthEducationSupervisorSearchForm").onEnter(search, 1);
            $("#healthEducationSupervisorBtnSearch").click(function() {
                search(1);
            });
            search(1);
	});

	function search(indexPage) { 
		var createBeginTime = new Date($("#createBeginTime").val());
		var createEndTime = new Date($("#createEndTime").val());

		if (createBeginTime > createEndTime) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return;
		} 
		var searchObj = {
			url : "/he/supervisor/list",
			insertDiv : "healthEducationSupervisorResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#healthEducationSupervisorSearchForm").submitFormLoadHtml(searchObj);
	};

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	return {
        search : search,
        toggle:toggle
	};
})();

$(document).ready(function () {
	/*添加健康教育活动*/
	$("#supervisorAdd").click(function() {
		var dialogParams = {
				id : "healthEducationSupervisor",
				url : "/he/supervisor/add",
				height : 370,
				width : 800,
				title : "新增工作督查信息"
		};
		$.dialog(dialogParams);
	});
	

	//按钮样式切换 
	$("#healthEducationSupervisorBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});