define(['../organizationLink/search'],function(searchLink) {
	function load() {
		$(function() {
			healthEducationUpload.uploadOrganizationLinkFile("linkMaMaterialFile","/he/upload/uploadFile/lhol","/he/upload/deleteFile/lhol");
			$("#returnContact").click(returnSearch);
			$("#saveContact").click(save);
		});
	}
	
	function save(){
		var validate = $("#organizationLinkFormId").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}

		$("#organizationLinkFormId").submitFormLoadHtml({
            url : "/organizationLink/save",
            callback :function(data){
            	 if (data.message == 'success') {
                     layer.alert("保存成功！", {icon:0,title:'提示'}, function(index){
                    	 returnSearch();
                    	 layer.close(index);
                    });
				}else if(data.message == '附件总数量不能大于1个！'){
					layer.alert("附件总数量不能大于1个！", {icon:0,title:'提示'});
				}else
				layer.alert("保存失败！", {icon:0,title:'提示'});
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
	
	function returnfunction() {
		$("#infoDivLink").empty();
        $("#top_allLink").show();
        searchLink.searchLink($("#currentPage").val());	
	}
	
	return {
		load: load
	};
});
