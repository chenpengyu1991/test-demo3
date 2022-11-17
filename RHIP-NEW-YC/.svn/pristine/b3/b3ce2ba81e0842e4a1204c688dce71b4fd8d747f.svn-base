define(['../infoType/subSearch'],function(subSearch){
	function load(){
		$(function(){
			
			
			$("#subinfoTypeSave").click(function(){
				save();
			});
			$("#subInfoTypeCancle").click(function(){
				$.removeDialog("addDialog");
			});
		});
	}
	
	
	
	function save(){
		/*var name = $("#serviceTypeName").val();*/
		var parentCode = $("#parentCode").val();
		var validate = $("#info_Type_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		var creatTime = $("#creatTime").val();
		var input = $("#serviceTypeName").val();
		if($.trim(input) == ''){
			layer.alert("输入服务类别名称为空！", {icon:0,title:'提示'}, function(index){
				$("#serviceTypeName").focus();
				layer.close(index);
			});
			return;
		}
		$("#info_Type_form").submitFormLoadHtml({
            url : "/lhinfoType/save",
            param : {
            	infoTypeGrade : '2',
            	parentCode : parentCode,
            },
            callback :function(data){
				if(data == "1"){
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index){
						$.removeDialog("addDialog");
						subSearch.search($("#currentPage").val());
						layer.close(index);
					});
					return;
				}else {
					layer.alert("保存失败！", {icon:0,title:'提示'}, function(index){
						$.removeDialog("addDialog");
						subSearch.search($("#currentPage").val());
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