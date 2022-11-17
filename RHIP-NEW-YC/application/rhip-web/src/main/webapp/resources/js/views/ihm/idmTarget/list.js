var idmTargetList = (function() {
	$(function() {
		$("input[name=targetHidden]").each(function(){
			search(this);
		});
	});
	function search(obj) {
		var val = $(obj).val();
		var arr = val.split(",");
		var code = arr[0];
		var type = arr[1];
		var targetCode = arr[2];
		var beginTime = $("#beginTime").val();
		var endTime = $("#endTime").val();
		var viewType = $("#viewType").val();
		var loadingImg = "<span><img src='" + contextPath + "/images/AjaxLoader16.gif' style='vertical-align:top;'/></span>";
		var loding =  $(loadingImg);
		$(obj).parent().append(loding);
		var searchObj = {
			url : "/hm/dc/getValue",
			checkRepeat : false,
			param : {
				code : code,
				type:type,
                viewType:viewType,
				targetCode:targetCode,
				beginTime:beginTime,
				endTime:endTime
			},
			callback:function(data){
				$(loding).remove();
				$(obj).parent().append(data);
			}
		};
		$.getJsonByUrl(searchObj);
	};
	return {
        search : search
	};
})();
