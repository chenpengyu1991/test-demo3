define(['../fileManage/search'],function(fileManagerSearch) {
	var ue;
	function load() {
		$(function() {
			$("#titleFileId").focus();
			UE.getEditor('editor').focus();
			ue = UE.getEditor('editor');
			healthEducationUpload.uploadFile("fileMaMaterialFile","/he/upload/uploadFile/lhpwdgl","/he/upload/deleteFile/lhpwdgl");
			$("#returnContact").click(returnSearch);
			$("#saveContact").click(save);
			$("#publishContact").click(publish);
		});
	}

	function save() {
    	var result=$($("#fileManagerForm")).easyValidate().validateForm();
    	var statusId = $("#statusId option:selected").val();
    	if(!result){
    		return;
    	}
    	// 修改状态为保存
    	//$("input[name='status']").val("1");
    	if (statusId == '1') {
    		doSave("1");//发布
    	} else {
    		doSave("0");//保存
    	}
	};
	
	function publish() {
		var result=$($("#fileManagerForm")).easyValidate().validateForm();
    	if(!result){
    		return;
    	}
    	//修改状态为发布
    	$("input[name='status']").val("1");
		alert($("input[name='status']").val());
    	doSave("1");
	}
	
	function doSave(status) {
		$("input[name='contents']").val(ue.getContent());
    	$("#fileManagerForm").submitFormGetJson({
			url : contextPath + '/fileManager/save',
            wait : true,
            callback : function(data) {
                if (data.message == 'success' && status == '0') {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    returnSearch();
                    return false;
                } else if (data.message == 'fail' && status == '0') {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else if(data.message == '请上传附件！' && status == '0'){
                	layer.alert("请上传附件！", {icon:0,title:'提示'});
                }else if (data.message == 'success' && status == '1') {
                    layer.alert("发布成功！", {icon:0,title:'提示'});
                    returnSearch();
                    return false;
                } else if(data.message == '附件总数量不能大于5个！' && status == '0'){
                	layer.alert("附件总数量不能大于5个！", {icon:0,title:'提示'});
                }
            }
		});
	}
	
	function returnSearch(){
		if(contentChanged){
			msgUtil.backConfirm(function(){
				$("#detailDivFile").empty();
		        $("#top_allFile").show();
				fileManagerSearch.searchFile(1);
			});
		}else{
			$("#detailDivFile").empty();
	        $("#top_allFile").show();
			fileManagerSearch.searchFile(1);			
		}
	}
	
	return {
		load: load
	};
});
