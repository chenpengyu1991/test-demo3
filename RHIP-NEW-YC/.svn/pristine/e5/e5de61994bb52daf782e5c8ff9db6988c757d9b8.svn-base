<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>" />
<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/statisticsByMonth/statisticsByMonth.js"></script>
<div class="section">
	<div class="searchbox">
		<form method="post" id="statisticsByMonthForm">
			<input type="hidden" name="centerName" value="${statisticsByOrganCode}"/>
			<input type="text" style="display: none;"/>
			<table class="reportSearch" id="statisticsTable">
				<ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN}">
					<colgroup>
						<col style="width:10%;"/>
						<col style="width:53%;"/>
						<col style="width:10%;"/>
				        <col style="width:23%;"/>
					</colgroup>
					<tr>
						<td class="coltext">日期</td>
						<td class="colinput">
							<input id="inputExamYear" name="searchTime" type="text" value="${statisticsNow}"
								            onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月'})"
								            maxlength="10" readonly="true" style="width: 40%"/>
						</td>
						<td class="coltext">常住类型</td>
						<td class="colinput">
							<label><input type="radio" name="householdType" value="-1" id="householdType" checked="checked" />全部</label>
							<ehr:dic-radio dicmeta="FS10005" name="householdType" code="1,2"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<td class="coltext">城镇</td>
						<td class="colinput">
							<ehr:dic-town-centre-station townName="searchTown" centreName="searchCenter" width="40.5%;" />
						</td>
						<td></td>
						<td>
							<input type="button" id="search_btn" class="search_btn" value="查询"/>
						</td>
					</tr>
				</ehr:authorize>
				<ehr:authorize ifAnyGranted="${YY_GLY}">
					<colgroup>
						<col style="width:10%;"/>
						<col style="width:23%;"/>
						<col style="width:10%;"/>
				        <col style="width:23%;"/>
				        <col style="width:10%;"/>
				        <col style="width:23%;"/>
					</colgroup>
					<tr>
						<td class="coltext">日期</td>
						<td class="colinput">
							<input id="inputExamYear" name="searchTime" type="text" value="${statisticsNow}"
								            onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月'})"
								            maxlength="10" readonly="true" style="width: 80%"/>
						</td>
						<td class="coltext">常住类型</td>
						<td class="colinput">
							<label><input type="radio" name="householdType" value="-1" id="householdType" checked="checked" />全部</label>
							<ehr:dic-radio dicmeta="FS10005" name="householdType"></ehr:dic-radio>
						</td>
						<td></td>
						<td class="colinput">
							<input type="button" id="search_btn" class="search_btn" value="查询"/>
						</td>
					</tr>
				</ehr:authorize>
			</table>
			<table>
	            <tr>
	                <td colspan="8" class="colbottom">
	                      <span onclick="statisticsByMonthJS.toggle(this,'statisticsTable')" class="ico-bottom">&nbsp;</span>
	                </td>
	            </tr>
			</table>
		</form>
		<div id="statisticsResultDiv"></div>
	</div>
</div>