var reserveSearch = (function() {
	$(function() {
		search(1);
		$("#reserveSearchBtn").click(function(){
			search(1);
		});
		
		$("#reserveSearch").onEnter(function(){
			search(1);
		});
		$("#searchSpanId").click(function(){
			toggle(this,'searchTable');
		});
		//分页绑定函数
		pageUtil.bind("listDiv",search);
	});
	
	function add(){
		$("#mainSearchDiv").hide();
		$.loadHtmlByUrl({
			url:"/portal/reserve/add",
			insertDiv:"addDiv"
		});
	}
	
	function search(indexPage) {
		var submitDateBegin = $("#submitDateBegin").val();
		var submitDateEnd = $("#submitDateEnd").val();
		
		var requestDateBegin = $("#requestDateBegin").val();
		var requestDateEnd = $("#requestDateEnd").val();
		
		if(!checkDate(submitDateBegin,submitDateEnd,"预约")){
			return;
		}
		
		if(!checkDate(requestDateBegin,requestDateEnd,"到诊")){
			return;
		}
		
		var option = {
			url:"/portal/reserve/list",
			insertDiv:"listDiv",
			param:{
				indexPage:indexPage
			}
		};
		$("#reserveSearch").submitFormLoadHtml(option);
	}
	
	function checkDate(startDate,endDate,desp){
		if(startDate && endDate && new Date(startDate) > new Date(endDate)){
			layer.alert(desp + "开始时间不能大于" + desp + "结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	
	return {
		search : search,
		add : add
	};
})();