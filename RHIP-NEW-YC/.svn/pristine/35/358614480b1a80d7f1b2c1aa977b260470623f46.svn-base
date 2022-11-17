var healthPromoteUnitSearch = (function() {
	$(function() {
		$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
            /*健康促进单位查询*/
            $("#healthPromoteUnitSearchForm").onEnter(search, 1);
            $("#healthPromoteUnitBtnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
            });
            search(1);
            
            $("#promoteUnitAdd").click(function(e) {
            	e.preventDefault();
        		/*var dialogParams = {
        				id : "healthPromoteUnit",
        				url : "/he/promoteunit/add",
        				height : 230,
        				width : 600,
        				title : "新增健康促进单位"
        		};
        		$.dialog(dialogParams);*/
        		
        		$.post(contextPath+"/he/promoteunit/add",
        				function(ret){
        		    	layui.use(['layer'], function() {
        		    		  var layer = layui.layer
        		    		  layer.open({
        		    			  type: 1,
        		    			  id:'addHealthPromoteUnitDialog',
        		    			  area: ['600px', '300px'],
        		    			  title:"新增健康促进单位",
        		    			  content: ret
        		    		  });
        		    		});
        		    	});
        	});
	});

	function search(indexPage) { 
		var createBeginTime = new Date($("#createBeginTime").val());
		var createEndTime = new Date($("#createEndTime").val());

		if (createBeginTime > createEndTime) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("开始时间不能大于结束时间");*/
			return;
		} 
		var searchObj = {
			url : "/he/promoteunit/list",
			insertDiv : "healthPromoteUnitResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#healthPromoteUnitSearchForm").submitFormLoadHtml(searchObj);
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

/*$(document).ready(function () {
	添加健康教育活动
	$("#promoteUnitAdd").click(function() {
		var dialogParams = {
				id : "healthPromoteUnit",
				url : "/he/promoteunit/add",
				height : 230,
				width : 600,
				title : "新增健康促进单位"
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

	});*/