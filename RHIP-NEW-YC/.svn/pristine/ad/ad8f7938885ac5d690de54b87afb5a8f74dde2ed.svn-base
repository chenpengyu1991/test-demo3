var drugRecord = (function() {
	$(function() {
		validate = $("#sdForm").easyValidate();
        $("#addDrug").click(function() {
        	addDrug();
        });
     
	});
	
	/*新增一种药品*/
	function addDrug(){
		var drugNum = $("#sdChildTable").find("tr").length;//药品数量
	    var html = '<tr>';
	    html += '<th><label class="required">药物名称</label></th>';
	    html += '<td><input type="text" name="drugName' + drugNum + '" reg=\'{"required":"true","maxlength":"20"}\' style="width:98%"/></td>';
	    html += '<th>成人剂量</th>';
	    html += '<td><input type="text" name="adultMetering' + drugNum + '" reg=\'{"maxlength":"20"}\' style="width:98%"/></td>';
	    html += '<th>实用剂量</th>';
	    html += '<td><input type="text" name="practicalMetering' + drugNum + '" reg=\'{"maxlength":"20"}\' style="width:98%"/></td>';
	    html += '<td><a href="javascript:void(0)" id="deleDrug" onclick="drugRecord.removeTr(this)">删除</a></td>';
        html += '</tr>';
        $("#sdChildTable").append(html);  
        switchLink();
	}
	
	/*新增一次服药记录*/
	function addDrugRecord(){
		var validate = $("#sdForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
		var html = fillData();
		
	    $("#sdTable").append(html);   
	    contentChanged = true;
	    idmCommon.closePopUp('sdDialog');		
	}
	function modifyDrugRecord(){
		validate = $("#sdForm").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		var rowNum = $('#rowNum').val();
		var item = $('#item').val();
		$("#sdTable tr").eq(rowNum).nextAll().each(function(){
			var currentItem = $(this).attr('item');
			if(currentItem == item){
				 $(this).remove();
			}
		});
		$("#sdTable tr").eq(rowNum).remove();
		var html = fillData();
		$("#sdTable tr").eq(rowNum - 1).after(html);
		contentChanged = true;
		$('#sdTable').css('class','repeattable');
	    idmCommon.closePopUp('sdDialog');			
	}
	function fillData(){
		var item = $('#item').val();
		if($.isEmpty(item)){
			item = getItemCount() + 1;
		}
		var drugNum = $("#sdChildTable").find("tr").length;//药品数量
		var drugDt = $("#sdDrugDtId").val();//用药时间
		var rowIndex = 1;
		var html = '';
		$("#sdChildTable tr").each(function() {
			html += '<tr item="' + item + '">';
			if(rowIndex == 1){
				html += ' <td field="drugDtStr" rowspan="'+ drugNum + '" >'+ drugDt +'</td>';
			}
			var drugName = $(this).find('td').eq(0).find('input').val();
			var adultMetering = $(this).find('td').eq(1).find('input').val();
			var practicalMetering = $(this).find('td').eq(2).find('input').val();
			html += '<td field="drugDt" style="display:none;">'+ drugDt + '</td>';
			html += '<td field="drugName" >'+ drugName + '</td>';
			html += '<td field="adultMetering" >'+ adultMetering + '</td>';
			html += '<td field="practicalMetering" >'+ practicalMetering + '</td>';
//			html += '<td field="patientName" ></td>';
			if(rowIndex == 1){
				html += '<td class="btnsublist" field="btn" rowspan="'+ drugNum + '"  >';
				html += '<a href="javascript:void(0)" onclick="drugreg.editTr(this)">修改</a>&nbsp;';
				html += '<a href="javascript:void(0)" onclick="drugreg.removeTr(this)">删除</a></td>';				
			}
		    html += '</tr>';
			rowIndex += 1;
		});
		return html;
	}
	function getItemCount(){
		var itemCount = 0;
        $("#sdTable tr").each(function(trindex,tritem){
            if(trindex > 0){
            	var fieldName;
                $(tritem).find("td").each(function(tdindex,tditem){
                	fieldName = $(this).attr("field");
                	if(fieldName == 'drugDtStr'){
                		itemCount += 1;
                	}
                });
            }
        });
        return itemCount;
	}
    function removeTr(rmBtn){
    	var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(){
            var extendDiv = rmBtn.parentNode.parentNode;
            $(extendDiv).remove();
            contentChanged = true;
            switchLink(); 
            layer.close(index);
        });
    }
    
    /*
     * 每天添加药品数量不能超过8个
     * */
    function switchLink(){
    	var result = true;
		var drugNum = $("#sdChildTable").find("tr").length;//药品数量
		if(drugNum < 8){
			$('#addDrug').removeAttr("disabled");
			$('#addDrug').unbind("click");
	        $("#addDrug").click(function() {
	        	addDrug();
	        });	
		}else{
			$('#addDrug').attr("disabled","disabled");
        	$('#addDrug').unbind("click");
        	result = false;
		}  
		return result;
    }
	return {
		addDrug:addDrug,
		addDrugRecord:addDrugRecord,
		removeTr:removeTr,
		modifyDrugRecord:modifyDrugRecord
	};
})();