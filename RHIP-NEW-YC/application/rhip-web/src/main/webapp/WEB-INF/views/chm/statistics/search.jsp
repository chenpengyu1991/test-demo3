<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/chm/statistics/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/util/jquery.placeholder.1.3.js" type="text/javascript"></script>
<div class="section">
	<div id="top_all">
	<!--div class="toolbar">
    </div -->    
		<div class="searchbox">
			<form id="statisticsSearchForm">				
                <table id="statisticsSearch" >
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:160px; width: 15%;"/>
                    <col style="min-width:80px; width: 10%;"/>
					<col style="min-width: 210px;width: 35%; "/>
                    <col style="min-width:60px; width: 10%;"/>
					<col style="min-width:160px; width: 20%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">统计内容</td>
                            <td class="colinput">
                                <select id="context" name="context">
                                	<option value="T001">门诊/急诊就诊人次</option>
                                	<option value="T002">住院人次</option>
                                	<option value="T003">手术人次</option>
                                	<option value="T004">平均住院日</option>
                                	<option value="T005">抗生素使用情况</option>
                                	<option value="T006">检查人次</option>
                                	<option value="T007">慢病随访人次</option>
                                	<option value="T008">居民建档人次</option>
                                </select>
                            </td>
							<td class="coltext">机构</td>
							<td class="col-input" colspan="3">
								<%-- <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" /> --%>
								<ehr:authorize ifAnyGranted="01,11">
									<ehr:dic-town-centre-station centreName="inputSuperOrganCode" stationName="inputOrganCode" townName="gBCode" width="130px;" />
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="02,03">
									<ehr:dic-org-list name="unitCode" width="150px"/>
								</ehr:authorize>
								<%-- <ehr:org-type-list id="unitCode" name="unitCode" type="hospital,centre" value="${currentOrgCode}" code="${fillOrganCode}"/> --%>
							</td>
						</tr>
                    <tr>
                    	<td class="coltext">时间范围</td>
	                    <td class="colinput">
	                            <tag:dateInput nullToToday="true" id="beginDate" name="beginDate" maxId="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 40%;"></tag:dateInput>
	                            ~<tag:dateInput nullToToday="true" id="endDate" name="endDate" minId="beginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 40%;"></tag:dateInput>
	                    </td>
	                    <td class="coltext">统计对象</td>
	                    <td >
	                    	<input type="radio" id="org" name="groupByObj"  value="1" checked="checked"/><label for="org">机构</label>
	                    	&nbsp;&nbsp;&nbsp;
	                    	<input type="radio" id="personal" name="groupByObj" disabled="disabled" value="0" /><label for="personal">个人</label>
	                    </td>
                        <td ></td>
                        <td align="left">
                            <input type="button" id="statisticsBtnSearch" value="查询" onclick="" class="search_btn"/>
                        </td>
                    </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="statisticsSearch.toggle(this,'statisticsSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="resultDiv">
        </div>
	</div>
	<div id="detailDiv" >    </div>
</div>

