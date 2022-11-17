var healthEducationResourceMediaSearch = (function() {
	$(function() {
		    var qwgzx = $("#qwgzx").val();
		    if(qwgzx == '04'){
				$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
			}
            /*健康教育资源查询*/
            $("#healthEducationResourceMediaSearchForm").onEnter(search, 1);
            $("#healthEducationResourceMediaBtnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
            });
            search(1);
            
            
            /*添加健康教育资源*/
        	$("#resourceAdd").click(function(e) {
        		e.preventDefault();
        		/*var dialogParams = {
        				id : "healthEducationResourceMedia",
        				url : "/he/resource/media/add",
        				height : 350,
        				width : 900,
        				title : "新增影像播放信息"
        		};
        		$.dialog(dialogParams);*/
        		
        		$.post(contextPath+"/he/resource/media/add",
        			function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'addHealthEducationResourceMediaDialog',
                			  area: ['900px', '350px'],
                			  title:"新增影像播放信息",
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
			url : "/he/resource/media/list",
			insertDiv : "healthEducationResourceMediaResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#healthEducationResourceMediaSearchForm").submitFormLoadHtml(searchObj);
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
	添加健康教育资源
	$("#resourceAdd").click(function(e) {
		e.preventDefault();
		var dialogParams = {
				id : "healthEducationResourceMedia",
				url : "/he/resource/media/add",
				height : 350,
				width : 900,
				title : "新增影像播放信息"
		};
		$.dialog(dialogParams);
	});
	

	//按钮样式切换 
	$("#healthEducationResourceMediaBtnSearch").hover(
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	);
});*/