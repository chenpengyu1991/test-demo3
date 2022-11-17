var cmdPhyExaminationList=(function()
{
	$(function()
	{
		search(1);

		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

		$('input').keypress(function(e)
		{
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});

		$("#idCard").keyup(function()
		{
			var idCardValue = $("#idCard").val();
			$("#idCard").attr("value", idCardValue.toUpperCase());
		});

		$("#per_search_btn").click(function(e)
		{
			e.preventDefault();
			search(1);
		});
		// 查看管理卡信息
		$("#diseaseInfo").on("click", ".report-link", viewCard);
		
		// 查看管理卡信息
		$("#diseaseInfo").on("click", ".phy-link", personPhyList);
		$("#diseaseInfo").on("click", ".add-link", add);

		$("#health-card-search-toggle-btn").on("click", toggle);

		$("select[multiple]").each(function()
		{
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择患病类型',
				selectedList : 13
			});
		});

        $("#phy-export-btn").click(function (e) {
            e.preventDefault();
        	exportList();
        });
        $("input[name='phyExamType']").click(function () {
        	var val = $("input[name='phyExamType']:checked").val();
			if(val != ""){
				$("#dt1").show();
				$("#dt2").show();
			}else {
				$("#dt1").hide();
				$("#dt2").hide();
			}
        });
	});

	function toggle()
	{
		$(this).toggleClass("ico-top");
		$(this).toggleClass("ico-bottom");
		$("#health-card-search-table").toggle();
	}

	function viewCard(event)
	{
		event.preventDefault();
		$("#cdm-manage-list-box").hide();
		$("#cdm-manage-input-box").show();
		var loadHtmlByUrlOption = {
			url : "/cdm/standardization/view/" + $(this).data("disid"),
			insertDiv : "cdm-manage-input-box"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	function personPhyList(event){
		event.preventDefault();
		var personId=$(this).data("personid");
		if(!personId){
			return;
		}
		$("#cdm-manage-list-box").hide();
		$("#cdm-manage-input-box").show();
		var loadHtmlByUrlOption = {
			url : "/cdm/standardization/phyExamination/perPhyList",
			insertDiv : "cdm-manage-input-box",
			param:{personId:personId}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function add(event)
	{
		event.preventDefault();
		var personId=$(this).data("personid");
		if (!personId){
			return;
		}
		$("#cdm-manage-list-box").hide();
		$("#cdm-manage-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/cdm/standardization/phyExamination/addPhy",
			insertDiv: "cdm-manage-input-box",
			param: {personId: personId}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function checkAge()
	{
		var startAge = $("#startAge").val();
		if (!isNumber(startAge))
		{
			$("#startAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		var endAge = $("#endAge").val();
		if (!isNumber(endAge))
		{
			$("#endAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		if (startAge && endAge && Number(startAge) > Number(endAge))
		{
			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	function isNumber(val)
	{
		if (val)
		{
			return val.match(/(\d+)|(^(\d+.\d+)$)/);
		}
		return true;
	}

    var currentIndexPage=1;

	function search(indexPage)
	{
		var validate = $("#form_search").easyValidate();
		var result = validate.validateForm();
		if (!result){
			return;
		}
        currentIndexPage=indexPage;
		if (!checkAge()){
			return;
		}
		var searchObj = {
			url : "/cdm/standardization/phyExamination/result",
			insertDiv : "diseaseInfo",
			param : {
				pageIndex : indexPage
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}

    function refresh(){
        search(currentIndexPage);
    }

    function exportList() {
        var option = {
            url: "/cdm/standardization/phyExamination/excel"
        };
        $("#form_search").exportListExcel(option);

    }
	return {
		search : search,
		showList : showList,
        refresh:refresh
	};
})();