define(['../interaction/search'],function(interactionSearch){
	var ue;
	function load(){
		$(function(){
			if ($("#operatorType").val() != '1') {
				$("#operatorType").focus();
				//ue = UE.getEditor('editor');
				//UE.getEditor('editor').focus();
			}
			$("#backToSearch").click(returnSearch);
			
			$("#updateInteraction").click(interactionUpdate);
		});
	}
	function interactionUpdate(){
		var validate = $("#interaction_form").easyValidate();
		
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		
		$("#interaction_form").submitFormLoadHtml({
            url : "/interaction/save",
            param : {
            	"contents": $("#replyContent").val()
            },
            callback :function(data){
				if(data == "1"){
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
						returnSearch();
						layer.close(index);
					});
                    return;
				}
				layer.alert("更新失败！", {icon:0,title:'提示'});
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
		$("#interactionDiv").empty();
        $("#searchDiv").show();
        interactionSearch.searchInteraction($("#currentPage").val());	
	}
	return {
		load : load
	};
});
