<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<div class="section" id="hsa-eval-list-box">
	<script type="text/javascript">
		!(function()
		{
			$("#hsa-eval-result-list").on("click", '.view-link', function()
			{
				$("#hsa-eval-input-add").show();	
				$("#hsa-eval-list-box").hide();	
			});
			
			$("#hsa-eval-form-back-btn").on("click", function()
			{
				$("#hsa-eval-input-add").hide();	
				$("#hsa-eval-list-box").show();	
			});
			$("#hsa-inspRecord-export-btn").on("click", function()
			{
				$("#hsa-eval-input-add table").exportExcel();
			});
		})();
	</script>
	<div class="toolbar">
		<ehr:authorize ifAnyGranted="03,28">
			<a href="javascript:void(0)" id="hsa-inspRecord-add-btn"><b class="xinz">新增</b></a>
		</ehr:authorize>
	</div>
	<div class="searchbox">
		<form method="post" id="form_search">
			<table id="hsa-record-recordSearchBox">
				<colgroup>
					<col style="min-width: 70px; width: 12%;" />
					<col style="min-width: 140px; width: 21%;" />
					<col style="min-width: 70px; width: 12%;" />
					<col style="min-width: 100px; width: 17%;" />
					<col style="min-width: 70px; width: 12%;" />
					<col style="min-width: 160px; width: 23%;" />
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">考核日期</td>
						<td class="colinput"><tag:dateInput nullToToday="true" name="startDate" pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;"
								id="hsa-startDate"
							></tag:dateInput> ~<tag:dateInput nullToToday="true" name="endDate" pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;" id="hsa-endDate"></tag:dateInput></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="hsaInspRecordList.toggle(this,'hsa-record-recordSearchBox')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="hsa-eval-result-list" class="repeattable">
		<table>
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 25%" />
				<col style="width: 20%" />
				<col style="width: 15%" />
				<col style="width: 5%" />
				<col style="width: 5%" />
				<col style="width: 8%" />
			</colgroup>
			<thead>
				<tr>
					<th>考核日期</th>
					<th>考核机构</th>
					<th>得分</th>
					<th></th>
					<th></th>
					<th></th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
				<tr>
					<td>A</td>
					<td>A</td>
					<td>A</td>
					<td>A</td>
					<td>A</td>
					<td>A</td>
					<td><a href="javascript:;" class='view-link' >查看</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div id="hsa-eval-input-add" class="postdiv hide ">
	<jsp:include page="evalTable.jsp"></jsp:include>
</div>
