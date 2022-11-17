var sewageTreatmentAdd = (function() {
	var validate = $("#sewageTreatmentForm").easyValidate();
	$(function() { 
        	  initTreatmentType();	
        	  $("#disinfectionTreatment").on("change", function(event){	
        		  initTreatmentType();}); 
	});

	//消毒处理方式切换
	function initTreatmentType()
    {	var chkVal = $("#disinfectionTreatment").find("option:selected").val();//$("input[name='disinfectionTreatment'][type='select']:checked").val();
	    if(chkVal== undefined){
	   		$("input[name=disinfectionTreatment][value='1']").attr("checked",true);//
	   		chkVal=1;
	      }
	   if(chkVal==1){
		   $(".material").hide();
			$(".disinfectant").show();
		}else if(chkVal==2){
			$(".disinfectant").hide();
			$(".material").show();
		} 
				
    }
	
	/*保存污水处理基本信息*/
	function saveSewageTreatment() {
		var rs =validate.validateForm();
		if(!rs)
			return;
			//参数
			var saveObj = {
				url : "/dmbc/medicalInst/saveSewageTreatment",
				insertDiv : "operationDiv",
				param : {
					type:$("#sewageTreatmentForm #type").val(),
					indexPage:1
				}
			};
			$("#sewageTreatmentForm").submitFormLoadHtml(saveObj);
	};
	
	/*进入添加处理记录页面*/
	function initTreatmentAdd(){
		var dialogParams = {
				id : "d1",
				url : "/dmbc/medicalInst/initTreatmentAdd/"+$("#monitorId").val(),
				height : 300,
				width : 500,
				title : "添加污水处理详细记录"
		};
		$.dialog(dialogParams);
	}
	
	/*进入修改捕蝇记录页面*/
	function initTreatmentEdit(id) {
		var dialogParams = {
				id : "d1",
				url : "/dmbc/medicalInst/initTreatmentAdd/"+$("#monitorId").val(),
				height : 300,
				width : 500,
				title : "修改污水处理详细记录",
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
                sewageTreatmentSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
            sewageTreatmentSearch.search(1);
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
	    	url : "/dmbc/medicalInst/delTreatment",
            callback:function(data){
            	layer.alert(data.message, {icon:0,title:'提示'});
            	if (data.result) {
            		sewageTreatmentList.viewOrEdit($("#monitorId").val(),$("#type").val());
        		}
    		},
	    	param:{
	    		id:id
	    	}
	     });
	}
	
	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/dmbc/medicalInst/treatmentList/"+$('#monitorId').val(),
				param : {
					indexPage : indexPage,
					type:$("#type").val()
				},
				insertDiv :"treatmentList"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};

	function uploadFile(id, uploadURL, deleteURL) {

		$("#"+id).fineUploader({
			request: {
				endpoint: contextPath + uploadURL
			},
			validation: {
				allowedExtensions: ['jpeg', 'jpg', 'gif', 'png'],
				sizeLimit: 5227520 // 5 MB = 5 * 1024 * 1024 bytes
			},
			retry: {
				showButton: true
			},
			deleteFile: {
				enabled: true,
				endpoint: contextPath + deleteURL
			},
			text: {
				uploadButton: "上传附件",
				waitingForResponse: "上传中",
				deleteFile: "删除"
			},
			failedUploadTextDisplay: {
				mode: 'custom',
				maxChars: 100,
				responseProperty: 'message',
				enableTooltip: false
			}
		});
	}
	
	return {
		returnSearch:returnSearch,
		saveSewageTreatment:saveSewageTreatment,
		initTreatmentAdd:initTreatmentAdd,
		initTreatmentEdit:initTreatmentEdit,
		del:del,
		search:search,
		uploadFile : uploadFile
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
