<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/ihm/mc/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/util/jquery.placeholder.1.3.js" type="text/javascript"></script>
<div class="section">
	<div id="top_all">
	<!--div class="toolbar">
    </div -->    
		<div class="searchbox">
			<form id="statisticsSearchForm">				
                <table id="statisticsSearch" >
				<colgroup>
					<col style="min-width:70px; width: 15%;"/>
					<col style="min-width:100px; width: 25%;"/>
                    <col style="min-width:140px; width: 15%;"/>
					<col style="min-width: 150px;width: 45%; "/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">统计内容</td>
                            <td class="colinput">
                                <select id="context" name="context">
                                	<option value="T001">健康档案</option>
                                	<option value="T002">健康教育</option>
                                	<option value="T003">预防接种</option>
                                	<option value="T004">儿童保健</option>
                                	<option value="T005">孕产妇保健</option>
                                	<option value="T006">老年人健康管理</option>
                                	<option value="T007">高血压健康管理</option>
                                	<option value="T008">2型糖尿病健康管理</option>
                                	<option value="T009">重性精神障碍患者管理</option>
                                	<option value="T010">传染病及突发公共卫生事件报告和处理</option>
                                	<option value="T011">卫生监督协管</option>
                                	<!-- <option value="T003">基本药物监管</option> -->
                                </select>
                            </td>
							<td class="coltext">机构</td>
							<td class="col-input" >
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
	                          <span onclick="mcSearch.toggle(this,'statisticsSearch')" class="ico-bottom">&nbsp;</span>
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

