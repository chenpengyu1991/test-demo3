<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript">
	var dmbcMouseReport = (function() {
		$(function() {
			search();
			$("#back").click(function(){
				baseLayoutLoad.popMainContent();
				if ($("#type").val() == "mouse") {
					mouseMonitorSearch.search(1);
				}
				if ($("#type").val() == "mosquitoes") {
					mosquitoesMonitorSearch.search(1);
				}
				if ($("#type").val() == "fly") {
					flyMonitorSearch.search(1);
				}
				if ($("#type").val() == "roach") {
					roachMonitorSearch.search(1);
				}
			});
			$("#searchBtn").click(search);
			$("#reportSearchForm").onEnter(search);
			$("#reportExport").click(function() {
				var table = $("#reportTable");
				if ($(table).find("tr").length > 2) {
					$(table).exportExcel();
				} else {
					layer.alert("没有数据，请重新查询！", {icon:0,title:'提示'});
				}
			});
		});

		function search() {
			var option = {
				url : "/dmbc/vertor/" + $("#type").val() + "/report",
				insertDiv : "reportDiv"
			};
			$("#reportSearchForm").submitFormLoadHtml(option);
		}
	})();
</script>
<div class="section">
	<div class="toolbar">
		<a href="#" id="back"><b class="fanhui">返回</b></a>
		<a href="#" id="reportExport"><b class="export">报表导出</b></a>
	</div>
	<div class="searchbox">
		<form id="reportSearchForm">
			<input type="hidden" id="type" value="${type}"/>
			<table id="mouseReportSearch">
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
					<td class="coltext">监测乡镇</td>
					<td class="colinput">
						<ehr:dic-town-village townName="townShip" townValue="${townShip}" width="150px;"/>
					</td>
					<td class="coltext">监测时间</td>
					<td class="col-input" >
						<tag:dateInput nullToToday="true" id="beginDate" name="beginDate" maxId="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
						~<tag:dateInput nullToToday="true" id="endDate" name="endDate" minId="beginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 90px;"></tag:dateInput>
					</td>
					<td></td>
					<td><input type="button" id="searchBtn" value="查询" class="search_btn"/></td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>
	<br/>
	<br/>
	<div id="reportDiv"></div>
</div>