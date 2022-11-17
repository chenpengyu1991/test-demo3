var hsaLocationList = (function() {
	$(function() {

		$("#form_search").keypress(function(e) {
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});

		/* 查询 */
		$("#hsa-inspRecord-locationList-search_btn").click(function(e) {
			e.preventDefault();
			search(1);
		});

		// 新增
		$("#hsa-location-add-btn").click(addLocationCard);

		$("#gjBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

        // export
        $("#hsa-location-export-btn").click(function(e) {
        	e.preventDefault();
            var option={
                url:"/hsa/inspRecord/locationList/excel",
                param:{}
            };
            $("#form_search").exportListExcel(option);
        });

		$("#hsa-record-result-locationList").on("click", ".cancel-link", function(event) {
			event.preventDefault();
			var id = $(this).attr("data-id");
			/*layer.confirm("是否注销？", function(index) {
				var loadHtmlByUrlOption = {
					url : "/hsa/inspRecord/locationCancel",
					param : {
						id : id
					},
					callback : function(data) {
						if (data == true)
						{
							msgUtil.alert("注销成功！", search(1));
						} else
						{
							msgUtil.alert("注销失败！");
						}
					}
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
				layer.close(index);
			});*/
			
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('是否注销？', {icon:1, title:'确认提示'}, function(index){
					var loadHtmlByUrlOption = {
							url : "/hsa/inspRecord/locationCancel",
							param : {
								id : id
							},
							callback : function(data) {
								if (data == true)
								{
									layer.alert("注销成功！", {icon:0,title:'提示'}, function() {
										layer.closeAll();
										search(1)
									});
								} else
								{
									layer.alert("注销失败！", {icon:0,title:'提示'});
								}
							}
						};
						$.loadHtmlByUrl(loadHtmlByUrlOption);
				});
			});
		});

		$("#hsa-record-result-locationList").on("click", ".view-link", function(event) {
			event.preventDefault();
			$("#hsa-record-locationList-box").hide();
			$("#hsa-record-location-input-add").show();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/viewLocation",
				insertDiv : "hsa-record-location-input-add",
				param : {
					locationId : $(this).data("id")
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});

		$("#hsa-record-result-locationList").on("click", ".modify-link", function(event) {
			event.preventDefault();
			$("#hsa-record-locationList-box").hide();
			$("#hsa-record-location-input-add").show();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/getLocInfoForUpdate",
				insertDiv : "hsa-record-location-input-add",
				param : {
					locationId : $(this).data("id")
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});

		search(1);
		
		HsaCommon.initSelect("#hsa-inspection-location-healthProfessional", "#hsa-inspection-location-mainBusinessCode", "/hsa/inspRecord/getMfCode");
		
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

	function addLocationCard(event) {
		$("#hsa-record-locationList-box").hide();
		$("#hsa-record-location-input-add").show();
		var loadHtmlByUrlOption = {
			url : "/hsa/inspRecord/addLocInfo",
			insertDiv : "hsa-record-location-input-add"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	// 查询列表
	function search(indexPage) {
		var searchObj = {
			url : "/hsa/inspRecord/locationListResult",
			insertDiv : "hsa-record-result-locationList",
			param : {
				indexPage : indexPage,
				type : $("#hsa-insp-record-type").val()
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