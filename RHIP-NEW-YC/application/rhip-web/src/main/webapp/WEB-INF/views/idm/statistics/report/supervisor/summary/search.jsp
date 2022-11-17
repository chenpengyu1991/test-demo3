<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/supervisor/summary/search.js" type="text/javascript"></script>

<div  class="section">
	<div id="summaryTopAll">
		<div class="toolbar">
			<a href="javascript:void(0)" id="supervisorExport"><b class="export">导出</b></a>
		</div> 	
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="summarySearchForm">				
                <table id="summarySearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:70px; width: 10%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext"><span id="summaryTypeTextId">填报月份</span></td>
							<td class="colinput" colspan="3">
								<input type="radio" id="summaryMonthId" name="summaryType"  class="radioGroup" value="1" checked="checked" onclick="summarySearch.changeSummaryType()"/><label for="summaryMonthId">按月</label>
								<input type="radio" id="summaryYearId" name="summaryType"  class="radioGroup" value="2" onclick="summarySearch.changeSummaryType()"/><label for="summaryYearId">按年</label>
								<tag:dateInput nullToToday="true" id="reportMonthId" name="reportMonth" pattern="yyyy/MM"  date="${defaultMonth}" onlypast="true" style="width: 100px;"/>
								<tag:dateInput nullToToday="true" id="reportYearId" name="reportYear" pattern="yyyy"  date="${defaultMonth}"  onlypast="true" style="width: 100px;display:none"/>
							</td>
                            <td rowspan="2">
                                <input type="button" id="summaryBtnSearch" value="汇总" onclick="" class="search_btn"/>
                            </td>							
						</tr>
						<tr>						
                            <td class="coltext">填报单位</td>
                            <td class="colinput" colspan="4">
                            	<ehr:authorize ifAnyGranted="${JKFYK}">
		                        	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType21" name="reportUnitType" value="hospital,centre" type="radio" CHECKED="checked" ><label for="reportUnitType21">全部</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType22" name="reportUnitType" value="hospital" type="radio" ><label for="reportUnitType22">市级医院</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType23" name="reportUnitType" value="centre" type="radio" ><label for="reportUnitType23">中心</label>
    	                    	</ehr:authorize>                            
                                <ehr:org-type-list id="reportUnitCode" name="reportUnitCode" type="hospital,centre" value="${reportUnitCode}" code="${reportUnitCode}" width="250px"/>
                            </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'summarySearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="summaryResultDiv" style="min-width: 750px; min-height:300px;overflow: auto;"></div>
	</div>
	<div id="summarydetailDiv" ></div>
</div>

