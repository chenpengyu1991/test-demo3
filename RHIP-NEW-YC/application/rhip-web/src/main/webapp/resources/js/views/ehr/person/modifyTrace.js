var modifyTracePagination = (function(){
	
	$(function() {
		modifyTraceSearch(1);
		
		$("#search_btn").bind("click",function(e){
			e.preventDefault();
			modifyTraceSearch(1);
		});
		
		document.onkeydown = function(e){
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	modifyTraceSearch(1);
		     }
		}
	});
	
	function modifyTraceSearch(indexPage) {
		var createBegin = new Date($("#inputBeginDate").val());
		var createEnd = new Date($("#inputEndDate").val());
		if (createBegin > createEnd) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			$("#inputBeginDate").val("");
			$("#inputEndDate").val("");
		} else {
			$("#form_search").submitFormLoadHtml({
	            url : contextPath + "/personRecord/viewModifyTrace",
	            insertDiv:"modifyTraces-result-content",
	            param:{
	            	inputBeginDate:$("#inputBeginDate").val(),
	            	inputEndDate:$("#inputEndDate").val(),
	            	regionType:$("input[name='regionType']:checked").val(),
	            	personId:$("#id_personId").val(),
	            	indexPage: indexPage
	            }
	        });
		}
	}
	
	return {
		pagination:modifyTraceSearch
	};
})();
	

	
	
	
	
	


