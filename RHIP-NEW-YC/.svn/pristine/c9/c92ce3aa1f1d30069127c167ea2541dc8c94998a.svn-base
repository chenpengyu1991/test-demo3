<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        addDrugAutoComplete();
        $("#saveButton").click(function (e) {
        	e.preventDefault();	
        	save();
        });
        $("#cancelButton").click(function (e) {
        	e.preventDefault();	
        	layer.closeAll();
        });
    })

    function save() {
        var validate = $("#dcParamForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#dcParamForm").submitFormGetJson({
            url : "/dcConfig/check/drug/save",
            callback : function(data) {
            	layer.closeAll();
                if (data.indexOf("fail") > -1) {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("保存成功！", {icon:0,title:'提示'});
                    search(1);
                }
            }
        });
    }

    function addDrugAutoComplete(){
        $.getJsonByUrl({
            url: "/dcConfig/drug/list",
            param : {inputValue:"C"},
            callback : function(data)
            {
                var drug = $("#drugName");
                if (drug.length > 0){
                    drug.autocomplete(data, {
                        minChars: 0,
                        width:250,
                        max: 100,
                        autoFill: false,
                        matchContains: true,
                        formatItem: function(row, i, max) {
                            return  row.drugName;
                        },
                        formatMatch: function(row, i, max) {
                            return row.drugName;
                        },
                        formatResult: function(row) {
                            return row.drugName;
                        }
                    }).result(function(event, data, formatted){
                        $("input[name='itemCode']").val(data.drugName);
                        $("#coopInsuranceCd1").val(data.coopInsuranceCd);
                        $("#pubmediCd1").val(data.pubmediCd);
                    });
                }
            }
        });
    }

</script>
<form id="dcParamForm">
    <div class="postcontent">
        <div class="postdiv">
            <table class="posttable">
                <colgroup>
                    <col style="width: 25%"/>
                    <col style="width: 75%"/>
                </colgroup>
                <tr>
                    <th><label class="required">药品名称：</label></th>
                    <td>
                        <input type="hidden" name="id" value="${dcParam.id}">
                        <input type="text" name="itemCode" id="drugName" style="width: 200px;" value="${dcParam.itemCode}" reg='{"required":"true"}'>
                        <input type="hidden" name="coopInsuranceCd" value="${dcParam.coopInsuranceCd}" id="coopInsuranceCd1">
                        <input type="hidden" name="pubmediCd" value="${dcParam.pubmediCd}" id="pubmediCd1">
                    </td>
                </tr>
                <tr>
                    <th><label class="required">时限：</label></th>
                    <td>
                        <input type="text" name="days" value="${dcParam.days}" reg='{"maxlength":"10","required":"true", "digits":"true"}' style="width:60px;text-align: center">天
                        <input type="text" name="minutes" value="${dcParam.minutes}" reg='{"maxlength":"10","required":"true", "digits":"true"}' style="width:60px;text-align: center">小时
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>
<p align="center">
    <button id="saveButton" class="layui-btn layui-btn-sm">保存</button>&nbsp;&nbsp;
    <button id="cancelButton" class="layui-btn layui-btn-sm">关闭</button>
</p>