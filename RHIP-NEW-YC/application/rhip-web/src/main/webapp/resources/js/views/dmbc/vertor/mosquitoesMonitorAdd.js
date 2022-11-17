var mosquitoesMonitorAdd = (function() {
	var validate = $("#mosquitoesMonitorForm").easyValidate();
	$(function() { 
		if($('#monitorId').val()!='')
		search(1);
			   
	});

	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/mosquitoesList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#mosquitoesMonitorForm #type").val()
				},
				insertDiv :"mosquitoesList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	/*保存成蚊监测基本信息*/
	function saveMosquitoesMonitor() {
		var rs =validate.validateForm();
		if(!rs)
			return;
			//参数
			var saveObj = {
				url : "/dmbc/vertor/saveMosquitoesMonitor",
				insertDiv : "operationDiv",
				param : {
					type:$("#mosquitoesMonitorForm #type").val(),
					indexPage:1
				}
			};
			$("#mosquitoesMonitorForm").submitFormLoadHtml(saveObj);
	};
	
	/*进入添加捕蚊记录页面*/
	function initMosquitoesAdd(){
		var dialogParams = {
				id : "d1",
				url : "/dmbc/vertor/initMosquitoesAdd/"+$("#monitorId").val(),
				height : 485,
				width : 550,
				title : "添加捕蚊记录"
		};
		$.dialog(dialogParams);
	}
	
	/*进入修改捕蚊记录页面*/
	function initMosquitoesEdit(id) {
		var dialogParams = {
				id : "d1",
				url : "/dmbc/vertor/initMosquitoesAdd/"+$("#monitorId").val(),
				height : 485,
				width : 550,
				title : "修改捕蚊记录",
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
                mosquitoesMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            mosquitoesMonitorSearch.search(1);
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
	    	url : "/dmbc/vertor/delMosquitoes",
            callback:function(data){
            	layer.alert(data.message, {icon:0,title:'提示'});
            	if (data.result) {
            		mosquitoesMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
        		}
    		},
	    	param:{
	    		id:id
	    	}
	     });
	}
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/mosquitoesList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#type").val()
				},
				insertDiv :"mosquitoesList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		returnSearch:returnSearch,
		saveMosquitoesMonitor:saveMosquitoesMonitor,
		initMosquitoesAdd:initMosquitoesAdd,
		initMosquitoesEdit:initMosquitoesEdit,
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
