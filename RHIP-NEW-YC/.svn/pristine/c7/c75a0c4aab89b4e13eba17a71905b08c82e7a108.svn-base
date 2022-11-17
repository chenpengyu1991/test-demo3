define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDiv",search);
			search(1);
			$("#baFormId").onEnter(search, 1);
			$("#baSearchBut").click(function() {
				search(1);
			});
		});
	}

    function search(indexPage) {
		var url = contextPath + "/ba/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : {indexPage : indexPage}
			 };
		$("#baFormId").formPost(searchObj);
	
	}
    return{
    	load: load
    };
});
