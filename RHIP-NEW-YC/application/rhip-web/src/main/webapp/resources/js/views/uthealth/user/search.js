define(function(){
	function load() {
		$(function(){
			//分页绑定函数
			pageUtil.bind("listDiv",search);
			$("#useSearchTableId").onEnter(search, 1);
			$("#userSearchBut").click(function() {
				search(1);
			});
			search(1);
		});
	}

    function search(pageIndex) {
		var url = contextPath + "/uthealth/user/list";
		var searchObj = {
			url : url,
			insertDiv : "listDiv",
			param : {pageIndex : pageIndex},
			callback: function() {
				initLinkClick("detail", userDetail, {userId: "data-user-id"});
			}
			 };
		$("#userFormId").formPost(searchObj);
	}
	function userDetail(userId) {
		$('#searchDiv').hide();
		$.loadHtmlByUrl({
			url : "/uthealth/user/detail",
			insertDiv :"detailDiv",
			param : {userId:userId}
		});
		$("#detailDiv").show();
	}

    return{
    	load: load
    };
});
