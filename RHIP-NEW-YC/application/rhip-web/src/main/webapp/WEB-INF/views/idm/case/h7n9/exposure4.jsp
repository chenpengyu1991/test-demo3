<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(function() {
	toggleOtherCK('contactWay','contactWayOtherDiv',13);
	toggleOtherCK('protectWay','protectWayOtherDiv',7);
})
</script>
<div>
	<form id="addEh4Form" method="get">
		<div>
			<table class="formtable" id="popEh4Table">
				<tr>
                    <input type="hidden" id="rowIndex" value="${rowIndex}"/>
					<th style="width: 35%">病例发病前日期</th>
					<td style="width: 65%"><tag:dateInput name="attackDt" onlypast="true" date="${idmListEh.attackDt}"
                                       reg='{"required":"true"}'/></td>
               </tr>
				<tr>
					<th style="width: 15%">接触病例/发热病人类型</th>
					<td><ehr:dic-radio dicmeta="IDM00532"  name="patientType" value="${idmListEh.patientType}"
		                        										/></td>
				</tr>
				<tr>
					<th>接触方式（可多选）</th>
					<td><ehr:dic-checkbox dicmeta="IDM00526"  name="contactWay" value="${idmListEh.contactWay}"
		                        		onchange="toggleOtherCK('contactWay','contactWayOtherDiv',13)"/>
						<span id="contactWayOtherDiv" style="display: none">
  						 	<input type="text" name="contactWayOther" id="contactWayOther"  value="${idmListEh.contactWayOther}"
   									reg='{"maxlength":"100"}' style="width: 150px;"/>
  						</span>
		        </tr>
				<tr>
					<th>防护措施（可多选）</th>
					<td><ehr:dic-checkbox dicmeta="IDM00529"  name="protectWay" value="${idmListEh.protectWay}"	onchange="toggleOtherCK('protectWay','protectWayOtherDiv',7)"/>
   								<span id="protectWayOtherDiv" style="display: none">
            						 	<input type="text" name="protectWayOther" id="protectWayOther" value="${idmListEh.protectWayOther}"
             									reg='{"maxlength":"100"}' style="width: 150px;"/>
            						 </span>
					</td>
				</tr>
				<tr>
					<th>接触时长（小时）</th>
					<td><input type="text" name="contactTime" value="${idmListEh.contactTime}"
	                                       reg='{"maxlength":"100"}' style="width: 50px;"/></td>
				</tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="hnCase.addEhList('4')">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="hnCase.editEhList('4')">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="caseEdit.closePopUp('eh4Dialog')">
    </div>
</div>