<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset>
	<legend>本次病情总体评价与转归 （管理结局）</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<tr>
			<th><label for="conclusion">结论</label></th>
			<td><ehr:dic dicmeta="DMD00035" code="${strtum.conclusion}" ></ehr:dic>
		</tr>
		<tr>
			<th><label for="affirmPerson">患者（或亲属）确认</label></th>
			<td><c:out value="${strtum.affirmPerson}"/></td>
		</tr>
	</table>
</fieldset>