define(function()
{
	function load(){
		$(function()
		{
			var validate=null;
			validate = $("#emailConfigForm").easyValidate();
			$("#save_config").on("click", function(event)
			{
				if (validate.validateForm()) {
					$("#emailConfigForm").submitFormGetJson({
						url : "/im/emailconfig/save",
						wait: true,
						callback :function(data) {
							if (data.indexOf("fail") > -1) {
								layer.alert("保存出错！", {icon:0,title:'提示'});
							}else if (data.indexOf("success") > -1) {
								layer.alert("保存成功！", {icon:0,title:'提示'});
								$.removeDialog ("emailConfigDialog");
							}
						}
					});
				}
			});
		});
	}

	
	return {
		load:load
	};
})