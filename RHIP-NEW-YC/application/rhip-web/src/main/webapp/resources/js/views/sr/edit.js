var srEdit = (function() {
	var validate = $("#editForm").easyValidate();
	$(function() {
		enableChangeConfirm();
		$("#back").click(back);
		$("#save").click(saveSr);
        toggleSrType('srType');

        var belongFlag = $("#belongFlag").val();
        $("#belong").val(belongFlag);
        belongChange();
	});

    function saveSr() {
        var belongName = '';
        var belongOrgan = '';
        var belong = $("#belong").val();
        if('1' == belong){
            belongName = getTableData("belongStaffs");
        }
        if('2' == belong) {
            var belongOrganCode = $("#belongOrganCode").val();
            var belongCenterCode = $("#belongCenterCode").val();
            var belongGbCode = $("#belongGbCode").val();
        }
        var validate0 = $("#form0").easyValidate();
        if(!validate0.validateForm()){
            return;
        }
        var srType = $("#srType").val();
        var form = 'form'+srType;
        var validate = $("#"+form).easyValidate();
        if (validate.validateForm()) {
            var option = {
                url : "/sr/save",
                param : {'srType':srType,
                    belongName:belongName,
                    belongOrganCode:belongOrganCode,
                    belongCenterCode:belongCenterCode,
                    belongGbCode:belongGbCode,
                    belong:belong},
                callback : (function(result) {
                    layer.alert(result.message, {icon:0,title:'提示'});
                    if (result.success) {
                        back();
                        layer.alert("保存成功！", {icon:0,title:'提示'});
                    }
                }),
                wait : true
            };
            $("#"+form).submitFormGetJson(option);
        }
    }

    function toggleSrType(sCName)
    {
        var raValue = $("select[name=\'" + sCName + "\']").find("option:selected").val();
        for(var i = 1 ; i<=5; i++){
            if(raValue != i || raValue == ''){
                $("#form" + i).hide();
            }else{
                $("#form" + i).show();
            }
        }
    }

    function popupStaff(btn, type, seq){
        var html = $("#belongStaffs").html();
        var param = {seq:seq, indexPage: 1, html:html};
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text()
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit', seq:seq};
        }
        var staffDialog = {
            url : "/sr/staffSearch",
            height : 600,
            width : 700,
            title : "人员选择",
            id :"staffDialog",
            param:param
        };
        $.dialog(staffDialog);
    }


    function selectStaffRow(staffName, idCard){
       var tableDataTemp = getTableData("selectedStaffTable");
       if(tableDataTemp.indexOf(idCard) != -1){
           layer.alert("该人员已被选定，请重新选择！", {icon:0,title:'提示'});
           return;
       }
       var html = generateTrHtml(['name', 'idCard'],[],[staffName,idCard],[]);
        $("#selectedStaffTable").append(html);
    }

    function generateTrHtml(showFields, hideFields, showValues, hideValues){
        var html = '<tr>';
        for(var i=0; i<showFields.length; i++){
            html += '<td style="text-align: center" field="' + showFields[i] + '" title="'+showValues[i]+'">'+showValues[i] +'</td>';
        }
        for(var i=0; i<hideFields.length; i++){
            html += '<td style="text-align: center" field="' + hideFields[i] + '" style="display: none">' + hideValues[i] + '</td>';
        }
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="srEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    //删除一行
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

	function back() {
		disableChangeConfirm();
		srSearch.search();
	}

    function selectStaffs(){
        var html = $("#selectedStaffTable").html();
        $("#belongStaffs").html(html);
        $.removeDialog ('staffDialog');

    }

    function getTableData(tableId){
        var tableString = ""
        $("#"+tableId+" tr").each(function(trindex,tritem){
            if(trindex > 0){
//                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    var inputValue = $(tditem).text();
                    if('' != inputValue && "undefined" != inputValue && undefined != inputValue && tdindex<2){
                        if(tdindex == 0){
                            tableString = tableString + inputValue + " ";
                        }
                        if(tdindex == 1){
                            tableString = tableString + inputValue + ";";
                        }
                    }
                });
            }
        });
        return tableString;

    }

    function belongChange(){
        var belong = $("#belong").val();
        if("1" == belong){
            $("#belongStaffs").show();
            $("#addStaffBtn").show();
            $("#organTable").hide();
        }
        if("2" == belong){
            $("#belongStaffs").hide();
            $("#addStaffBtn").hide();
            $("#organTable").show();
        }
    }

    function changePlanCategory(){

    }
    function changePlanCategory(sCName){
        var raValue = $("select[name=\'" + sCName + "\']").find("option:selected").val();
        var dicCode = '';
        if(raValue == '1'){
            dicCode = 'PCB00002';
        }
        if(raValue == '2'){
            dicCode = 'PCB00003';
        }
        if(raValue == '3'){
            dicCode = 'PCB00004';
        }
        if (dicCode != ''){
            $.getJsonByUrl({
                url : '/sr/getDicList',
                param : {dicCode : dicCode},
                callback : function(data){
                    initNext(data, 'planType');
                }
            });
        }else{
            $("#planType").empty();
            $("#planType").hide();
        }
    }

    function changeAwardCategory(sCName){
        var raValue = $("select[name=\'" + sCName + "\']").find("option:selected").val();
        var dicCode = '';
        if(raValue == '1'){
            dicCode = 'PCB00006';
        }
        if(raValue == '2'){
            dicCode = 'PCB00007';
        }
        if(raValue == '3'){
            dicCode = 'PCB00008';
        }
        if (dicCode != ''){
            $.getJsonByUrl({
                url : '/sr/getDicList',
                param : {dicCode : dicCode},
                callback : function(data){
                    initNext(data, 'awardName');
                }
            });
        }else{
            $("#awardName").empty();
            $("#awardName").hide();
        }
    }

    function initNext(data, id){
        var $awardName = $("#" + id);
        $awardName.empty();
        if($.isEmpty(data)){
//            $planType.hide();
        }else{
            $awardName.append("<option value='' >请选择</option>");
            $awardName.append(data);
            $awardName.show();
//        for (key in data){
//            key = data[key];
//            $planType.append("<option title=" + data[key] + " value='" + key + "'  >" + data[key] + "</option>");
//        }
        }
    }

	return {
		back : back ,
        toggleSrType : toggleSrType ,
        popupStaff : popupStaff,
        selectStaffRow : selectStaffRow,
        removeTr : removeTr,
        selectStaffs : selectStaffs,
        belongChange : belongChange,
        changePlanCategory : changePlanCategory,
        changeAwardCategory : changeAwardCategory
	}
})();