var cardRrEdit = (function() {
	$(function() {
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            laydate.render({
                elem: '#treatmentDtId'
                ,format: 'yyyy/MM/dd'
                ,max: 0
                , trigger: 'click'
				,done:function (value) {
       				if(!$.isEmpty(value)){
       					$("#treatmentDtId").removeClass("lose");
       				}else{
       					$("#treatmentDtId").addClass("lose");
       				}
       			}
            });

        });
		
	});

    function valiNum(){
        var str = $("#mny1").val().replace(/^0*/g,'');
        $("#mny1").val(str);
        /*if(/^\d$/.test(str)){                     //验证是否纯数字
            str = str.replace(/^0*!/g,'');    //把开头的N个0替换成空
            $("#mny1").val(str);             //把值赋给input
            alert($("#mny1").val());
        }*/
    }

	/*添加信息变更记录*/
	function saveRr(type){
        valiNum()
		var validate = $("#rrForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
		var html = fillData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#rrTable tr").eq(rowIndex).html(html);
        }else{
            $("#rrTable").append(html);
        }        
        contentChanged = true;
        closeDialog();

	}

    function closeDialog() {
        layer.close(layer.index);
    }
	
	function fillData(){
        var rrObj = idmCommon.getPopObj('rrChildTable');
        rrObj['lapsetoStr']=$("#lapsetoId").find("option:selected").text();
        rrObj['lapseto'] = $("#lapsetoId").val();
        var rrShowFields = ['treatmentDt', 'treatmentType', 'treatmentMoney','lapsetoStr'];
        var rrHideFields = ['lapseto'];
        var rrShowValues = [rrObj.treatmentDt,rrObj.treatmentType,rrObj.treatmentMoney,rrObj.lapsetoStr];
        var rrHideValues = [rrObj.lapseto];
        var editMethod = "cardEdit.popupRr(this,'edit')";
        return idmCommon.generateTrHtml(rrShowFields, rrHideFields, rrShowValues, rrHideValues, editMethod);
	}
 	return {
 		saveRr:saveRr,
        valiNum:valiNum,
        closeDialog: closeDialog
	};
})();