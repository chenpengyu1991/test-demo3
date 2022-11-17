<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
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
            url : "/dcConfig/check/inspect/save",
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
                    <th><label class="required">项目名称：</label></th>
                    <td>
                        <input type="hidden" name="id" value="${dcParam.id}">
                        <%--<input type="text" name="item" value="${dcParam.item}" reg='{"maxlength":"50","required":"true"}'>--%>
                        <ehr:dic-list name="itemCode" dicmeta="FS10250" reg='{"required":"true"}' code="XA,PX,DX,DR,CT,LS,OCT,IVUS,BDUS,BUS" value="${dcParam.itemCode}"></ehr:dic-list>
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