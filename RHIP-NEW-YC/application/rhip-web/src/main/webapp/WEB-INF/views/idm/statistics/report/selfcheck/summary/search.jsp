<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/selfcheck/summary/search.js" type="text/javascript"></script>

<div  class="section">
	<div id="summaryTopAll">
		<div class="toolbar">
			<a href="javascript:void(0)" id="selfcheckExport"><b class="export">导出</b></a>
		</div> 	
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="summarySelfSearchForm">				
                <table id="summarySelfSearch" >
				<colgroup>
					<col style="min-width:70px; width: 15%;"/>
					<col style="min-width:100px; width: 65%;"/>
                    <col style="min-width:70px; width: 20%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">填报月份</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="reportMonthId" name="reportMonth" 
									date="${defaultMonth}" pattern="yyyy/MM"  onlypast="true" style="width: 100px;"/>
                                <%--隐藏的文本框是为了一个文本框不能响应回车事件的解决方法，不能删除--%>
                                <input type="text" style="display: none;">
							</td>
	                        <td  rowspan="2">
	                            <input type="button" id="summarySelfBtnSearch" value="汇总" onclick="" class="search_btn"/>
	                        </td>  							
						</tr>
						<tr>							
                            <td class="coltext">填报单位</td>
                            <td class="colinput">
                            	<ehr:authorize ifAnyGranted="${JKFYK}">
		                        	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType41" name="reportUnitType" value="hospital,centre" type="radio" CHECKED="checked" ><label for="reportUnitType41">全部</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType42" name="reportUnitType" value="hospital" type="radio" ><label for="reportUnitType42">市级医院</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType43" name="reportUnitType" value="centre" type="radio" ><label for="reportUnitType43">中心</label>
    	                    	</ehr:authorize>                             
                                <ehr:org-type-list id="selfSummaryUnitCodeId" name="reportUnitCode" type="hospital,centre" value="${reportUnitCode}" code="${reportUnitCode}" width="250px"/>
                            </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="statisticsCommon.toggle(this,'summarySelfSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="summarySelfResultDiv" style="min-width: 750px; min-height:300px;overflow: auto;"></div>
	</div>
	<div id="summarydetailDiv" ></div>
</div>

