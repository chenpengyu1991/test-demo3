<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="ZJSB" value="<%=RoleType.ZJSB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/mhm/statistics/report/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>

<div  class="section">
	<div id="reportTopAll">
		<div class="toolbar">
		
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">精神障碍患者管理</a>
		        <a href="javascript:void(0)">统计分析</a>
		        <a>
		          <cite>报表管理</cite></a>
		      </span>
    		</div>
			<!-- <a href="javascript:void(0)" id="reportExport"><b class="export">导出</b></a> -->
			<a href="javascript:void(0)" id="reportExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			<ehr:authorize ifAnyGranted="${ZXJFYS}">
		        <%--<a href="javascript:void(0)" id="reportEdit" style="display: none"><b class="xiug">修改</b></a>--%>
                <!-- <a href="javascript:void(0)" id="reportEdit" style="display: none"><b class="baocun">保存</b></a> -->
                <a href="javascript:void(0)" id="reportEdit" style="display: none" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
                <!-- <a href="javascript:void(0)" id="reportSave" style="display: none"><b class="baocun">保存</b></a> -->
                <a href="javascript:void(0)" id="reportSave" style="display: none" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		    </ehr:authorize>		
		</div> 	
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}"/>
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="reportSearchForm">				
                <table id="reportSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 25%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 25%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 25%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext"><span id="reportTypeTextId">时间范围</span></td>
							<td class="colinput" colspan="4">
								<input type="radio" id="mhmReprtYearId" name="mhmReprtType"  class="radioGroup" value="1" checked="checked" onclick="mhmReportSearch.changeReportType()"/><label for="mhmReprtYearId">按年</label>
								<input type="radio" id="mhmReprtQuarterId" name="mhmReprtType"  class="radioGroup" value="2" onclick="mhmReportSearch.changeReportType()"/><label for="mhmReprtQuarterId">按季度</label>
								<input type="radio" id="mhmReprtMonthId" name="mhmReprtType"  class="radioGroup" value="3" onclick="mhmReportSearch.changeReportType()"/><label for="mhmReprtMonthId">按月</label>
								<%-- <tag:dateInput nullToToday="true" id="reportYearId" name="reportYear" pattern="yyyy"  date="${defaultMonth}" onlypast="true" reg='{"required":"true"}' style="width: 100px;"/> --%>
								<input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:100px;padding-left: 0px;"  name="reportYear" id="reportYearId" value="<fmt:formatDate value='${defaultMonth}' pattern='yyyy'/>" />
								<select id="reportQuarter" name="reportQuarter" style="width: 100px;display:none">
									<option value="1">第一季度</option>
									<option value="2">第二季度</option>
									<option value="3">第三季度</option>
									<option value="4">第四季度</option>
								</select>
								<%-- <tag:dateInput nullToToday="true" id="reportMonthId" name="reportMonth" pattern="yyyy/MM"  date="${defaultMonth}"  onlypast="true" reg='{"required":"true"}' style="width: 100px;display:none"/> --%>
								<input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:100px;padding-left: 0px;display:none;"  name="reportMonth" id="reportMonthId" value="<fmt:formatDate value='${defaultMonth}' pattern='yyyy/MM'/>" />
							</td>
	                        <td rowspan="2">
	                            <!-- <input type="button" id="reportBtnSearch" value="查询" onclick="" class="search_btn"/> -->
	                            <button class="layui-btn layui-btn-sm" id="reportBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
	                        </td> 							
						</tr>
						<tr>
                            <td class="coltext">单位名称</td>
                            <td class="colinput" colspan="4">
                            	<ehr:authorize ifAnyGranted="${JKJFZX},${ADMIN}">
                            		<ehr:dic-town-centre-station centreName="centerCode"  townName="townCode" width="160px;" cssClass="x-layui-input"/>	
    	                    	</ehr:authorize> 
                            	<ehr:authorize ifAnyGranted="${ZXJFYS}">
		                        	<ehr:dic-org-list  name="stationCode"  width="180px;" cssClass="x-layui-input"></ehr:dic-org-list>
    	                    	</ehr:authorize>
                                <ehr:authorize ifAnyGranted="${ZJSB}">
                                    <ehr:dic-org-list id="nowAddressCode" name="gBCode" defaultval="Y" width="180px;" cssClass="x-layui-input"/>
                                </ehr:authorize>
                            </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="mhmCommon.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="reportResultDiv" style="min-width: 750px; min-height:300px;overflow: auto;"></div>
	</div>
	<div id="reportDetailDiv" ></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#reportYearId' 
        	  ,type: 'year'
       	   ,max:0
        });

        laydate.render({
          elem: '#reportMonthId'
          ,type:'month'
           ,format: 'yyyy/MM'
        	   ,max:0
        });
        
      
      
      });

    </script>
