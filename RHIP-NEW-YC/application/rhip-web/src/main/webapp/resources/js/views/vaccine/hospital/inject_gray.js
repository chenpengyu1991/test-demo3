var injectGray = (function() {
	// 点击保存按钮
	$(function() {
		validate = $("#vaccine_rabies_contine_save").easyValidate();
		$("#rabiesContineSave").click(function(e) {
			e.preventDefault();
			var result = validate.validateForm();
			if (!result) {
				return;
			}
			vaccineSave();
		});
		init();
	});
	function init(){
        //生产厂家自动检索设置
        var opb = {
            url:"/ph/hospital/records/factoryData/true",
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
	// 显示保存结果 ---待定
	function vaccineSave() {
		var vaccineFactory = $("#vaccineCompanyCode").val();
		$("#vaccineFactory").val(vaccineFactory);		
		$("#vaccine_rabies_contine_save").submitFormGetJson({
			url : "/ph/rabies/saveGray",
			callback : function(data) {
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			if (data == "1") {
	    				layer.alert("接种成功！", {icon:0,title:'提示'}, function() {
	    					layer.closeAll();
	    					mainPageH.search(1);
	    				});
	    				/*$.removeDialog("displayDialog");*/
	    				return;
	    			}
	    			layer.alert("接种失败！", {icon:0,title:'提示'});
	    			
	    		});
			}
		});
	}
})();