var userOperationLogSearch = (function() {
	$(function() {
		$("#userOperationLogQuery").click(function(e) {
			e.preventDefault();
			recordsPerform(1);
		});
		$("#form_search").onEnter(function() {
			recordsPerform(1);
		});
   		recordsPerform(1);

        $("#searchReportRecordId").click(function(e) {
            e.preventDefault();
        	searchReportRecord(1);
        });
        $("#reportSearchForm").onEnter(function() {
            searchReportRecord(1);
        });
        searchReportRecord(1);
//   		$("#infoType").bind("change",function(){
//	    	var selectValue=$(this).val();
//	    	$.getJsonByUrl({
//				url : contextPath+"/serviceInfo/infoTypeChildren",
//				param : {
//					code : selectValue,
//				},
//				callback : function(model) {
//					var detailType=$("#detailType");
//					if(model.success){
//						var infoTypeChildren=model.infoTypeChildren;
//							detailType.empty();
//							detailType.append("<option value=''>请选择类别</option>");
//						if(null!=infoTypeChildren&&infoTypeChildren.length>0){
//							for(var i=0;i<infoTypeChildren.length;i++){
//								detailType.append("<option value='"+infoTypeChildren[i].code+"'>"+infoTypeChildren[i].name+"</option>");
//							}
//						}
//					}else{
//						detailType.empty();
//						detailType.append("<option value=''>请选择类别</option>");
//					}
//				}
//			});
//	    	
//	    });
	});
	
//	function add(){
//		$("#mainSearchDiv").hide();
//		var option = {
//				url : "/serviceInfo/edit",
//				insertDiv : "operationDiv",
//				param :{
//					operatorType:'3'
//				}
//		};
//		$.loadHtmlByUrl(option);
//	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
//	function empty(){
//		$("#infoType").val("0");
//		$("#detailType").val("0");
//		$("#title").val("");
//		$("#author").val("");
//		$("#source").val("");
//		$("#beginTime").val("");
//		$("#endTime").val("");
//	}
	function recordsPerform(indexPage) {
		var createBegin = new Date($("#beginTime").val());
		var createEnd = new Date($("#endTime").val());

		if (createBegin > createEnd) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("接种开始时间不能大于接种结束时间！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("接种开始时间不能大于接种结束时间");*/
		} else {
			var searchObj = {
				url : "/system/log/list",
				insertDiv : "userOperationLogList",
				param : {
					indexPage : indexPage
				}
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}

    /**
     * 查询报卡记录
     */
    function searchReportRecord(indexPage){

    	var createDateBegin = new Date($("#createDateBegin").val());
		var createDateEnd = new Date($("#createDateEnd").val());

		if (createDateBegin > createDateEnd)
		{
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			return;
		}
		
		indexPage = ($.isEmpty(indexPage)?$("#pageIndex").val():indexPage);
        var searchObj = {
            url : "/system/log/report/list",
            insertDiv : "reportRecordList",
            param : {
                indexPage : indexPage
            },
//            wait:true,
            callback : function(data) {
            	$("#pageIndex").val(indexPage);
            }
        };
        $("#reportSearchForm").submitFormLoadHtml(searchObj);
    }

    function detailReportRecord(id){
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/system/log/report/detail",
            insertDiv :"reportRecordListDiv",
            param : {id:id}
        });
        $("#reportRecordListDiv").show();
    }

    function returnSearch(){
        $("#reportRecordListDiv").empty();
        $("#top_all").show();
        searchReportRecord(1);
    };

    function changeType(){
        var statusDiv = document.getElementById("statusDiv");
        var dmdStatus = document.getElementById("dmdStatus");
        var idmStatus = document.getElementById("idmStatus");

        if($("#type").val()==1){
            statusDiv.style.visibility = "visible";
            dmdStatus.style.display = "block";
            idmStatus.style.display = "none";
        }else if($("#type").val()==2){
            statusDiv.style.visibility = "visible";
            dmdStatus.style.display = "none";
            idmStatus.style.display = "block";
        }else{
            statusDiv.style.visibility = "hidden";
            dmdStatus.style.display = "none";
            idmStatus.style.display = "none";
        }
    }

    /**
     * 补卡
     * reportRecordId：报卡记录ID
     * reportType==1:慢病补卡
     * reportType==2:传染病
     */
    function reSubmit(reportRecordId,reportType){
    	var url;
    	if(reportType == '1'){//慢病
    		url ="/cdm/reportcard/rereport";
    	}else if(reportType == '2'){//传染病
    		url = "/idm/report/resubmit";
    	}

 		$("#top_all").hide();
        $.loadHtmlByUrl({
            url : url,
            insertDiv :"reportRecordListDiv",
            param : {reportRecordId:reportRecordId}
            // wait : true
        });
        $("#reportRecordListDiv").show();		
    }

    /**
     * 弹出报卡删除原因页面
     * @param reportRecordId
     */
    function deleteReportRecordDialog(reportRecordId) {
        /*var dialogObj = {
            id :"deleteContentDialog",
            width:"600",
            height:"200",
            url : contextPath + "/system/log/report/popDeleteReportRecord",
            param : {reportRecordId:reportRecordId},
            title : "填写删除原因"
        };
        $.dialog(dialogObj);*/
        
        $.post(contextPath+'/system/log/report/popDeleteReportRecord',
        		{ reportRecordId:reportRecordId
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'deleteContentDialog',
        			  area: ['600px', '210px'],
        			  title:'填写删除原因',
        			  content: ret
        		  });
        		});
        	});
    };

//    /**
//     * 关闭删除原因页面
//     * @param dialogId
//     */
//    function closePopUp(dialogId){
//        $.removeDialog (dialogId);
//    }
//
//    /**
//     * 删除报卡监控记录
//     */
//    function deleteReportRecord(reportRecordId){
//        var validate = $("#deleteContentForm").easyValidate();
//        var result=validate.validateForm();
//        if(!result){
//            return;
//        }
//        var deleteContent = $("#deleteContentId").val();
//    	msgUtil.confirm("删除报卡监控记录",function(){
//	        $("#reportSearchForm").submitFormGetJson({
//	            url : "/system/log/report/deleteReportRecord",
//	            callback : function(data) {
//	                if (data.indexOf("fail") > -1) {
//	                    msgUtil.alert("删除失败！");
//	                }else {
//	                    msgUtil.alert("删除成功！");
//	                    searchReportRecord();
//                        closePopUp('deleteContentDialog');
//	                    return false;
//	                }
//	            },
//	            param : {reportRecordId:reportRecordId,deleteContent:deleteContent},
//	            wait:true
//	        });
//    	});
//    }
	return {
		search : recordsPerform,
        searchReportRecord : searchReportRecord,
        changeType : changeType,
        detailReportRecord : detailReportRecord,
        returnSearch : returnSearch,
		toggle : toggle,
		reSubmit:reSubmit,
        deleteReportRecordDialog:deleteReportRecordDialog
//		empty:empty,
//		add : add
	};
})();