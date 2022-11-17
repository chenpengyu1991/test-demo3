var healthEducationResourceRecordSearch = (function() {
	$(function() {
		$("#healthEducationResourceRecordSearchForm #contentType").multiselect({
			header : false,
			noneSelectedText : '请选择',
			selectedList : 4,
			minWidth : "auto"
		});

		var wgzx = $("#wgzx").val();
        if(wgzx == '04'){
			$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
		}

            /*健康教育记录查询*/
            $("#healthEducationResourceRecordSearchForm").onEnter(search, 1);
            $("#healthEducationResourceRecordBtnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
            });
            search(1);
            
            
            /*添加健康教育资源*/
        	$("#resourceRecordAdd").click(function() {
        		var type = $("#searchType").val();
        		var t = "";
        		// var h = 0;//设置高度弹出框滚动条会超框
        		if (type == 1) {
        			t = "添加宣传阵地使用情况";
        		} else if (type == 2) {
        			t = "添加健康资料发放情况";
        		}
        		/*var dialogParams = {
        				id : "healthEducationResourceRecord",
        				url : "/he/record/add/"+type,
        				// height : h,
        				width : 800,
        				title : t
        		};
        		$.dialog(dialogParams);*/
        		
        		$.post(contextPath+"/he/record/add/"+type,
        			function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'addHealthEducationResourceRecordDialog',
                			  area: ['800px', '500px'],
                			  title:t,
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
			return;
		} 
		var searchObj = {
			url : "/he/record/list/"+$("#searchType").val(),
			insertDiv : "healthEducationResourceRecordResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#healthEducationResourceRecordSearchForm").submitFormLoadHtml(searchObj);
	};

	function generateDialogTitle() {
		var type = $("#searchType").val();
		var t = "";
		if (type == 1) {
			t = "新增宣传阵地使用情况";
		} else if (type == 2) {
			t = "新增健康资料发放情况";
		}
		return t;
	}
	
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
	var type = $("#searchType").val();
	var t = "";
	// var h = 0;//设置高度弹出框滚动条会超框
	if (type == 1) {
		t = "添加宣传阵地使用情况";
	} else if (type == 2) {
		t = "添加健康资料发放情况";
	}

	添加健康教育资源
	$("#resourceRecordAdd").click(function() {
		var dialogParams = {
				id : "healthEducationResourceRecord",
				url : "/he/record/add/"+type,
				// height : h,
				width : 800,
				title : t
		};
		$.dialog(dialogParams);
	});
	

	//按钮样式切换 
	$("#healthEducationResourceRecordBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});*/