var hsaFamilyList = (function()
{
	$(function()
	{
		search(1);
		// 添加回车监听事件
		$('input').keypress(function(e)
		{
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});

		$("#hsa-inspRecord-familyList-search_btn").click(function()
		{
			search(1);
		});
		$("#hsa-inspRecord-family-add-btn").click(function()
		{
			showList(false);
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/familyRecordAdd",
				insertDiv : "hsa-record-family-view-box"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});

		// 点击超链接新增信息
		$("#hsa-record-family-result").on("click", ".add-link", function(event)
		{
			event.preventDefault();
			showList(false);
			var familyId = $(this).data("recordId");
			if (familyId)
			{
				var loadHtmlByUrlOption = {
					url : "/hsa/inspRecord/familyRecordModify",
					insertDiv : "hsa-record-family-view-box",
					param : {
						id : familyId
					}
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			}
		});

	});

	function showList(show)
	{
		if (show)
		{
			$("#hsa-record-familyList-box").show();
			$("#hsa-record-family-view-box").hide();
		} else
		{
			$("#hsa-record-familyList-box").hide();
			$("#hsa-record-family-view-box").show();
		}
	}

	function checkDate()
	{
		var startDate = $("#hsa-startDate").val();
		var endDate = $("#hsa-endDate").val();
		if (startDate && endDate && startDate > endDate)
		{
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}

	// 查询列表
	function search(indexPage)
	{
		var searchObj = {
			url : "/hsa/inspRecord/familyListResult",
			insertDiv : "hsa-record-family-result",
			param : {
				indexPage : indexPage,
				type : $("#hsa-insp-record-type").val()
			}
		};
		$("#hsa-record-familyList-form").submitFormLoadHtml(searchObj);
	}

	function toggle(obj, tableId)
	{
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}

	return {
		search : search,
		toggle : toggle,
		showList : showList
	};
})();