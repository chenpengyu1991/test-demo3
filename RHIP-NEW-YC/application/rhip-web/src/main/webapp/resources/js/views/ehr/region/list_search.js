var listSearch = (function(){
	
	$(function(){
		
		$("#per_search_btn").click(function(){
			if($("#createBeginDate").val() > $("#createEndDate").val()) {
				layer.alert('建档开始时间不能大于建档结束时间！', {icon:0,title:'提示'});
				return;
			}
			if($("#beginAge").val() > $("#endAge").val()) {
				layer.alert('年龄开始时间不能大于年龄结束时间！', {icon:0,title:'提示'});
				return;
			}
		});

		// 查询
//		$(this).keydown(function(e) {
//			var key;
//			if (window.event) { // IE
//				key = e.keyCode;
//			} else if (e.which) { // Netscape/Firefox/Opera
//				key = e.which;
//			}
//			if (key == 13) {
//				personSearch(1);
//			}
//		});
		
	});
	
		
})();

