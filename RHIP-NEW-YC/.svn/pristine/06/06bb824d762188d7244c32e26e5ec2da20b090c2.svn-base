var reportCardInput = (function()
{
	var saveUrl="/cdm/reportcard/save";//保存报卡
	var validate=$("#report-input-form").easyValidate();;
	$(function()
	{
		//病信息切换
		$("#dis-select-box input").on("click", function(event)
		{
			var name = $(this).attr("name");
			var targetBoxId = name + "-box";
			if ($(this).prop("checked"))
			{
				$("#" + targetBoxId).show();
			} else
			{
				$("#" + targetBoxId).hide();
			}
		});
		$("#person-info").find("input[name='personInfo.householdType']").on("click",function(){
			if("2"==$(this).val()){
				$("#hr-address-select").find("select").attr("disabled","disabled");
				$("#hr-address-select").hide();
			}else{
				$("#hr-address-select").find("select").removeAttr("disabled");
				$("#hr-address-select").show();
			}
		});
		//保存按钮
		$("#report-input-save-btn").on("click",save);
	});
	
	function save(event){
		event.preventDefault();
		//验证
		var result=validate.validateForm();
		if(!result){
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("请根据提示正确输入！", {icon:0,title:'提示'});
			});
			/*msgUtil.alert("请根据提示正确输入！");*/
			return;
		}
		//保存
		$("#report-input-form").submitFormGetJson({
            url : saveUrl,
            param:{
            },
            wait:true,
            callback:function(data){
            	layui.use('layer', function(){
    				var layer = layui.layer;
    				layer.alert("保存成功！", {icon:0,title:'提示'});
    			});
            	/*msgUtil.alert("保存成功");*/
            }
        });
	}

})();