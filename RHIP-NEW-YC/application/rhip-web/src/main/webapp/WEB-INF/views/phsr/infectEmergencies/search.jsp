<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/phsr/infectEmergencies/search.js" type="text/javascript"></script>

<div class="section">

    <div class="toolbar">
        <a id="infectEmergenciesListDivExport" href="javascript:void(0)"><b class="export">导出</b></a>
       <%-- <c:if test="${roleType eq '02' || roleType eq '03'}">
       <span id="modifyInfectEmer">
            <a href="javascript:void(0)" id="modify" ><b class="xiug">修改</b></a>
        </span>
        <span id="cancelInfectEmer">
            <a href="javascript:void(0)" id="cancel" ><b class="quxiao">取消</b></a>
            <a href="javascript:void(0)" id="save" ><b class="baocun">保存</b></a>
        </span>
        </c:if>--%>
    </div>

    <div class="searchBox">
        <form id="infectEmergenciesForm">
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
                    <td class="col-text"><label>时间范围</label></td>
                    <td class="col-input" colspan="4">
                        <input type="radio" id="mhmReprtYearId" name="countType"  class="radioGroup" value="1" checked="checked" onclick="infectEmergencies.changeReportType()"/><label for="mhmReprtYearId">按年</label>
                        <input type="radio" id="mhmReprtQuarterId" name="countType"  class="radioGroup" value="2" onclick="infectEmergencies.changeReportType()"/><label for="mhmReprtQuarterId">按季度</label>
                        <tag:dateInput nullToToday="true" id="reportYearId" name="year" pattern="yyyy"  date="${searchDate}" onlypast="true" reg='{"required":"true"}' style="width: 100px;"/>
                        <select id="reportQuarter" name="quarter" style="width: 100px;display:none">
                            <option value="1">第一季度</option>
                            <option value="2">第二季度</option>
                            <option value="3">第三季度</option>
                            <option value="4">第四季度</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">机构</td>
                    <td class="col-input" colspan="4">
                        <ehr:authorize ifAnyGranted="01,12">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" />
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,03">
                            <ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true"/>
                        </ehr:authorize>
                    </td>

                    <td style="text-align: right;"><input type="button" id="infectEmergenciesSearch" value="查询" class="search_btn" /></td>
                </tr>
                </tbody>
            </table>
            <%--<table>
                <tr>
                    <td colspan="4" class="col-bottom"><span
                            onclick="healthVaccinationSearch.toggle(this,'healthVaccinationSearch')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>--%>
        </form>
    </div>

    <div id="infectEmergenciesListDiv">

    </div>
</div>