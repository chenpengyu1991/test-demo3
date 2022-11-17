define(['../doctor/search'],function(doctorSearch) {
	function load() {
		$(function() {
			$("#returnContact").click(returnSearch);
			$("#saveContact").click(doSave);
			healthEducationUpload.uploadOrganizationLinkFile("doctorPictureFile","/he/upload/uploadFile/outDoctorPic","/he/upload/deleteFile/outDoctorPic");
		});
	}
	
	function doSave(status) {

		var result=$($("#outDoctorForm")).easyValidate().validateForm();
		var statusId = $("#statusId option:selected").val();
		if(!result){
			return;
		}
		$("#outDoctorForm").submitFormGetJson({
			url : contextPath + '/outDoctor/save',
            wait : true,
            callback : function(data) {
                if (data.indexOf("success") != -1) {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    returnSearch();
                    return false;
                } else if(data.indexOf("exits") != -1){
                	layer.alert("此机构下医生编码(工号)已存在，请确认后提交！", {icon:0,title:'提示'});
                } else if(data.indexOf("out") != -1) {
					layer.alert("附件总数量不能大于1个！", {icon:0,title:'提示'});
				} else {
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}
			}
		});
	}
	
	function returnSearch(){
		if(contentChanged){
			msgUtil.backConfirm(function(){
				$("#detailDivDoctor").empty();
		        $("#top_allDoctor").show();
				doctorSearch.searchDoctor(1);
			});
		}else{
			$("#detailDivDoctor").empty();
	        $("#top_allDoctor").show();
			doctorSearch.searchDoctor(1);
		}
	}
	
	return {
		load: load
	};
});
