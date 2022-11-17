var ismReportCardList = (function()
{
	var lastPageIndex = 1;
	$(function()
	{
		// 添加回车监听事件
		$('input').keypress(function(e)
		{
			var key = e.which;
			if (key == 13)
			{
				searchReportList(1);
			}
		});

		$("#slideTable").on("click", function(event)
		{
			toggle(this, 'searchTable');
		});

		$("#reportCard_search_btn").on("click", function(event)
		{
			searchReportList(1);
		});


		$("#idCard").keyup(function()
		{
			var idCardValue = $("#idCard").val();
			$("#idCard").attr("value", idCardValue.toUpperCase());
		});
		
		
		// 查看报卡
		$("#list_datagrid").on("click", ".report-link", viewReport);

		//审核报卡
		$("#list_datagrid").on("click", ".app-report-link", appReport);
		
		
		searchReportList(1);

	});
	
	function viewReport(event)
	{
		event.preventDefault();
		var $this=$(this);
		var id =$this.data("id");
		if(!id){
			layer.alert("数据错误！", {icon:0,title:'提示'});
			return;
		}
		var url = "/ism/reportCard/view/"+id;
		var loadHtmlByUrlOption = {
			url : url,
			insertDiv : "input_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#input_view").show();
	}
	
	function appReport(event){
		event.preventDefault();
		var $this=$(this);
		var id =$this.data("id");
		if(!id){
			layer.alert("数据错误！", {icon:0,title:'提示'});
			return;
		}
		var url = "/ism/reportCard/app/"+id;
		var loadHtmlByUrlOption = {
			url : url,
			insertDiv : "input_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#input_view").show();
	}

	function addTrHoverEvent(data)
	{
		var $table=$("#reportCard_table");
		var $trs=$table.find("tr");
		$trs.off('mousemove mouseout mouseleave mouseenter');
		$trs.on("click", function(event)
		{
			var $tr = $(this);
			var clazz = $tr.attr("id");
			$table.find("." + clazz).addClass("listtrselect");
		});

		$trs.hover(function()
		{
			//debugger;
			var $tr = $(this);
			var clazz = $tr.attr("id");
			$table.find("." + clazz).addClass("listtrhover");
		}, function()
		{
			var $tr = $(this);
			var clazz = $tr.attr("id");
			$table.find("." + clazz).removeClass("listtrhover");
		});
	}

	function isNumber(val){
		if(val){
			return val.match(/(\d+)|(^(\d+.\d+)$)/);
		}
		return true;
	}
	
	function checkAge(){
		var startAge=$("#startAge").val();
		if(!isNumber(startAge)){
			$("#startAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		var endAge=$("#endAge").val();
		if(!isNumber(endAge)){
			$("#endAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		if(startAge&&endAge&&Number(startAge) > Number(endAge)){
			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	function checkDate(){
		var reportCreateStartDate=$("#reportCreateStartDate").val();
		var reportCreateEndDate=$("#reportCreateEndDate").val();
		if(reportCreateStartDate&&reportCreateEndDate&&new Date(reportCreateStartDate)>new Date(reportCreateEndDate)){
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	
	// 查询报卡列表
	function searchReportList(indexPage)
	{
		var flag=null;
		var  flagView=$("#ism-view-flag").val();
		if(flagView){
			flag="2";
		}
		var  flagApp=$("#ism-app-flag").val();
		if(flagApp){
			flag="3";
		}
		if(!checkAge()){
			return;
		}
		if(!checkDate()){
			return;
		}
		var param = {
			indexPage : indexPage,
			flag:flag
		};
		var submitFormLoadHtmlOption = {
			url : '/ism/reportCard/list',
			param : param,
			insertDiv : 'list_datagrid',
			callback : addTrHoverEvent
		};
		lastPageIndex = indexPage;
		$("#form_search").submitFormLoadHtml(submitFormLoadHtmlOption);
	}
	function showList()
	{
		$("#list_view").show();
		$("#input_view").hide();
	}
	function showDetail()
	{
		$("#list_view").hide();
		$("#input_view").show();
	}
	function refresh()
	{
		searchReportList(lastPageIndex);
	}

	function toggle(obj, tableId)
	{
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	;

	return {
		search : searchReportList,
		showList : showList,
		refresh : refresh,
		toggle : toggle
	};

})();