<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/takeSample/search.js" type="text/javascript"></script>

<div  class="section">
	<div id="takeSampleTopAll">
		<div class="toolbar">
			<a href="javascript:void(0)" id="takeSampleExport"><b class="export">导出</b></a>
		</div> 	
		<div class="searchbox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="takeSampleSearchForm">				
                <table id="takeSampleSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 30%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 40%;"/>
                    <col style="min-width:70px; width: 10%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">患者姓名</td>
							<td class="colinput">
								<input type="text" name="name" style="width:180px"/>
							</td>
							<td class="coltext">性别</td>
							<td class="colinput">
								<ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" />
							</td>
                            <td rowspan="3">
                                <input type="button" id="takeSampleBtnSearch" value="汇总" onclick="" class="search_btn"/>
                            </td>								
						</tr>
						<tr>
							<td class="coltext">采样日期</td>
							<td class="colinput" colspan="3">
								<tag:dateInput nullToToday="true" id="reportBeginMonthId" name="reportBeginMonth" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;"/>
								~<tag:dateInput nullToToday="true" id="reportEndMonthId" name="reportEndMonth" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"/>
							</td>
						</tr>
						<tr>
                            <td class="coltext">采样单位</td>
                            <td class="colinput" colspan="3">
                            	<ehr:authorize ifAnyGranted="${JKFYK}">
		                        	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType51" name="reportUnitType" value="hospital,centre" type="radio" CHECKED="checked" ><label for="reportUnitType51">全部</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType52" name="reportUnitType" value="hospital" type="radio" ><label for="reportUnitType52">市级医院</label>
	    	                    	<input class="radioGroup" onclick="statisticsCommon.changeReportUnit(this.value)" id="reportUnitType53" name="reportUnitType" value="centre" type="radio" ><label for="reportUnitType53">中心</label>
    	                    	</ehr:authorize>                              
                                <ehr:org-type-list id="reportUnitCode" name="reportUnitCode" type="hospital,centre,other" value="${reportUnitCode}" code="${reportUnitCode}"  codeOther="46714114-9" width="200px"/>
                            </td>								

						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="5" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'takeSampleSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="takeSampleResultDiv" style="min-width: 750px; min-height:300px;overflow: auto;"></div>
	</div>
	<div id="takeSampledetailDiv" ></div>
</div>

