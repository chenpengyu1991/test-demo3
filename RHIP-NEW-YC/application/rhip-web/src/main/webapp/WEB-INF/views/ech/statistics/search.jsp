<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKZYY" value="<%=RoleType.JKZYY.getValue()%>"/>
<c:set var="ZXZYY" value="<%=RoleType.ZXZYY.getValue()%>"/>
<c:set var="ZZYY" value="<%=RoleType.ZZYY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/ech/statistics/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
	<div class="toolbar">
	          <%-- <a id="echStatisticsExport" href="javascript:void(0)"><b class="export">导出</b></a> --%>
	          <a id="echStatisticsExport" href="javascript:void(0)"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
	 </div>
	<div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
               <table id="search" >
			<colgroup>
				<col style="min-width:60px; width: 8%;"/>
				<col style="min-width:120px; width: 15%;"/>
                <col style="min-width:60px; width: 8%;"/>
				<col style="min-width:300px; width: 51%;"/>
				<col style="min-width:100px; width: 10%;"/>
               </colgroup>
				<tbody>
					<tr>
						<td class="coltext"><label class="required">年份</label></td>
						<td class="colinput">
							<%-- <tag:dateInput id="inputExamYear" name="examYear" pattern="yyyy" date="${currentYear}" style="width:100px" reg='{"required":"true"}'/> --%>
							<input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date"  name="examYear" id="inputExamYear" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>"  style="width: 100px;padding-left: 0px;" />
						</td>
						<td class="coltext">机构</td>
						<td class="colinput">
							<ehr:authorize ifAnyGranted="${ADMIN},${QWGZX},${JKZYY}">
								<ehr:dic-town-centre-station centreName="inputSuperOrganCode" stationName="inputOrganCode" townName="gbcode" width="30%" isShowOneself="true"  cssClass="x-layui-input"/>
							</ehr:authorize>
							<%--<ehr:authorize ifAnyGranted="${QWGZX}">--%>
								<%--<ehr:dic-town-centre-station centreName="inputSuperOrganCode" stationName="inputOrganCode" townName="gbcode" width="30%" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>--%>
							<%--</ehr:authorize>--%>
							<ehr:authorize ifAnyGranted="${ZXZYY}">
							<ehr:dic-org-list name="inputOrganCode" width="30%"  isShowOneself="true" cssClass="x-layui-input"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${ZZYY}">
							<ehr:dic-org-list name="inputOrganCode" width="30%" defaultval="Y" cssClass="x-layui-input"/>
							</ehr:authorize>
																					
						</td>
						<td  class="centertd">
						<%-- <input type="button" id="btnSearch" value="查询" class="search_btn"/> --%>
						<button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
               <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="toggle(this,'search')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>

		 </form>
	</div>
	<div id="resultDiv"></div>
</div>
<div id="detailDiv"></div>

<script type="text/javascript">
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        

        laydate.render({
            elem: '#inputExamYear'
            ,type:'year'
         	   ,max:0
         	  , trigger: 'click' 
          });
        
        
      });

    </script>
