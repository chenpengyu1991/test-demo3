var infromBookModel = (function() {
	var validate = null;
	var ue;
	$(function() {
		ue = UE.getEditor('editor');
		UE.getEditor('editor').focus();

		validate = $("#infromBookForm").easyValidate();
		$("#infromBookSubmit").click(function(){
			var result = validate.validateForm();
			if (!result) {
				return;
			}
			save();
		});
	});
	function save(){
		if(ue.getContent() == "" && $('input[name="is_open"]:checked').val()=="1"){
			layer.alert("告知书暂无内容，请将状态改为关闭！", {icon:0,title:'提示'});
			return;
		}
		$("input[name='contents']").val(ue.getContent());

		var validate = $("#infromBookForm").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#infromBookForm").submitFormGetJson({
			url : contextPath + "/infromBook/save",
			callback : function(data){
				if("success" == $.trim(data)){
					layer.alert("保存成功！", {icon:0,title:'提示'});
				}
				else{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}
			}
		});
	}
	return {
		save:save
	};
})();