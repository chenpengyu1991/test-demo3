define(function() {

	function load() {
		$(function () {
			$("#montiorSearch").click(function () {
				search(1);
			});
			$("#serviceSearchForm").onEnter(search, 1);
			search(1);
		});
	}
			function search(indexPage) {
				indexPage = ($.isEmpty(indexPage)?1:indexPage);
				var searchObj = {
					url : "/wsMonitor/serviceInfo/monitor/list",
					insertDiv : "serviceResultDiv",
					param : {
						indexPage : indexPage
					},
					callback: function(data) {
						$("#pageIndex").val(indexPage);
						$("#serviceTable tr").each(function(){
							var wsdl = $(this).find("td:eq(1)").data("wsdl");
							var webServiceName = $(this).find("td:eq(3)").data("webServiceName");
							if($.isEmpty(wsdl)){
								return true;
							}
							var trId = $(this).attr('id');
							$("#load1" + trId).html(loadingSource);
							getServiceStatus(wsdl,trId);
							$("#load2" + trId).html(loadingSource);
							var beginDate = $('#serviceTb').find('#beginDate').val();
							var endDate = $('#serviceTb').find('#endDate').val();
							getServiceAccessCount(webServiceName,trId,beginDate,endDate);
						});
					}
				};
				$("#serviceSearchForm").submitFormLoadHtml(searchObj);
			};

			/**
			 * 获取服务器状态
			 */
			function getServiceStatus(wsdl,trId){
				$.getJsonByUrl({
					url : "/wsMonitor/serviceInfo/checkService",
					callback : function(data) {
						$("#" + data.trId).find("td:eq(4)").removeClass('infolevel3');
						if(data.wsStatus == 1 ){
							$("#" + data.trId).find("td:eq(4)").addClass('infolevel1');
						}else{
							$("#" + data.trId).find("td:eq(4)").addClass('infolevel4');
						}
						$("#load1" + trId).html('');
					},
					param:{wsdl:wsdl,trId:trId},
					async : true,
					checkRepeat:false
				});
			}

			/**
			 * 获取服务器访问次数
			 */
			function getServiceAccessCount(webServiceName,trId,beginDate,endDate){
				$.getJsonByUrl({
					url : "/wsMonitor/serviceInfo/getServiceAccessCount",
					callback : function(data) {
						$("#load2" + trId).html(data.accessCount);
					},
					param:{
						webServiceName:webServiceName
						,trId:trId
						,beginDate:beginDate
						,endDate:endDate
					},
					async : true,
					checkRepeat:false
				});
			}
			function toggle(obj,tableId) {
				$(obj).toggleClass("ico-top");
				$(obj).toggleClass("ico-bottom");
				$("#" + tableId).toggle();
			};
			return {
				load : load,
				search : search,
				toggle:toggle
			};
});


$(document).ready(function () {
	//按钮样式切换
	$("#montiorSearch").hover(
		function () {
		$(this).removeClass("search_btn").addClass("search_btn_h");
		},
		function () {
		$(this).removeClass("search_btn_h").addClass("search_btn");
		}
	);

});
