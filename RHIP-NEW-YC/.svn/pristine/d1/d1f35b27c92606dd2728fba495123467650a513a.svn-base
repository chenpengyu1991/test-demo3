<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<table class="posttable">
	<colgroup>
			<col style="width: 15%" />
			<col style="width: 35%" />
			<col style="width: 15%" />
			<col style="width: 35%" />
		</colgroup>
	<tr>
		<th><label for="strokeType">脑卒中类型</label></th>
		<td><ehr:dic dicmeta="DMD00009"   code="${brwDiseaseInfo.strokeType}" /></td>
		<th><label>确诊时间</label></th>
		<td><fmt:formatDate value='${brwDiseaseInfo.strokeDiagnosisDate}' pattern='yyyy/MM/dd'/></td>
	</tr>

	<tr>
		<th><label >家族史</label></th>
		<td><ehr:dic  dicmeta="PH00001"  code="${brwDiseaseInfo.strokeFamilyHisFlag}"  /></td>
		<th><label>身体活动受限</label></th>
		<td><ehr:dic dicmeta="FS10246"  code="${brwDiseaseInfo.strokeBodyLimitFlag}" /></td>
	</tr>
</table>