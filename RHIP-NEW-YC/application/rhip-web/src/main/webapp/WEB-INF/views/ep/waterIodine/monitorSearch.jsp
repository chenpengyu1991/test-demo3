<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/waterIodine/monitorSearch.js"/>
<div class="section">
	<div class="toolbar" >
	    <a href="javascript:void(0)"><b class="xinz" id="btnAdd">新增</b></a>
	</div>
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:183px; width: 23%;"/>
				</colgroup>
				<tr>
					<td class="coltext">调查时间</td>
					<td class="colinput">
						<tag:dateInput id="beginDate" name="beginDate" pattern="yyyy/MM/dd" style="width:75px;" />
						&nbsp;~&nbsp;
						<tag:dateInput id="endDate" name="endDate" pattern="yyyy/MM/dd" style="width:75px;" />
					</td>
					<td class="coltext">监测点编号</td>
					<td class="colinput"><input type="text" name="monitorId" style="width:175px"/></td>
					<td class="coltext">乡镇</td>
					<td class="colinput">
						<ehr:dic-town-village townValue="${monitor.gbCode}" townName="gbCode" />
					</td>
				</tr>
				<tr>
					<td class="coltext">水厂名称</td>
					<td class="colinput"><input type="text" name="factoryName" style="width:177px"/></td>
					<td class="coltext">水厂类型</td><%--需求变更.水厂类型和监测类型反了，为了保持历史数据，现将两个字段对调使用，即： monitorType存的是水厂类型，刘洋，2014-04-14--%>
					<td class="colinput"><ehr:dic-list name="monitorType" dicmeta="FS10265" value="${monitor.monitorType}" width="177px" /></td>
					<td class="coltext"></td>
					<td class="colinput"><input type="button" id="btnSearch" value="查询" class="search_btn"/></td>
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