<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKXG" value="<%=RoleType.JKXG.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/ncp/manageReport/classifySearch.js" type="text/javascript"></script>

<div class="section">

    <div class="toolbar">
        <a href="javascript:void(0)" id="report-export"><b class="export">导出</b></a>
    </div>
    <div class="searchBox">
        <form id="manageReportForm">
            <table>
                <colgroup>
                    <col style="width: 50px;" />
                    <col style="width: 80px;" />
                    <col style="width: 50px;" />
                    <col style="width: 60px;" />
                    <col style="width: 50px;" />
                    <col style="width: 200px;" />
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">机构</td>
                    <td class="col-input" colspan="4">
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKXG}">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" />
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${ZX_GLY},${ZXXG},${Z_GLY},${ZXG}">
                            <ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true"/>
                        </ehr:authorize>
                    </td>

                    <td style="text-align: right;"><input type="button" id="manageReportSearch" value="查询" class="search_btn" /></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

    <div id="manageReportListDiv">
    </div>
</div>