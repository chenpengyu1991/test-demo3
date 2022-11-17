<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/disinfectionMonitorSearch.js" type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
	<div id="top_all">
		<div class="toolbar">
			<ehr:authorize ifAnyGranted="02,03">
				<a id="initAdd"><b class="xinz">新增</b></a>
			</ehr:authorize>
		</div>
		<div class="searchbox">
			<form id="disinfectionMonitorSearchForm">				
                <table id="disinfectionMonitorSearch" >
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:80px; width: 10%;"/>
					<col style="min-width: 210px;width: 20%; "/>
                    <col style="min-width:60px; width: 10%;"/>
					<col style="min-width:160px; width: 20%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">机构名称</td>
                            <td class="colinput">
								<ehr:org-type-list name="orgName" code="${currentOrg.organCode}" value="${currentOrg.organCode}"  type="hospital,centre,station" width="150px;"/>
								
							</td>
							<td class="coltext">监测时间</td>
                            <td class="colinput">
                                <tag:dateInput nullToToday="true" id="beginDate" name="beginDate" maxId="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
	                            ~<tag:dateInput nullToToday="true" id="endDate" name="endDate" minId="beginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
							</td>
                            <td class="coltext"></td>
		                    <td align="left">
                            	<input type="button" id="disinfectionMonitorBtnSearch" value="查询" class="search_btn"/>
                        	</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span class="ico-bottom" onclick="toggle(this,'disinfectionMonitorSearch')">&nbsp;</span>
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
<div id="operationDiv"></div>
