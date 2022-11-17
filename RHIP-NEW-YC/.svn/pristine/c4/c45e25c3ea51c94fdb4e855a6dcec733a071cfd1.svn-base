var healthPromoteUnitDetail = (function() {
	
	function viewHealthPromoteUnit(id) {
		
		/*var dialogParams = {
				id : "healthPromoteUnit",
				url : "/he/promoteunit/detail/"+id,
				height : 235,
				width : 500,
				title : "查看健康促进单位"
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/promoteunit/detail/"+id,
				{id : id},
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'viewHealthPromoteUnitDialog',
		    			  area: ['500px', '235px'],
		    			  title:"查看健康促进单位",
		    			  content: ret
		    		  });
		    		});
		    	});
	}

	return {
		viewHealthPromoteUnit : viewHealthPromoteUnit
	};
})();
