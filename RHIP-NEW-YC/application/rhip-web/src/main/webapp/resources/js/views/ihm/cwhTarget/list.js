var cwhTargetList = (function() {
	$(function() { 
		$("input[name=targetHidden]").each(function(){
			search(this);
		});
	});
	
	function search(obj) {
		var targetCode = $(obj).val();
		var beginTime = $("#beginTime").val();
		var endTime = $("#endTime").val();
		var loadingImg = "<span><img src='" + contextPath + "/images/AjaxLoader16.gif' style='vertical-align:top;'/></span>";
		var loding =  $(loadingImg);
		$(obj).parent().append(loding);
		var searchObj = {
			url : "/hm/cwh/getValue",
			checkRepeat : false,
			param : {
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
