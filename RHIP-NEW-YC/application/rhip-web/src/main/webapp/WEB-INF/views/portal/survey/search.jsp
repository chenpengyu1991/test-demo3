<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ page import="com.founder.rhip.portal.common.SurveyStatus" %>

<c:set var="SAVE" value="<%=SurveyStatus.SAVE.getValue()%>"/>
<c:set var="START" value="<%=SurveyStatus.START.getValue()%>"/>
<c:set var="ENDS" value="<%=SurveyStatus.ENDS.getValue()%>"/>

<script type="text/javascript">
		 require(['views/portal/survey/search'],function(surveySearch){
		 surveySearch.load();
	 });
</script>

<div>
	<div id="top_allSurvey">
		<div class="toolbar">
		    <a id="surveyAddButId"><b class="xinz">新增</b></a>
		</div>
		 <div class="searchbox">
			<form id="searchSurveyForm" name="searchSurveyForm" method="post">
				<table id="surveySearchTableId">
		               <colgroup>
		                    <col style="width: 10%"/>
		                    <col style="width: 15%"/>
		                    <col style="width: 10%"/>
		                    <col style="width: 15%"/>
		                    <col style="width: 10%"/>
		                    <col style="width: 23%"/>
						   <col style="width: 23%"/>
		                </colgroup>
		     			<tbody>
						<tr>
							<td class="coltext">标题</td>
							<td class="colinput">
								<input type="text" style="width: 80%" id="survey.title" name="survey.title" />
		                    </td>
							<td class="coltext">审核状态</td>
							<td class="colinput">
								<ehr:dic-list name="survey.status" id="survey.status" dicmeta="LH00008"></ehr:dic-list>
							</td>
		                    <td class="coltext">创建日期</td>
		                     <td class="colinput">
		                         <tag:dateInput id="startDate" name="startDate" pattern="yyyy/MM/dd"  onlypast="true" style="width:38%;"/>
		                         ~<tag:dateInput id="endDate" name="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width:38%;"/>
		                     </td>
							<td class="colinput"/>
							<td class="colinput">
								<input type="button" id="surveySearchBut" value="查 询" class="search_btn" />
							</td>
						</tr>
					</tbody>
				</table>
		         <table>
		              <tr>
		                  <td colspan=6" class="colbottom">
		                         <span id="surveySearchSpanId" class="ico-bottom">&nbsp;</span>
		                  </td>
		              </tr>
		         </table>
			</form>
		</div>
		<div id="listDivSurvey"></div>
	</div>
 	<div id="detailDivSurvey"></div>
 	<div id="nextDetailDivSurvey"></div>
</div>
