<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form id="addContacted" method="get">
        <div>
            <table class="formtable" id="popEfcTable">
                <tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
                    <th style="width: 15%">密接姓名</th>
                    <td style="width: 35%"><input type="text" name="name"
                                                  id="name" value="${idmListEfc.name}"
                                                  reg='{"required":"true","maxlength":"50"}'></td>
                    <th style="width: 15%">性别</th>
                    <td><ehr:dic-radio name="sex" dicmeta="GBT226112003"
                                       code="1,2" id="sex" value="${idmListEfc.sex}"
                                       reg='{"required":"true"}'/></td>
                </tr>
                <tr>
                    <th>年龄</th>
                    <td><input type="text" name="age" id="age"
                               value="${idmListEfc.age}" reg='{"digits":"true","max":"200"}'></td>
                    <th>住址</th>
                    <td><input type="text" name="unitAddr" id="unitAddr"
                               value="${idmListEfc.unitAddr}" reg='{"maxlength":"100"}'></td>
                </tr>
                <tr>
                    <th>接触方式</th>
                    <td><input type="text" name="contactType" id="contactType"
                               value="${idmListEfc.contactType}" reg='{"maxlength":"100"}'></td>
                </tr>
            </table>
        </div>
    </form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContactPerson" value="添加" onclick="plagueCase.addEfcList()">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContactPerson" value="修改" onclick="plagueCase.editEfcList()">
        </c:if>
        <input type="button" id="cancel" value="取消" onclick="plagueCase.closePopUp('efcDialog')"></td>
    </div>
</div>