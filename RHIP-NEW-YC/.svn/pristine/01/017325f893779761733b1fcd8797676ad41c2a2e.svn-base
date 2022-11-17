define(function(){
	function load() {
		//分页绑定函数
		pageUtil.bind("sms_list",search);
		search(1);
		$("#smsSearchBtn").click(function(){
			search(1);
		});
		
		$("#sms_form_search").onEnter(function(){
			search(1);
		});
		$("#smsSearchTableSpanId").click(function(){
			toggle(this,'smsSearchTable');
		});
	}

	function search(indexPage) {
		var createTimeBegin = $("#createTimeBegin").val();
		var createTimeEnd = $("#createTimeEnd").val();

		if(!checkDate(createTimeBegin, createTimeEnd,"短信发送")){
			return;
		}

		var option = {
			url:"/portal/sms/list",
			insertDiv:"sms_list",
			param:{
				indexPage:indexPage
			}
		};
		$("#sms_form_search").submitFormLoadHtml(option);
	}
	
	function checkDate(startDate,endDate,desp){
		if(startDate && endDate && new Date(startDate) > new Date(endDate)){
			layer.alert(desp + "开始时间不能大于" + desp + "结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	
	return {
		load: load
	};
});