<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="posttable">
	<colgroup>
		<col style="min-width: 100px; width: 30%" />
		<col style="min-width: 150px; width: 70%" />
	</colgroup>
		<tr>
		<th><label for="visitDate">随访日期</label></th>
		<td><fmt:formatDate value="${strtum.visitDate}" pattern="yyyy/MM/dd"/></td>
	</tr>
	<tr>
		<th><label for="visitWayCode">随访方式</label></th>
		<td>
		<ehr:dic dicmeta="DMD00026" code="${strtum.visitWayCode}" ></ehr:dic>
	</tr>
</table>