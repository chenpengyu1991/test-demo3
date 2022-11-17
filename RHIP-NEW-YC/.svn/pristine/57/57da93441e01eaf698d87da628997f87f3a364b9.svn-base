<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
	<legend>非药物治疗措施</legend>
	<table class="posttable" >
		<tr>
			<td >
				<ehr:dic dicmeta="DMD00054" code="${strtum.nonDrugs}"></ehr:dic>
				<c:if test="${not empty strtum.nonDrugsOther}">
					<br />其他措施详细：<c:out value="${strtum.nonDrugsOther}" />
				</c:if>
			</td>
		</tr>
	</table>
</fieldset>