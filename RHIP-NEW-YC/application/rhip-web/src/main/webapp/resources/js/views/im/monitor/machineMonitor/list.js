var machineMonitorList = (function() {
//	$("#selectAllFlag").change(function(){
//		var status=this.checked;
//		if(status){
//			$("input[name='selectFlag']").each(function(){
//				this.checked=true;
//			});
//		}else{
//			$("input[name='selectFlag']").each(function(){
//				this.checked=false;
//			});
//		}
//	});
//	function doDeleteSels(){
//		if(msgUtil.confirm("鏄惁褰诲簳鍒犻櫎閫変腑鐨勯」鐩�")){
//			var array=new Array();
//			$("input[name='selectFlag']").each(function(){
//				if(this.checked){
//					array.push($(this).attr("id"));
//				}
//			});
//			array.join();
//			deleteServiceInfos('/serviceInfo/deleteAll',array.toString());
//		}
//	}
	
//	function deleteServiceInfos(dUrl,ids){
//			$.getJsonByUrl({
//				url : dUrl,
//				param : {
//					id : ids
//				},
//				callback : function() {
//					msgUtil.alert("鍒犻櫎鎴愬姛!");
//					infoSearch.search(1);
//				}
//			});
//	}
	
//	function deleteServiceInfo(dUrl,id){
//		msgUtil.confirm("鏄惁褰诲簳鍒犻櫎姝ら」?",function(){
//			$.getJsonByUrl({
//				url : dUrl,
//				param : {
//					id : id
//				},
//				callback : function() {
//					msgUtil.alert("鍒犻櫎鎴愬姛!",function(){infoSearch.search(1);});
//				}
//			});
//		});
//	}
//	
//	function view(id){
//		$("#mainSearchDiv").hide();
//		var option = {
//				url : "/serviceInfo/edit",
//				insertDiv : "operationDiv",
//				param :{
//					id : id,
//					operatorType:'1'
//				}
//		};
//		$.loadHtmlByUrl(option);
//	}
//
//	function modify(id){
//		$("#mainSearchDiv").hide();
//		var option = {
//				url : "/serviceInfo/edit",
//				insertDiv : "operationDiv",
//				param :{
//					id : id,
//					operatorType:'2'
//				}
//		};
//		$.loadHtmlByUrl(option);
//	}
				
	return {
	};
})();
