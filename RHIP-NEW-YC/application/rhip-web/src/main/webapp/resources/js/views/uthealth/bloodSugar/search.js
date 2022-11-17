define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDiv",search);
			search(1);
			$("#bloodSugarFormId").onEnter(search, 1);
			$("#SearchBt").click(function() {
				search(1);
			});
		});
	}

    function search(indexPage) {
		var url = contextPath + "/uthealth/bloodSugar/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : {pageIndex : indexPage}
			 };
		$("#bloodSugarFormId").formPost(searchObj);
	
	}
    return{
    	load: load
    };
});
