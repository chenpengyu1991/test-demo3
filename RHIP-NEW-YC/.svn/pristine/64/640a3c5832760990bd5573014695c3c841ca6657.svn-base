var hsaInspRecordList = (function() {
	$(function() {
		search(1);
		// 添加回车监听事件
		$('form').keypress(function(e) {
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});
		/* 查询 */
		$("#hsa-inspRecord-list-search_btn").click(function(e) {
			e.preventDefault();
			if (!checkDate())
			{
				return;
			}
			search(1);
		});

		// 新增
		$("#hsa-inspRecord-add-btn").click(function(e) {
			e.preventDefault();
			addCard();
		});

		// 点击超链接查看信息
		$("#hsa-record-result-list").on("click", ".view-link", function(event) {
			event.preventDefault();
			$("#hsa-record-list-box").hide();
			$("#hsa-record-input-add").show();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/view",
				insertDiv : "hsa-record-input-add",
				param : {
					locationId : $(this).data("locationid"),
					id : $(this).attr("data-id"),
					flag : "view"
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
		// 点击超链接查看信息
		$("#hsa-record-result-list").on("click", ".modify-link", function(event) {
			event.preventDefault();
			$("#hsa-record-list-box").hide();
			$("#hsa-record-input-add").show();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/edit",
				insertDiv : "hsa-record-input-add",
				param : {
					locationId : $(this).data("locationid"),
					id : $(this).attr("data-id")
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
		
		HsaCommon.initSelect("#hsa-inspection-list-categoryCode", "#hsa-inspection-list-healthProfessionsCode", "/hsa/inspRecord/getMfCode");

	});

	function checkDate() {
		var startDate = $("#hsa-startDate").val();
		var endDate = $("#hsa-endDate").val();
		if (startDate && endDate && startDate > endDate)
		{
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			return false;
		}
		return true;
	}

	function addCard(event) {
		$("#hsa-record-list-box").hide();
		$("#hsa-record-input-add").show();
		var loadHtmlByUrlOption = {
			url : "/hsa/inspRecord/add",
			insertDiv : "hsa-record-input-add"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	// 查询列表
	function search(indexPage) {
		var searchObj = {
			url : "/hsa/inspRecord/listResult",
			insertDiv : "hsa-record-result-list",
			param : {
				indexPage : indexPage
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	return {
		search : search,
		toggle : toggle
	};
})();