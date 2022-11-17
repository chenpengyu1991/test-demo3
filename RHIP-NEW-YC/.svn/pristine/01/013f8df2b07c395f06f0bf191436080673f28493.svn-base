/**
 * Created with JetBrains WebStorm.
 * User: liuk
 * Date: 13-7-30
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
!(function ()
{
	var validate=null;
	$(function ()
	{
		validate = $("#sodp-add-dia-form").easyValidate();
		addEvent();
	});

	function addEvent()
	{
		$("#sodp-form-save-btn").on("click", save);
		$("#sodp-form-back-btn").on("click", back);
		$("#sodp-form-add-btn").on("click", add);
	}

	function add()
	{
		 var result = validate.validateForm();
		 if (!result){
		 	return;
		 }
		var data=getPostData($("#sodp-add-dia-form"));
		hsaSodpMain.addCallback(data);
		$.removeDialog("hsa-sodp-add-from-dialog") ;
	}
	function save()
	{
		 var result = validate.validateForm();
		 if (!result){
		 	return;
		 }
		var data=getPostData($("#sodp-add-dia-form"));
		hsaSodpMain.saveCallback(data);
		$.removeDialog("hsa-sodp-add-from-dialog") ;
	}

	function back()
	{
		$.removeDialog("hsa-sodp-add-from-dialog") ;
	}

	function getPostData($form) {
		var postData =$form.serializeObject();
		var chooseInput = $("input[name='gender']:checked");
		if(chooseInput.length>0){
			postData.gender__label=chooseInput.data("label");
		}else{
			postData.gender="";
			postData.gender__label="";
		}
		var selectInput =$("select[name='occupation']").find("option:selected").attr("title");
		postData.occupation__label=selectInput;
		return postData;
	}

})();
