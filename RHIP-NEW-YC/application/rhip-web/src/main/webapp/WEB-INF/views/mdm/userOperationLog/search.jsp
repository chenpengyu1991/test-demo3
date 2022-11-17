<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="${pageContext.request.contextPath}/js/views/mdm/userOperationLog/search.js"
	type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
	<div class="searchbox">
		<form method="post" id="form_search">
			<div class="searchbox" id="searchTable">
				<table>
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 15%;" />
						<col style="width: 10%;" />
						<col style="width: 15%;" />
						<col style="width: 10%;" />
						<col style="width: 35%;" />
						<col style="width: 5%;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">模块功能</td>
							<td class="colinput">
					      		<select id="moduleName" name="moduleName" style="width: 120px;">
							    	<option value="">请选择类别</option>
							    	<c:forEach var="mo" items="${moList}">
							    		<option value="${mo.zhName}">${mo.zhName}</option>
							    	</c:forEach>
						    	</select>
					      	</td>
							<td class="coltext">
								操作者
							</td>
							<td class="colinput">
								<input type="text" name="userName" id="userName" style="width: 120px;"/>
							</td>
							<td class="coltext">
								日期范围
							</td>
							<td class="colinput">
							 	<input type="text" name="beginTime" id="beginTime" value="" onClick="WdatePicker({dateFmt:'yyyy/MM/dd'})" style="width: 100px;"/>
					      		~
								<input type="text" name="endTime" id="endTime" value="" onClick="WdatePicker({dateFmt:'yyyy/MM/dd'})" style="width: 100px;"/>
							</td>
					      	<td nowrap="nowrap" align="right">
					      		<input type="button" value="查询" class="search_btn" id="userOperationLogQuery"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span
						onclick="infoSearch.toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="userOperationLogList"></div>
</div>
<div id="operationDiv"></div>


