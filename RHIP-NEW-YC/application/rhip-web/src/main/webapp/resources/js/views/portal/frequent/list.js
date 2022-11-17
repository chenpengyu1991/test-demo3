var accountInfoList = (function() {
	$("#selectAllFlag").change(function(){
		var status=this.checked;
		if(status){
			$("input[name='selectFlag']").each(function(){
				this.checked=true;
			});
		}else{
			$("input[name='selectFlag']").each(function(){
				this.checked=false;
			});
		}
	});
	function doCheckAccountInfoSels(){
		var array=new Array();
		$("input[name='selectFlag']").each(function(){
			if(this.checked){
				array.push($(this).attr("id"));
			}
		});
		array.join();
		checkAccountInfoSels('/accountInfo/checkAll',array.toString());
	}
	function loadVaccineDetailsHtml(ehrId,type) {
		var dUrl = displayUrl(type);
		var vaccineDetails = {
			url : dUrl,
			id : "displayDialog",
			height : 600,
			width : 900,
			param : {
				ehrId : ehrId
			},
			title : "个人预防接种信息"
		};
		$.dialog(vaccineDetails);
	}
	function checkAccountInfoSels(dUrl,ids){
		$.getJsonByUrl({
			url : dUrl,
			param : {
				id : ids
			},
			callback : function() {
				accountInfoSearch.search(1);
			}
		});
	}
	function checkAccountInfo(dUrl,id,checkFlag){
		if(checkFlag == '1'){
			layer.alert("该记录已被审核！", {icon:0,title:'提示'});
			return;
		}
		$.getJsonByUrl({
			url : dUrl,
			param : {
				id : id
			},
			callback : function() {
				accountInfoSearch.search(1);
			}
		});
	}
	
	function checkDialog(id,checkFlag){
		if(id){
			var option = {
					url : "/accountInfo/showAccountInfo",
					id : "checkDialog",
					height : 450,
					weight : 30,
					width : "50%",
					param : {
						id : id
					},
					title : "用户信息审核"
			};
			$.dialog(option);
		}
	}
	
	function enableOrDisableRev(id,flag){
		$.getJsonByUrl({
			url : '/accountInfo/enableOrDisableReserve',
			param : {
				id : id,
				flag:flag
			},
			callback : function(data) {
//				cancle();
				if(data == '1'){
					layer.alert("操作成功！", {icon:0,title:'提示'}, function(index){
						accountInfoSearch.search(1);
						layer.close(index);
					});
					return;
				}
				layer.alert("操作失败！", {icon:0,title:'提示'}, function(index){
					accountInfoSearch.search(1);
					layer.close(index);
				});
			}
		});
	}
	return {
		checkAccountInfo:checkAccountInfo,
		doCheckAccountInfoSels:doCheckAccountInfoSels,
		checkDialog : checkDialog,
		enableOrDisableRev:enableOrDisableRev
	};
})();
