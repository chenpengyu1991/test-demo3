<%@page import="com.founder.rhip.ehr.common.EHRConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/views/hsa/reportRecord/list/list.js" type="text/javascript"></script>
<div class="section" id="hsa-report-record-content">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">卫生计生监督协管</a>
		        <a>
		          <cite>报告登记</cite></a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form method="post" id="hsa-report-record-search-form">
			<table id="hsa-recordLocation-recordSearchBox">
				<colgroup>
					<col style="min-width: 70px; width: 8%;" />
					<col style="min-width: 100px; width: 25%;" />
					<col style="min-width: 70px; width: 5%;" />
					<col style="min-width: 100px; width: 15%;" />
					<col style="min-width: 70px; width: 7%;" />
					<col style="min-width: 100px; width: 15%;" />
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">信息类别</td>
						<td><ehr:dic-list  dicmeta="HSA00006" parentCode="0" name="infoTypeCode" id="infoTypeCode" uninclude="1,4,99" cssClass="x-layui-input"/></td>
						<td class="coltext">信息内容</td>
						<td><input type="text" name="infoContent"></input></td>
						<td class="coltext">发现时间</td>
						<td><%-- <tag:dateInput id="hsa-report-record-search-startDiscoveryDate" name="startDiscoveryDate" style="width: 36%;"></tag:dateInput>~ <tag:dateInput id="hsa-report-record-search-endDiscoveryDate" name="endDiscoveryDate"
								style="width: 36%;"
							></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-sm-date"  name="startDiscoveryDate" id="hsa-report-record-search-startDiscoveryDate" style="padding-left: 0px;width: 36%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="endDiscoveryDate" id="hsa-report-record-search-endDiscoveryDate" style="padding-left: 0px;width: 36%;" />
							</td>
					
					</tr>
					<tr>
						<td class="coltext">处理状态</td>
						<td>
								<label><input checked="checked" name="status" type="radio" value="" />全部</label>
								<label><input name="status" type="radio" value="1" />未接收</label>
								<label><input  name="status" type="radio" value="2" />已接收</label>
								<label><input name="status"  type="radio" value="3" />已处理</label>
								<label><input name="status"  type="radio" value="4" />待回访</label>
								<label><input name="status"  type="radio" value="5" />已回访</label>
						</td>
						<td class="coltext">报告时间</td>
						<td><%-- <tag:dateInput name="startCreateDate" date="${currentYearStartDate}" id="hsa-report-record-search-startCreateDate" style="width: 36%;"></tag:dateInput>~ <tag:dateInput id="hsa-report-record-search-endCreateDate" name="endCreateDate"
								style="width: 36%;"
							></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-sm-date"  name="startCreateDate" id="hsa-report-record-search-startCreateDate" style="padding-left: 0px;width: 36%;" value="<fmt:formatDate value='${currentYearStartDate}' pattern='yyyy/MM/dd'/>" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="endCreateDate" id="hsa-report-record-search-endCreateDate" style="padding-left: 0px;width: 36%;" />
							</td>
						<td></td>
						<td align="left"><!-- <input type="button" id="hsa-inspRecord-locationList-search_btn" value="查询" class="search_btn" width="80"> -->
						<button class="layui-btn layui-btn-sm" id="hsa-inspRecord-locationList-search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
					<ehr:authorize ifAnyGranted="01,05,0122">
						<tr>
							<td class="coltext">上报机构</td>
							<td colspan="5"><ehr:dic-town-centre-station centreName="centerOrganCode" townName="gbcode" isShowOther="true" width="180px;" cssClass="x-layui-input"/></td>
						</tr>
					</ehr:authorize>
					<%-- <ehr:authorize ifAnyGranted="04">
						<tr>
							<td class="coltext">上报机构</td>
							<td colspan="5"><ehr:dic-town-centre-station centreName="centerOrganCode" townName="gbcode"  width="180px;" includeTownCodes="${currentLoginInfo.organization.gbCode}"/></td>
						</tr>
					</ehr:authorize> --%>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="HsaCommon.toggle(this,'hsa-recordLocation-recordSearchBox')"
						class="ico-bottom"
					>&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection">
		<!-- <a href="javascript:void(0)" id="hsa-report-record-add-btn"><b class="xinz">新增</b></a> -->
		<a href="javascript:void(0)" id="hsa-report-record-add-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</div>
	<div id="hsa-report-record-list-result-content" class="repeattable"></div>
</div>
<div id="hsa-report-record-input-content" class="postdiv"></div>
<div id="hsa-record-card-add"></div>

 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#hsa-report-record-search-startDiscoveryDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        
        laydate.render({
          elem: '#hsa-report-record-search-endDiscoveryDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
        laydate.render({
          elem: '#hsa-report-record-search-startCreateDate'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });
      
     
        laydate.render({
          elem: '#hsa-report-record-search-endCreateDate'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });
      });

    </script>