var drug = (function() {
	$(function() {
        // $("#2-30").attr("onclick","");
        // $("#2-31").attr("onclick","");
        // $("#4-31").attr("onclick","");
        // $("#6-31").attr("onclick","");
        // $("#9-31").attr("onclick","");
        // $("#11-31").attr("onclick","");
        var d = new Date();
        var vYear = d.getFullYear();
        //闰月判断
        // if(!(((vYear % 4) == 0 && (vYear % 100 != 0)) || (vYear % 400 == 0))){
        //     $("#2-29").attr("onclick","");
        // }

        var initJson = $("#initJson").val();
        var initFields = initJson.split(",");
        for(var i = 0 ; i < initFields.length; i++){
            var sig = initFields[i].split(":");
            initPic(sig[0], sig[1]);
        }
	});


    function changePic(selectTd){
        var flag =  $(selectTd).attr("flag");
        if("" == flag){
            $(selectTd).addClass("td_bgL");
            $(selectTd).removeClass("td_bgF");
            $(selectTd).attr("flag", "1");
        }
        if("1" == flag){
            $(selectTd).addClass("td_bgF");
            $(selectTd).removeClass("td_bgL");
            $(selectTd).attr("flag", "2");
        }
        if("2" == flag){
            $(selectTd).removeClass("td_bgL");
            $(selectTd).removeClass("td_bgF");
            $(selectTd).attr("flag", "");
        }

    }

    function initPic(id, flag){
        if("1" == flag){
            $("#"+id).addClass("td_bgL");
            $("#"+id).removeClass("td_bgF");
            $("#"+id).attr("flag", "1");

        }
        if("2" == flag){
            $("#"+id).addClass("td_bgF");
            $("#"+id).removeClass("td_bgL");
            $("#"+id).attr("flag", "2");
        }

    }

    function saveDrug(singleId){
        var trData = {};
        $("#drugTable tr").each(function(trindex,tritem){
            if(trindex > 0){
                $(tritem).find("td").each(function(tdindex,tditem){
                    if(tdindex > 0){
                        var inputValue = $(tditem).attr("flag");
                        if(!$.isEmpty(inputValue)){
                            trData[$(tditem).attr("id")] = inputValue;
                        }
                    }
                });
            }
        });
        $("#tbForm").submitFormGetJson({
            url : '/idm/tb/management/saveDrug',
            wait : true,
            param : {
                singleId : singleId,
                dataJson : util.Obj2str(trData)
            },
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    standardization.searchTemp();
                }
            }
        });
    }

	return {
        changePic:changePic,
        saveDrug:saveDrug,
        initPic:initPic
	};
})();
