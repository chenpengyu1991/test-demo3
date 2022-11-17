var offPersonRecord = (function(){
	var validate=null;
	$(function(){
		validate = $("#offForm").easyValidate();
        $("#off_button").click(function(e) {
        	e.preventDefault();
        	var result=validate.validateForm();
        	if(!result){
        		return;
        	}
        	if (isEmpty($("input[name='canceledReason']:checked").val())) {
        		layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请选择结案原因！");
        		});
        		return;
        	}
        	
            $("#offForm").submitFormGetJson({
                url : "/personRecord/checkOffPersonRecord",
                callback:function(data){
            		layer.alert(data.remsg);
                	var val="已建档";
                	switch (data.restatus) {
	                    case "2": val="审核中";personRecordPagination.pagination(1);break;
	                    case "9": 
	                    	val="已结案";
                            $("#tr"+$("#personId").val()).addClass("offedperson");
	                    	$("#status"+$("#personId").val()).val("9");
	                		$("#pIndex"+$("#personId").val()).empty();
	                		$("#pIndex"+$("#personId").val()).append(val);
	                		personRecordPagination.pagination(1);
	                    	break;
	                    case "3": 
	                    	val="已退回";
	                    	$("#status"+$("#personId").val()).val("3");
	                		$("#pIndex"+$("#personId").val()).empty();
	                		$("#pIndex"+$("#personId").val()).append(val);
	                    	$("#tr"+$("#personId").val()).removeClass("offedperson");
	                    	personRecordPagination.pagination(1);
                            break;
                	}  
//                	$("#tdStatus"+$("#personId").val()).text(val);                 	
                	if(data.restatus==1||data.restatus==2)
                	{
                		$("#tr"+$("#personId").val()).addClass("offedperson");
                		$("#status"+$("#personId").val()).val("2");
                		$("#pIndex"+$("#personId").val()).empty();
                		$("#pIndex"+$("#personId").val()).append(val);
                	} 
                	if(data.restatus!=0)
            		{ 
//                		$.removeDialog("offDialog");
                		layer.closeAll();
            		} 
                }
            });
        });
		//结案原因选择时，修改结案原因日期显示
       /* $("input:radio[name='canceledReason']").on("change", function(){
        	//字典：FS10311：1死亡，2迁出，3失访，9其他
            var canceledReason = $('input:radio[name="canceledReason"]:checked').val();
            $('#otherReasonTr').hide();
            if("1" == canceledReason){
				$('#cancelReasonDateLable').text("死亡时间：");
				$('#cacelReasonLabel').text("死亡原因：");
                $('#otherReasonTr').show();
			}
            if("2" == canceledReason){
                $('#cancelReasonDateLable').text("迁出时间：");
                $('#movePlaceTr').show();
                $('#archivesHandoverRecordTr').show();
            }else{
                $('#movePlaceTr').hide();
                $('#archivesHandoverRecordTr').hide();
			}
            if("3" == canceledReason){
                $('#cancelReasonDateLable').text("失访时间：");
            }
            if("9" == canceledReason){
                $('#cancelReasonDateLable').text("发生时间：");
                $('#cacelReasonLabel').text("原因：");
                $('#otherReasonTr').show();
            }
            if(!$.isEmpty(canceledReason)){
            	$('#cancelReasonDateTr').show();
			}
        });
        $("input:radio[name='canceledReason']").each(function(){

        });*/
        
        function controlDateTimeView() {

        	//字典：FS10311：1死亡，2迁出，3失访，9其他
            var canceledReason = $('input:radio[name="canceledReason"]:checked').val();
            $('#otherReasonTr').hide();
            if("1" == canceledReason){
				$('#cancelReasonDateLable').text("死亡时间：");
				$('#cacelReasonLabel').text("死亡原因：");
                $('#otherReasonTr').show();
			}
            if("2" == canceledReason){
                $('#cancelReasonDateLable').text("迁出时间：");
                $('#movePlaceTr').show();
                $('#archivesHandoverRecordTr').show();
            }else{
                $('#movePlaceTr').hide();
                $('#archivesHandoverRecordTr').hide();
			}
            if("3" == canceledReason){
                $('#cancelReasonDateLable').text("失访时间：");
            }
            if("9" == canceledReason){
                $('#cancelReasonDateLable').text("发生时间：");
                $('#cacelReasonLabel').text("原因：");
                $('#otherReasonTr').show();
            }
            if(!$.isEmpty(canceledReason)){
            	$('#cancelReasonDateTr').show();
			}
        
        }
        
        return {controlDateTimeView:controlDateTimeView}
    });
})();