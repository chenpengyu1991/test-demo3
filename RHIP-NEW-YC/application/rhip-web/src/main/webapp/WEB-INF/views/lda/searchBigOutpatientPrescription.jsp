<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%--<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/views/lda/unusualSearch.js" type="text/javascript"></script>--%>
<script type="text/javascript">
	require(['views/lda/unusualSearch'],function(ldaUnusualSearch){
		ldaUnusualSearch.load();
	});
</script>
<div id="top_all">
	<div class="searchbox">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<form id="unusualSearchForm">
			<table id="unusualSearch" >
				<colgroup>
					<col style="min-width:90px; width: 12%;"/>
					<col style="min-width:180px; width: 38%;"/>
					<col style="min-width:90px; width: 15%;"/>
					<col style="min-width:180px; width: 35%;"/>
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext"><label class="required">监控指标</label></td>
					<td class="colinput">
						<select id="monitorIndex" name="monitorIndex" style="width: 100px" onchange="ldaUnusualSearch.monitorValueChange(this.value)">
							<option value="1">处方金额</option>
							<option value="2">用量</option>
							<option value="3">天数</option>
							<option value="4">品种</option>
						</select>
						&nbsp;&nbsp;&nbsp;范围&nbsp;<input type="text" name="monitorValue" style="width: 60px;">~<input type="text" name="monitorValueMax" style="width: 60px;">
					</td>
					<td class="coltext"><label class="required">开方日期</label></td>
					<td class="colinput">
						<tag:dateInput nullToToday="true" id="prescribeDateBegin" name="prescribeDateBegin"
									   date="${currentBeginDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;" reg="{'required':'true'}"></tag:dateInput>
						~<tag:dateInput nullToToday="true" id="prescribeDateEnd" name="prescribeDateEnd"
										date="${currentEndDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput>
					</td>
				</tr>
				<tr>
					<td class="coltext">开方医生姓名</td>
					<td class="colinput">
						<input type="text" name="prescribeDoctorName" style="width: 120px;"/>
					</td>
					<td class="coltext">开方医生工号</td>
					<td class="colinput">
						<input type="text" name="prescribeDoctorNo" style="width: 120px;"/>
					</td>
				</tr>
				<tr>
					<td class="coltext">所属机构</td>
					<td class="colinput" colspan="2">
						<tag:autoSelect name="hospitalCode" id="hospitalCode" codeValue="${reportUnitCode}" style="width:200px;" reg="{'required':'true'}"></tag:autoSelect>
					</td>
					<td class="righttd">
						<input type="button" id="unusualBtnSearch" value="查询" class="search_btn"/>
					</td>
				</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom">
						<span onclick="daCommon.toggle(this,'unusualSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="unusualResultDiv">
		<div class="repeattable">
			<table>
				<colgroup>
					<col style="min-width:120px;width: 15%;"/>
					<col style="min-width:80px;width: 10%;"/>
					<col style="min-width:80px;width: 10%;"/>
					<col style="min-width:80px;width: 10%;"/>
					<col style="min-width:140px;width: 15%;"/>
					<col style="min-width:80px;width: 10%;"/>
					<col style="min-width:80px;width: 10%;"/>
					<col style="min-width:100px;width: 10%;"/>
				</colgroup>
				<thead>
				<tr>
					<th>医疗机构</th>
					<th>监控指标</th>
					<th>
						<c:choose>
							<c:when test='${monitorIndex == "1"}'>处方金额</c:when>
							<c:when test='${monitorIndex == "2"}'>最大用量</c:when>
							<c:when test='${monitorIndex == "3"}'>最大天数</c:when>
							<c:when test='${monitorIndex == "4"}'>处方品种</c:when>
						</c:choose>
					</th>
					<th>处方类型</th>
					<th>处方号</th>
					<th>开方日期</th>
					<th>开方医生</th>
					<th>操作</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<div id="unusualDetailDiv"></div>

