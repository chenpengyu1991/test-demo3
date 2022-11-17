<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fieldset id="death-info-box" class="${reportInfo.reportType =='2' ? 'show' :'hide'}">
	<legend> <span style="color: #ff0000">死亡信息</span></legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%; min-width: 100px;" />
			<col style="width: 35%; min-width: 200px;" />
			<col style="width: 15%; min-width: 100px;" />
			<col style="width: 35%; min-width: 200px;" />
		</colgroup>
		<tr>
			<th><label >死亡上报单位</label></th>
			<td><ehr:org code="${reportInfo.deathReportOrganCode}" /></td>
			<th><label >死亡日期</label></th>
			<td><fmt:formatDate pattern="yyyy/MM/dd" value="${reportInfo.deathDate}" /></td>
		</tr>
		<tr>
			<th><label >死亡原因</label></th>
			<td colspan="3"><input type="text" readonly="readonly" value="${reportInfo.deathReason}" /></td>
		</tr>
	</table>
</fieldset>
