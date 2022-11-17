var contineHepatitisPage = (function(){
	//点击保存按钮
	$(function(){
		$("#contineBtn").click(function(){
			$("#contineBtn").hide();
			$("#vaccinationAgain").show();
		});
	
		validate = $("#vaccine_hepatitis_contine_save").easyValidate();
		$("#hepatitisContineSave").click(function(){
			var result=validate.validateForm();
	    	if(!result){
	    		return;
	    	}
			vaccineSave();
		});
		mainPageH.factoryAutoComplete(".factoryClass");
	});

	//显示保存结果 ---待定
	function vaccineSave(){
		$("#vaccine_hepatitis_contine_save").submitFormLoadHtml({
			url : "/ph/hepatitis/contine",
			callback:function(data){
            	if(data=="1"){
            		layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("接种成功！", {icon:0,title:'提示'});
               		});
					$.removeDialog("displayDialog");
					mainPageH.search(1);
					return;
            	}
            	layui.use('layer', function() {
        			var layer = layui.layer;
        			layer.alert("接种失败！", {icon:0,title:'提示'});
           		});
            }
        });
	}
})();