var managementSearch = (function() {
	$(function() {
        searchManagement(1);
        $("#managementSearch").onEnter(searchManagement, 1);
        mhmCommon.addIcd10AutoComplete("mhmIcd10Code");
        $("#searchManagementButton").click(function(e) {
        	e.preventDefault();
        	searchManagement(1);
        });
    });
	function searchManagement(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
//        var mhmIcd10CodeTemp = $("#mhmIcd10Code").val();
//        if(!$.isEmpty(mhmIcd10CodeTemp)){
//            var start = mhmIcd10CodeTemp.indexOf("[");
//            var end = mhmIcd10CodeTemp.indexOf("]");
//            mhmIcd10CodeTemp = mhmIcd10CodeTemp.substring(start + 1, end);
//        }
		var searchObj = {
			url : "/mhm/management/list",
			insertDiv : 'managementResultDiv',
			param : {
                pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#managementSearchForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#managementDetailDiv").empty();
        searchManagement();
        $("#management_top_all").show();
    }
    function loadManagement(statusId,logoff,pixId,bringIntoMode){
		var loadHtmlByUrlOption = {
				url : "/mhm/management/index",
				param : {statusId : statusId, logoff:logoff,pixId: pixId,bringIntoMode:bringIntoMode},
				checkRepeat : true,
				insertDiv : "managementDetailDiv",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);      	
    }
    function editManagement(statusId,logoff,pixId,bringIntoMode){
        $("#managementDetailDiv").show();
        loadManagement(statusId,logoff, pixId,bringIntoMode);
        $("#management_top_all").hide();  	
    }
    
    function transfer(type){
    	var transferDialog = {
                url : "/mhm/management/popupTransfer",
                height : 520,
                width : 700,
                title : ("2" == type?"纳入":"迁出"),
                id :"transferDialog",
                param:{type:type}
            };
        $.dialog(transferDialog);	    	
    }
	
	function intoManagement(statusId,eventId,logoff){
/*		$.post(contextPath+'/mhm/patient/into/add',
    	        		{ indexPage : 1,statusId : statusId, eventId: eventId, logoff:logoff
    				     }, 
    				function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'familyEhrAdd',
                			  area: ['900px', '600px'],
                			  title:'纳入管理－患者基本档案',
                			  content: ret
                		  });
                		});
                	});*/
		$("#management_top_all").hide();
		$.loadHtmlByUrl({
			url : contextPath+'/mhm/patient/into/add',
			param: { indexPage : 1,statusId : statusId, eventId: eventId, logoff:logoff},
			insertDiv :"managementDetailDiv",
			wait : true
		});
        /*var intoDialog = {
            url : "/mhm/patient/into/add",
            height : 600,
            id : "intoDialog",
            width : 900,
            param : {statusId : statusId, eventId: eventId, logoff:logoff},
            title : "纳入管理－患者基本档案"
        };
        $.dialog(intoDialog);*/
    }

	function delManagement(statusId,pixId,idcard){
		layer.confirm("确定要删除吗？", {icon:2, title:'确认提示'}, function(index){
			$.getJsonByUrl({
				url:"/mhm/management/delManageMentData",
				param:{
					statusId:statusId,
					pixId:pixId,
					idcard:idcard
				},
				callback:function(data){
					if("success" ==data.message){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index){
							$("#searchManagementButton").click();
							layer.close(index);
						});
					}else{
						layer.alert("删除失败！", {icon:0,title:'提示'});
					}
				}
			});
			layer.close(index);
		});
	}

	return {
		searchManagement:searchManagement,
        search:search,
        editManagement:editManagement,
        transfer:transfer,
		intoManagement:intoManagement,
		delManagement:delManagement
	};
})();