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
		<td></td>
		<td></td>
	</tr>
	<tr>
		<th><label class="required" for="visitDate">随访日期</label></th>
		<td><tag:dateInput onlypast="true" id="visitDate" name="visitDate" date="${strtum.visitDate}" reg="{'required':true}" /></td>
	</tr>
	<tr>
		<th><label class="required" for="visitWayCode">随访方式</label></th>
		<td><ehr:dic-radio reg="{'required':true}" dicmeta="DMD00026" value="${strtum.visitWayCode}" name="visitWayCode"></ehr:dic-radio></td>
	</tr>
	<tr>
		<th><label class="required" for="condition">病情（常规）</label></th>
		<td><textarea id="condition" name="condition" reg="{'required':true,'maxlength':100}">${strtum.condition}</textarea></td>
	</tr>
	<tr>
		<th><label class="required" for="treatment">治疗（常规）</label></th>
		<td><textarea id="treatment" name="treatment" reg="{'required':true,'maxlength':100}">${strtum.treatment}</textarea></td>
	</tr>
</table>
<jsp:include page="../common/inputInfo.jsp"></jsp:include>
