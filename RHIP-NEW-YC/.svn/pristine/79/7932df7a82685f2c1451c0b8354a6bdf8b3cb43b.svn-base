var echIdenList = (function ()
{
	$(function ()
	{
		search(1);

		$('input').keypress(function (e)
		{
			var key = e.which;
			if (key == 13){
				search(1);
			}
		});
		
		$("#ech-person-phyexam-result-box").on("click", ".view-link", initReport);

		$("#ech-person-phyexam-result-box").on("click", ".edit-link", initReport);

		$("#ech-person-phyexam-result-box").on("click", ".delete-link", deleteEch);

		$("#ech-person-phyexam-list-back-btn").on("click", function ()
		{
			$("#ech-manage-input-box").hide();
	        $("#ech-manage-list-box").show();
	        if (changed && echIdenList && $.isFunction(echIdenList.refresh)) {
	        	echIdenList.refresh();
	        }
		});

		$("#ech-person-phyexam-list-add-btn").on("click", initReport);

	});

	function deleteEch(){
		var id = $(this).data("id");
		layer.confirm("确认删除？", {icon:2, title:'确认提示'}, function(index) {
			$.getJsonByUrl({
				url: "/ech/manage/report/deleteReport",
				param: {id: id},
				callback: function (data) {
					layer.alert(data.message, {icon:0,title:'提示'});
					search(1);
					echManageSearch.manageSearch(1);
				}
			});
			layer.close(index);
		});
	}



//	function phyInput(event)
//	{
//		event.preventDefault();
//		$("#ech-person-phyexam-list-box").hide();
//		$("#ech-person-phyexam-input-box").show();
//		var loadHtmlByUrlOption = {
//			url: "/cdm/standardization/phyExamination/add",
//			insertDiv: "ech-person-phyexam-input-box"
//		};
//		$.loadHtmlByUrl(loadHtmlByUrlOption);
//	}

	var currentPage=1;
    var changed=false;

	function refresh(){
		search(currentPage);
        changed=true;
	}

	function search(indexPage)
	{
		currentPage=indexPage;
		var personId = $("#ech-perphyexam-list-personid-input").val();
		if (!personId){
			return;
		}
			
		var searchObj = {
			url: "/ech/manage/perEchResult",
			insertDiv: "ech-person-phyexam-result-box",
			param: {
				indexPage: indexPage,
				personId: personId
			}
		};
		$.loadHtmlByUrl(searchObj);
	}

    /**
     * 初始化记录表页面
     */
	function initReport() {
		var id = $(this).data("id");
		var personId = $(this).data("personid");
		var type = $(this).data("type");
		$("#ech-person-phyexam-list-box").hide();
		$("#ech-person-phyexam-input-box").show();

		var loadHtmlByUrlOption = {
			url: '/ech/manage/report/init',
			insertDiv: "ech-person-phyexam-input-box",
			param: {personId:personId, id: id, editflag: type,sourceFlag:"1"}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	return {
		search: search,
        refresh:refresh
	};
})();