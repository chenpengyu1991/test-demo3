define(['../hospitalInfo/search'],function(hospitalInfosearch) {
	var ue;
	var ue_guide;
	function load(){
		$(function(){
			$("#hospitalCategory").focus();
			if($("#operation").val() != '1'){
				ue = UE.getEditor('editor');
				UE.getEditor('editor').focus();
				
				ue_guide = UE.getEditor('editor_guide');
				UE.getEditor('editor_guide').focus();
				
				ue_microGuide = UE.getEditor('editor_microGuide');
				UE.getEditor('editor_microGuide').focus();
			}
			healthEducationUpload.uploadOrganizationLinkFile("hospitalPictureFile","/he/upload/uploadFile/lhHospitalPic","/he/upload/deleteFile/lhHospitalPic");
			$("#backToSearch").click(function(){
				returnSearch();
			});
			
			$("#updateHospitalInfo").click(function(){
				hospitalInfoUpdate();
			});
			
			$("#addHospitalInfo").click(function(){
				addHospitalInfo();
			});	   
		});
	}
	
	function hospitalInfoUpdate(){
		var validate = $("#hospitalInfo_form").easyValidate();
		
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#hospitalInfo_form").submitFormLoadHtml({
            url : "/lhhospitalInfo/save",
            param : {
            	hospitalInf:ue.getContent(),
            	guideForMedical:ue_guide.getContent(),
            	microGuidance:ue_microGuide.getContent()
            },
            callback :function(data){
            	if(data.message == 'success'){
            		layer.alert("修改成功！", {icon:0,title:'提示'}, function(index){
            			returnSearch();
            			layer.close(index);
            		});
				} else if(data.message == '附件总数量不能大于1个！'){
					layer.alert("附件总数量不能大于1个！", {icon:0,title:'提示'});
				}else {
					layer.alert("修改失败！", {icon:0,title:'提示'});
				}

			}
        });
	}
	
	/**
	 * 添加医院信息
	 */
	function addHospitalInfo(){
		var validate = $("#hospitalInfo_form").easyValidate();
		
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		
		$("#hospitalInfo_form").submitFormLoadHtml({
            url : "/lhhospitalInfo/save",
            param : {
            	hospitalInf:ue.getContent(),
            	guideForMedical:ue_guide.getContent()
            },
            callback :function(data){
            	if(data.message == 'success'){
					layer.alert("添加成功!",function(index){
						returnSearch();
						layer.close(index);
					});
				} else if(data.message == '附件总数量不能大于1个！', {icon:0,title:'提示'}){
					layer.alert("附件总数量不能大于1个！", {icon:0,title:'提示'});
				}else
				layer.alert("添加失败！", {icon:0,title:'提示'});
			}
        });
	}
	
	function returnSearch(){
		if(contentChanged){
			msgUtil.backConfirm(function(){
				returnfunction();
			});
		} else {
			returnfunction();
		}
	}
	
    function returnfunction(){
        $("#hospitalInfoDiv").empty();
        $("#searchDiv").show();
        hospitalInfosearch.search($("#currentPage").val());
    }	
	return {
		load : load,
	};
});
