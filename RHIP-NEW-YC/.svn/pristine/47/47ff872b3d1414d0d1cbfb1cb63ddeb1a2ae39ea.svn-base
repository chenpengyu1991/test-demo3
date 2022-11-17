<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script>

$(function() {
	$("#saveButton").click(function(e) {
		e.preventDefault();
		save();
	})
})
    function save() {
        var validate = $("#refreshTimeForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#refreshTimeForm").submitFormGetJson({
            url : "/sysConfig/reportRemind/frequency/save",
            callback : function(data) {
                $.removeDialog("dcConfigDialog");
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                }
            }
        });
    }
</script>
<div class="toolbar" style="margin-top: 10px;">
    <a id="saveButton" href="javascript:void(0)" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="postcontent" >
    <form id="refreshTimeForm">
            <fieldset class="layui-elem-field">
                <legend>报卡提醒时间设置</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 30%"/>
                        <col style="width: 70%"/>
                    </colgroup>
                    <tr>
                        <input type="hidden" name="id" value="${reportRefreshTime.id}">
                        <th><label class="required">报卡提醒频率：</label></th>
                        <td>
                            每<input type="text" class="x-layui-input" name="minutes" value="${reportRefreshTime.minutes}" reg='{"maxlength":"10","required":"true", "digits":"true"}' style="width:60px;text-align: center">分钟提醒
                        </td>
                    </tr>
                    <%--<tr>--%>
                        <%--<input type="hidden" name="id" value="${reportRefreshTime.id}">--%>
                        <%--<th><label class="required">传染病报卡提醒频率：</label></th>--%>
                        <%--<td>--%>
                            <%--每<input type="text" name="idmFrequency" value="${reportRefreshTime.idmFrequency}" reg='{"maxlength":"10","required":"true", "digits":"true"}' style="width:60px;text-align: center">分钟提醒--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<th><label class="required">慢病报卡提醒频率：</label></th>--%>
                        <%--<td>--%>
                            <%--每<input type="text" name="cmdFrequency" value="${reportRefreshTime.cmdFrequency}" reg='{"maxlength":"10","required":"true", "digits":"true"}' style="width:60px;text-align: center">分钟提醒--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                </table>
            </fieldset>
    </form>
</div>