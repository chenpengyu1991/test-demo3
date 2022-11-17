<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset>
	<legend>非药物治疗措施</legend>
	<table class="posttable" >
		<tr>
			<td style="height: 50px">
				<ehr:dic dicmeta="DMD00054" code="${strtum.nonDrugs}"></ehr:dic>
				<br />
				<c:out value="${strtum.nonDrugsOther}" />(其他措施详细)
			</td>
		</tr>
	</table>
</fieldset>