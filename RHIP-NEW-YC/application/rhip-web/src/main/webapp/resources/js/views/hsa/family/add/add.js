var hsaFamilyInspRecordAdd = (function()
{
	var validate = null;
	var message="有异味";
	var message2="有肉眼可见物";
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
		
		setMainPro("inspGuideRecord.dosp",message);
		setMainPro("inspGuideRecord.dostv",message2);
	});

	function back()
	{
		hsaFamilyList.showList(true);
	}
	
	function setMainPro(name,message){
		var $findMainPro=$("input[name='findMainPro']");
		$("input[name='"+name+"']").click(function(){
			var $this=$(this);
			var value=$this.val();
			var old=$findMainPro.val();
			var newStr="";
			if("1"==value){
				old=old.replace("无","");
				newStr=replaceOrAppendStr(old,message);
			}else{
				newStr=old.replace(message,"");
			}
			$findMainPro.val(newStr);
		});
	}
	
	function replaceOrAppendStr( old, some){
		if(!old){
			old="";
		}
		old=$.trim(old);
		if(old){
			var index=old.indexOf(some);
			if(index!=-1){
				return old;
			}
			return old+ " "+some;
		}
		return some;
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
