var idmCommon = (function() {

    /**
     *
     * @param singleId 页面子表为1对1时的tableId
     * @param tableIds 页面子表为1对多时的tableId
     * @param flags  子表的flag
     * @param idmId
     * @returns {Array}
     */
    function getTablesData(singleId, tableIds, flags, idmId){
        var tableData = [];
        tableData = getArrayDataForTable(singleId, tableData, 0, idmId);
        for(var i=0; i<tableIds.length; i++ ){
            tableData = getArrayDataForTable(tableIds[i], tableData,flags[i], idmId);
        }
        return tableData;
    }

    function getArrayDataForTable(tableId, tableData,flag, idmId){
        $("#"+tableId+" tr").each(function(trindex,tritem){
            if(trindex > 0){
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
//                    trData['idmId'] = idmId;
                    var inputValue = $(tditem).text();
                    inputValue = inputValue.replace(/\t/g,'');//制表符替换
                    inputValue = inputValue.replace(/\n/g,'');//换行替换     
                    if('' != inputValue && "undefined" !=inputValue && undefined !=inputValue ){
                        trData[$(this).attr("field")] = inputValue;
                    }
                    trData['flag'] = flag;
                });
                tableData.push(trData);
            }
        });
        return tableData;
    }

    /**
     *
     * @param showFields 显示的字段
     * @param hideFields 隐藏的字段
     * @param showValues 显示字段的值
     * @param hideValues 隐藏字段的值
     * @param editMethod 修改的方法
     * @returns {string} 新增的一条子表记录的html
     */

    function generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod){
        var html = '<tr>';
        for(var i=0; i<showFields.length; i++){
            html += '<td field="' + showFields[i] + '" title="'+showValues[i]+'">'+showValues[i] +'</td>';
        }
        for(var i=0; i<hideFields.length; i++){
            html += '<td field="' + hideFields[i] + '" style="display: none">' + hideValues[i] + '</td>';
        }
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick=' + '\"'+ editMethod + '\"' + '>修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    /**
     *
     * @param tableId 弹出子表的tableId
     * @returns {{}}
     */
    function getPopObj(tableId){
        var popObj = {};
        $("#" + tableId).find("input").each(function(index, obj) {
            if (obj.type == "text" || obj.type == "hidden") {
                var inputValue = $(this).val();
                popObj[$(this).attr("name")] = inputValue;
            }
            if(obj.type == "radio"){
                if($(this).is(":checked")){
                    var name = $(this).attr("name");
                    popObj[$(this).attr("name")] = $(this).val();
                }
            }
        });
        return popObj;
    }

    //个案字表删除一行
    function removeTr(rmBtn){
        layui.use('layer', function(){
        	var layer = layui.layer;
        	layer.confirm('你确定要删除此条数据吗？', {icon:2, title:'确认提示'}, function(index){
        		var extendDiv = rmBtn.parentNode.parentNode;
                $(extendDiv).remove();
        		layer.close(index);
        	});
        });
    }

    function closePopUp(dialogId){
        $.removeDialog (dialogId);
    }

    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };

    /*隐藏、显示地址*/
    function toggerAddress(){
        /*是否流动人口*/
        var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
        if(isEmpty(value)){
            /*病人属于*/
            value=$('input[name="generalCondition.patientAttribute"]:checked').val();
            if('1' == value){
                changeAddress("1");
            }else{
                changeAddress("2");
            }
            toggleOther('generalCondition.patientAttribute','pavillage_address','1');
            toggleOther('generalCondition.patientAttribute','patown_address','1');
            toggleOther('generalCondition.patientAttribute','hrvillage_address','1');
            toggleOther('generalCondition.patientAttribute','hrtown_address','1');
        }else{
            if('1' == value){
                changeAddress("1");
            }else{
                changeAddress("2");
            }
            toggleOther('generalCondition.floatPopulation','pavillage_address','1');
            toggleOther('generalCondition.floatPopulation','patown_address','1');
            toggleOther('generalCondition.floatPopulation','hrvillage_address','1');
            toggleOther('generalCondition.floatPopulation','hrtown_address','1');
        }
        displayPaAddress();
        displayHrAddress();
    }
    function changeAddress(type){
        if(type=="1"){
            $("#pavillage_address").removeAttr("disabled");
            $("#hrvillage_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
            $('#hrtown_address').removeAttr("disabled");
            $("#tempPaValue").show();
            $("#tempHrValue").show();
            $('#spanPaNumber').text("门牌号");
            $('#spanHrNumber').text("门牌号");
            $('#pahouseNumber').attr({"style":"width:180px"});
            $('#hrhouseNumber').attr({"style":"width:180px"});
        }else{
            $("#pavillage_address").attr("disabled", "disabled");
            $("#hrvillage_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
            $("#hrtown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $("#tempHrValue").hide();
            $('#spanPaNumber').text("详细地址");
            $('#spanHrNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
            $('#hrhouseNumber').attr({'style':'width:90%'});
        }
    }

    function setAge(idNo){
        var idCardBirthDay = IC.getBirthday(idNo);
        var lastedAge = getAge(idCardBirthDay);
        $("#age").val(lastedAge);
        $("input[name=ageUnit]:eq(0)").attr("checked",'checked');
        $("input[name=\'generalCondition.ageUnit\']:eq(0)").attr("checked",'checked');
    }

    /*解析日期字符串*/
    function parseDate(str){

        if(str.match(/^\d{4}[\/\/\s+]\d{1,2}[\/\/\s+]\d{1,2}$/)){
            return new Date(str.replace(/[\-\/\s+]/i,'/'));
        }else if(str.match(/^\d{8}$/)){
            return new Date(str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6));
        }else{
            layer.alert('date parse error', {icon:0,title:'提示'});
        }
    }

    /*根据出生日期获取年龄*/
    function getAge(strDate){
    	if(isEmpty($.trim(strDate))){
    		return;
    	}    	
        var age;
        var aDate=new Date();
        var thisYear=aDate.getFullYear();
        var thisMonth=aDate.getMonth()+1;
        var thisDay=aDate.getDate();
        var brith=parseDate(strDate);
        brithy=brith.getFullYear();
        brithm=brith.getMonth()+1;
        brithd=brith.getDate();
        if(thisYear-brithy<0){
            layer.alert("输入错误！", {icon:0,title:'提示'});
            age="";
        }else{
            if(thisMonth-brithm<0){
                age = thisYear-brithy-1;
            }
            else{
                if(thisDay-brithd>=0){
                    age = thisYear-brithy;
                }
                else{
                    age = thisYear-brithy-1;
                }
            }
        }
        return age;
    }
	function saveEfcTable(){
		var idmId = $("#idmId").val();
		var caseStatus = $('#caseStatusId').val();
		$("#efcList").val(Obj2str(idmCommon.getTablesData('efcTable', [], [], idmId)));
		$("#caseForm").submitFormGetJson({
			url : '/idm/case/import/save',
			param:{idmId:idmId,caseStatus:caseStatus}
		});		 
	}

    function displayPaAddress() {
        $("select[name='generalCondition.pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='generalCondition.patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }

    function displayHrAddress() {
        $("select[name='generalCondition.hrstreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='generalCondition.hrtownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempHrValue").text(prefix);
        });
    }
	/**
	 * 禁用表单
	 */
    function diabaleForm(formId){
		$('#' + formId).diabaleForm();
		$('#' + formId).find('input').each(function(){
			if($(this).data('inputtype') == 'date'){
				$(this).removeAttr("onfocus");
			}
		});
		$('#' + formId + ' .xinz').hide(); 	
		$('#' + formId + ' .btnsublist').empty();
		$('#' + formId + ' .required').removeClass("required"); 		
    }
	return {
        getTablesData:getTablesData,
		removeTr:removeTr,
		closePopUp:closePopUp,
        generateTrHtml:generateTrHtml,
        getPopObj:getPopObj,
        toggle:toggle,
        toggerAddress:toggerAddress,
        setAge:setAge,
        displayPaAddress:displayPaAddress,
        displayHrAddress:displayHrAddress,
        diabaleForm:diabaleForm
	};
})();



