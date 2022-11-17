<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/phsr/childCensus/search.js" type="text/javascript"></script>

<div class="section">
		<div class="toolbar">
		    <a id="childCensusExport" href="javascript:void(0)"><b class="export">导出</b></a>
		</div>
		<div class="searchBox">
			<input type="hidden" name="timeFlag" value="1"/>
			<form id="childCensusSearchForm">
				<table id="childCensusSearch">
					<colgroup>
						<col style="width: 50px;" />
						<col style="width: 80px;" />
						<col style="width: 50px;" />
						<col style="width: 60px;" />
						<col style="width: 50px;" />
						<col style="width: 200px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text"><label class="required">年份</label></td>
							<td class="col-input">
								<tag:dateInput name="year" id="year"  onlypast="true" style="width:120px;"  date="${currentYear}"  pattern="yyyy" reg='{"required":"true"}'/>
							</td>
							<td class="col-text"><span id="summaryTypeTextId">月份</span></td>
							<td class="col-input" colspan="3">
								<input type="radio" id="monthType" name="summaryType"  class="radioGroup" value="1" checked="checked" onclick="childCensusSearch.changeSummaryType()"/><label for="monthType">月份</label>
								<input type="radio" id="createTimeType" name="summaryType"  class="radioGroup" value="2" onclick="childCensusSearch.changeSummaryType()"/><label for="createTimeType">时间段</label>
								<tag:dateInput name="month" id="month"  style="width:120px;" pattern="MM"/>
								<span id="createTime" style="display:none">
									<tag:dateInput name="createBeginTime" id="createBeginTime"  maxId="createEndTime" onlypast="true" style="width:120px;" /> ~ <tag:dateInput name="createEndTime" id="createEndTime" style="width:120px;" minId="createBeginTime"/>
								</span>								
							</td>
							</tr>
							<tr>
                             <td class="col-text">机构</td>
							<td class="col-input" colspan="4"> 
								<ehr:authorize ifAnyGranted="01,12">
									<input type="hidden" id="admin" value="${'01'}"/>
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" />
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="02,03">
								<ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true"/>
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="04">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
								</ehr:authorize>
							</td>
                            <td style="text-align: right;">
                           		<input type="button" id="childCensusBtnSearch" value="查询" class="search_btn" />
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom">
							<span onclick="childCensusSearch.toggle(this,'childCensusSearch')" class="ico-bottom">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="childCensusResultDiv">
		</div>
</div>