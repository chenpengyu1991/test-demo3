<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/pam/person/performance2.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
	require(['views/pam/person/performanceSearch'],function(performanceSearch){
		performanceSearch.load();
	});
</script> -->
<%--统一人员绩效考核搜索--%>
<div class="section">
	<div class="searchBox">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <input type="hidden" id="disease" value="${disease}">
       	<!--  不能选择的机构类型 -->
        <input type="hidden" id="unSelectType" value="${unSelectType}">
        <!--  查询机构类型 -->
        <input type="hidden" id="organType" value="${organType}">
		<form id="performanceSearchForm" class="postcontent" style="padding: 0">
			<table id="targetSearch">
				<colgroup>
                	<col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 140px;"/>
					<col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 30%; min-width: 140px;"/>
                    <col />
                    <col/>
				</colgroup>
				<tbody>
					<tr>
                    	<td class="col-text">机构</td>
                    	 <c:if test="${not empty disease}">
                    	 	<td class="col-input">
                            <%--<ehr:dic-org-list  name="fillOrganCode"  width="180px;"></ehr:dic-org-list>--%>
                                <%--<ehr:dic-town-centre-station centreId="centre" townId="town" stationId="station" centreName="superOrganCode" stationName="organCode" townName="gbCode" width="180px;" />--%>
                                <input type="hidden" id="genreCode" name="genreCode"/>
                                <tag:autoSelect name="organCode" id="organCode" style="width:180px" ></tag:autoSelect>
                        	</td>
                        	<td class="col-text">类型</td>
                        	<td>
                        		<input name="opEmHpMark" class="radioGroup" id="opEmHpMark0" type="radio" value="" checked="checked"/><label for="opEmHpMark1">全部</label>
                        		<input name="opEmHpMark" class="radioGroup" id="opEmHpMark1" type="radio" value="1"/><label for="opEmHpMark1">门诊</label>
                        		<input name="opEmHpMark" class="radioGroup" id="opEmHpMark3" type="radio" value="3"/><label for="opEmHpMark1">住院</label>
                        	</td>
                        </c:if>
                         <c:if test="${empty disease}">
	                        <td class="col-input" colspan="3">
	                            <%--<ehr:dic-org-list  name="fillOrganCode"  width="180px;"></ehr:dic-org-list>--%>
	                                <%--<ehr:dic-town-centre-station centreId="centre" townId="town" stationId="station" centreName="superOrganCode" stationName="organCode" townName="gbCode" width="180px;" />--%>
	                                <input type="hidden" id="genreCode" name="genreCode"/>
	                                <tag:autoSelect name="organCode" id="organCode" style="width:180px" ></tag:autoSelect>
	                        </td>
                        </c:if>
					</tr>
                    <tr>
                        <td class="col-text">时间类型</td>
                        <td class="col-input">
                            <select name="rangeType" id="rangeType" style="width: 120px;">
                                <c:if test="${empty monthRangeFlag}"><option value="1">按月</option></c:if>
                                <c:if test="${empty quarterRangeFlag}"><option value="2">按季度</option></c:if>
                                <c:if test="${empty yearRangeFlag}"><option value="3">按年</option></c:if>
                                <c:if test="${empty rangeFlag}"><option value="4">按时间段</option></c:if>
                            </select>
                        </td>
                        <td class="col-text">时间</td>
                        <td class="col-input">
                            <input type="hidden" id="beginDate" name="beginDate"/>
                            <input type="hidden" id="endDate" name="endDate"/>
                            <div id="byMonth">
                                <tag:dateInput name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                            </div>
                            <div id="byQuarter">
                                <tag:dateInput name="quarterDate" pattern="yyyy" id="beginDate2" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                                <select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                                    <option value="1">第一季度</option>
                                    <option value="2">第二季度</option>
                                    <option value="3">第三季度</option>
                                    <option value="4">第四季度</option>
                                </select>
                            </div>
                            <div id="byYear">
                                <tag:dateInput name="yearDate" pattern="yyyy" id="beginDate3" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                                <c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label></c:if>
                                <c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label></c:if>
                                <c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label></c:if>
                            </div>
                            <div id="byRange">
                                <c:if test="${empty pattern}"><c:set var="patternFormat" value="yyyy/MM/dd"></c:set></c:if>
                                <c:if test="${not empty pattern}"><c:set var="patternFormat" value="${pattern}"></c:set></c:if>
                                <tag:dateInput name="beginDate4" pattern="${patternFormat}" id="beginDate4" maxId="endDate4" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>~<tag:dateInput name="endDate4" pattern="${patternFormat}" id="endDate4" minId="beginDate4" date="${currentEndDate}" onlypast="true"  style="width: 80px;"/>
                            </div>
                        </td>
                        <td style="text-align: left;">
                            <input type="button" id="searchBtn" value="查询" onclick="" class="search_btn" />
                        </td>
                    </tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom">
						<span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
    <div id="resultDiv">
        <jsp:include page="${listpath}" ></jsp:include>
    </div>
</div>