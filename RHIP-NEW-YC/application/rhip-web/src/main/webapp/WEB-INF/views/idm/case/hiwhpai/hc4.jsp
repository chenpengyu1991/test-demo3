<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<div>
    <form id="addHc4Form" method="get">
        <div>
            <table class="formtable" id="popHc4Table">
                <tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
                    <th style="width: 15%">姓名</th>
                    <td style="width: 35%">
                        <input type="text" name="name" value="${idmListHc.name}" reg='{"required":"true","maxlength":"50"}'>
                    </td>
                    <th style="width: 15%">性别</th>
                    <td>
                        <ehr:dic-radio name="sex" dicmeta="GBT226112003" code="1,2" value="${idmListHc.sex}"/>
                    </td>
                </tr>
                <tr>
                    <th>年龄</th>
                    <td><input type="text" name="age" value="${idmListHc.age}" reg='{"maxlength":"20"}'></td>
                    <th>发病与否</th>
                    <td>
                        <ehr:dic-radio name="attack" dicmeta="PH00001" code="1,2" value="${idmListHc.attack}"/>
                    </td>
                </tr>
                <tr>
                    <th>接触病死动物种类</th>
                    <td>
                        <input type="text" name="dieAnimalCategory" value="${idmListHc.dieAnimalCategory}" reg='{"maxlength":"100"}'>
                    </td>
                </tr>
                <tr>
                    <th>接触病死动物方式</th>
                    <td colspan="3">
                        <ehr:dic-checkbox name="dieAnimalType" dicmeta="IDM00144" value="${idmListHc.dieAnimalType}"/>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="hiwhpaiCase.saveHcData('add',4)">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="hiwhpaiCase.saveHcData('edit',4)">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('hcDialog')">
    </div>
</div>