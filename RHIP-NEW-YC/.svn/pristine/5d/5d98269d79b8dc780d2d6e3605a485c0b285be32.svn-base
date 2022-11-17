var readRecordJS = (function(){
	
	$(function() {
		readRecordSearch(1);

		$("#readRecordBtn").on("click", function(e){
			e.preventDefault();
			readRecordSearch(1);
		});
	});
	
	function readRecordSearch(indexPage){
		var startDate=$("#beginDate").val();
		var endDate=$("#endDate").val();
		if(startDate && endDate && new Date(startDate) > new Date(endDate)){
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			return;
		}
		$("#readRecordForm").submitFormLoadHtml({
            url : "/personRecord/readRecordList",
            insertDiv : "readRecord-result-content",
            param:{
                indexPage: indexPage
            }
        });
	}
	
	return {
		pagination : readRecordSearch
	};
})();