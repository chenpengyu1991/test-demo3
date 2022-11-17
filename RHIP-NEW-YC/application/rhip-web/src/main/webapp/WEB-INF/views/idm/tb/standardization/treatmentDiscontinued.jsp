<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/idm/tb/standardization.js" type="text/javascript"></script>--%>
<div>
    <form id="addFrForm" method="get">
        <input type="hidden" id="rowIndexed" value="${rowIndex}"/>
        <div>
            <table class="formtable" id="popFrTable">
                <colgroup>
                    <col style="width: 20%" />
                    <col style="width: 30%" />
                    <col style="width: 20%" />
                    <col style="width: 30%" />
                </colgroup>
                <tr>
                    <th>出现停止治疗时间：</th>
                    <td>
                        <input type="text" name="discontinuedTime" id="discontinuedTime" value='<fmt:formatDate value="${statusInfo.discontinuedTime}" pattern="yyyy/MM/dd" />'/>
<%--                        <tag:dateInput name="discontinuedTime" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
                                       date="${statusInfo.discontinuedTime}"/>--%>
                    </td>
                    <th>停止治疗原因：</th>
                    <td>
                        <ehr:dic-list name="discontinuedReason" dicmeta="IDM00419" value="${statusInfo.discontinuedReason}"/>
                    </td>
                </tr>
                <tr>
                    <th>应访患者：</th>
                    <td>
                        <input type="text" name="planVisitCount" reg='{"maxlength":"2"}' value="${statusInfo.planVisitCount}" maxlength="5">次
                    </td>
                    <th>实际访视患者：</th>
                    <td>
                        <input type="text" name="visitCount" reg='{"maxlength":"2"}' value="${statusInfo.visitCount}" maxlength="5">次
                    </td>
                </tr>
                <tr>
                    <th>应服药：</th>
                    <td>
                        <input type="text" name="planDoseCount" reg='{"maxlength":"2"}' value="${statusInfo.planDoseCount}" maxlength="5">次
                    </td>
                    <th>实际服药：</th>
                    <td>
                        <input type="text" name="doseCount" reg='{"maxlength":"2"}' value="${statusInfo.doseCount}" maxlength="5">次

                    </td>
                </tr>
                <tr>
                    <th>服药率：</th>
                    <td><input type="text" name="doseRate" reg='{"maxlength":"2"}' value="${statusInfo.doseRate}" maxlength="5">%</td>
                    <th>评估医生：</th>
                    <td>
                        <input type="text" name="doctor" reg='{"maxlength":"2"}' value="${statusInfo.doctor}" maxlength="20">
                        <input type="hidden" name="id" value="${statusInfo.id}">
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="toolbarpop">
            <input class="layui-btn layui-btn-sm" type="button" id="editContact" value="保存" onclick="standardization.saveDiscontinued()">
        <input class="layui-btn layui-btn-sm" type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('trdDialog')">
    </div>
</div>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#discontinuedTime'
            ,format: 'yyyy/MM/dd'
            ,max:0 //今天之后不可选
        });

    });
</script>