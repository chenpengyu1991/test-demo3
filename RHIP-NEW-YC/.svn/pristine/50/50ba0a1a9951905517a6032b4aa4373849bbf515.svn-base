var cmdPersonPhyExaminationList = (function ()
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

		$("#cdm-person-phyexam-result-box").on("click", ".view-link", view);

		$("#cdm-person-phyexam-result-box").on("click", ".edit-link", edit);

		$("#cdm-person-phyexam-result-box").on("click", ".delete-link", deleteExam);

		$("#cdm-person-phyexam-list-back-btn").on("click", function (e)
		{
			e.preventDefault();
			back();
		});

		$("#cdm-person-phyexam-list-add-btn").on("click", function (e)
		{
			e.preventDefault();
			add();
		});

	});

    function back() {
        $("#cdm-manage-input-box").hide();
        $("#cdm-manage-list-box").show();
        if (changed&&cmdPhyExaminationList && $.isFunction(cmdPhyExaminationList.refresh)) {
            cmdPhyExaminationList.refresh();
        }
    }

	function add()
	{
		var personId = $("#cdm-perphyexam-list-personid-input").val();
		if (!personId){
			return;
		}
		$("#cdm-person-phyexam-list-box").hide();
		$("#cdm-person-phyexam-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/cdm/standardization/phyExamination/add",
			insertDiv: "cdm-person-phyexam-input-box",
			param: {personId: personId}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function edit()
	{
		var personId = $(this).data("personid");
		var ehrId = $(this).data("ehrid");
		$("#cdm-person-phyexam-list-box").hide();
		$("#cdm-person-phyexam-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/cdm/standardization/phyExamination/edit",
			insertDiv: "cdm-person-phyexam-input-box",
			param: {personId: personId, ehrId: ehrId,editFlag:'edit'}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function view()
	{
		var personId = $(this).data("personid");
		var ehrId = $(this).data("ehrid");
		$("#cdm-person-phyexam-list-box").hide();
		$("#cdm-person-phyexam-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/cdm/standardization/phyExamination/view",
			insertDiv: "cdm-person-phyexam-input-box",
			param: {personId: personId, ehrId: ehrId}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function deleteExam()
	{

		var personId = $(this).data("personid");
		var ehrId = $(this).data("ehrid");
		if(personId&&ehrId){
			var index = layer.confirm("确认删除？", function() {
				$("#cdm-person-phyexam-form").submitFormGetJson({
					url : "/cdm/standardization/phyExamination/delete",
					param: {personId: personId, ehrId: ehrId},
					wait : true,
					callback : function(data)
					{
						var layer = layui.layer;
						if (data == true)
						{
							layer.alert("删除成功！", {icon:0,title:'提示'});
                            refresh();
						} else
						{
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
		$("#cdm-person-phyexam-list-box").hide();
		$("#cdm-person-phyexam-input-box").show();
		var loadHtmlByUrlOption = {
			url: "/cdm/standardization/phyExamination/add",
			insertDiv: "cdm-person-phyexam-input-box"
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
		var personId = $("#cdm-perphyexam-list-personid-input").val();
		if (!personId){
			return;
		}
		var searchObj = {
			url: "/cdm/standardization/phyExamination/perPhyResult",
			insertDiv: "cdm-person-phyexam-result-box",
			param: {
				indexPage: indexPage,
				personId: personId
			}
		};
		$("#cdm-person-phyexam-form").submitFormLoadHtml(searchObj);
	}


	return {
		search: search,
        refresh:refresh
	};
})();