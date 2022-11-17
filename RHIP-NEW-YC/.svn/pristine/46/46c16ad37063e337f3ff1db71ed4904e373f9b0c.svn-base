var healthEducationResourceDetail = (function() {
	
	function viewHealthEducationResource(id) {
		var type = $("#searchType").val();
		var t = "";
		var h = 350;
		if (type == 1) {
			t = "查看宣传设备";
		} else if (type == 2) {
			t = "查看宣传阵地";
		} else if (type == 3) {
			t = "查看宣传材料";
			h = 280;
		}
		
		/*查看健康教育资源*/
		/*var dialogParams = {
				id : "healthEducationResource",
				url : "/he/resource/detail/"+type,
				param : {
					id : id
				},
				height : h,
				width : 900,
				title : t
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/resource/detail/"+type,
        		{ id : id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'viewHealthEducationResourceDialog',
        			  area: ['900px', h],
        			  title:t,
        			  content: ret
        		  });
        		});
        	});
	}

	return {
		viewHealthEducationResource : viewHealthEducationResource
	};
})();
