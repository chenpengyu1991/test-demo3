<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
	require(['views/ihm/weightSet/staffRpPaSearch'],function(staffRpPaSearch){
		staffRpPaSearch.load();
	});
</script>
<div class="section" id="top_all_weight">
	<div class="searchBox">
		<form id="staffRpPaSearchForm" class="postcontent" style="padding: 0;">
			<table id="staffRpPaSearch">
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
                        <td class="col-input">
							<tag:autoSelect name="organCode" id="organCode" reg='{"required":"true"}'></tag:autoSelect>
						</td>
						<td class="col-text">指标类型</td>
						<td class="col-input">
							<ehr:dic-list id="weightIndex" name="weightIndex" dicmeta="FS990012" reg='{"required":"true"}'/>
						</td>
					</tr>
					<tr>
						<td class="col-text">时间</td>
						<td class="col-input">
							<tag:dateInput id="beginDate" name="beginDate" style="width: 43%" maxId="endDate" reg='{"required":"true"}'/>~
							<tag:dateInput id="endDate" name="endDate" style="width: 43%" minId="beginDate" reg='{"required":"true"}'/>
						</td>
						<td class="col-text">权重类型</td>
						<td class="col-input">
							<ehr:dic-radio id="rpType" name="rpType" dicmeta="FS990011" reg='{"required":"true"}'/>
						</td>
						<td class="centertd">
							<input type="button" value="查询" id="staffRpPaSearchId" class="search_btn"/>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="col-bottom">
						<span onclick="toggle(this,'staffRpPaSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<div id="resultDiv">
		无数据，请选择考核条件！
	</div>
</div>
