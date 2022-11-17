<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspection/list/list.js" type="text/javascript"></script>
<div class="section" id="hsa-record-list-box">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">卫生计生监督协管</a>
		        <a>
		          <cite>日常巡查</cite></a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
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
						<td class="coltext">巡查卫生专业</td>
						<td><ehr:dic-list dicmeta="HSA00006"   id="hsa-inspection-list-categoryCode" name="inspHealthProfessional" uninclude="1,4,99" parentCode="0" cssClass="x-layui-input"/></td>
						<td class="coltext">是否巡查指导</td>
						<td class="colinput"><ehr:dic-list dicmeta="FS10097" name="isGuide" cssClass="x-layui-input"/></td>
						<td class="coltext">是否报告登记</td>
						<td class="colinput"><ehr:dic-list dicmeta="FS10097" name="isReport" cssClass="x-layui-input"/></td>
					</tr>
					<tr>
						<td class="coltext">巡查地点</td>
						<td class="colinput"><input type="text" name="unitName" class="x-layui-input" /></td>
						<td class="coltext">巡查人</td>
						<td class="colinput"><input type="text" name="inspPersonName" class="x-layui-input" /></td>
						<td class="coltext">巡查日期</td>
						<td class="colinput"><%-- <tag:dateInput nullToToday="true" name="startDate" pattern="yyyy/MM/dd" date="${currentYearStartDate}" onlypast="true" style="width: 36%;" id="hsa-startDate"></tag:dateInput> ~<tag:dateInput
								nullToToday="true" name="endDate" pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;" id="hsa-endDate"></tag:dateInput> --%>
								
							<input type="text" class="layui-input x-admin-sm-date"  name="startDate" id="hsa-startDate"  value="<fmt:formatDate value='${currentYearStartDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 36%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="hsa-endDate" style="padding-left: 0px;width: 36%;" />	
								</td>
					</tr>
					<ehr:authorize ifAnyGranted="01,05,0122">
						<c:set var="isShowOrgan" value="${true }"></c:set>
					</ehr:authorize>
					<tr>
						<c:if test="${ isShowOrgan==true}">
							<td class="coltext">巡查机构</td>
							<td colspan="4"><ehr:dic-town-centre-station centreName="centerOrganCode" townName="gbcode" isShowOther="true" width="180px;" cssClass="x-layui-input"/></td>
						</c:if>
						<ehr:authorize ifAnyGranted="04">
							<td class="coltext">巡查机构</td>
							<td colspan="4"><ehr:dic-town-centre-station centreName="centerOrganCode" townName="gbcode"  width="180px;" stationName="stationCode" includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/></td>
						</ehr:authorize>
						<c:if test="${ isShowOrgan!=true}">
							<ehr:authorize ifNotGranted="04">
							<td colspan="5"></td>
							</ehr:authorize>
						</c:if>
						<td align="left"><!-- <input type="button" id="hsa-inspRecord-list-search_btn" value="查询" class="search_btn" width="80"> -->
						<button class="layui-btn layui-btn-sm" id="hsa-inspRecord-list-search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="HsaCommon.toggle(this,'hsa-record-recordSearchBox')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection">
		<ehr:authorize ifAnyGranted="01,0122,0222,0422">
			<!-- <a href="javascript:void(0)" id="hsa-inspRecord-add-btn"><b class="xinz">新增</b></a> -->
			<a href="javascript:void(0)" id="hsa-inspRecord-add-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</ehr:authorize>
	</div>
	<div id="hsa-record-result-list" class="repeattable"></div>
</div>
<div id="hsa-record-input-add" class="postdiv"></div>
<div id="hsa-record-reportCard-add"></div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#hsa-startDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    //执行一个laydate实例
    laydate.render({
      elem: '#hsa-endDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
  });
</script>