<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/samplingSearch.js"/>
<div class="section">
	<div class="toolbar">
		<a href="javascript:void(0)" id="btnAdd"><b class="xinz">新增</b></a>
	</div>
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 55%"/>
					<col style="width: 30%"/>
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext">抽检年份</td>
					<td class="colinput">
						<tag:dateInput id="samplingTime" name="samplingTime" date="${currentYear}" pattern="yyyy" style="width: 100px"/>
						<input type="text" style="display: none"/>
					</td>
					<td><input type="button" id="btnSearch" value="查询" class="search_btn"/></td>
				</tr>
				</tbody>
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