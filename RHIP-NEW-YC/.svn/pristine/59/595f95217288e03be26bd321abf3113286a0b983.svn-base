var drug = (function() {
	$(function() {
        $("#2-30").attr("onclick","");
        $("#2-31").attr("onclick","");
        $("#4-31").attr("onclick","");
        $("#6-31").attr("onclick","");
        $("#9-31").attr("onclick","");
        $("#11-31").attr("onclick","");
        var d = new Date();
        var vYear = d.getFullYear();
        //闰月判断
        if(!(((vYear % 4) == 0 && (vYear % 100 != 0)) || (vYear % 400 == 0))){
            $("#2-29").attr("onclick","");
        }

        var initJson = $("#initJson").val();
        var initFields = initJson.split(",");
        for(var i = 0 ; i < initFields.length; i++){
            var sig = initFields[i].split(":");
            initPic(sig[0], sig[1]);
        }
        toggleDosage('dosageA');
        toggleDosage('dosageB');
        toggleOther('reexamineItemsA');
        toggleOther('reexamineItemsB');
        toggleOther('reexamineItemsC');
        toggleOther('reexamineItemsD');
        toggleOther('reexamineItemsE');
        toggleOther('reexamineItemsF');
	});
	 function displayPaAddress() {
	        var town = $("select[name='patownShip'] option:selected").text();
	        var street = $("select[name='pastreet'] option:selected").text();
	        var village = $("select[name='paGroup'] option:selected").text();
	        if(!$.isEmpty($("select[name='paGroup'] option:selected").val())) {
	            $("#pahouseNumber").removeAttr("reg");
	            $("#pahouseNumber").removeClass("lose");
	        }
	        var result = '';
	        if (town != '请选择')
	            result = town;
	        if (street != '请选择')
	            result = result + street;
	        if (village != '请选择') {
	            result = result + village;
	        }
	        $("#tempPaValue").text(result);
	    }
	  /*function displayPaAddress() {
	        $("select[name='drugCard.pastreet']").on("change villageChange", function()
	        {
	            var prefix = $("select[name='drugCard.patownShip']").find("option[value!='']:selected").text();
	            prefix += $(this).find("option[value!='']:selected").text();
	            $("#tempPaValue").text(prefix);
	        });
	    }*/
    function changePic(selectTd){
        var flag =  $(selectTd).attr("flag");
        if("" == flag){
            $(selectTd).html('<font color="green">O</font>');
            $(selectTd).attr("flag", "1");
        }
        if("1" == flag){
            $(selectTd).html('<font color="red">N</font>');
            $(selectTd).attr("flag", "2");
        }
        if("2" == flag){
            $(selectTd).html('<font color="red">X</font>');
            $(selectTd).attr("flag", "3");
        }
        if("3" == flag){
            $(selectTd).html('');
            $(selectTd).attr("flag", "");
        }
    }

    function initPic(id, flag){
        var arrId = id.split("-");
        if(arrId[1]==18){
            $("#"+id).attr("flag", flag);
            $("#"+id+"-txt").val(flag);
            return;
        }
        if("1" == flag){
            $("#"+id).html('<font color="green">O</font>');
            $("#"+id).attr("flag", "1");

        }
        else if("2" == flag){
            $("#"+id).html('<font color="red">N</font>');
            $("#"+id).attr("flag", "2");
        }
        else if("3" == flag){
            $("#"+id).html('<font color="red">X</font>');
            $("#"+id).attr("flag", "3");
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
        var validate = $("#tbForm").easyValidate();
        if(!validate.validateForm())
            return;
        $("#tbForm").submitFormGetJson({
            url : '/idm/tb/management/saveNdyDrug',
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
                    var patName = $("#name").val();
                    standardization.initNdyDrug(singleId,patName,"1");
                }
            }
        });
    }

    function toggleDosage(doseCheckboxName){
        $('input[name="'+doseCheckboxName+'"]:not(:checked)').each(function(){
            $('#'+doseCheckboxName+$(this).val()).hide();
        });
        $('input[name="'+doseCheckboxName+'"]:checked').each(function(){
            $('#'+doseCheckboxName+$(this).val()).show();
        });

    }

    function toggleOther(cbName){
        $('input[name="'+cbName+'"]:not(:checked)').each(function(){
            // alert($(this).val());
             if('04'==($(this).val()))
                $('#'+cbName).hide();
        });
        $('input[name="'+cbName+'"]:checked').each(function(){
            if('04'==($(this).val()))
                $('#'+cbName).show();
        });
    }

    function changeJYBC(selectTd,val){
        $("#"+selectTd).attr("flag", val);
    }
	return {
        changePic:changePic,
        changeJYBC:changeJYBC,
        saveDrug:saveDrug,
        initPic:initPic,
        toggleDosage:toggleDosage,
        toggleOther:toggleOther,
        displayPaAddress:displayPaAddress
	};
})();
