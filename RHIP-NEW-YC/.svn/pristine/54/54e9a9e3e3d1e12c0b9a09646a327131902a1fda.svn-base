var outInfo = (function() {
	$(function() { 
        $("#addDetailId").click(function() {
        	popupDetail();	
        });		
		enableChangeConfirm();
		toggleOther('mh00016','mh00016Id','99');//如未治，未治原因
		toggleOther('mh00015','mh00015Id','99');//药物不良反应
		toggleOther('MH00037','MH00037Id','99');//康复地点
		toggleOther('PH00002','PH00002Id','1');//劳动收入水平
        toggleOtherCK('mhmInhospital.recoveryMeasure', 'spanRecoveryMeasureId', 99);
        toggleOtherCK('mhmInhospital.nextRecoveryMeasure', 'spanNextRecoveryMeasureId', 99);
	});

    function saveOutInfo(){
        var validate=null;
        validate = $("#outInfoForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var eventId = $("#eventIdOut").val();
        var inMedication = getTableData('inMedicationTable', eventId);
        var nextMedication = getTableData('nextMedicationTable', eventId);

        $("#inMedication").val(Obj2str(inMedication));
        $("#nextMedication").val(Obj2str(nextMedication));

        $("#outInfoForm").submitFormGetJson({
            url : "/mhm/outInfo/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
            		});
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
            				disableChangeConfirm();
            				layer.closeAll();
            			});
            		});
                    return false;
                }
            },
            wait:true
        });
    }

    function clickRow(selectRow){
        if($("#logoffId").val() == 0){
            $("#saveBtn").show();
        }
        var eventId = $(selectRow).attr("id");
        var statusId = $("#statusId").val();
        $.loadHtmlByUrl({
            url : "/mhm/outInfo/initDetail",
            insertDiv :"detailDiv",
            param : {
                eventId : eventId,
                statusId : statusId
            },
            wait:true
        });
    }
  
	function popupMedication(btn, type, refTable){
        var param = {refTable:refTable};;
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                inputValue = inputValue.replace(/\t/g,'');//制表符替换
                inputValue = inputValue.replace(/\n/g,'');//换行替换                
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit', refTable:refTable};
        }
       /* var medicationDialog = {
                url : "/mhm/outInfo/popMedication",
                height : 300,
                width : 600,
                title : ("edit" == type?"修改":"新增") + "用药明细" ,
                id :"medicationDialog",
                param:param
            };
        $.dialog(medicationDialog);	*/
        
        $.post(contextPath+'/mhm/outInfo/popMedication',
        		param, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'medicationDialog',
        			  area: ['600px', '300px'],
        			  title:("edit" == type?"修改":"新增") + "用药明细",
        			  content: ret
        		  });
        		});
        	});
	}

    function getTableData(tableId, eventId){
        if(tableId == 'inMedicationTable'){
            var type = 1;//住院用药
        }else{
            var type = 2;//下一步治疗方案
        }
        var tableData = [];
        $("#"+tableId+" tr").each(function(trindex,tritem){
            if(trindex > 0){
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    trData['eventId'] = eventId;
                    trData['type'] = type;
                    var inputValue = $(tditem).text();
                    if('' != inputValue && "undefined" != inputValue && undefined != inputValue){
                        trData[$(this).attr("field")] = inputValue;
                    }
                });
                tableData.push(trData);
            }
        });
        return tableData;
    }

    /* 对象转成json/json数组 */
    function Obj2str(o)
    {
        if (o == undefined)
        {
            return "";
        }
        var r = [];
        if (typeof o == "string")
            return "\"" + o.replace(/([\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
        if (typeof o == "object")
        {
            if (!o.sort)
            {
                for ( var i in o)
                    r.push("\"" + i + "\":" + Obj2str(o[i]));
                if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString))
                {
                    r.push("toString:" + o.toString.toString());
                }
                r = "{" + r.join() + "}";
            } else
            {
                for ( var i = 0; i < o.length; i++)
                    r.push(Obj2str(o[i]));
                r = "[" + r.join() + "]";
            }
            return r;
        }
        return o.toString().replace(/\"\:/g, '":""');
    }

    function searchInPatientRecords(pageIndex,singleId){
        var statusId = $("#statusId").val();
        $.loadHtmlByUrl({
            url : "/mhm/outInfo/inPatientRecords",
            insertDiv :"contactsList",
            wait : true,
            param : {statusId:statusId, pageIndex:pageIndex}
        });
    }

 	return {
        saveOutInfo:saveOutInfo,
        popupMedication:popupMedication,
        clickRow:clickRow,
        searchInPatientRecords : searchInPatientRecords
	};
})();