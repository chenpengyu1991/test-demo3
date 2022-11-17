<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<c:set var="JK" value="<%=OrgGenreCode.JK.getValue()%>" />
<c:set var="INFIRMARY" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<c:set var="INFIRMARY" value="<%=OrgGenreCode.INFIRMARY.getValue()%>" />
<c:set var="HEALTH_OVERSIGHT" value="<%=OrgGenreCode.HEALTH_OVERSIGHT.getValue()%>" />
<c:set var="OTHER" value="<%=OrgGenreCode.OTHER.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/followup/statistics.js" type="text/javascript"></script>

<div class="section">
	<div class="toolbar">
		 <%-- <a href="javascript:void(0)" id="ehr-person-export-btn"><b class="export">导出</b></a> --%>
		 <a href="javascript:void(0)" id="ehr-person-export-btn"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form method="post" id="form_search">
			<table id="reportSearch">
				<colgroup>
					<col style="min-width:70px; width: 8%;"/>
					<col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:70px; width: 8%;"/>
                    <col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:80px; width: 8%;"/>
                    <col style="min-width:160px; width: 20%;"/>
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">统计类型</td>
						<td class="colinput">
							<input type="radio" id="serachType" name="searchType"  class="radioGroup" value="1" checked="checked" onclick="followupStatistics.changeSearchType()"/>按机构
							<input type="radio" id="serachType1" name="searchType"  class="radioGroup" value="2" onclick="followupStatistics.changeSearchType()"/>按现住址
						</td>
						<td class="coltext">医务人员名称</td>
						<td class="colinput">
							<input type="text" name="inputerName" id="inputerName" style="width: 80%;" class="x-layui-input"/>
							<input type="hidden" name="staffCode" id="staffCodeId" style="width: 40%;"/>
						</td>
						<td class="coltext">日期</td>
						<td class="colinput">
							<%-- <tag:dateInput id="beginDateId" name="beginDate" pattern="yyyy/MM/dd" date="${beginDate}" onlypast="true"  style="width:40%;"/>
							~<tag:dateInput id="endDateId" name="endDate" pattern="yyyy/MM/dd" date="${endDate}" onlypast="true"  style="width: 40%;"/> --%>
							<input type="text" class="layui-input x-admin-sm-date"  name="beginDate" id="beginDateId" style="width: 40%;padding-left: 0px;" value="<fmt:formatDate value='${beginDate}' pattern='yyyy/MM/dd'/>"> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="endDateId" style="width: 40%;padding-left: 0px;" value="<fmt:formatDate value='${endDate}' pattern='yyyy/MM/dd'/>">
						</td>
					</tr>
					<tr id="orgFollowupTrId">
						<td class="coltext">
							机构
						</td>
						<td colspan="3">
							<ehr:dic-town-centre-station centreName="centreCode" stationName="stationCode" townName="townCode" isShowOneself="true" width="27%" cssClass="x-layui-input"/>
						</td>
						<td></td>
						<td style="text-align: center;">
						<%-- <input class="search_btn" type="button" name="search" onclick="followupStatistics.pagination(1)" value="查询" style="float: left;"/> --%>
						<button class="layui-btn layui-btn-sm" id="followupStatisticsId" style="float: left;"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
					<tr id="villageFollowupTrId" style="display: none">
						<td class="coltext">现住址</td>
						<td colspan="3">
							<ehr:dic-town-street-village townName="patownShip" streetName="paStreet" width="30%" cssClass="x-layui-input"/>
						</td>
						<td></td>
						<td style="text-align: center;">
						<%-- <input class="search_btn" type="button" name="search" onclick="followupStatistics.pagination(1)" value="查询" style="float: left;"/> --%>
						<button class="layui-btn layui-btn-sm" id="followupStatisticsId2" style="float: left;"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
                <tr>
                    <td colspan="5" class="colbottom">
                         <%-- <span onclick="personRecordPagination.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>--%>
                    </td>
                </tr>
			</table>
		</form>
	</div>
<div id="list_datagrid" ></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#beginDateId' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#endDateId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      });

    </script>