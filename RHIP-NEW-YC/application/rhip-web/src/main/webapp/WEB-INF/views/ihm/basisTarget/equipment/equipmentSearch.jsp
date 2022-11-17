<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%-- <script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/equipment/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/equipment/hrCommon.js" type="text/javascript"></script> --%>
<script type="text/javascript">
	 require(['views/ihm/baseTarget/equipment/search','views/ihm/baseTarget/equipment/hrCommon'],function(search,hrCommon){
		 search.load();
		 hrCommon.load();
	 });
</script>
<div class="section">
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="equipmentPageIndex" value="${pageIndex}">
		<form id="equipmentSearchForm">
			<table id="equipmentSearch">
				<colgroup>
                	<col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 35%; min-width: 250px;"/>
					<col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 150px;"/>
                    <col/>
				</colgroup>
				<tbody>
					<tr>
                    	<td class="col-text">统计类型</td>
                        <td class="col-input" colspan="4">
                            <input type="radio" id="orgType4" name="orgType"  class="radioGroup" value="4" checked="checked" onclick="hrCommon.changeOrgType()"/><label for="orgType4">按镇</label>
                          	<input type="radio" id="orgType1" name="orgType"  class="radioGroup" value="1" onclick="hrCommon.changeOrgType()"/><label for="orgType1">按市级医院</label>
							<input type="radio" id="orgType2" name="orgType"  class="radioGroup" value="2" onclick="hrCommon.changeOrgType()"/><label for="orgType2">按卫生院</label>
							<input type="radio" id="orgType3" name="orgType"  class="radioGroup" value="3" onclick="hrCommon.changeOrgType()"/><label for="orgType3">按社区卫生服务站</label>
                        </td>
					</tr>
					<tr>
						<td class="col-text">机构</td>
						<td class="col-input" colspan="3">
							<%--当前选择机构类型 --%>
							<input type="hidden" id="genreCode" name="genreCode"/>
							<div id="orgCode1"><tag:autoSelect name="hospitalCode" id="hospitalCode" style="width:200px" ></tag:autoSelect></div>
							<div id="orgCode2" style="display:none"><tag:autoSelect name="superOrganCode" id="superOrganCode" style="width:200px;" ></tag:autoSelect></div>
							<div id="orgCode3" style="display:none"><tag:autoSelect name="organCode" id="organCode" style="width:200px" ></tag:autoSelect></div>
							<div id="orgCode4" style="display:none"><ehr:dic-town-village  townId="gbCode" townName="gbCode" width="200px"/></div>
						</td>
						<td style="text-align: left;">
							<input type="button" id="equipmentBtnSearch" value="查询" onclick="" class="search_btn" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span
						onclick="toggle(this,'equipmentSearch')"
						class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>

		</form>
	</div>
	<div id="equipmentDiv">
		<jsp:include page="equipmentList.jsp"></jsp:include>
	</div>
</div>