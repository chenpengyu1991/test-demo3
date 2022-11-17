<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<form id="addEh3Form" method="get">

		<div>
			<table class="formtable" id="popEh3Table">
				 <tr>
                    <input type="hidden" id="rowIndex" name="rowIndex" value="${rowIndex}"/>
					<th style="width: 35%">病例发病前日期</th>
					<td style="width: 65%"><tag:dateInput name="attackDt" id="attackDt" onlypast="true" date="${idmListEh.attackDt}"
                                       reg='{"required":"true"}'/></td>
				</tr>
				<tr>
					<th >是否到过</th>
					<td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="toMarket" value="${idmListEh.toMarket}"
		                        										/></td>
				</tr>
				<tr>
					<th>是否经过有活禽摊位的通道</th>
					<td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="passageway" value="${idmListEh.passageway}"
		                        										/></td>
		        </tr>
				<tr>
					<th>是否到过活禽摊位1米之内的范围</th>
					<td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="nearMarket" value="${idmListEh.nearMarket}"
		                        										/></td>
				</tr>
				<tr>
					<th>是否直接接触活禽摊位的活禽</th>
					<td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="contactMarket" value="${idmListEh.contactMarket}"
		                        										/></td>
					
				</tr>
				<tr>
				<th>次数</th>
					<td><input type="text" name="visitNum" value="${idmListEh.visitNum}"
                               reg='{"maxlength":"50"}'></td>
				</tr>

			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="hnCase.addEhList('3')">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="hnCase.editEhList('3')">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('eh3Dialog')">
    </div>
</div>