<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/phsr/elderlyStatistical/search.js" type="text/javascript"></script>

<div class="section">
		<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">公卫服务监管</a>
		        <a>
		          <cite>老年人健康管理统计报表</cite></a>
		      </span>
		</div>
    	</div>
		<div class="searchBox searchSection x-admin-sm">
			<input type="hidden" name="timeFlag" value="1"/>
			<form id="childStatisticalSearchForm">
				<table id="childStatisticalSearch">
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
							<td class="col-text"><label>时间范围</label></td>
							<td class="col-input" colspan="3">
								<input type="radio" id="mhmReprtYearId" name="countType"  class="radioGroup" value="1" checked="checked" onclick="elderlyStatisticalSearch.changeReportType()"/><label for="mhmReprtYearId">按年</label>
                       		 	<input type="radio" id="mhmReprtQuarterId" name="countType"  class="radioGroup" value="2" onclick="elderlyStatisticalSearch.changeReportType()"/><label for="mhmReprtQuarterId">按季度</label>
								<%-- <tag:dateInput name="year" id="year"  onlypast="true" style="width:120px;"  date="${currentYear}"  pattern="yyyy" reg='{"required":"true"}'/> --%>
								<input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:120px;padding-left: 0px;" name="year" id="year" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>" />
								<select name="month" id="month" style="width:120px;display: none;" class="x-layui-input">
									<option value="">请选择</option>
									<option value="01"  >第一季度</option>
									<option value="02"  >第二季度</option>
									<option value="03"  >第三季度</option>
									<option value="04" >第四季度</option>
								</select>						
							</td>
							</tr>
							<tr>
                             <td class="col-text">机构</td>
							<td class="col-input" colspan="4"> 
								<ehr:authorize ifAnyGranted="01,12,0106,02,0206,0306,03">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" cssClass="x-layui-input"/>
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="04,0406">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
								</ehr:authorize>
							</td>
							
                            <td style="text-align: right;"><!-- <input type="button" id="childStatisticalBtnSearch" value="查询"
								 class="search_btn" /> -->
								<button class="layui-btn layui-btn-sm" id="childStatisticalBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button> 
								 </td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="colbottom"><span
							onclick="elderlyStatisticalSearch.toggle(this,'childStatisticalSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="toolbarSection x-admin-sm">
		<a id="childStatisticalResultDivExport" href="javascript:void(0)"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		</div>
		<form   id="communityInfoForm">
		<div id="childStatisticalResultDiv">
		<jsp:include page="list.jsp"/>
		</div></form>
</div>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#year' 
     	   ,type: 'year'
     	   ,max:0
      });

  
});
</script>
