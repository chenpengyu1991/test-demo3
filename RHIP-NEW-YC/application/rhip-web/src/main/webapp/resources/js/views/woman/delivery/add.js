var pFPAdd = (function() {
    $(function() {

        toggleOtherCK('complicationsCode','complicationsCodeID',6);

        $("#BackId").on("click", function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                doBack();
            });

        });
        $("#SaveId").on("click", save);
         $("#addChildBtn").on("click",addChild);
         $("#delTwins").on("click",delTwins);
        // $("#delTriplets").on("click",delTriplets);

        $("#textIdCard").keyup(function () {
            var idCardValue = $("#textIdCard").val();
            $("#textIdCard").attr("value", idCardValue.toUpperCase());
        });

        // //指导
        // $("input[name='diseaseScreeningProject']").on("click", function(){
        //     dic_other("diseaseScreeningProject", "diseaseScreeningProjectId",
        //         "diseaseScreeningResults");
        // });

        $("#textIdCard").on("blur", function () {
            var idCardValue = $.trim($("#textIdCard").val());
            if (idCardValue.length == 15 || idCardValue.length == 18) {
                $.getJsonByUrl({
                    url: "/personRecord/getPersonByIdcard",
                    param: {
                        idCard: idCardValue
                    },
                    callback: function (data) {
                        if (data) {
                            if (!data.healthFileNo) {
								layui.use('layer', function(){
				        			var layer = layui.layer;
				        			layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
	        					});
                            } else {
                                $("#healthFileNoId").val(data.healthFileNo);
                                $("#text_personId").val(data.id);
                                $("#text_name").val(data.name);
                            }
                        }else{
                            $("#healthFileNoId").val("");
                            $("#text_personId").val("");
                            $("#text_name").val("");
							layui.use('layer', function(){
				        			var layer = layui.layer;
				        			layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
	        					});
                        }
                    }
                });
            }
        });
    });


    function doBack(){
        $("#delivSearchDivId").show();
        $("#delivDetailDiv").hide();
    }

    function save() {
        var validate = $("#DelivFromId").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        if($.isEmpty($("#text_personId").val())) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
	        });
            return;
        }
        // 保存
        $("#DelivFromId").submitFormGetJson({
            url : "/ehr/delivery/save",
            wait : true,
            callback : function(data)
            {
				layui.use('layer',function(){
				var layer=layui.layer;
				if (data == "success")
                {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    womanSearch.search(1);
                    doBack();
                } else {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }
				})
            }
        });

    }
    
    function addChild() {
        // var colgroup ='<colgroup><col style="width: 15%;"/><col style="width: 30%;"/><col style="width: 15%;"/><col style="width: 30%;"/></colgroup>'
        var size = $("#xseDiv table").size();
        var tableId ="xseTable"+size;
        var fieldsetId ="xseFieldset"+size;
        var prefixHtml ='<fieldset id="'+fieldsetId+'">\n'+'<legend>新生儿情况'+(size+1)+'</legend>'
         var html =prefixHtml+'<table id="'+tableId+'">';
        $("#childTable input").each(function(){
            var nameVal = $(this).attr('name').replace('[i]','['+size+']');
            $(this).attr('name',nameVal);
        });
        $("#childTable .other").each(function(){
            var idVal = $(this).attr('id').replace('_i','_'+size+'');
            $(this).attr('id',idVal);

        });
        $("#childTable .radioGroup").each(function () {

            if(this.onchange!=null&&this.onchange.length>0){

                if( $(this).attr('name').indexOf("puerperaResult") >= 0){
                    var toggleVal ="toggleOther('neonatalList["+size+"].puerperaResult','puerperaResultSpan_"+size+"',4);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("birthDefectFlag") >= 0){
                    var toggleVal ="toggleOther('neonatalList["+size+"].birthDefectFlag','birthDefectFlagID_"+size+"',2);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("neonatalComplicationsFlag") >= 0){
                    var toggleVal ="toggleOther('neonatalList["+size+"].neonatalComplicationsFlag','neonatalComplicationsFlagID_"+size+"',2);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("bcgStates") >= 0){
                    var toggleVal ="toggleOther('neonatalList["+size+"].bcgStates','BCGStatesId_"+size+"',1);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("hepatitisBvaccine") >= 0){
                    var toggleVal ="toggleOther('neonatalList["+size+"].hepatitisBvaccine','hepatitisBVaccineId_"+size+"',1);";
                    $(this).attr('onchange',toggleVal)
                }
            }
        });
        $("#childTable .checkboxGroup").each(function () {
            if(this.onchange!=null&&this.onchange.length>0){
                if( $(this).attr('name').indexOf("diseaseScreeningProject") >= 0){
                    var dicToggleVal ="toggleOtherCK('neonatalList["+size+"].diseaseScreeningProject','diseaseScreeningProjectId_"+size+"',3);";
                    $(this).attr('onchange',dicToggleVal)
                }
            }
    });

            var childTable=$("#childTable").html();

            //this.onchange = "toggleOther('"+this.name+"','"+"'"+spanId+"',"+ "4')"


        // var childTable = $("#childTable").html();
        html+=childTable+'</table>'
        var lastHtml ='</fieldset>'
        $("#xseDiv").append(html+lastHtml);
        $("#childTable input").each(function(){
            var nameVal = $(this).attr('name').replace('['+size+']','[i]');
            $(this).attr('name',nameVal);
        });
        $("#childTable .other").each(function(){
            var idVal = $(this).attr('id').replace('_'+size+'','_i');
            $(this).attr('id',idVal);

        });
        $("#childTable .radioGroup").each(function () {

            if(this.onchange!=null&&this.onchange.length>0){
                if( $(this).attr('name').indexOf("puerperaResult") >= 0){
                    var toggleVal ="toggleOther('neonatalList[i].puerperaResult','puerperaResultSpan_i',4);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("birthDefectFlag") >= 0){
                    var toggleVal ="toggleOther('neonatalList[i].birthDefectFlag','birthDefectFlagID_i',2);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("neonatalComplicationsFlag") >= 0){
                    var toggleVal ="toggleOther('neonatalList[i].neonatalComplicationsFlag','neonatalComplicationsFlagID_i',2);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("bcgStates") >= 0){
                    var toggleVal ="toggleOther('neonatalList[i].bcgStates','BCGStatesId_i',1);";
                    $(this).attr('onchange',toggleVal)
                }
                if( $(this).attr('name').indexOf("hepatitisBvaccine") >= 0){
                    var toggleVal ="toggleOther('neonatalList[i].hepatitisBvaccine','hepatitisBVaccineId_i',1);";
                    $(this).attr('onchange',toggleVal)
                }
            }
        });
    }
    
    function delTwins() {
        debugger;
        var size = $("#xseDiv table").size();
        $("#xseDiv fieldset[id^='xseFieldset']:last").remove();

    }


    function dic_other(dicName, hiddenId, otherName){
        if($("input[name='" + dicName + "']:last").is(":checked")){
            $("#" + hiddenId).css("display","inline");
        }else {
            $("input[name='" + otherName + "']").attr("value", "");
            $("#" + hiddenId).css("display","none");
        }
    }
})();



