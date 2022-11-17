function onDatePickerChanged(){
	$("#reserveSearchBtn").trigger("focus");
}
function onDatePickerChanged(){
	$("#reserveSearchBtn").trigger("focus");
}

var reserveSearch = (function() {
	$(function() {
		search(1);
		$("#reserveSearchBtn").click(function(){
			search(1);
		});
		$("#reserveSearch").onEnter(function(){
			search(1);
		});
	});
	
	function add(){
		$("#mainSearchDiv").hide();
		$.loadHtmlByUrl({
			url:"/portal/reserve/add",
			insertDiv:"addDiv"
		});
	}
	
	function search(indexPage) {
		var createBegin = new Date($("#requestDateBegin").val());
		var createEnd = new Date($("#requestDateEnd").val());

		if(!checkDate(createBegin,createEnd,"预约")){
			return;
		}
		var option = {
			url:"/userSpace/reserve/list",
			insertDiv:"listDiv",
			param:{
				indexPage:indexPage
			}
		};
		$("#reserveSearch").submitFormLoadHtml(option);
	}
	
	function checkDate(startDate,endDate,desp){
		if(startDate && endDate && new Date(startDate) > new Date(endDate)){
			msgUtil.alert(desp + "开始时间不能大于" + desp + "结束时间");
			return false;
		}
		return true;
	}
	
	return {
		search : search,
		add : add
	};
})();