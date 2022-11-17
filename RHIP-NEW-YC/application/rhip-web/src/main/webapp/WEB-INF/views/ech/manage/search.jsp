<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKZYY" value="<%=RoleType.JKZYY.getValue()%>"/>
<c:set var="ZXZYY" value="<%=RoleType.ZXZYY.getValue()%>"/>
<c:set var="ZZYY" value="<%=RoleType.ZZYY.getValue()%>"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ech/manage/search.js"></script>

<link href="${pageContext.request.contextPath}/css/views/ech/report.css" type="text/css"   rel="stylesheet"/>
    <div class="section" id="ech-manage-list-box">
		<div class="toolbar">
			<%-- <a href="javascript:void(0)" id="tzbs-export-btn"><b class="export">导出</b></a> --%>
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">中医药健康管理</a>
		        <a>
		          <cite>体质辨识</cite></a>
		      </span>
		</div>
		</div>
        <div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="searchForm">
				<table id="searchTable">
					<colgroup>
                        <col style="width: 10%;"/>
                        <col style="width: 26%;"/>
                        <col style="width: 10%;"/>
                        <col style="width: 22%;"/>
						<col style="width: 10%;"/>
						<col style="width: 22%;"/>
					</colgroup>
					<tr>
						<td class="coltext">年份</td>
						<td class="colinput">
							<%-- <tag:dateInput id="inputExamYear" name="examYear" date="${currentYear}" style="width:100px" pattern="yyyy"/> --%>
							<input type="text" class="layui-input x-admin-sm-date"  name="examYear" id="inputExamYear" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>"  style="width: 100px;padding-left: 0px;" />
						</td>
						<td class="coltext">姓名</td>
						<td class="colinput"><input type="text" name="name" value="" class="x-layui-input"/></td>
						<td class="coltext">性别</td>
						<td class="colinput"><ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2"  /></td>
					</tr>
					<tr>
						<td class="coltext">是否辨识</td>
						<td class="colinput">
							<select name="tcmStatus" class="x-layui-input">
								<option value="">请选择</option>
								<option value="0" selected>否</option>
								<option value="1">是</option>
							</select>						
						</td>
						<td class="coltext">身份证号</td>
						<td class="colinput"><input type="text" name="idcard" value="" class="x-layui-input"/></td>
						<td class="coltext">体质类型</td><!-- CV0501005 -->
						<td class="colinput">
							<input type="text" name="tcmConclusion" value="" class="x-layui-input"/>
						</td>						

					</tr>
						<!-- <tr class="advanceSearchSection" style="display: none;">
						
					<td class="coltext">是否结案</td>
						<td class="colinput">
							<select name="logoff" class="x-layui-input">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td> 
					</tr>-->
					<tr class="advanceSearchSection" style="display: none;">
						<td class="coltext">现住居委会</td>
						<td class="colinput">
							<ehr:dic-town-street-village streetId="street_address" townId="town_address"
														streetName="searchPastreet" townName="searchPatownShip"  width="40%;" cssClass="x-layui-input"/>
						</td>
						<td class="coltext">管理机构</td>
						<td class="colinput" colspan="3">
							<input type="hidden" id="selectCodeType" name="selectCodeType"/>
							<ehr:authorize ifAnyGranted="${ZXZYY}">
								<ehr:dic-org-list name="searchOrg" isShowOneself="true" width="31.9%;" cssClass="x-layui-input"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${ZZYY}">
								<ehr:dic-org-list id="searchOrg" name="searchOrg" width="31.9%;" cssClass="x-layui-input"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${ADMIN},${JKZYY},${QWGZX}">
								
								<%--<tag:autoSelect name="organCode" id="organCode" style="width:170px" ></tag:autoSelect>--%>
								<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchOrg"  townName="searchTown" width="31.9%;" isShowOneself="true" cssClass="x-layui-input" />
							</ehr:authorize>
							<%--<ehr:authorize ifAnyGranted="${ZXZYY},${ZZYY}">
								<ehr:dic-org-list name="inputOrganCode" isShowOneself="true"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${ADMIN},${JKZYY},${QWGZX}">
								<input type="hidden" id="selectCodeType" name="selectCodeType"/>
								<tag:autoSelect name="organCode" id="organCode" style="width:230px" ></tag:autoSelect>
							</ehr:authorize>--%>
							<%--<ehr:authorize ifAnyGranted="${QWGZX}">--%>
							<%--111<input type="hidden" id="selectCodeType" name="selectCodeType"/>--%>
							<%--<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchOrg" townName="searchTown" width="180px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>--%>
							<%--</ehr:authorize>--%>
						</td>
						<td></td>

					</tr>
					<tr>
						<td class="righttd" colspan="6">
							<%-- <input id="searchButton" type="button" name="" value="查询" class="search_btn"/> --%>
							<button class="layui-btn layui-btn-sm" id="searchButton"><i class="layui-icon">&#xe615;</i>查询</button>
							<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span id="btnSearch" class="ico-bottom" onclick="echManageSearch.toggle(this, 'searchTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form>
        </div>
		<div class="toolbarSection">
			<a href="javascript:void(0)" id="tzbs-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		</div>
		<div id="mainResultDiv"></div>
    </div>
     <div id="ech-manage-input-box" ></div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        

        laydate.render({
            elem: '#inputExamYear'
            ,type:'year'
         	   ,max:0
          });
        
        
      });

    </script>