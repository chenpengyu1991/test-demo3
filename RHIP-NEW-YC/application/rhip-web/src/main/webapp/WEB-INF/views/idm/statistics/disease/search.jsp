<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/statistics/disease/search.js" type="text/javascript"></script>

<div class="sectionForBorder">
		<div class="searchBox">
			<form id="statisticsSearchForm">
				<table id="statisticsSearch">
					<colgroup>
					 	<col style="width: 8%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 100px;"/>
                        <col style="width: 8%; min-width: 50px;"/>
                        <col style="width: 8%; min-width: 50px;"/>
						<col style="width: 8%; min-width: 50px;"/>
						<col style="width: 38%; min-width: 100px;"/>
                        <col style="width: 10%; min-width: 50px;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">上报日期</td>
	                        <td class="col-input">
	                            <tag:dateInput id="fillBeginDate" name="fillBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 40%;"></tag:dateInput>
	                            ~<tag:dateInput nullToToday="true" id="fillEndDate" name="fillEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 40%;"></tag:dateInput>
	                        </td>
							<td class="col-text">疾病种类</td>
	                        <td class="col-input">
	                           <select id="diseaseType" name="diseaseType" style="width: 100%;">
	                           		<option value="1">甲类</option>
	                           		<option value="2">乙类</option>
	                           		<option value="3">丙类</option>
	                           		<option value="9">其他</option>
	                           </select>
	                        </td>
	                        <ehr:authorize ifAnyGranted="${ADMIN},${JKFYK}">
								<td class="col-text">上报机构</td>
								<td class="col-input">
									<ehr:dic-town-centre-station townName="townOrgCode" centreName="centerOrgCode" stationName="orgCode" style="width:130px;"/>
								</td>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${ZXCRB}">
								<td class="col-text">机构</td>
								<td class="col-input">
									<ehr:dic-org-list name="orgCode" width="30%" isShowOneself="true"/>
								</td>
							</ehr:authorize>
								<td class="col-text"><input type="button" id="statisticsBtnSearch" value="查询"
									onclick="" class="search_btn" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="5" class="col-bottom"><span
							onclick="statisticsSearch.toggle(this,'statisticsSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>

			</form>
		</div>

		<div id="statisticsResultDiv">
		</div>
</div>