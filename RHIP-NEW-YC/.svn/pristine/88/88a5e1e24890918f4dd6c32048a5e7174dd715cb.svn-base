var healthEducationResourceRecordDetail = (function() {
	
	function viewHealthEducationResourceRecord(id) {
		var type = $("#searchType").val();
		var t = "";
		var h = 300;
		if (type == 1) {
			t = "查看宣传阵地使用情况";
		} else if (type == 2) {
			t = "查看健康资料发放情况";
		}
		
		/*查看健康教育资源记录*/
		/*var dialogParams = {
				id : "healthEducationResourceRecord",
				url : "/he/record/detail/"+type,
				param : {
					id : id
				},
				height : h,
				width : 800,
				title : t
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/record/detail/"+type,
        		{ id : id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'viewhealthEducationResourceDialog',
        			  area: ['800px', h],
        			  title:t,
        			  content: ret
        		  });
        		});
        	});
	}

	return {
		viewHealthEducationResourceRecord : viewHealthEducationResourceRecord
	};
})();
