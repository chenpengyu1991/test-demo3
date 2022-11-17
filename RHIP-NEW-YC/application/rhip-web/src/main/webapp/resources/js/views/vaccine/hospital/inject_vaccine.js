var injectVaccine = (function() {
	// 点击保存按钮
	$(function() {
		validate = $("#vaccine_contine_save").easyValidate();
		$("#rabiesContineSave").click(function(e) {
			e.preventDefault();
			var flag = true;
			if ($("input[name='domicileFlag']:checked").val() == '1') {
				if (isEmpty($("#fee").val())) {
					$("#fee").attr("class","lose");
					flag = false;
				}
			}
			var result = validate.validateForm();
			if (!result || !flag) {
				return;
			}
			vaccineSave();
		});
		init();
	});

	function init(){
        //生产厂家自动检索设置
        var opb = {
            url:"/ph/hospital/records/factoryData/false",
            feild: {
                value: "itemCode",
                lable: "itemName"
            }
        };

        var vaccineFactory=$("#vaccineCompanyCode");
        if(vaccineFactory.length>0){
            //初始化自动检索
            vaccineFactory.selectBox(opb);
        }
    }  
	// 获取删除或修改的URL
	function opUrl(type, op) {
		if (type == "1") {
			return "/ph/rabies/" + op;
		} else if (type == "2") {
			return "/ph/hepatitis/" + op;
		} else if (type == "3") {
			return "/ph/influenza/" + op;
		} else if (type == "4") {
			return "/ph/pneumonia/" + op;
		}
	}

	// 显示保存结果 ---待定
	function vaccineSave() {
		var inUrl = opUrl($("#vaccineType").val(), "contine");
		var vaccineFactory = $("#vaccineCompanyCode").val();
		$("#vaccineFactory").val(vaccineFactory);
		$("#vaccine_contine_save").submitFormGetJson({
			url : inUrl,
			callback : function(data) {
                layui.use('layer',function(){
                    var layer=layui.layer;
                    if (data == "1"){
                        layer.alert("接种成功！", {icon:0,title:'提示'}, function (){
                            layer.closeAll();
                            mainPageH.search(1);
                            return;
                        })
                    } else {
                        layer.alert("保存失败！", {icon:0,title:'提示'});
                    }
                });
			}
		});
	}
	
	function viewFeeArea(value) {
		if (value == '1') {
			$("#feeDiv").html("<input name=\"fee\" id=\"fee\" type=\"text\" style=\"width: 50px;\"/>元");
		} else {
			$("#feeDiv").html('');
		}
	}
	
	return {
		viewFeeArea : viewFeeArea
	};
})();