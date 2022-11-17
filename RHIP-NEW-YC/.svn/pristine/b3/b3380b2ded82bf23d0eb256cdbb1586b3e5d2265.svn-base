define(['../serviceInfo/search'],function(ServiceInfoSearch){
	var ue;
	function load(){
		$(function(){
			//市级医院不审核新闻中心
			hideSH();
			$("#edittitle").focus();
			getchild();
			if ($("#operatorType").val() == '1') {
				lookUpStyle();
			}
			if ($("#operatorType").val() != '1') {
				ue = UE.getEditor('editor');
				UE.getEditor('editor').focus();
				$("#seeRollPic").hide();
			}
			if ($("#operatorType").val() == '3') {
				$("#seeRollPic").hide();
				$("#rollPictureDiv").hide();
			}
			healthEducationUpload.uploadOrganizationLinkFile("serviceInfoMaMaterialFile","/he/upload/uploadFile/lhrollpic","/he/upload/deleteFile/lhrollpic");
			$("#editinfoType").change(getchild);
			
			//是否为滚动信息默认为否
			if($("#isRollPicVal").val() == '0') {
				$("#rollPictureDiv").hide();
			}
				
			$("input[name='isRollPicture']").on("click", function()
			{
				if ("0" == $(this).val())
				{
					$("#rollPictureDiv").hide();
				} else
				{
					$("#rollPictureDiv").show();
				}
			});
				
			$("#back-btn").click(returnSearch);
			$("#save-btn").click(save);
			
			$("#editinfoType").change(function(event) {
				//市级医院不审核新闻中心
				hideSH();
		       });
		});
	};
	
	function hideSH() {
		if($("#role").val() == '39'
			 && $("#editinfoType").find("option:selected").text() == '新闻中心') {
			$("#field tr:eq(2) th:eq(1)").hide();
			 $("#field tr:eq(2) td:eq(1)").hide();
		} else {
			 $("#field tr:eq(2) th:eq(1)").show();
			 $("#field tr:eq(2) td:eq(1)").show();
		}
	}
	
	function getchild(callback){
		var selectValue=$("#editinfoType").val();
		$.getJsonByUrl({
			url : contextPath+"/lhserviceInfo/infoTypeChildren",
			param : {
				id : selectValue
			},
			callback : function(map) {
				var detailType=$("#editdetailType");
				if(map.success){
					var infoTypeChildren=map.infoTypeChildren;
					detailType.empty();
					detailType.append("<option value=''>请选择类别</option>");
					if(null != infoTypeChildren && infoTypeChildren.length > 0){
						for(var i=0;i<infoTypeChildren.length;i++){
							detailType.append("<option value='"+infoTypeChildren[i].id+"'>"+infoTypeChildren[i].name+"</option>");
						}
					}
				}else{
					detailType.empty();
					detailType.append("<option value=''>请选择类别</option>");
				}
				var childValue = $("#detailTypeValue").val();
				$("#editdetailType").val(childValue);
			}
		});
	}
	
	function save(){
        var validate = $("#serviceInfoFrom").easyValidate();
		
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		
		if ($("#rollPictureDiv").css("display") == 'block') {
			if ($(".qq-upload-success").size() < 1 && $("#editRollPic a img").size() < 1) {
				layer.alert("附件总数量不能小于1个！", {icon:0,title:'提示'});
			} else if($("#editRollPic a img").size() == 1) {
				saveService();
			} else {
				saveService();
			}
		} else {
			saveService();
		}
			
	}
	
	function saveService() {
		$("#serviceInfoFrom").submitFormGetJson({
			url : "/lhserviceInfo/save",
			param:{
				contents: ue.getContent()
				
			},
			callback : function(data) {
				if(data.message == 'success'){
					layer.alert("服务信息保存成功！", {icon:0,title:'提示'}, function(index){
						returnSearch();
						layer.close(index);
					});
				} else if(data.message == '附件总数量不能大于1个！'){
					layer.alert("附件总数量不能大于1个！", {icon:0,title:'提示'});
				}else
				layer.alert("保存失败！", {icon:0,title:'提示'});
			}
		});
	}
	
	function lookUpStyle(){
		$("#save-btn").hide();
		$("#createTime").attr("disabled","disabled");
        $("#edittitle").attr("disabled","disabled");
		$("#editinfoType").attr("disabled","disabled");
		$("#editdetailType").attr("disabled","disabled");
		$("#editauthor").attr("disabled","disabled");
		$("#editsource").attr("disabled","disabled");
		$("#editisRecommend").attr("disabled","disabled");
		$("input[name='status']").attr("disabled","disabled");
		$("input[name='isRollPicture']").attr("disabled","disabled");
		$("#rollPictureInfo").attr("disabled","disabled");
		$("#editRollPic").attr("hidden","hidden");
		$("#rollPictr").attr("hidden","hidden");
		$("#seeRollPic").show();
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
	
	function returnfunction() {
		$("#operationDiv").empty();
        $("#mainSearchDiv").show();
        ServiceInfoSearch.search($("#currentPage").val());	
	}
	
	return{
		load : load
	}
});