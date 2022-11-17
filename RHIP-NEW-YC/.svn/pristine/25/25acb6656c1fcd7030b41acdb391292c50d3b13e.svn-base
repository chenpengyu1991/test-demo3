var mouseMonitorAdd = (function() {
	var validate = null;
	$(function() { 
		validate = $("#mouseMonitorForm").easyValidate();
		if($('#monitorId').val()!='')
			search(1);
	});
	/*保存鼠密度监测基本信息*/
	function saveMouseMonitor() {
		var rs =validate.validateForm();
		if(!rs)
			return;
			//参数
			var saveObj = {
				url : "/dmbc/vertor/saveMouseMonitor",
				insertDiv : "operationDiv",
				param : {
					type:$("#mouseMonitorForm #type").val(),
					indexPage:1
				}
			};
			$("#mouseMonitorForm").submitFormLoadHtml(saveObj);
	};
	
	/*进入添加捕鼠记录页面*/
	function initMouseAdd(){
		var dialogParams = {
				id : "d1",
				url : "/dmbc/vertor/initMouseAdd/"+$("#monitorId").val(),
				height : 485,
				width : 550,
				title : "添加捕鼠记录"
		};
		$.dialog(dialogParams);
	}
	
	/*进入修改捕鼠记录页面*/
	function initMouseEdit(id) {
		var dialogParams = {
				id : "d1",
				url : "/dmbc/vertor/initMouseAdd/"+$("#monitorId").val(),
				height : 485,
				width : 550,
				title : "修改捕鼠记录",
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
                mouseMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            mouseMonitorSearch.search(1);
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
	    	url : "/dmbc/vertor/delMouse",
            callback:function(data){
            	layer.alert(data.message, {icon:0,title:'提示'});
            	if (data.result) {
            		mouseMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
        		}
    		},
	    	param:{
	    		id:id
	    	}
	     });
	}
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/mouseList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#type").val()
				},
				insertDiv :"mouseList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		returnSearch:returnSearch,
		saveMouseMonitor:saveMouseMonitor,
		initMouseAdd:initMouseAdd,
		initMouseEdit:initMouseEdit,
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
