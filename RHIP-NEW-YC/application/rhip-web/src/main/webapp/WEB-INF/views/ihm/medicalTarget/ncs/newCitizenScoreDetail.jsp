<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<fieldset>
<legend></legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
		</colgroup>
		<tr>
			<th>接口类型：</th>
			<td style="text-align: left">
				    <c:if test="${result.logType eq '1'}"><ehr:tip>5年内的捐献全血量</ehr:tip></c:if>
					<c:if test="${result.logType eq '2'}"><ehr:tip>5年内的捐献血小板量</ehr:tip></c:if>
				    <c:if test="${result.logType eq '3'}"><ehr:tip>是否早孕建卡</ehr:tip></c:if>
					<c:if test="${result.logType eq '4'}"><ehr:tip>是否满足5次产检检查</ehr:tip></c:if>
					<c:if test="${result.logType eq '5'}"><ehr:tip>是否3星健康档案</ehr:tip></c:if>
					<c:if test="${result.logType eq '6'}"><ehr:tip>是否预防接种齐全</ehr:tip></c:if>
				    <c:if test="${result.logType eq '7'}"><ehr:tip>是否办理从业人员健康证</ehr:tip></c:if>
					<c:if test="${result.logType eq '8'}"><ehr:tip>是否受过行政处罚</ehr:tip></c:if>
					<c:if test="${result.logType eq '9'}"><ehr:tip>儿童是否定期检查</ehr:tip></c:if>
			</td>
			<th>身份证号码：</th>
            <td style="text-align: left">${result.idCard}</td>
		</tr>
		<tr>
			<th>姓名：</th>
            <td style="text-align: left">${result.personName}</td>
			<th>出生日期：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.brithday}" pattern="yyyyMMdd"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>父亲/母亲姓名：</th>
			<td style="text-align: left">${result.parentName}</td>
			<th>参数时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.operateDate}" pattern="yyyyMMdd"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>创建时间：</th>
			<td style="text-align: left"><fmt:formatDate value="${result.createDate}" pattern="yyyyMMdd"></fmt:formatDate></td>
			<th></th>
            <td style="text-align: left"></td>
		</tr>
	</table>
</fieldset>
</div>