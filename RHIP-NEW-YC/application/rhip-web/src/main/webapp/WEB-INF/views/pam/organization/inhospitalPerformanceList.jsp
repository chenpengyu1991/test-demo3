<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<div id='currentSearch'>
    <input type="hidden" id="resultGenreCode" value="${resultGenreCode}">
    <input type="hidden" id="resultOrganCode" value="${resultOrganCode}">
    <input type="hidden" id="resultSuperOrganCode" value="${resultSuperOrganCode}">
    <input type="hidden" id="resultGbCode" value="${resultGbCode}">
    <input type="hidden" id="resultRangeType" value="${resultRangeType}">
    <input type="hidden" id="resultMonthDate" value="${resultMonthDate}">
    <input type="hidden" id="resultRangeQuarter" value="${resultRangeQuarter}">
    <input type="hidden" id="resultQuarterDate" value="${resultQuarterDate}">
    <input type="hidden" id="resultYearType" value="${resultYearType}">
    <input type="hidden" id="resultYearDate" value="${resultYearDate}">
</div>
<div>
    <input type="hidden" id="chart_orgcode" value="">
    <input type="hidden" id="chart_title" value="">
    <input type="hidden" id="this_data" value="">
    <input type="hidden" id="categories" value="">
    <input type="hidden" id="seriesname" value="">
</div>

<div style="height: 400px;">
<div class="repeattable">
<div style="min-width: 1000px; width: 100%">
<div id="cpwlisttableTopDiv">
    <table>
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
            </c:choose>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
        </colgroup>
        <thead>
        <tr>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>镇</th>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <th colspan="2">医疗机构</th>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <th colspan="3">医疗机构</th>
                </c:when>
                <c:otherwise>
                    <th rowspan="2">医疗机构</th>
                </c:otherwise>
            </c:choose>
             <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>平均出院病人数</th>
		            <th>平均住院日数</th>
		            <th>平均住院费用</th>
                </c:when>
                <c:otherwise>
                	<th rowspan="2">平均出院病人数</th>
		            <th rowspan="2">平均住院日数</th>
		            <th rowspan="2">平均住院费用</th>
                </c:otherwise>
            </c:choose>
        </tr>
        <c:if test="${genreCode != '0' }">
        	<tr>
	            <c:choose>
	                <c:when test="${genreCode == HOSPITAL}">
	                    <th>镇</th>
	                    <th>医院</th>
	                </c:when>
	                <c:when test="${genreCode == CENTRE}">
	                    <th>镇</th>
	                    <th>卫生院</th>
	                </c:when>
	                <c:when test="${genreCode == STATION}">
	                    <th>镇</th>
	                    <th>中心</th>
	                    <th>站</th>
	                </c:when>
	            </c:choose>
	          </tr>
        </c:if>
        </thead>
    </table>
</div>
<div id="cpwlisttableDiv" <c:if test="${genreCode != '0' }">class="contentfixed144"</c:if> style="min-width: 1000px; width: 100%;overflow-x: auto; margin-left: -2px;">
    <table style="width: 100%;">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
                <c:otherwise>
                    <col style="width: 160px;"/>
                </c:otherwise>
            </c:choose>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
        </colgroup>
        <tbody>
        <c:forEach var="report" items="${result}" varStatus="status">
            <tr>
                <c:choose>
	              	<c:when test="${genreCode == '0' }">
              			<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip>
              				<c:if test="${report.gbCode == '合计' || report.organCode == '合计'}"> <b>合计</b> </c:if>
              			</td> 
	              	</c:when>
	              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
	              		<c:choose>
	              			<c:when test="${report.gbCode == '合计' || report.organCode == '合计'}">
	              				<td colspan="2" class="centertd"><b>合计</b></td>
	              			</c:when>
	              			<c:when test="${report.gbCode == '小计' || report.organCode == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
	              				<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				 <td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
	              				 <td><ehr:tip><ehr:org code="${report.organCode}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              	</c:when>
	                  <c:when test="${genreCode == STATION}">
	                  	<c:choose>
	              			<c:when test="${report.gbCode == '合计' || report.organCode == '合计'}">
	              				<td colspan="3" class="centertd"><b>合计</b></td> 
	              			</c:when>
	              			<c:when test="${report.gbCode == '小计' || report.organCode == '小计'}">
	              			<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.centerCode}"/></ehr:tip></td>
			                  	<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.centerCode}"/></ehr:tip></td>
			                  	<td><ehr:tip><ehr:org code="${report.organCode}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	                  </c:when>
              </c:choose>
               <td data-is-data="true" data-total-level="0" data-total="${report.leaveNum}"><tags:numberLabel value="${report.leaveNum}" defaultValue="0" /></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.inhospitalDay}"><tags:numberLabel value="${report.inhospitalDay}" defaultValue="0" /></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.feeTotal}"><tags:numberLabel value="${report.feeTotal}" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</div>
</div>
