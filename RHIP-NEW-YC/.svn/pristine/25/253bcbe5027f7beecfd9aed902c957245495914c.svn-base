var manageMenu = (function() {
	var validate = null;
    $(function() {
    	validate = $("#manageMenuForm").easyValidate();
        init();
    });

    function init(){
        var isParent = $('input[name="isParent"]:checked').val();
        if($.isEmpty(isParent)){
            $('input[name="isParent"]:eq(0)').attr("checked",'checked');
        }
        $("#saveMenu").click(function() {
            saveMenu();
        });  
        $("#modifyMenu").click(function() {
            saveMenu();
        });  
        $("#cancelMenu").click(function() {
            $.removeDialog ("menuManageDialog");
        });
        $("input[name='isParent']").on("change",function(){
            changeIsParent();
        });
        changeIsParent();
    }

    function saveMenu(){
        validate = $("#manageMenuForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#manageMenuForm").submitFormGetJson({
            url : "/role/saveMenu",
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("菜单保存失败！", {icon:0,title:'提示'});
                }else{
                    layer.alert("菜单保存成功！", {icon:0,title:'提示'});
                    roleAccess.getAllAccess();
                    return false;
                }
            }
        });
        $.removeDialog ("menuManageDialog");
    }
    /**
     * 根据是否包含子节点,隐藏链接地址
     */
    function changeIsParent(){
        
        var isParent = $('input[name="isParent"]:checked').val();
        if("1" == isParent){
            $('#trNameZh').hide();
        }else{
            $('#trNameZh').show();
        }
    }
	return {

	};
})();



