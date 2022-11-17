<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>"/>
<c:set var="ZXJKDN" value="<%=RoleType.ZXJKDN.getValue()%>"/>
<c:set var="ZJKDN" value="<%=RoleType.ZJKDN.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/phsr/vaccinationCensus/search.js"
        type="text/javascript"></script>

<div class="section">
    <div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">公卫服务监管</a>
		        <a>
		          <cite>预防接种统计报表</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchBox searchSection x-admin-sm">
        <input type="hidden" name="timeFlag" value="1"/>
        <form id="vaccinationCensusForm">
            <table id="vaccinationCensus">
                <colgroup>
                    <col style="width: 50px;"/>
                    <col style="width: 80px;"/>
                    <col style="width: 50px;"/>
                    <col style="width: 60px;"/>
                    <col style="width: 50px;"/>
                    <col style="width: 200px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text"><label>时间范围</label></td>
                    <td class="col-input" colspan="3">
                        <input type="radio" id="mhmReprtYearId" name="countType" class="radioGroup" value="1"
                               checked="checked" onclick="vaccinationCensus.changeReportType()"/><label
                            for="mhmReprtYearId">按年</label>
                        <input type="radio" id="mhmReprtQuarterId" name="countType" class="radioGroup" value="2"
                               onclick="vaccinationCensus.changeReportType()"/><label
                            for="mhmReprtQuarterId">按季度</label>
                        <%-- <tag:dateInput name="year" id="year" onlypast="true" style="width:120px;" date="${currentYear}"
                                       pattern="yyyy" reg='{"required":"true"}'/> --%>
                         <input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:120px;padding-left: 0px;" name="year" id="year" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>" />
                        <select name="month" id="month" style="width:120px;display: none;" class="x-layui-input">
                            <option value="">请选择</option>
                            <option value="01">第一季度</option>
                            <option value="02">第二季度</option>
                            <option value="03">第三季度</option>
                            <option value="04">第四季度</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">机构</td>
                    <td class="col-input" colspan="4">
                        <ehr:authorize ifAnyGranted="${ADMIN},${ZX_GLY},${ZXJKDN},${JKJKDN}">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                         townName="gbcode" width="130px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${YY_GLY},${Z_GLY},${ZJKDN}">
                            <ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>

                    <td style="text-align: right;"><!-- <input type="button" id="vaccinationCensusBtnSearch" value="查询"
                                                          class="search_btn"/> -->
                        <button class="layui-btn layui-btn-sm" id="vaccinationCensusBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>                                  
                                                          </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom"><span
                            onclick="vaccinationCensus.toggle(this,'vaccinationCensus')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection">
        <!-- <a id="vaccinationCensusResultDivExport" href="javascript:void(0)"><b class="export">导出</b></a> -->
        <a id="vaccinationCensusResultDivExport" href="javascript:void(0)"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        <ehr:authorize ifAnyGranted="${ZXJKDN},${ZJKDN}">
            <span id="modifyCommunityIdSpan">
					<!-- <a href="javascript:void(0)" id="modifyCommunityId"><b class="xiug">修改</b></a> -->
					<a href="javascript:void(0)" id="modifyCommunityId"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe642;</i>修改</button></a>
				</span>
            <span id="cancelCommunityIdSpan">
					<!-- <a href="javascript:void(0)" id="cancelCommunityId"><b class="quxiao">取消</b></a> -->
					<a href="javascript:void(0)" id="cancelCommunityId"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#x1006;</i>取消</button></a>
                <!-- <a href="javascript:void(0)" id="saveCommunityId"><b class="baocun">保存</b></a> -->
					<a href="javascript:void(0)" id="saveCommunityId"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe605;</i>保存</button></a>
				</span>
        </ehr:authorize>
    </div>
    <form id="communityInfoForm">
        <div id="vaccinationCensusResultDiv">
            <jsp:include page="list.jsp"/>
        </div>
    </form>
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