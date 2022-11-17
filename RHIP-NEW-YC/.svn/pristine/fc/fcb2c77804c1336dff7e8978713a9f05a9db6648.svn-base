var hsaFamilyInspRecordAdd = (function()
{
	var validate = null;
	$(function()
	{
		validate = $("#hsa-familyrecordadd-form").easyValidate();
		$("#hsa-familyrecordadd-back-btn").click(function()
		{
			back();
		});
		$("#hsa-familyrecordadd-save-btn").click(function()
		{
			save();
		});
		validate.addExtension("cuValidate", customValidate);// 方法名,方法
	});

	function back()
	{
		hsaFamilyList.showList(true);
	}

	function save()
	{
		var result = validate.validateForm();
		if (!result)
		{
			return;
		}
		$("#hsa-familyrecordadd-form").submitFormGetJson({
			url : "/hsa/inspRecord/familyRecordSave",
			callback : function(data)
			{
				if (true == data)
				{
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
						back();
						layer.close(index);
					});
					hsaFamilyList.showList(true);
					hsaFamilyList.search(1);
				}else{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}
			}
		});
	}

	function customValidate(name, $input)
	{
		var value = $input.filter(":checked").val();
		if (value != 5)
		{
			return true;
		} else
		{
			return false;
		}
	}
})();