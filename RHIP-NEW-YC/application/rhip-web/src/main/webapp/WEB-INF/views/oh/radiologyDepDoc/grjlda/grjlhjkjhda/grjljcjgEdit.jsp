<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grjlda/grjlhjkjhda/grjljcjgEdit.js" type="text/javascript"></script>
<input id="ohDoseDetectionOperationType" type="hidden" value="${ohDoseDetectionOperationType }">
<div>
	<form method="post" id="doseDetection_form">
	    <input name="id" type="hidden" value="${record.id }">
	    <input name="isDelete" type="hidden" value="${record.isDelete }">
		<div class="postcontent">
			<div class="postdiv">
				<fieldset>
					<legend>个人剂量检测结果</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="40%" />
							<col width="40%" />
						<colgroup>
						<tr>
							<th><label>检测时间:</label></th>
							<td><tag:dateInput nullToToday="true" onlypast="true" name="detectionQuarter" date="${record.detectionQuarter}" reg='{"maxlength":"16"}' /></td>
						</tr>
						<tr>
							<th><label>检测结果:</label></th>
							<td><input type="text" name="detectionResult" value="${record.detectionResult}" reg='{"maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label>录入时间:</label></th>
							<td><tag:dateInput nullToToday="true" onlypast="true" name="inputTime"  date="${record.inputTime}" ></tag:dateInput></td>
						</tr>
						<tr>
							<th><label>录入人:</label></th>
							<td><input type="text" name="inputPerson" value="${record.inputPerson }" reg='{"maxlength":"16"}'><td>
						</tr>
						<tr>
							<th><label>确认时间:</label></th>
							<td><tag:dateInput nullToToday="true" onlypast="true" name="confirmTime"  date="${record.confirmTime}" ></tag:dateInput></td>
						</tr>
						<tr>
							<th><label>确认人:</label></th>
							<td><input type="text" name="confirmPerson" value="${record.confirmPerson}" reg='{"maxlength":"16"}'></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>
	</form>
</div>
<div style="text-align: center">
	<div>
		    <input id="saveRecord" class="btnopr" type="button"  value="保存" onclick="grjldaEdit.save()"/>&nbsp;&nbsp;&nbsp;&nbsp; 
		    <input id="cancleRecord" class="btnopr" type="button"  value="取消" onclick="grjldaEdit.cancle()" />
	</div>
</div>