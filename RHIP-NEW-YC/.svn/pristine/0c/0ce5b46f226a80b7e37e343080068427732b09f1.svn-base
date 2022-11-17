<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="toolbar">
	<a href="javascript:void(0)" id="cdm-report-manageAndFollowup-export"><b class="export">导出</b></a>
</div>
<div id="list_view">
	<div class="section">
		<div class="searchbox">	
			<form id="manageAndfFollowupForm" name="" action="" method="post">
				<table id="hiddeSearch">
					<colgroup>
						<col style="min-width:100px; width: 10%;"/>
						<col style="min-width:160px; width: 30%;"/>
						<col style="min-width:160px; width: 45%;"/>
						<col style="min-width:160px; width: 25%;"/> 
				    </colgroup>		
					<tbody>				
					   <tr>	
					  		<td class="coltext">时间</td>
					   		<td>
					   			  <tag:dateInput style="width:110px;" name="mafr_beginAge" date="${defaultBeginDate}"  id="mafr_beginAge" onlypast="true"/>~
					   			  <tag:dateInput style="width:110px;" name="mafr_endAge" date="${currentDate}" id="mafr_endAge" onlypast="true"/>
					   		</td>	                  
						    <td >
						    	类型
					   			<input type="radio" name="cdmType" id="hbm" value="1" checked="checked">高血压
					   			<input type="radio" name="cdmType" id="di" value="2">糖尿病		
					   			<input type="radio" name="cdmType" id="tumor" value="5">肿瘤
					   			<input type="radio" name="cdmType" id="stroke" value="3">脑卒中
					   			<input type="radio" name="cdmType" id="coronary" value="4">冠心病
				
						  </td>
						    <td>
					   			<input id="mafr_SearchButton" type="button" class="button search_btn" value="查询" />
					   		</td>
					   </tr>
					   <tr>
					   
					   
					<ehr:authorize ifAnyGranted="11,01">
						<tr>
							<td class="coltext">管理机构</td>
							<td colspan="3">
								<ehr:dic-town-centre-station  centreName="centreCode" stationName="stationCode" townName="gbCode"
															  width="180px;"/>
							</td>
						</tr>
					</ehr:authorize>
					
					<ehr:authorize ifAnyGranted="03">
						<tr>
							<td class="coltext">管理机构</td>
							<td colspan="2">
									<ehr:dic-org-list  name="stationCode"  width="27.5%;"></ehr:dic-org-list>
							</td>
							<td></td>
						</tr>
					</ehr:authorize>
					   
					 
					   </tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="cdmWorkStatistics.toggle(this,'hiddeSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
		</div>
		<div id="manageAndFollowup_result"></div>
	</div>
</div>
