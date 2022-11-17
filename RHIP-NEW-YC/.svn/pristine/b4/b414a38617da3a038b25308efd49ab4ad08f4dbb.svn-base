<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/monthReport/dysentery/list.js" type="text/javascript"></script>
<div id="dysenteryList" class="repeattable">
	<form id="dysenteryForm">
		<input type="hidden" name="currentOrgCode" value="${currentOrgCode}"/>
		<input type="hidden" name="currentMonth" value="${currentMonth}"/>
		<input type="hidden" id="reportNameId" name="reportName" value="<ehr:org code="${fillOrgCode}"/>${reportMonth}传染病管理月报表"/>
	<table id="dysenterytable">
		<colgroup>
			<col style="width: 100px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>
			<col style="width: 80px;"/>						
		</colgroup>		
		<thead>
			<tr style="text-align: center;">
				<td style="border:none;"></td>
				<td style="border:none;" colspan="11">
					<h1 style="font-size:150%;margin: 20px 0px 20px 0px">细菌性痢疾流调月报表</h1>
				</td>
				<td style="border:none;"></td>
			</tr>
			<tr>
				<th rowspan="2"></th>
				<th rowspan="2">病例数</th>
				<th rowspan="2">流调数</th>
				<th rowspan="2">饮服业病人数</th>
				<th colspan="3">实验室检查依据</th>
				<th colspan="4">可能感染因素</th>
				<th colspan="2">病家消毒</th>
			</tr>
			<tr>
				<th>培养(+)</th>
				<th>常规(+)</th>
				<th>未做</th>
				<th>水</th>
				<th>食物</th>
				<th>接触</th>
				<th>不详</th>
				<th>上门</th>
				<th>自行</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="dysentery" items="${dysenterys}" varStatus="status">
				<c:if test="${dysentery.diseaseCode !='-1'}">
					<tr>
						<td>
							<ehr:tip>本月</ehr:tip>
							<input type="hidden" name="diseaseCode" value="${dysentery.diseaseCode}"/>
						</td>
						<td><tags:numberLabel value="${dysentery.report}"/></td>
						<td><tags:numberLabel value="${dysentery.survey}"/></td>
						<td><tags:numberLabel value="${dysentery.catering}"/></td>
						<td>
							<span id="viewReport1${status.count}Id" style="float:right;">${dysentery.culture}</span>
							<input type="text" id="editReport1${status.count}Id" name="culture" value="${dysentery.culture}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<tags:numberLabel value="${dysentery.routine}"/>
						</td>
						<td>
							<tags:numberLabel value="${dysentery.notDone}"/>
						</td>
						<td>
							<span id="viewReport2${status.count}Id" style="float:right;">${dysentery.water}</span>
							<input type="text" id="editReport2${status.count}Id" name="water" value="${dysentery.water}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport3${status.count}Id" style="float:right;">${dysentery.food}</span>
							<input type="text" id="editReport3${status.count}Id" name="food" value="${dysentery.food}" style="width: 95%;text-align: right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport4${status.count}Id" style="float:right;">${dysentery.contact}</span>
							<input type="text" id="editReport4${status.count}Id" name="contact" value="${dysentery.contact}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport5${status.count}Id" style="float:right;">${dysentery.unspecified}</span>
							<input type="text" id="editReport5${status.count}Id" name="unspecified" value="${dysentery.unspecified}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>						
						<td>
							<span id="viewReport6${status.count}Id" style="float:right;">${dysentery.call}</span>
							<input type="text" id="editReport6${status.count}Id" name="call" value="${dysentery.call}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport7${status.count}Id" style="float:right;">${dysentery.self}</span>
							<input type="text" id="editReport7${status.count}Id" name="self" value="${dysentery.self}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>												
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach var="dysentery" items="${dysenterys}" varStatus="status">
				<c:if test="${dysentery.diseaseCode =='-1'}">
					<tr>
						<td>
							<ehr:tip>累计</ehr:tip>
						</td>
						<td><tags:numberLabel value="${dysentery.report}"/></td>
						<td><tags:numberLabel value="${dysentery.survey}"/></td>
						<td><tags:numberLabel value="${dysentery.catering}"/></td>
						<td><tags:numberLabel value="${dysentery.culture}"/></td>
						<td><tags:numberLabel value="${dysentery.routine}"/></td>
						<td><tags:numberLabel value="${dysentery.notDone}"/></td>
						<td><tags:numberLabel value="${dysentery.water}"/></td>
						<td><tags:numberLabel value="${dysentery.food}"/></td>
						<td><tags:numberLabel value="${dysentery.contact}"/></td>
						<td><tags:numberLabel value="${dysentery.unspecified}"/></td>						
						<td><tags:numberLabel value="${dysentery.call}"/></td>
						<td><tags:numberLabel value="${dysentery.self}"/></td>												
					</tr>
				</c:if>
			</c:forEach>			
			<tr>
				<td colspan="13" style="border:none;text-align: left;">
					<p>填表要求：各单位于每月3日前将上月的《传染病管理月报表》通过市疾病预防</p>
				</td>
			</tr>
			<tr>
				<td colspan="13" style="border:none;text-align: right;">
					<c:choose>
						<c:when test="${empty fillUserId}">
							<span style="margin: 0px 180px 20px 0px">填表单位</span>
							<span style="margin:0px 100px 20px 0px">填报人：</span>
							<span style="margin: 0px 150px 20px 0px">填报日期：</span>						
						</c:when>
						<c:otherwise>
							<span style="margin: 0px 10px 20px 0px">填表单位</span>
							<span style="margin: 0px 10px 0px 0px"><b><ehr:org code="${fillOrgCode}"/></b></span>
							<span style="margin: 0px 10px 20px 0px">填报人：</span>
							<span style="margin: 0px 10px 0px 0px"><b><ehr:user userCode="${fillUserId}"/></b></span>
							<span style="margin: 0px 100px 20px 0px">填报日期：<b><fmt:formatDate pattern="yyyy/MM/dd" value="${fillDt}"/></b></span>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>									
		</tbody>
	</table>
	</form>
</div>