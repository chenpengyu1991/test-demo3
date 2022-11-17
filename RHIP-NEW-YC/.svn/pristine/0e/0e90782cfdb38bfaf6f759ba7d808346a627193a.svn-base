/**
 * Created by f on 2019/10/10.
 */
//报卡上报医院/公卫通用
/*var comReport = (function() {
    $(function () {
    });*/
    function checkAttachment(){
        var flag = true;
        $("#dis-select-box input").each(function() {
            var name = $(this).attr("name");
            var attachBoxId = name + "Tr";
            if ($(this).prop("checked") && "hbpFlag" == name) { // 高血压
                var size = $("#"+attachBoxId+" ul li").size();
                if(size == 0) { // 没有上传附件
                	layer.alert(" 高血压附件必传！", {icon:0,title:'提示'});
                    flag = false;
                    return flag;
                }
            }else if ($(this).prop("checked") && "diFlag" == name) { // 糖尿病
                var size = $("#"+attachBoxId+" ul li").size();
                if(size == 0) { // 没有上传附件
                	layer.alert(" 糖尿病附件必传！", {icon:0,title:'提示'});
                    flag = false;
                    return flag;
                }
            }
        })
        return flag;
    }
/*
    return {
        checkAttachment:checkAttachment
    };
});*/
