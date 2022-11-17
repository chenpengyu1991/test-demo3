<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/report/list.js" type="text/javascript"></script>

<c:set var="JKWJ" value="<%=RoleType.JKWJ.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZXWJ" value="<%=RoleType.ZXWJ.getValue()%>"/>
<c:set var="ZWJ" value="<%=RoleType.ZWJ.getValue()%>"/>
<div id="hsa-report-service-report-content">
	<div class="section">
		<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">卫生计生监督协管</a>
		        <a>
		          <cite>统计查询</cite></a>
		      </span>
		</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form id="hsa-report-service-report-serach-form" name="" action="" method="post">
				<table id="hiddeSearch">
					<colgroup>
						<col style="width: 8%;">
						<col style="width: 35%;">
						<col style="width: 8%;">
						<col style="width: 35%;">
						<col style="width: 8%;">
						<%-- <col style="width: 16.5%;">
						<col style="width: 8%;">
						<col style="width: 16.5%;">
						<col style="width: 8%;">
						<col style="width: 6.5%;"> --%>
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">统计时间</td>
							<td class="colinput" style="width: 28%">
							 <%-- <tags:dateInput style="width:120px;" name="yearMonthStart" pattern="yyyy/MM/dd"></tags:dateInput>
							 ~ 
							 <tags:dateInput name="yearMonthEnd" id="yearMonthEnd" style="width:120px;" date="${currentDate}" pattern="yyyy/MM/dd"/> 
							<tags:dateInput name="yearMonthEnd" id="yearMonthEnd" style="width:120px;" date="${currentDate}" pattern="yyyy/MM/dd"/> --%>
							
							<input type="text" class="layui-input x-admin-sm-date"  name="yearMonthStart" id="yearMonthStartId" style="padding-left: 0px;width:100px;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="yearMonthEnd" id="yearMonthEndId" value="<fmt:formatDate value='${currentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:100px;" />
							</td>
							<%-- <ehr:authorize ifAnyGranted="01,05,0122">
									<td class="coltext">上报机构</td>
								<td class="colinput"><ehr:dic-town-centre-station width="130px;" centreName="organCode" townName="gbCode" cssClass="x-layui-input"></ehr:dic-town-centre-station>
								</td>
							</ehr:authorize> --%>
							
							
							<ehr:authorize ifAnyGranted="${ZWJ},${ZXWJ}">
								<td class="coltext">上报机构</td>
								<td class="colinput">
									<ehr:dic-org-list name="createOrganCode" width="130px" isShowOneself="true" />
								</td>
							</ehr:authorize>
							
							
							<ehr:authorize ifAnyGranted="${JK},${JKWJ},${ADMIN}">
								<td class="coltext">上报机构</td>
								<td class="colinput">
									<ehr:dic-town-centre-station centreName="centerOrganCode" stationName="createOrganCode" townName="gbcode"  width="180px;" />
								</td>
							</ehr:authorize>
							
							<%-- <ehr:authorize ifAnyGranted="04">
								<td class="coltext">上报机构</td>
								<td class="colinput"><ehr:dic-town-centre-station width="130px;" centreName="organCode" townName="gbCode" includeTownCodes="${currentLoginInfo.organization.gbCode}"></ehr:dic-town-centre-station>
								</td>
							</ehr:authorize> --%>
						
							<td class="colinput" colspan="2"><input class="hide" /><!-- <input id="hsa-report-service-report-serach-btn" type="button"
								class="button search_btn" value="查询"
							/> -->
							<button class="layui-btn layui-btn-sm" id="hsa-report-service-report-serach-btn"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="6" class="colbottom"><span onclick="HsaCommon.toggle(this,'hiddeSearch')" class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="toolbarSection">
			<!-- <a href="javascript:void(0)" id="hsa-report-service-report-export-btn"><b class="export">导出</b></a> -->
			<a href="javascript:void(0)" id="hsa-report-service-report-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		</div>
		<div id="hsa-report-service-report-result-content">
			<jsp:include page="result.jsp"></jsp:include>
		</div>
	</div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#yearMonthStartId' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#yearMonthEndId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
      });

    </script>