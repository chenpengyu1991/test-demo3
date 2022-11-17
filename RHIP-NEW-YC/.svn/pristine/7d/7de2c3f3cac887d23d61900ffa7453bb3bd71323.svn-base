<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset style="margin-top: 10px">
   <legend>麻风密切接触者登记</legend>
  	<form id="ccForm">
   	<input type="hidden" id="singleIdContact" name="idmId" value="${idmId == null ? listCc.idmId : idmId}">
    <input type="hidden" id="ccId" name="id" value="${listCc.id}">
    <table class="formtable" id="popVillageTable">
					<colgroup>
						<col style="width: 30%" />
						<col style="width: 70%" />
					</colgroup>
					<tr>
                        <th>患者姓名：</th>
                        <td>${generalCondition.name}<input type="hidden" name="patientName" value="${generalCondition.name}"/> </td>
                    </tr>
					<tr>
						<th><label class="required">接触者姓名：</label></th>
						<td><input type="text" name="closeName" value="${listCc.closeName}" reg='{"required":"true","maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>性别：</th>
						<td><ehr:dic-radio dicmeta="GBT226112003" code="1,2"  name="sex" value="${listCc.sex}"/> </td>
					</tr>
					<tr>
						<th>年龄：</th>
						<td><input type="text" name="age" value="${listCc.age}" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>详细地址：</th>
						<td><input type="text" name="address" value="${listCc.address}" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th><label class="required">与接触者关系：</label></th>
						<td><ehr:dic-radio dicmeta="IDM00249" name="closeType" value="${listCc.closeType}" reg='{"required":"true"}'
	                                           onchange="contact.changeType('closeType')"/>
	                        <span id="closeDetail1" style="${listCc.closeType == '1' ? '' : 'display:none;'}">
	                        	<ehr:dic-list name="closeDetail" id="closeDetail" dicmeta="IDM00055" code="2,3,5,7,99" value="${listCc.closeDetail}" reg='{"required":"true"}'/>
	                        </span>
	                        <span id="closeDetail2" style="${listCc.closeType == '2' ? '' : 'display:none;'}">
	                        	<ehr:dic-list name="checkSympton" id="checkSympton" dicmeta="IDM00057" code="2,3,4,99" value="${listCc.checkSympton}" reg='{"required":"true"}'/>
	                        </span>
	                    </td>
					</tr>
					<tr>
						<th>麻风阳性体征：</th>
						<td>
							<ehr:dic-radio dicmeta="PH00002" code="1,2" name="positiveSigns" value="${listCc.positiveSigns}"
								onchange="toggleOther('positiveSigns','diagnosisResultDetail','1')"/>
							<span id="diagnosisResultDetail" style="${listCc.positiveSigns == '1' ? '' : 'display:none;'}">
								类型及诊断依据：<input type="text" name="diagnosisResultDetail" value="${listCc.diagnosisResultDetail}" reg='{"maxlength":"50"}' style="width: 40%;">
							</span>
						 </td>
					</tr>
					<tr>
						<th>检查医生：</th>
						<td><input type="text" name="dorctorName" value="${listCc.dorctorName}" reg='{"maxlength":"50"}'/></td>
					</tr>
					<tr>
						<th>检查日期：</th>
						<td><tag:dateInput nullToToday="true" name="registDt" pattern="yyyy/MM/dd" onlypast="true" date="${listCc.registDt}"/></td>
					</tr>
				</table>
	</form>
</fieldset>