<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script
	src="${pageContext.request.contextPath}/js/views/mdm/userOperationLog/recordSearch.js"
	type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
	<div class="searchbox">
		<form method="post" id="recordSearchForm">
			<div class="searchbox" id="searchTable">
				<table>
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 15%;" />
						<col style="width: 10%;" />
						<col style="width: 15%;" />
						<col style="width: 10%;" />
						<col style="width: 20%;" />
						<col style="width: 10%;" />
						<col style="width: 10%;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">身份证号</td>
							<td class="colinput">
					      		<input type="text" name="idCard" style="width: 160px;">
					      	</td>
							<td class="coltext">
								姓名
							</td>
							<td class="colinput">
								<input type="text" name="name" id="name" style="width: 120px;"/>
							</td>
							<td class="coltext">
								日期范围
							</td>
							<td class="colinput">
							 	<input type="text" name="beginTime" id="beginTime" value="" onClick="WdatePicker({dateFmt:'yyyy/MM/dd'})" style="width: 40%;"/>
					      		~
								<input type="text" name="endTime" id="endTime" value="" onClick="WdatePicker({dateFmt:'yyyy/MM/dd'})" style="width: 40%;"/>
							</td>
							</tr>
							<tr>
							<td class="coltext">来源</td>
							<td class="colinput">
								<ehr:dic-list name="sourceName" dicmeta="FS990100"/>
					      		<%--<select id="sourceName" name="sourceName" style="width: 120px;">
							    	<option value="">请选择类别</option>
							    	<c:forEach var="source" items="${sourceList}">
							    		<option value="${source.code}">${source.name}</option>
							    	</c:forEach>
						    	</select>--%>
					      	</td>
					      	<td class="coltext">机构</td>
							<td class="colinput" colspan="2">
							  <ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode" townName="gbcode" width="130px"/>
							</td>
					      	<td >
					      		<input type="button" value="查询" class="search_btn" id="recordSearchQuery"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span
						onclick="recordSearch.toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="recordList"></div>
</div>
<div id="operationDiv"></div>


