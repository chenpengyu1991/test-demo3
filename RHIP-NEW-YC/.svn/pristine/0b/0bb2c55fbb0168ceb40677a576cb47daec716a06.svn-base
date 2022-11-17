<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<table class="posttable">
	<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
	<tr>
		<th><label for="coronaryType">冠心病类型</label></th>
		<td><ehr:dic dicmeta="DMD00008" code="${brwDiseaseInfo.coronaryType}"/></td>
		<th><label>确诊时间</label></th>
		<td><fmt:formatDate value='${brwDiseaseInfo.coronaryDiagnosisDate}' pattern='yyyy/MM/dd'/></td>
	</tr>	
	<tr>
		<th><label >家族史</label></th>
		<td><ehr:dic dicmeta="PH00001" code="${brwDiseaseInfo.coronaryFamilyHisFlag}" /></td>
		<th><label>身体活动受限</label></th>
		<td><ehr:dic dicmeta="FS10246" code="${brwDiseaseInfo.coronaryBodyLimitFlag}" /></td>
	</tr>
</table>
