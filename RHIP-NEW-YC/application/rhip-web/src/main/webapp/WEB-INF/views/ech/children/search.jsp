<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKZYY" value="<%=RoleType.JKZYY.getValue()%>"/>
<c:set var="ZXZYY" value="<%=RoleType.ZXZYY.getValue()%>"/>
<c:set var="ZZYY" value="<%=RoleType.ZZYY.getValue()%>"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ech/children/search.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/child/examine/organSelect.js" ></script>

<link href="${pageContext.request.contextPath}/css/views/ech/report.css" type="text/css"   rel="stylesheet"/>
    <div class="section" id="echSearchId">
        <div class="toolbar">
        	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">中医药健康管理</a>
		        <a>
		          <cite>儿童中医药健康管理</cite></a>
		      </span>
		</div>
        </div>
        <div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="searchForm">
				<table id="searchTable">
					<colgroup>
                        <col style="width: 8%; min-width: 70px;"/>
                        <col style="width: 15%; min-width: 200px;"/>
                        <col style="width: 8%; min-width: 70px;"/>
                        <col style="width: 15%; min-width: 200px;"/>
						<col style="width: 10%; min-width: 100px;"/>
					</colgroup>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput"><input type="text" name="name" value="" class="x-layui-input" /></td>
                        <td class="coltext">身份证号</td>
                        <td class="colinput"><input type="text" name="idcard" value="" class="x-layui-input" /></td>
                        <td></td>
					</tr>
					<tr>
						<td class="coltext">管理机构</td>
						<td class="colinput" colspan="3">
                            <ehr:authorize ifAnyGranted="${ADMIN},${QWGZX},${JKZYY}">
                                <ehr:dic-town-centre-station centreName="centerCode" stationName="stationCode"  townName="townCode" width="30%" isShowOneself="true" includeTownCodes="${includeTownCodes}" cssClass="x-layui-input" />
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ZXZYY}">
                                <ehr:dic-org-list name="inputOrganCode" width="30%"  isShowOneself="true" cssClass="x-layui-input"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ZZYY}">
                                <ehr:dic-org-list name="inputOrganCode" width="30%" defaultval="Y" cssClass="x-layui-input"/>
                            </ehr:authorize>
						</td>
						<td style="text-align: center;">
							<%-- <input id="searchButton" type="button" name="" value="查询" class="search_btn"/> --%>
							<button class="layui-btn layui-btn-sm" id="searchButton"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span id="btnSearch" class="ico-bottom" onclick="echChildrenSearch.toggle(this, 'searchTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form>
        </div>
		<div class="toolbarSection">
			<ehr:authorize ifAnyGranted="${ZXZYY},${ZZYY}">
				<a href="javascript:void(0)" id="newChildExamBtn" onclick="echChildrenSearch.initReport('','new')">
					<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
				</a>
			</ehr:authorize>
		</div>
		<div id="mainResultDiv"></div>
    </div>
    <div id="maindetailDiv" ></div>
