<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<c:forEach items="${brwDiseaseInfo.tumorReports}" var="reportInfo">
			<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
			<tr>
				<th><label class="required" >肿瘤病名</label></th>
				<td><c:out value="${reportInfo.tumorType}"/></td>
				<th><label >ICD-10编码</label></th>
				<td><c:out value="${reportInfo.tumorIcdTenCode}"/></td>
			</tr>
			<tr>
				<th><label class="required" >知情状态标志</label></th>
				<td><ehr:dic dicmeta="PH00001"  code="${reportInfo.tumorInformedFlag}" /></td>
				<th><label >原发部位</label></th>
				<td><c:out value="${reportInfo.tumorPrimaryPart}"/></td>
			</tr>
			<tr>
				<th><label >转移部位</label></th>
				<td><c:out value="${reportInfo.tumorMetastasisPart}" /></td>
				<th><label >诊断依据</label></th>
				<td><ehr:dic dicmeta="DMD00010" code="${reportInfo.tumorDiagnosisDepends}"  /></td>
			</tr>
			<tr>
				<th><label >病理类型</label></th>
				<td><c:out value="${reportInfo.tumorPathologyType}"/></td>
				<th><label >ICD-0-3编码</label></th>
				<td><c:out value="${reportInfo.tumorIcdThreeCode}" /></td>
			</tr>
			<tr>
				<th><label class="required">发病日期</label></th>
				<td><fmt:formatDate value="${reportInfo.tumorAccidentDate}" pattern="yyyy/MM/dd" /></td>
				<th><label class="required" >诊断日期</label></th>
				<td><fmt:formatDate value="${reportInfo.tumorDiagnosisDate}" pattern="yyyy/MM/dd" /></td>
			</tr>
			</table>
			<hr />
		</c:forEach>