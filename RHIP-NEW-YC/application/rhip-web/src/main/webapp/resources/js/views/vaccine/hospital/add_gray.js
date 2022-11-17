var saveGrayPage = (function(){
	var validate=null;

	//点击保存按钮
	$(function(){
		validate = $("#vaccine_gray_save").easyValidate();
		$("#graySave").click(function(){
            graySave();
		});

        //  添加取消按钮
        $("#grayCansel").click(function() {
            $.removeDialog("grayDialog");
        });
        
        factoryAutoComplete(".factoryClass");
	});
	
	function factoryAutoComplete(query) {
		$.getJsonByUrl({
			url : "/ph/hospital/records/factory",
			param : {
			
			},
			callback : function(data) {
				var $drugInput = $(query);
				$drugInput.autocomplete(data, {
					minChars : 0,
					width : 250,
					max : 100,
					autoFill : false,
					matchContains : true,
					formatItem : function(row, i, max) {
						return row.itemName;
					},
					formatMatch : function(row, i, max) {
						return row.itemName;
					},
					formatResult : function(row) {
						return row.itemName;
					}
				});
			}
		});
	}
	
	//显示保存结果 ---待定
	function graySave(){
        var result=validate.validateForm();
    	if(!result){
    		return;
    	}

		$("#vaccine_gray_save").submitFormLoadHtml({
            url : "/ph/rabies/saveGray",
            callback:function(data){
                if(data == "1"){
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'});
               		});
                	grayDetialH.closeDialog();
                     return;
                }
                layui.use('layer', function() {
        			var layer = layui.layer;
        			layer.alert("保存失败！", {icon:0,title:'提示'});
           		});
            }
         });
	}
})();
