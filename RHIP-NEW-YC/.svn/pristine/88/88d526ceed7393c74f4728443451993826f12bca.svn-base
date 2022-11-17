<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/supervisor/fill/search.js" type="text/javascript"></script>
<div>
	<div id="fillTopAll">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="fillSearchForm">				
                <table id="fillSearch" >
				<colgroup>
					<col style="min-width:80px; width: 15%;"/>
					<col style="min-width:150px; width: 30%;"/>
					<col style="min-width:80px; width: 15%;"/>
					<col style="min-width:150px; width: 30%;"/>
                    <col style="min-width:100px; width: 10%;"/>
				</colgroup>
					<tbody>
						<tr>
							<td class="coltext">填报月份</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="reportBeginMonthId" name="reportBeginMonth" pattern="yyyy/MM"  onlypast="true" style="width: 36%;"/>
								~<tag:dateInput nullToToday="true" id="reportEndMonthId" name="reportEndMonth" pattern="yyyy/MM"  onlypast="true"  style="width: 36%;"/>
								
							</td>
							<td class="coltext">填报日期</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="reportBeginDateId" name="reportBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"/>
								~<tag:dateInput nullToToday="true" id="reportEndDateId" name="reportEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"/>
							</td>
							<td></td>
						</tr>
						<tr>
                            <td class="coltext">填报单位</td>
                            <td class="colinput" colspan="3">
                            	<ehr:authorize ifAnyGranted="${JKFYK}">
		                        	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType11" name="reportUnitType" value="hospital,centre" type="radio" CHECKED="checked" ><label for="reportUnitType11">全部</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType12" name="reportUnitType" value="hospital" type="radio" ><label for="reportUnitType12">市级医院</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType13" name="reportUnitType" value="centre" type="radio" ><label for="reportUnitType13">中心</label>
    	                    	</ehr:authorize>
                                <ehr:org-type-list id="reportUnitCode" name="reportUnitCode" type="hospital,centre" value="${reportUnitCode}" code="${reportUnitCode}" width="250px"/>
                            </td>
                            <td>
                                <input type="button" id="fillBtnSearch" value="查询" onclick="" class="search_btn"/>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'fillSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="fillResultDiv"></div>
	</div>
	<div id="filldetailDiv" ></div>
</div>

