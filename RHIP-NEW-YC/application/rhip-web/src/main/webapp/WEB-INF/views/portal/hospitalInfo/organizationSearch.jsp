<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<c:set var="FS990001_ROOT" value="<%=EHRConstants.FS990001_ROOT%>"/>

<script type="text/javascript">
	 require(['views/portal/hospitalInfo/organizationSearch'],function(organizationSearch){
		 organizationSearch.load();
	 });
</script>
<div class="section">
	<div id="top_all">
		<div class="searchbox">
			<input type="hidden" id="orgPageIndex" value="${pageIndex}">
			<form:form id="orgSearchForm" modelAttribute="organization">
				<table id="searchTable">
					<colgroup span="6">
						<col style="width: 80px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">机构编码</td>
							<td class="colinput">
								<form:input path="organCode" style="width:150px;"/>
							</td>
							<td class="coltext">机构名称</td>
							<td class="colinput">
								<form:input path="organName" style="width:150px;"/>
							</td>
							<td class="coltext">机构类别</td>
							<td class="colinput">
								 <ehr:dic-list name="genreCode" dicmeta="GBT2182002" code="A1,B1,B2,D400,L,R2" width="150px"/>
								<%--<ehr:dic-list name="genreCode" dicmeta="GBT2182002" code="A1,R2"/>--%>
							</td>
						</tr>
						<tr>
							<td class="coltext">行政区划</td>
							<td class="colinput">
								<form:select path="gbCode" style="width:150px;">
									<form:option value="" label="全部"/>
									<ehr:dicItems dicmeta="FS990001"  parentcode= "${FS990001_ROOT}" />
								</form:select>
							</td>
							<td class="coltext">机构级别</td>
							<td class="colinput">
								<form:select path="gradeCode" style="width:150px;">
									<form:option value="" label="全部"/>
									<ehr:dicItems dicmeta="DM02-02"  />
								</form:select>
							</td>
							<td class="coltext">经营性质</td>
							<td class="colinput">
								<form:select path="manageCode" style="width:150px;">
									<form:option value="" label="全部"/>
									<ehr:dicItems dicmeta="FS10223"  />
								</form:select>
							</td>
						</tr>
						<tr>
							<td class="coltext" colspan="6">
                                <!-- <input type="button" id="btnReset" value="重置"  class="search_btn" style="float:right;"/> -->
								<input type="button" id="btnSearch" value="查询"  class="search_btn" style="float:right;"/>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="6" class="colbottom">
							<span id="organizationSearchSpanId" class="ico-bottom">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div id="orgResultDiv"></div>
</div>