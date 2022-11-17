<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKJKJY" value="<%=RoleType.JKJKJY.getValue()%>"/>
<c:set var="ZXJKJY" value="<%=RoleType.ZXJKJY.getValue()%>"/>
<c:set var="ZJKJY" value="<%=RoleType.ZJKJY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/he/prescription/search.js" type="text/javascript"></script>

<div class="section" id="mainSearchDiv">
	<ehr:authorize ifAnyGranted="${JKJKJY},${ZXJKJY},${ZJKJY}">
		<div class="toolbar">
			<a id="prescriptionAdd" href="javascript:void(0)"><b id="btnReflashLabel" class="xinz">新增</b></a>
		</div>
	</ehr:authorize>	
		<div class="searchBox">
			<form id="healthEducationPrescriptionSearchForm">
				<table id="healthEducationPrescriptionSearch">
					<colgroup>
						<col style="width: 10%;"/>
						<col style="width: 20%;"/>
						<col style="width: 10%;"/>
						<col style="width: 40%;"/>
						<col style="width: 20%;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">处方名称</td>
							<td class="col-input"><input type="text" name="name" style="width:110px;"/></td>
							<td class="col-text">时间</td>
							<td class="col-input"> 
								<tag:dateInput name="createBeginTime" id="createBeginTime"  style="width: 100px;"/>~<tag:dateInput name="createEndTime" id="createEndTime"  style="width: 100px;"/>
                            </td>
							<td></td>
						</tr>
						<tr>
							<td class="col-text">发布状态</td>
							<td class="colinput">
								<ehr:dic-list id="status" dicmeta="LH00007" name="status" reg="{'required':true}"
											  width="45%"/>
							</td>
                            <td class="col-text">机构</td>
							<td class="col-input">
								<ehr:authorize ifAnyGranted="${QWGZX}">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="110px;" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
								</ehr:authorize>
                                <ehr:authorize ifNotGranted="${QWGZX}">
									<input type="hidden" id="wgzx" value="${QWGZX}"/>
								<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="110px;" />
								</ehr:authorize>
							</td>

							<td>
								<input type="button" id="healthEducationPrescriptionBtnSearch" value="查询"
									   class="search_btn"/>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom">
							<span onclick="util.toggle(this,'healthEducationPrescriptionSearch')" class="ico-bottom">&nbsp;</span>
						</td>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="healthEducationPrescriptionResultDiv">
		</div>
</div>
<div id="operationDiv"></div>