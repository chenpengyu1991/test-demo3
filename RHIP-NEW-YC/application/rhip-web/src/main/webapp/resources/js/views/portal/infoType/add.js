define(['../infoType/search'],function(infoTypeSearch){
	function load(){
		$(function(){
			$("#infoTypeSave").click(function() {
				save();
			});
			$("#infoTypeCancle").click(function(){
				$.removeDialog("addDialog");
			});
		});
	}
	
	function save(){
		
		var validate = $("#info_Type_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		/*var input = $("#serviceTypeName").val();
		if($.trim(input) == ''){
			layer.alert("输入服务类别名称为空!",function(){$("#serviceTypeName").focus();});
			return;
		}*/
		$("#info_Type_form").submitFormLoadHtml({
            url : "/lhinfoType/save",
            param : {
            	infoTypeGrade : '1',
            },
            callback :function(data){
				if(data == "1"){
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index){
						$.removeDialog("addDialog");
						infoTypeSearch.search($("#currentPage").val());
						layer.close(index);
					});
					return;
				}else {
					layer.alert("保存失败！", {icon:0,title:'提示'}, function(index){
						$.removeDialog("addDialog");
						infoTypeSearch.search($("#currentPage").val());
						layer.close(index);
					});
					return;
				}
			}
        });
	}
	
	return{
		load : load,
	};
});