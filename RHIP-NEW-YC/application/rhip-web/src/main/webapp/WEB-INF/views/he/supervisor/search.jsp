<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKJKJY" value="<%=RoleType.JKJKJY.getValue()%>"/>
<c:set var="ZXJKJY" value="<%=RoleType.ZXJKJY.getValue()%>"/>
<c:set var="ZJKJY" value="<%=RoleType.ZJKJY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/he/supervisor/search.js" type="text/javascript"></script>

<div class="section">
	    <ehr:authorize ifNotGranted="${QWGZX}">
			<input type="hidden" id="wgzx" value="${QWGZX}"/>
		<div class="toolbar">
			<a id="supervisorAdd" href="javascript:void(0)"><b id="btnReflashLabel" class="xinz">新增</b></a>
		</div>
		</ehr:authorize>
		<div class="searchBox">
			<form id="healthEducationSupervisorSearchForm">
				<table id="healthEducationSupervisorSearch">
					<colgroup>
						<col style="width: 50px;" />
						<col style="width: 200px;" />
						<col style="width: 50px;" />
						<col style="width: 300px;" />
						<col style="width: 80px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">时间</td>
							<td class="col-input"> 
								<input type="text" readonly="readonly" id="createBeginTime" 
                               onfocus="WdatePicker({skin:&#39;whyGreen&#39;,dateFmt:&#39;yyyy/MM/dd&#39;})" name="createBeginTime" style="width: 120px;"/>~
                        		<input type="text" readonly="readonly"  id="createEndTime" onfocus="WdatePicker({skin:&#39;whyGreen&#39;,dateFmt:&#39;yyyy/MM/dd&#39;})"
                               name="createEndTime" style="width: 120px;" />
                            </td>
                             <td class="col-text">机构</td>
							<td class="col-input"> 
								<ehr:authorize ifAnyGranted="${ADMIN},${JKJKJY}">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" />
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="${QWGZX}">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="${ZJKJY},${ZXJKJY}">
								<ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true"/>
								</ehr:authorize>
							</td>
							
                            <td style="text-align: right;" rowspan="2"><input type="button" id="healthEducationSupervisorBtnSearch" value="查询"
								 class="search_btn" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom"><span
							onclick="healthEducationSupervisorSearch.toggle(this,'healthEducationSupervisorSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="healthEducationSupervisorResultDiv">
		</div>
</div>