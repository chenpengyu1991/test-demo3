var hmPersonPhyExaminationList = (function ()
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

		$("#hm-person-phyexam-result-box").on("click", ".view-link", view);

		$("#hm-person-phyexam-result-box").on("click", ".edit-link", edit);

		$("#hm-person-phyexam-result-box").on("click", ".delete-link", deleteExam);

		$("#hm-person-phyexam-list-back-btn").on("click", function (e){
			e.preventDefault();
			back();
		});

		$("#hm-person-phyexam-list-add-btn").on("click", add);

	});

    function back() {
        $("#hm-manage-input-box").hide();
        $("#hm-manage-list-box").show();
        if (changed && hmPersonPhyExaminationList && $.isFunction(hmPersonPhyExaminationList.refresh)) {
        	hmPersonPhyExaminationList.refresh();
        }
        //hmManageSearch..refresh();
        if (!changed && hmManageSearch) {
        	hmManageSearch.search(1);
        }
    }

	function add()
	{
		var personId = $("#hm-perphyexam-list-personid-input").val();
		if (!personId){
			return;
		}
		$("#hm-person-phyexam-list-box").hide();
		$("#hm-person-phyexam-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/hm/manage/edit",
			insertDiv: "hm-person-phyexam-input-box",
			param: {personId: personId}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function edit()
	{
		var personId = $(this).data("personid");
		var ehrId = $(this).data("ehrid");
		$("#hm-person-phyexam-list-box").hide();
		$("#hm-person-phyexam-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/hm/manage/edit",
			insertDiv: "hm-person-phyexam-input-box",
			param: {personId: personId, ehrId: ehrId,editFlag:'edit'}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function view()
	{
		var personId = $(this).data("personid");
		var ehrId = $(this).data("ehrid");
		$("#hm-person-phyexam-list-box").hide();
		$("#hm-person-phyexam-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/hm/manage/view",
			insertDiv: "hm-person-phyexam-input-box",
			param: {personId: personId, ehrId: ehrId,status:"1"}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function deleteExam()
	{
		var personId = $(this).data("personid");
		var ehrId = $(this).data("ehrid");
		var physicalexamcode = $(this).attr('data-physicalexamcode');
		if(personId && ehrId && physicalexamcode){
			layer.confirm("确认删除？", {icon:2, title:'确认提示'}, function(index) {
				$("#hm-person-phyexam-form").submitFormGetJson({
					url : "/hm/manage/delete",
					param: {personId: personId, ehrId: ehrId, physicalExamCode:physicalexamcode},
					wait : true,
					callback : function(data){
						if (data == 'success'){
							layer.alert("删除成功！", {icon:0,title:'提示'});
                            refresh();
						} else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
				layer.close(index);
			});

		}
	}



	function phyInput(event)
	{
		event.preventDefault();
		$("#hm-person-phyexam-list-box").hide();
		$("#hm-person-phyexam-input-box").show();
		var loadHtmlByUrlOption = {
			url: "/cdm/standardization/phyExamination/add",
			insertDiv: "hm-person-phyexam-input-box"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	var currentPage=1;

    var changed=false;

	function refresh(){
		search(currentPage);
        changed=true;
	}

	function search(indexPage)
	{
		currentPage=indexPage;
		var personId = $("#hm-perphyexam-list-personid-input").val();
		if (!personId){
			return;
		}
		var searchObj = {
			url: "/hm/manage/perPhyResult",
			insertDiv: "hm-person-phyexam-result-box",
			param: {
				indexPage: indexPage,
				personId: personId
			}
		};
		$("#hm-person-phyexam-form").submitFormLoadHtml(searchObj);
	}


	return {
		search: search,
        refresh:refresh
	};
})();