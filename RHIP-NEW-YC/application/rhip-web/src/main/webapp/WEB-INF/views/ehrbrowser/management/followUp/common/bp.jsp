<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<tr>
	<th><label for="bpExamFlag">血压检测标志</label></th>
	<td><ehr:dic dicmeta="DMD00027" code="${strtum.bpExamFlag}"></ehr:dic>
	<c:if test="${strtum.bpExamFlag == '1'}">
		<c:out value="${strtum.sbp}"/>
		<c:if test='${strtum.bpExamFlag eq "1"}'>~</c:if>
		<c:out value="${strtum.dbp}"/>mmHg
	</c:if>
</tr>
<tr>
	<th><label for="fpg">血糖检测</label></th>
	<td>
		<ehr:dic dicmeta="DMD00027" code="${strtum.bloodGlucoseFalg}"></ehr:dic>
		<table style="display:${strtum.bloodGlucoseFalg !='1'?'none':'inline' }" >
			<colgroup>
				<col style="width:250px;">
				<col style="width:100px;">
			</colgroup>
			<tr>
				<th><label for="fpg">空腹血糖值</label></th>
				<td><c:out value="${strtum.fpg}" />mmol/L
				</td>
			</tr>
			<tr>
				<th><label for="gluValue">餐后2小时血糖值</label></th>
				<td>
				<c:out value="${strtum.gluValue}"/>mmol/L
				</td>
			</tr>
			<tr>
				<th><label for="hgb">糖化血红蛋白值</label></th>
				<td>
				<c:out value="${strtum.hgb}"/>%
			</tr>
		</table>
	</td>
</tr>
<tr>
	<th><label for="fat">血脂检测</label></th>
	<td>
		<ehr:dic dicmeta="DMD00027" code="${strtum.bloodFat}"></ehr:dic>
			<table style="display:${strtum.bloodFat !='1'?'none':'inline' }" >
				<colgroup>
				<col style="width:250px;"><col style="width:100px;">
				</colgroup>
				<tr>
					<th><label for="tc">总胆固醇值(mmol/L)</label></th>
					<td><c:out value="${strtum.tc}" /></td>
				</tr>
				<tr>
					<th><label for="triglycerideValue">甘油三酯值(mmol/L)</label></th>
					<td><c:out value="${strtum.triglycerideValue}" /></td>
				</tr>
				<tr>
					<th><label for="ldlcDetectValue">血清低密度脂蛋白胆固醇检测值(mmol/L)</label></th>
					<td><c:out value="${strtum.ldlcDetectValue}" /></td>
				</tr>
				<tr>
					<th><label for="hdlcDetectValue">血清高密度脂蛋自胆固醇检测值(mmol/L)</label></th>
					<td><c:out value="${strtum.hdlcDetectValue}" /></td>
				</tr>
			</table>
	</td>
</tr>
