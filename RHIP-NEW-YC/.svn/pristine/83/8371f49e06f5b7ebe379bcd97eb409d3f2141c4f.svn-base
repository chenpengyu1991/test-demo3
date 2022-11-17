var frequentList = (function() {
	
	function deleteFrequent(id){
		if(confirm("你确定要删除该条信息吗？")){
			var option = {
				url : "/userSpace/reserve/frequent/deleteFrequent",
				param :{
					frequentId:id
				},
				callback:function(data){
					if(data == "ok"){
						msgUtil.alert("删除常用联系人信息成功");
						frequentSearch.search(1);
						return;
					}else if(data == "fail"){
						msgUtil.alert("删除常用联系人信息失败");
						return;
					}
				}
			};
			$.getJsonByUrl(option);
		}
	}

	function modifyFrequent(obj){
        initFrequent();
		var data = $(obj).parent();
		$('#frequentId').val($(data).attr('data-id'));
		$('#frequentName_id').val($(data).attr('data-frequent-name'));//val($(data).data('frequentName'));
        var gender = $(data).attr('data-gender');
        $("input[name='gender']:[value='" + gender + "']").attr("checked",'checked');
		$('#telephone').val($(data).attr('data-telephone'));
		$('#cardNo').val($(data).attr('data-card-no'));
		var dateStr = $(data).attr('data-birthday');
		if(!isEmpty(dateStr)) {
			dateStr = dateStr.replace(".0","");
			dateStr = dateStr.replace(/-/g,"/");
			$('#birthday').val(new Date(dateStr).pattern("yyyy/MM/dd"));
		}
		$('#addFrequentForm').slideUp();
		$('#addFrequentForm').slideToggle();
	}

	function get(fmt) {
		var o = {
			"M+" : this.getMonth()+1, //月份
			"d+" : this.getDate(), //日
			"h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
			"H+" : this.getHours(), //小时
			"m+" : this.getMinutes(), //分
			"s+" : this.getSeconds(), //秒
			"q+" : Math.floor((this.getMonth()+3)/3), //季度
			"S" : this.getMilliseconds() //毫秒
		};
		var week = {
			"0" : "/u65e5",
			"1" : "/u4e00",
			"2" : "/u4e8c",
			"3" : "/u4e09",
			"4" : "/u56db",
			"5" : "/u4e94",
			"6" : "/u516d"
		};
		if(/(y+)/.test(fmt)){
			fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
		}
		if(/(E+)/.test(fmt)){
			fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
		}
		for(var k in o){
			if(new RegExp("("+ k +")").test(fmt)){
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
			}
		}
		return fmt;
	}

	function formatDate(date) {
		if (date) {
			return date.pattern("yyyy/MM/dd");
		}
		return "";
	}

    function initFrequent(){
        $("#frequentNameSpan").empty();
        $("#genderSpan").empty();
        $("#telephoneSpan").empty();
        $("#cardNoSpan").empty();
        $("#birthdaySpan").empty();
    }

	return {
		deleteFrequent : deleteFrequent,
		modifyFrequent : modifyFrequent
	};
})();