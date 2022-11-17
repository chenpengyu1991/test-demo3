<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<script src="${pageContext.request.contextPath}/js/views/mdm/userOperationLog/popDelete.js" type="text/javascript"></script>

<div style="padding-top: 20px;">
    <form id="deleteContentForm">
        <input type="hidden" name="id" value="${reportRecordId}"/>
        <div class="postcontent postdiv">
            <table class="posttable">
                <tr>
                    <th style="width: 20%"><label class="required">删除原因:</label></th>
                    <td style="width: 80%">
                        <ehr:dic-radio id="deleteContent" name="deleteContent" dicmeta="IDM00379" reg='{"required":"true"}' onchange="toggleOther('deleteContent','deleteContentOtherId','99');"/>
                        <span  id="deleteContentOtherId" style="display: none"><input type="text" style="width: 200px;" id="deleteContentOther" name="deleteContentOther" reg="{'maxlength':200,'required':'true'}"/></span>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="toolbarpop">
        <!-- <input type="button" id="deleteBtn" value="删除" onclick="userOperationLogPopDelete.deleteReportRecord()"> -->
        <button class="layui-btn layui-btn-sm" id="deleteBtn">删除</button>
        <!-- <input type="button" id="cancelBtn" value="取消" onclick="userOperationLogPopDelete.closePopUp('deleteContentDialog')"> -->
        <button class="layui-btn layui-btn-sm" id="cancelBtn">取消</button>
    </div>
</div>
