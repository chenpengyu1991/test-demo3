var staffOrgAdd = (function() {
    $(function () {
        $("#selectTownId").change(function() {
            var organCode = $("#selectTownId").val();
            $("#organCodeId").val(organCode);
            $("#organNameId").val($("#selectTownId").find("option:selected").text());
        });
        $("#selectCenterId").change(function() {
            var organCode = $("#selectCenterId").val();
            $("#organCodeId").val(organCode);
            $("#organNameId").val($("#selectCenterId").find("option:selected").text());
            getDeptList(organCode);
        });
        $("#selectStationId").change(function() {
            var organCode = $("#selectStationId").val();
            var organName = $("#selectStationId").find("option:selected").text();
            if($.isEmpty(organCode)){
                organCode = $("#selectCenterId").val();
                organName = $("#selectCenterId").find("option:selected").text();
            }
            $("#organCodeId").val(organCode);
            $("#organNameId").val(organName);
            getDeptList(organCode);
        });
        $("#organCodeId").change(function() {
            getDeptList($("#organCodeId").val());
        });
        //getDeptList($("#organCodeId").val());
        
        $("#staffOrgAddBtn").click(function(e) {
        	e.preventDefault();
        	saveOptionData($("#rowIndexed").val());
        });
        
        $("#staffOrgCancelBtn").click(function(e) {
        	e.preventDefault();
        	closePopUp();
        });
    });

    function getDeptList(organCode) {
        var option = {
            url : "/staff/getDept",
            param : {
                organCode : organCode
            },
            callback : showDeptList
        };
        $.getJsonByUrl(option);
    }

    function showDeptList(list) {
        var select = $("#deptSelectId");
        select.empty();
        var html = '<option value="">请选择</option>';
        for (var i in list) {
            html += '<option value="' + list[i].deptCode+ '">' + list[i].deptName + '</option>';
        }
        $(select).append(html);
    }

    function closePopUp(){
       // $.removeDialog ('optionDialog');
        //$("#staffOrgDivId").clear();
        $("#staffOrgDivId").hide();
    }

    function saveOptionData(rowIndex){

        var validate = $("#staffOrgForm").easyValidate();
        var result = validate.validateForm();
        var orgCode = $("#organCodeId").val();
        if($.isEmpty($("#selectCenterId").val())){//一定要选所在机构 即二级下拉框必须不为空
            layer.alert("请选择所属的兼职机构！", {icon:0,title:'提示'});
            return;
        }
        if(!result){
            return;
        }
        if(isHaveSameOrg(orgCode) && $.isEmpty(rowIndex)){
            layer.alert("此机构已存在，请核实后添加！", {icon:0,title:'提示'});
            return;
        }
        var html = fillOptionRowData();
        if($.isEmpty(rowIndex)) {
            $("#staffOrgTable").append(html);
        } else {
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#staffOrgTable tr").eq(rowIndex).html(html);
        }

        closePopUp();
    }

    function isHaveSameOrg(orgCode) {
        //验证所在编制的机构
        if($("#organCode").val() == orgCode) {
            return true;
        }
        var flag = false;
        //验证在兼职机构是否存在
        $("#staffOrgTable tr").each(function(trindex,tritem){
            if(trindex > 0){
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    var inputValue = $(tditem).text();
                    inputValue = inputValue.replace(/\t/g,'');//制表符替换
                    inputValue = inputValue.replace(/\n/g,'');//换行替换
                    if(($(this).attr("field") == "organCode") && inputValue == orgCode){
                        flag = true;
                        return;
                    }
                });
            }
        });
        return flag;
    }
    function fillOptionRowData(){
        var obj = getPopObj('popStaffOrgTable');
        var isDefaultValue = '';
        var showFields = ['organName','deptName','workIdCard','cardNum'];
        var hideFields = ['organCode', 'deptCode'];

        var showValues = [obj.organName, obj.deptName,obj.workIdCard,obj.cardNum];
        var hideValues = [ obj.organCode, obj.deptCode];
        var editMethod = "staffEdit.popup(this, 'edit')";
        return generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod);
    }

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
        $("#" + tableId).find("select").each(function(index, obj) {
            var name = $(this).attr("name");
            if(name == 'deptCode' && !$.isEmpty($(this).val())) {
                popObj[$(this).attr("name")] = $(this).val();
                popObj['deptName'] = $(this).find("option:selected").text();
            } else if(name == 'deptCode' && $.isEmpty($(this).val())) {//为请选择时显示为空
                popObj[$(this).attr("name")] = $(this).val();
                popObj['deptName'] = '';
            }
        });
        return popObj;
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
            '<a class="layui-btn layui-btn-xs" href="javascript:void(0)" onclick=' + '\"'+ editMethod + '\"' + 'title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon" >&#xe642;</i>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
            '<a class="layui-btn layui-btn-danger layui-btn-xs" href="javascript:void(0)" onclick="staffEdit.removeTr(this)" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    return {
        closePopUp:closePopUp,
        saveOptionData:saveOptionData
    };
})();