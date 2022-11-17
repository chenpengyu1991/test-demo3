define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDiv",search);
			search(1);
			$("#waterOilFormId").onEnter(search, 1);
			$("#waterOilSearchBut").click(function() {
				search(1);
			});
		});
	}

    function search(indexPage) {
		var url = contextPath + "/waterOil/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : {indexPage : indexPage}
			 };
		$("#waterOilFormId").formPost(searchObj);
	
	}
    return{
    	load: load
    };
});
