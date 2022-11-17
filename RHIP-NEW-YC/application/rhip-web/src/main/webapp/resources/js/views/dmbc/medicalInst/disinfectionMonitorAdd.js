var disinfectionMonitorAdd = (function() {
	var validate = $("#disinfectionMonitorForm").easyValidate();
	$(function() { 

	});
	
	/*保存消毒处理基本信息*/
	function saveDisinfectionMonitor() {
		var rs =validate.validateForm();
		if(!rs)
			return;
			//参数
			var saveObj = {
				url : "/dmbc/medicalInst/saveDisinfectionMonitor",
				insertDiv : "operationDiv",
				param : {
					type:$("#disinfectionMonitorForm #type").val(),
					indexPage:1
				}
			};
			$("#disinfectionMonitorForm").submitFormLoadHtml(saveObj);
	};
	
	/*进入添加监测结果采样记录页面*/
	function initDisinfectionRsAdd(){
		var dialogParams = {
				id : "d1",
				url : "/dmbc/medicalInst/initDisinfectionRsAdd/"+$("#monitorId").val(),
				height : 550,
				width : 600,
				title : "添加采样记录"
		};
		$.dialog(dialogParams);
	}
	
	/*进入修改采样记录页面*/
	function initDisinfectionRsEdit(id) {
		var dialogParams = {
				id : "d1",
				url : "/dmbc/medicalInst/initDisinfectionRsAdd/"+$("#monitorId").val(),
				height : 485,
				width : 550,
				title : "修改采样记录",
				param : {
					id : id
				}
		};
		$.dialog(dialogParams);
	}
	
	function returnSearch(){
        if(contentChanged){
            msgUtil.backConfirm(function(){
                var pageIndex = $("#pageIndex").val();
                disinfectionMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            disinfectionMonitorSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }

    }
	
	function del(id){
		var index = layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function() {
			deleteDo(id);
			layer.close(index);
		});
	}
	
	function deleteDo(id){
		$.getJsonByUrl({
	    	url : "/dmbc/medicalInst/delDisinfectionRs",
            callback:function(data){
            	layer.alert(data.message, {icon:0,title:'提示'});
            	if (data.result) {
            		disinfectionMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
        		}
    		},
	    	param:{
	    		id:id
	    	}
	     });
	}
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/medicalInst/disinfectionRsList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#type").val()
				},
				insertDiv :"disinfectionRsList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		returnSearch:returnSearch,
		saveDisinfectionMonitor:saveDisinfectionMonitor,
		initDisinfectionRsAdd:initDisinfectionRsAdd,
		initDisinfectionRsEdit:initDisinfectionRsEdit,
		del:del,
		search:search
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
//	$("#enterpriseBtnSearch").hover( 
//		function () { 
//		$(this).removeClass("search_btn").addClass("search_btn_h"); 
//		}, 
//		function () { 
//		$(this).removeClass("search_btn_h").addClass("search_btn"); 
//		} 
//	); 

});
