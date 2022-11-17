<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
	require(['views/ihm/weightSet/search'],function(weightSetSearch){
		weightSetSearch.load();
	});
</script>
<div>
<div class="section" id="top_all_weight">
	<div class="toolbar">
		<a id="weight-set-add-btn" name="weight-set-add-btn"><b class="xinz">新增</b></a>
	</div>
	<div class="searchBox">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<form id="weightSearchForm" class="postcontent" style="padding: 0;">
			<table id="weightSearch">
                <colgroup>
                    <col style="width: 15%;"/>
					<col style="width: 30%;"/>
					<col style="width: 15%;"/>
					<col style="width: 20%;"/>
					<col style="width: 20%;"/>
				</colgroup>
				<tbody>
					<tr>
                    	<td class="col-text">机构</td>
                        <td class="col-input" colspan="3">
                        	<ehr:dic-town-centre-station centreId="centerCode" townId="gbCode" stationId="organCode" 
							centreName="centerCode" townName="gbCode" stationName="organCode" width="30%"/>
						</td>
					</tr>
					<tr>
						<td class="col-text">时间</td>
						<td class="col-input">
							<tag:dateInput id="beginDate" name="beginDate" style="width: 43%" maxId="endDate"/>~
							<tag:dateInput id="endDate" name="endDate" style="width: 43%" minId="beginDate"/>
						</td>
						<td class="col-text">权重类型</td>
						<td class="col-input">
							<ehr:dic-radio id="rpType" name="rpType" dicmeta="FS990011" isDefault="Y" />
						</td>
						<td class="centertd" colspan="2">
							<input type="button" value="查询" id="weightSetSearchId" class="search_btn"/>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="col-bottom">
						<span onclick="toggle(this,'weightSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<div id="resultDiv"></div>
</div>
<div id="detailDivWeight"></div>
</div>
