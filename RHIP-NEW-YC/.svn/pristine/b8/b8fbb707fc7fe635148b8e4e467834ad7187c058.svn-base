define(function() {

	function load() {
		$(function () {
			$("#logBackId").click(function () {
				returnSearch();
			});
			$("#requestMegId").click(function () {
				toggleMessage(this,'requestMeg','requestMegSub');
			});
			$("#responseMegId").click(function () {
				toggleMessage(this,'responseMeg','responseMegSub');
			});
		});
	}

	function returnSearch(){
		$("#detailDiv").empty();
		$("#top_all").show();
	};

	function toggleMessage(obj,divId1,divId2){
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + divId1).toggle();
		$("#" + divId2).toggle();
		if($(obj).hasClass('ico-top')){
			$(obj).text('收起');
		}else{
			$(obj).text('查看详细');
		}

	}

	return {
		load : load
	};
});
