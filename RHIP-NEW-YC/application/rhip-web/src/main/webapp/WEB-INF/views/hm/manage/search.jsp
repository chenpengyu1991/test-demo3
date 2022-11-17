<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKLNR" value="<%=RoleType.JKLNR.getValue()%>"/>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>



<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/manage/search.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/hm/verify/search.js" type="text/javascript"></script>--%>
	<div class="section"  id="hm-manage-list-box">
		<div class="toolbar">
			<div class="x-nav">
       <span class="layui-breadcrumb">
        <a href="javascript:void(0)">老年人健康管理</a>
        <a>
          <cite>健康管理</cite></a>
      </span>
    </div>
		</div>
	<div id="search">
		<%--<div class="toolbar"><b></b></div>--%>
		<div class="searchbox searchSection x-admin-sm">
			<form id="searchForm">
				<table id="searchTable">
					<colgroup>
                        <col style="width: 10%;"/>
                        <col style="width: 23%;"/>
                        <col style="width: 10%;"/>
                        <col style="width: 23%;"/>
						<col style="width: 10%;"/>
						<col style="width: 23%;"/>
					</colgroup>
					<tr>
						<td class="coltext">年&nbsp;&nbsp;&nbsp;&nbsp;份</td>
						<td class="colinput">
							<%-- <tag:dateInput id="inputExamYear" name="examYear" date="${currentYear}" pattern="yyyy"/> --%>
							<input type="text" class="layui-input x-admin-sm-date" reg="{'required':true}" name="examYear" id="inputExamYear" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>"  style="padding-left: 0px;"   />
						</td>
						<td class="coltext">姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
						<td class="colinput"><input type="text" name="name" value="" class="x-layui-input" /></td>
						<td class="coltext">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td class="colinput"><ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2"  /></td>
					</tr>
					<tr>
						<td class="coltext">身份证号</td>
						<td class="colinput"><input type="text" name="idcard" value=""  class="x-layui-input"/></td>
						<!-- <td class="coltext">是否结案</td>
						<td class="colinput">
							<select name="logoff" class="x-layui-input">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td> -->
						<td class="coltext">管理机构</td>
						<td class="colinput">
							<ehr:authorize ifAnyGranted="${ZXLNR},${ZX_GLY}">
								<ehr:dic-org-list name="inputOrganCode" isShowOneself="true"  cssClass="x-layui-input" />
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${ZLNR},${Z_GLY}">
								<ehr:dic-org-list id="inputOrganCode" name="inputOrganCode"  cssClass="x-layui-input" />
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${ADMIN},${JKLNR}">
								<input type="hidden" id="selectCodeType" name="selectCodeType"/>
								<ehr:dic-town-centre-station centreName="centerCode" stationName="stationCode"  townName="townCode" isShowOneself="true" includeTownCodes="${includeTownCodes}" cssClass="x-layui-input" />
							</ehr:authorize>
						</td>
					</tr>
					<tr class="advanceSearchSection" style="display: none;">
						<td class="coltext">体检状态</td>
						<td class="colinput">
							<select name="examStatus" class="x-layui-input">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
						<td class="coltext">是否评估</td>
						<td class="colinput">
							<select name="estimateStatus" class="x-layui-input">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
						<td class="coltext">是否中医指导</td>
						<td class="colinput">
							<select name="healthGuideStatus" class="x-layui-input">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
					</tr>
					<tr class="advanceSearchSection" style="display: none;">
						<td class="coltext">是否规范年检</td>
						<td class="colinput">
							<select name="criterionExamination" onchange="hmManageSearch.showStatus(this.value);" class="x-layui-input">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
						<td class="coltext">体检日期</td>
                            <td class="colinput">
                                <%-- <tag:dateInput name="examinationDateStart" onlypast="true" style="width:35%;"/> ~
                                <tag:dateInput name="examinationDateEnd" onlypast="true" style="width:35%;"/> --%>
                                <input type="text" class="layui-input x-admin-sm-date"  name="examinationDateStart" id="examinationDateStartId" style="padding-left: 0px;width: 37.8%;" /> ~
                                <input type="text" class="layui-input x-admin-sm-date" name="examinationDateEnd" id="examinationDateEndId" style="padding-left: 0px;width: 37.8%;" />
                            </td>
                        <td class="coltext">现住居委会</td>
						<td class="colinput">
							<ehr:dic-town-street-village streetId="street_address" townId="town_address" 
														streetName="searchPastreet" townName="searchPatownShip"  width="118px;" cssClass="x-layui-input" />
						</td>
					</tr>
					<tr>
                        <td class="righttd" colspan="6">
							<button class="layui-btn layui-btn-sm" id="searchButton"><i class="layui-icon">&#xe615;</i>查询</button>
							<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span id="btnSearch" class="ico-bottom" onclick="hmManageSearch.toggle(this, 'searchTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="toolbarSection">
		<ehr:authorize ifAnyGranted="${ADMIN},${ZXLNR},${ZLNR}"><!-- 站、中心 -->
			<%-- <a href="javascript:void(0)" id="btnReflash"><b class="gengxin" id="btnReflashLabel">更新名单</b></a> --%>
			<a href="javascript:void(0)" id="btnReflash"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe669;</i>更新名单</button></a>
			</ehr:authorize>
		<a href="javascript:void(0)" id="ehr-person-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
    </div>
	<div id="reportListDiv"></div>
</div>
<div id="hm-manage-input-box"></div>

 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#inputExamYear' 
       	   ,type: 'year'
       	   ,max:0
        });

        laydate.render({
          elem: '#examinationDateStartId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
        laydate.render({
          elem: '#examinationDateEndId'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });
      
      
      });

    </script>