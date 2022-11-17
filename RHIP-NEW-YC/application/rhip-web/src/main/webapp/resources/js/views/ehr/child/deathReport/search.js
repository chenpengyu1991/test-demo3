var deathMedicineCertificateSearch = (function() {
	$(function(){
		//$("#searchForm").onEnter(search, 1);
		search(1);
		$("#btnSearch").click(function(e) {
                e.preventDefault();
			search(1);
		});
		$("#childDeathAdd").click(function(){
			edit("");
		});
		
		$('#child-death-search-toggle-btn').click(function() {
            $(this).toggleClass("ico-top");
            $(this).toggleClass("ico-bottom");
            $("#child-death-search-table").toggle();
        })
	});
	
    function search(indexPage) {
		var url = "/childDeathReport/list";
		var searchObj = {
			 url : url,
			 insertDiv : "resultDiv",
			 param : {indexPage : indexPage}
		 };
		$("#searchForm").formPost(searchObj);
	}

	/*function view(id){
		var dialog = {
			url : "/childDeathReport/view",
			param : {id:id},
			height : 570,
			width : 800,
			title : "儿童死亡报告卡",
			id :"dialog"
		};
		$.dialog(dialog);
	}*/
    // 查看儿童死亡报告卡
    function view(id){
    	$("#childDeathListDiv").hide();
        $("#childDeathDiv").show();
        var loadHtmlByUrlOption = {
            url: "/childDeathReport/view",
            insertDiv: "childDeathDiv",
            param: {
                id: id
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    // 打开编辑页面
    function edit(id){
    	$("#childDeathListDiv").hide();
        $("#childDeathDiv").show();
        var loadHtmlByUrlOption = {
            url: "/childDeathReport/edit",
            insertDiv: "childDeathDiv",
            param: {
                id: id
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }
	
    // 删除
    function deleteChild(id) {
    	layer.confirm("确定要删除吗？", {icon:2, title:'确认提示'}, function(index){
			$.getJsonByUrl({
				url:"/childDeathReport/delete",
				param:{
					id:id
				},
				callback:function(data){
					if(data == "删除成功!"){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index){
							$("#btnSearch").click();
							layer.close(index);
						});
					}else{
						layer.alert("删除失败！", {icon:0,title:'提示'});
					}
				}
			});
			layer.close(index);
		});
    }
    
	return {
		search : search,
		view : view,
		edit : edit,
		deleteChild : deleteChild
	};
})();