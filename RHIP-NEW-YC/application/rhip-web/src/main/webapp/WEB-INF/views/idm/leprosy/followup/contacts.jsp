<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript">
	$(function() {
		toggleOther('contactAttackCondition','spanAttackDt',1);
        var id= $("#closeTypeId").val();
        if(id==1){
//            $("#closeDetailId").removeClass("hide").addClass("show");
//            $("#checkSymptonId").removeClass("show").addClass("hide");
            $("#closeDetailId").show();
            $("#checkSymptonId").hide();
        }else if(id==2){
            $("#closeDetailId").hide();
            $("#checkSymptonId").show();
//            $("#closeDetailId").removeClass("show").addClass("hide");
//            $("#checkSymptonId").removeClass("hide").addClass("show");
        }else{
//            $("#closeDetailId").addClass("hide");
//            $("#checkSymptonId").addClass("hide");
            $("#closeDetailId").hide();
            $("#checkSymptonId").hide();
        }
    });
</script>
<div>
	<form id="contactForm">
		<div>
			<input type="hidden" id="rowNum" value="${rowNum}"/>
            <input type="hidden" id="closeTypeId" value="${contact.closeType}">
			<table class="formtable" id="popContactTable">
				<colgroup>
					<col style="width:80px;"/>
					<col style="width:200px;"/>
		            <col style="width:80px;"/>
					<col style="width:200px;"/>
				</colgroup>		
				<tr>
					<th><label class="required">姓名</label></th>
					<td><input type="text" name="closeName" reg='{"required":"true","maxlength":"50"}' value ='${contact.closeName}'/></td>
					<th>性别</th>
					<td><ehr:dic-radio id="contactSex" name="sex" dicmeta="GBT226112003" code="1,2" value ='${contact.sex}'/></td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><tag:dateInput name="birthday" date="${contact.birthday}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
					<th>与患者关系</th>
					<td>
						<ehr:dic-radio dicmeta="IDM00249" name="closeType" value="${contact.closeType}" onchange="followup.changeType('closeType')"/>
                        <span id="closeDetailId">
                        	<ehr:dic-list name="closeDetail" id="closeDetail" dicmeta="IDM00055" code="2,3,5,7,99" value="${contact.closeDetail}"/>
                        </span>
                        <span id="checkSymptonId">
                        	<ehr:dic-list name="checkSympton" id="checkSympton" dicmeta="IDM00057" code="2,3,4,99" value="${contact.checkSympton}"/>
                        </span>
					</td>
				</tr>
				<tr>
					<th>接触月数</th>
					<td><input type="text" name="closeMonths" reg='{"maxlength":"20"}' value ='${contact.closeMonths}' style="width:98%"/>	</td>
					<th>接触频率</th>
					<td><input type="text" name="closeFrequency" reg='{"maxlength":"20"}' value ='${contact.closeFrequency}' style="width:98%"/></td>
				</tr>
				<tr>
					<th><label class="required">检查结果</label></th>
					<td colspan="3">
						<ehr:dic-radio name="diagnosisResult" dicmeta="IDM00369" value ='${contact.diagnosisResult}' reg='{"required":"true"}'/>
					</td>
				</tr>				
			</table>
		</div>
	</form>
	<div class="toolbarpop">
		<c:if test="${type == 'add'}">
            <input type="button" id="saveContact" value="添加" onclick="followup.saveCcData('add','${rowIndex}')">
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" id="editContact" value="修改" onclick="followup.saveCcData('edit','${rowIndex}')">
        </c:if>
        <input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('contactDialog')">
	</div>
</div>
