<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<tr>
	<th><label for="bpExamFlag">血压检测标志</label></th>
	<td><ehr:dic dicmeta="DMD00027" code="${strtum.bpExamFlag}"></ehr:dic>
	<c:out value="${strtum.sbp}"/>~
	<c:out value="${strtum.dbp}"/>
</tr>
<tr>
	<th><label for="fpg">血糖检测</label></th>
	<td>
		<ehr:dic dicmeta="DMD00027" code="${strtum.bloodGlucoseFalg}"></ehr:dic>
		<table>
			<colgroup>
			<col style="width:190px;">
			</colgroup>
			<tr>
				<th><label for="fpg">空腹血糖值(mmol/L)</label></th>
				<td><c:out value="${strtum.fpg}" />mmol/L
				</td>
			</tr>
			<tr>
				<th><label for="gluValue">餐后2小时血糖值(mmol/L)</label></th>
				<td>
				<c:out value="${strtum.gluValue}"/>mmol/L
				</td>
			</tr>
			<tr>
				<th><label for="hgb">糖化血红蛋白值(%)</label></th>
				<td>
				<c:out value="${strtum.hgb}"/>%
			</tr>
		</table>
	</td>
</tr>
