var healthEducationResourceSearch = (function() {
	$(function() {
		    var qwgzx = $("#qwgzx").val();
		    if(qwgzx == '04'){
				$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
			}
            /*健康教育资源查询*/
            $("#healthEducationResourceSearchForm").onEnter(search, 1);
            $("#healthEducationResourceBtnSearch").click(function(e) {
                e.preventDefault();
            	search(1);
            });
            search(1);
            
            /*添加健康教育资源*/
        	$("#resourceAdd").click(function(e) {
        		e.preventDefault();
        		debugger;
        		var type = $("#searchType").val();
        		var h = 350;
        		var t = "";
        		if (type == 1) {
        			t = "新增宣传设备";
        		} else if (type == 2) {
        			t = "新增宣传阵地";
        		} else if (type ==3) {
        			t = "新增宣传材料";
        			h = 280;
        		}
        		/*var dialogParams = {
        				id : "healthEducationResource",
        				url : "/he/resource/add/"+type,
        				height : h,
        				width : 900,
        				title : t
        		};
        		$.dialog(dialogParams);*/
        		
        		$.post(contextPath+"/he/resource/add/"+type,
                		{ indexPage : 1
        			     }, 
        			function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'healthEducationResourceDialog',
                			  area: ['900px', h],
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
			url : "/he/resource/list/"+$("#searchType").val(),
			insertDiv : "healthEducationResourceResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#healthEducationResourceSearchForm").submitFormLoadHtml(searchObj);
	}

	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	function editHealthEducationResource(id) {
		var type = $("#searchType").val();
		var h = 350;
		var t = "";
		if (type == 1) {
			t = "修改宣传设备";
		} else if (type == 2) {
			t = "修改宣传阵地";
		} else if (type ==3) {
			t = "修改宣传材料";
			h = 300;
		}
		
		$.post(contextPath+"/he/resource/edit/"+type,
	    		{ id : id
			     }, 
			function(ret){
	    	layui.use(['layer'], function() {
	    		  var layer = layui.layer
	    		  layer.open({
	    			  type: 1,
	    			  id:'healthEducationResourceEditDialog',
	    			  area: ['900px', h],
	    			  title:t,
	    			  content: ret
	    		  });
	    		});
	    	});
	}

	function deleteHealthEducationResource(id) {
		if (!id) {
			return;
		}
		
		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/he/resource/delete/"+id,
					callback : function(data) {
						if (data.result) {
							layer.close(index);
							healthEducationResourceSearch.search(1);
						} else {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
	}

	return {
        search : search,
        toggle:toggle,
        editHealthEducationResource:editHealthEducationResource,
        deleteHealthEducationResource:deleteHealthEducationResource
	};
})();

/*$(document).ready(function () {
	

	//按钮样式切换 
	$("#healthEducationResourceBtnSearch").hover( 
	function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});

*/