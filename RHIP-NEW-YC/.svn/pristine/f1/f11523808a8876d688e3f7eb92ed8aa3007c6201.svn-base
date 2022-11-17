var flyMonitorAdd = (function() {
	$(function() { 
		if($('#monitorId').val()!='')  
		search(1);
	});

	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/flyList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#flyMonitorForm #type").val()
				},
				insertDiv :"flyList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	/*保存苍蝇监测基本信息*/
	function saveFlyMonitor() {
		var validate = $("#flyMonitorForm").easyValidate();
		var rs =validate.validateForm();
		if(!rs)
			return;
		//参数
		var saveObj = {
			url : "/dmbc/vertor/saveFlyMonitor",
			insertDiv : "operationDiv",
			param : {
				type:$("#flyMonitorForm #type").val(),
				indexPage:1
			}
		};
		$("#flyMonitorForm").submitFormLoadHtml(saveObj);
	};
	
	/*进入添加捕蝇记录页面*/
	function initFlyAdd(){
		var dialogParams = {
				id : "d1",
				url : "/dmbc/vertor/initFlyAdd/"+$("#monitorId").val(),
				height : 485,
				width : 550,
				title : "添加捕蝇记录"
		};
		$.dialog(dialogParams);
	}
	
	/*进入修改捕蝇记录页面*/
	function initFlyEdit(id) {
		var dialogParams = {
				id : "d1",
				url : "/dmbc/vertor/initFlyAdd/"+$("#monitorId").val(),
				height : 485,
				width : 550,
				title : "修改捕蝇记录",
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
                flyMonitorSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            flyMonitorSearch.search(1);
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
	    	url : "/dmbc/vertor/delFly",
            callback:function(data){
            	layer.alert(data.message, {icon:0,title:'提示'});
            	if (data.result) {
            		flyMonitorList.viewOrEdit($("#monitorId").val(),$("#type").val());
        		}
    		},
	    	param:{
	    		id:id
	    	}
	     });
	}
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/vertor/flyList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#type").val()
				},
				insertDiv :"flyList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	return {
		returnSearch:returnSearch,
		saveFlyMonitor:saveFlyMonitor,
		initFlyAdd:initFlyAdd,
		initFlyEdit:initFlyEdit,
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
