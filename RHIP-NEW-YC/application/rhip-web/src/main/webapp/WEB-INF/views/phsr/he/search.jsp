<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZXJKJY" value="<%=RoleType.ZXJKJY.getValue()%>"/>
<c:set var="ZXJKDN" value="<%=RoleType.ZXJKDN.getValue()%>"/>
<c:set var="ZJKJY" value="<%=RoleType.ZJKJY.getValue()%>"/>
<c:set var="JKJKJY" value="<%=RoleType.JKJKJY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/phsr/he/search.js" type="text/javascript"></script>

<div class="section">
		<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">公卫服务监管</a>
		        <a>
		          <cite>健康教育报表</cite></a>
		      </span>
		</div>
			<!-- <a id="healthEducationStatisticsExport" href="javascript:void(0)"><b class="export">导出</b></a> -->
		</div>
		<div class="searchBox searchSection x-admin-sm">
			<input type="hidden" name="timeFlag" value="1"/>
			<form id="healthEducationStatisticsSearchForm">
				<table id="healthEducationStatisticsSearch">
					<colgroup>
						<col style="width: 50px;" />
						<col style="width: 80px;" />
						<col style="width: 50px;" />
						<col style="width: 60px;" />
						<col style="width: 50px;" />
						<col style="width: 200px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text"><label class="required">年份</label></td>
							<td class="col-input">
								<%-- <tag:dateInput name="year" id="year"  onlypast="true" style="width:120px;"  date="${currentYear}"  pattern="yyyy" reg='{"required":"true"}'/> --%>
								<input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:120px;padding-left: 0px;" name="year" id="year" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>" />
							</td>
							<td class="col-text"><span id="summaryTypeTextId">月份</span></td>
							<td class="col-input" colspan="3">
								<input type="radio" id="monthType" name="summaryType"  class="radioGroup" value="1" checked="checked" onclick="healthEducationStatisticsSearch.changeSummaryType()"/><label for="monthType">月份</label>
								<input type="radio" id="createTimeType" name="summaryType"  class="radioGroup" value="2" onclick="healthEducationStatisticsSearch.changeSummaryType()"/><label for="createTimeType">时间段</label>
								<%-- <tag:dateInput name="month" id="month"  style="width:120px;" pattern="MM"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" style="width:120px;padding-left: 0px;" name="month" id="month" />
								<span id="createTime" style="display:none">
									<%-- <tag:dateInput name="createBeginTime" id="createBeginTime"  maxId="createEndTime"  onlypast="true" style="width:120px;" /> ~ <tag:dateInput name="createEndTime" id="createEndTime" style="width:120px;"    minId="createBeginTime"/> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="createBeginTime" id="createBeginTime" style="padding-left: 0px;width:120px;" /> ~
                                    <input type="text" class="layui-input x-admin-sm-date"  name="createEndTime" id="createEndTime" style="padding-left: 0px;width:120px;" />
								</span>								
							</td>
							</tr>
							<tr>
                             <td class="col-text">机构</td>
							<td class="col-input" colspan="4"> 
								<ehr:authorize ifAnyGranted="${ADMIN},${JKJKJY}">
									<input type="hidden" id="admin" value="${ADMIN}"/>
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" cssClass="x-layui-input"/>
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="${ZXJKJY},${ZJKJY},${ZXJKDN}">
								<ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true" cssClass="x-layui-input"/>
								</ehr:authorize>
								<%--<ehr:authorize ifAnyGranted="04">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
								</ehr:authorize>--%>
							</td>
							
                            <td style="text-align: right;"><!-- <input type="button" id="healthEducationStatisticsBtnSearch" value="查询"
								 class="search_btn" /> -->
								 <button class="layui-btn layui-btn-sm" id="healthEducationStatisticsBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								 </td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="colbottom"><span
							onclick="healthEducationStatisticsSearch.toggle(this,'healthEducationStatisticsSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="toolbarSection x-admin-sm">
		<a id="healthEducationStatisticsExport" href="javascript:void(0)"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		</div>
		<div id="healthEducationStatisticsResultDiv">
			<jsp:include page="list.jsp"/>
		</div>
</div>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#year' 
     	   ,type: 'year'
     	   ,max:0
      });

     laydate.render({
         elem: '#month' 
         	,type:'month'
      	   ,format: 'MM'
      	   ,max:0
       });
     
     laydate.render({
         elem: '#createBeginTime'
          ,format: 'yyyy/MM/dd'
       	   ,max:0
       });
     
     laydate.render({
         elem: '#createEndTime'
          ,format: 'yyyy/MM/dd'
       	   ,max:0
       });
});
</script>