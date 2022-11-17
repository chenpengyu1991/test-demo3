<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/menubox/menubox.css"></link>
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/selfcheck/fill/search.js" type="text/javascript"></script>
<div>
	<div id="fillSelfTopAll">
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="fillSelfSearchForm">				
                <table id="fillSelfSearch" >
				<colgroup>
					<col style="min-width:70px; width: 15%;"/>
					<col style="min-width:100px; width: 65%;"/>
                    <col style="min-width:70px; width: 20%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">填报月份</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="reportBeginMonthId" name="reportBeginMonth" pattern="yyyy/MM"  onlypast="true" style="width: 100px;"/>
								~<tag:dateInput nullToToday="true" id="reportEndMonthId" name="reportEndMonth" pattern="yyyy/MM"  onlypast="true"  style="width: 100px;"/>
							</td>
	                        <td rowspan="2">
	                            <input type="button" id="selfFillBtnSearch" value="查询" onclick="" class="search_btn"/>
	                        </td> 								
						</tr>
						<tr>
                            <td class="coltext">填报单位</td>
                            <td class="colinput">
                            	<ehr:authorize ifAnyGranted="${JKFYK}">
		                        	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType31" name="reportUnitType" value="hospital,centre" type="radio" CHECKED="checked" ><label for="reportUnitType31">全部</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType32" name="reportUnitType" value="hospital" type="radio" ><label for="reportUnitType32">市级医院</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType33" name="reportUnitType" value="centre" type="radio" ><label for="reportUnitType33">中心</label>
    	                    	</ehr:authorize>                             
                                <ehr:org-type-list id="reportUnitCode" name="reportUnitCode" type="hospital,centre" value="${reportUnitCode}" code="${reportUnitCode}" width="250px"/>
                            </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'fillSelfSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="fillSelfResultDiv"></div>
	</div>
	<div id="fillSelfdetailDiv" ></div>
</div>

