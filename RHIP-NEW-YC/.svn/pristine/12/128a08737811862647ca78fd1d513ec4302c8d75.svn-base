<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:100px;width: 15%;"/>
			<col style="min-width:100px;width: 20%;"/>
			<col style="min-width:100px;width: 20%;"/>
			<col style="min-width:100px;width: 20%;"/>
	        <col style="min-width:100px;width: 15%;"/>	
	        <col style="min-width:80px;width: 10%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>接口类别</th>
				<th>身份证号码</th>
				<th>姓名</th>
				<th>父亲/母亲姓名</th>
				<th>参数时间</th>
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<tr>
					<td class="left">
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
					<td class="centertd"><ehr:tip>${result.idCard}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.personName}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${result.parentName}</ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${result.operateDate}" pattern="yyyyMMdd"></fmt:formatDate></ehr:tip></td>
					<td class="centertd"><a href="javascript:void(0)" onclick="newCitizenScoreSearch.viewNewCitizenScore('${result.id}')"
                           class="person-link-btn">查看</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			 <ehr:pagination action="newCitizenScoreSearch.search" />
		</tr>
	</table>
</div>