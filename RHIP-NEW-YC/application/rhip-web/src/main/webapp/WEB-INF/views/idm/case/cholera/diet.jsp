<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
<form id="addBdd" method="get">
	<input type="hidden" id="rowIndex" value="${rowIndex}"/>
	<div>
		<table class="formtable" id="popBddTable">
			<colgroup>
	            <col style="width: 20%"/>
	            <col style="width: 80%"/>
	        </colgroup>
			<tr>
				<th>餐饮日期</th>
				<td>
					<tag:dateInput name="dietDate" onlypast="true" id="dietDate" date="${idmListBdd.dietDate}"/>
                </td>
			</tr>
			<tr>
				<th>餐次</th>
				<td>
					<input type="text" name="mealNum" id="mealNum" value="${idmListBdd.mealNum}" reg='{"maxlength":"2"}'/>
					<span>注：早，中，晚，其它</span>
                </td>
			</tr>
			<tr>
				<th>地点</th>
				<td>
					<input type="text" name="addr" id=addr value="${idmListBdd.addr}" reg='{"required":"true","maxlength":"100"}'/>
                 </td>
			</tr>
			<tr>
				<th>食物名称</th>
				<td>
					<input type="text" name="foodName" id="foodName" value="${idmListBdd.foodName}" reg='{"maxlength":"100"}'/>
                 </td>
			</tr>
			<tr>
				<th>同餐对象</th>
				<td>
					<input type="text" name="mealPeople" id="mealPeople" value="${idmListBdd.mealPeople}" reg='{"maxlength":"100"}'/>
                </td>
			</tr>
		</table>
	</div>
</form>
<div class="toolbarpop">
    <c:if test="${type == 'add'}">
        <input type="button" id="saveContact" value="添加" onclick="choleraCase.addBddList()">
    </c:if>
    <c:if test="${type == 'edit'}">
        <input type="button" id="editContact" value="修改" onclick="choleraCase.editBddList()">
    </c:if>
    <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('dietDialog')">
</div>
</div>
