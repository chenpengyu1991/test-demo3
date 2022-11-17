define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDiv",search);
			search(1);
			$("#fsrFormId").onEnter(search, 1);
			$("#fsrSearchBut").click(function() {
				search(1);
			});
		});
	}

    function search(indexPage) {
		var url = contextPath + "/fsr/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : {indexPage : indexPage}
			 };
		$("#fsrFormId").formPost(searchObj);
	
	}
    return{
    	load: load
    };
});
