define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDiv",search);
			search(1);
			$("#ohtFormId").onEnter(search, 1);
			$("#ohtSearchBut").click(function() {
				search(1);
			});
		});
	}

    function search(indexPage) {
		var url = contextPath + "/oht/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : {indexPage : indexPage}
			 };
		$("#ohtFormId").formPost(searchObj);
	
	}
    return{
    	load: load
    };
});
