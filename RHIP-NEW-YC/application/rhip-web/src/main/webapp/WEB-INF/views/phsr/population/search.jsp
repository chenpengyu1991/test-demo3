<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/phsr/population/search.js" type="text/javascript"></script>

<div class="section">
    <div class="searchBox">
        <form id="populationForm">
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
                        <input type="radio" id="YearType" name="countType"  class="radioGroup" value="1" checked="checked" onclick="population.changeReportType()"/><label for="YearType">按年</label>
                        <input type="radio" id="QuarterType" name="countType"  class="radioGroup" value="2" onclick="population.changeReportType()"/><label for="QuarterType">按季度</label>
                        <tag:dateInput nullToToday="true" id="Year" name="year" pattern="yyyy"  date="${searchDate}" onlypast="true" reg='{"required":"true"}' style="width: 100px;"/>
                        <select id="Quarter" name="quarter" style="width: 100px;display:none">
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
                            <ehr:dic-town-centre-station centreName="parentCode" stationName="organCode" townName="gbCode" width="130px;" isShowOneself="true" />
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04">
                            <ehr:dic-town-centre-station centreName="parentCode" stationName="organCode" townName="gbCode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,03">
                            <ehr:dic-org-list name="organCode" width="150px" isShowOneself="true"/>
                        </ehr:authorize>
                    </td>
                    <td style="text-align: right;"><input type="button" id="populationSearch" value="查询" class="search_btn" /></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <div id="populationListDiv">
    </div>
</div>

