<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hsa/sodp/searchsodp.js"></script>
<div class="section" id="hsa-sodp-list-box">
	<div class="toolbar">
		<ehr:authorize ifAnyGranted="01,0122,0222,0422">
		<a href="javascript:void(0)" id="hsa-susOccDi-add-btn"><b class="xinz">新增</b></a>
		 </ehr:authorize>	
	</div>
	<div class="searchbox">
		<form method="post" id="sus_occ_di_form_search">
			<table id="susOccDiSearchBox">
				<colgroup>
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 23%">
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 23%">
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 23%">
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput"><input type="text" name="name" id="personName" /></td>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput name="idcard" style="ime-mode:Disabled;"></tag:idcardInput></td>
						<td class="coltext">性别</td>
						<td class="colinput"><ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode" /></td>
					</tr>
					<tr>
						<ehr:authorize ifAnyGranted="01,28,32">
							<td class="coltext">机构</td>
							<td colspan="3"><ehr:dic-town-centre-station centreName="centerOrganCode" isShowOther="true" townName="gbcode" width="32.5%;" /></td>
						</ehr:authorize>
						<ehr:authorize ifAnyGranted="0422">
							<td class="coltext">机构</td>
							<td colspan="3"><ehr:dic-town-centre-station centreName="centerOrganCode"  townName="gbcode" width="32.5%;" includeTownCodes="${currentLoginInfo.organization.gbCode}"/></td>
						</ehr:authorize>
						<ehr:authorize ifAnyGranted="0222">
							<td colspan="4"></td>
						</ehr:authorize>
						<td class="coltext"></td>
						<td align="right"><input type="button" id="hsa-sodp-search-btn" value="查询" onclick="" class="search_btn" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="susOccDi.toggle(this,'susOccDiSearchBox')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="hsa-sodp-result-box" class="repeattable"></div>
</div>
<div id="sus-occ-detailed-view" style="display: none"></div>
