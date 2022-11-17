<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/report/acuteReport/year/search.js" type="text/javascript"></script>

<div  class="section">
	<div id="acuteYearTopAll">
		<div class="toolbar">
			<a href="javascript:void(0)" id="acuteYearExport"><b class="export">导出</b></a>
		</div> 	
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}"/>
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="acuteYearSearchForm">				
                <table id="acuteYearSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">填报年份</td>
							<td class="colinput">
								<tag:dateInput nullToToday="true" id="fillDateId" name="fillDate" 
									date="${defaultMonth}" pattern="yyyy"  onlypast="true"/>
                                <%--隐藏的文本框是为了一个文本框不能响应回车事件的解决方法，不能删除--%>
                                <input type="text" style="display: none;">
							</td>
							<td></td>
							<td></td>
							<td></td>
	                        <td rowspan="2">
	                            <input type="button" id="acuteYearBtnSearch" value="汇总" onclick="" class="search_btn"/>
	                        </td> 														
						</tr>
						<tr>								
                            <td class="coltext">填报单位</td>
                            <td class="colinput" colspan="4">
                            	<ehr:authorize ifAnyGranted="${JKYFJZ}">
		                        	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType91" name="reportUnitType" value="hospital,centre,other" type="radio" CHECKED="checked" ><label for="reportUnitType91">全部</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType92" name="reportUnitType" value="hospital" type="radio" ><label for="reportUnitType92">市级医院</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType93" name="reportUnitType" value="centre" type="radio" ><label for="reportUnitType93">乡镇卫生院</label>
    	                    	</ehr:authorize>                               
                                <ehr:org-type-list id="fillOrganCodeId" name="fillOrganCode" type="hospital,centre,other" value="${fillOrganCode}" code="${fillOrganCode}"  codeOther="46714114-9" width="250px"/>
                                <input type="hidden" id="codeOther" value="46714114-9"/>
                            </td>
                            <td></td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'acuteYearSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="acuteYearResultDiv" style="min-width: 750px; min-height:300px;overflow: auto;"></div>
	</div>
	<div id="acuteYeardetailDiv" ></div>
</div>

