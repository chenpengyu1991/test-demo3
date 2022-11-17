<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/knowledgeSearch.js"/>
<div class="section">
	<div class="toolbar" >
		<a href="javascript:void(0)"><b class="xinz" id="btnAdd">新增</b></a>
	</div>
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 35%;"/>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 35%;"/>
                    <col style="min-width:73px; width: 10%;"/>
				</colgroup>
				<tr>
					<td class="coltext">调查时间</td>
					<td class="colinput">
						<tag:dateInput id="beginDate" name="beginDate" pattern="yyyy/MM/dd" style="width:75px;" />
						&nbsp;~&nbsp;
						<tag:dateInput id="endDate" name="endDate" pattern="yyyy/MM/dd" style="width:75px;" />
					</td>
					<td class="coltext">抽样点</td>
					<td class="colinput">
						<select name="samplingId" style="width:180px" >
							<option value="">请选择</option>
							<c:forEach var="sampling" items="${samplingList}">
								<option value="${sampling.id}">${sampling.name}</option>
							</c:forEach> 
						</select>
					</td>
					<td class="colinput">
						<td class="colinput"><input type="button" id="btnSearch" value="查询" class="search_btn"/></td>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="colbottom">
						<span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="listDiv"></div>
</div>