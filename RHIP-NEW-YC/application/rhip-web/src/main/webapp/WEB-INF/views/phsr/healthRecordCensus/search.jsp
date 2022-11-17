<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
 <jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="ZXJKDN" value="<%=RoleType.ZXJKDN.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>
<c:set var="ZJKDN" value="<%=RoleType.ZJKDN.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/phsr/healthRecordCensus/search.js" type="text/javascript"></script>

<div class="section">

    <div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">公卫服务监管</a>
		        <a>
		          <cite>城乡居民健康档案管理统计报表</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchBox searchSection x-admin-sm">
        <form id="healthRecordCensusForm">
            <table id="healthRecordCensus">
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
                    <td class="col-input" colspan="4">
                        <input type="radio" id="mhmReprtYearId" name="countType"  class="radioGroup" value="1" checked="checked" onclick="healthRecordCensus.changeReportType()"/><label for="mhmReprtYearId">按年</label>
                        <input type="radio" id="mhmReprtQuarterId" name="countType"  class="radioGroup" value="2" onclick="healthRecordCensus.changeReportType()"/><label for="mhmReprtQuarterId">按季度</label>
                        <%-- <tag:dateInput nullToToday="true" id="reportYearId" name="year" pattern="yyyy"  date="${searchDate}" onlypast="true" reg='{"required":"true"}' style="width: 100px;"/> --%>
                        <input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:100px;padding-left: 0px;" name="year" id="reportYearId" value="<fmt:formatDate value='${searchDate}' pattern='yyyy'/>" />
                        <select id="reportQuarter" name="quarter" style="width: 100px;display:none" class="x-layui-input">
                            <option value="0">请选择</option>
                            <option value="1">第一季度</option>
                            <option value="2">第二季度</option>
                            <option value="3">第三季度</option>
                            <option value="4">第四季度</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">机构</td>
                    <td class="col-input" colspan="4">
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN}">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${ZX_GLY},${ZXJKDN},${Z_GLY},${ZJKDN}">
                            <ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>

                    <td style="text-align: right;"><!-- <input type="button" id="healthRecordCensusSearch" value="查询" class="search_btn" /> -->
                    <button class="layui-btn layui-btn-sm" id="healthRecordCensusSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
					<tr>
						<td colspan="4" class="colbottom"><span
							onclick="healthRecordCensus.toggle(this,'healthRecordCensus')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
        </form>
    </div>
    <div class="toolbarSection">
        <!-- <a href="javascript:void(0)" id="report-export"><b class="export">导出</b></a> -->
        <a href="javascript:void(0)" id="report-export"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        <c:if test="${roleType eq '02' || roleType eq '03'}">
       <span id="modifyInfectEmer">
            <!-- <a href="javascript:void(0)" id="modify" ><b class="xiug">修改</b></a> -->
            <a href="javascript:void(0)" id="modify"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe642;</i>修改</button></a>
        </span>
            <span id="cancelInfectEmer">
            <!-- <a href="javascript:void(0)" id="cancel" ><b class="quxiao">取消</b></a> -->
            <a href="javascript:void(0)" id="cancel"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#x1006;</i>取消</button></a>
                <!-- <a href="javascript:void(0)" id="save" ><b class="baocun">保存</b></a> -->
            <a href="javascript:void(0)" id="save" ><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe605;</i>保存</button></a>
        </span>
        </c:if>
    </div>

    <div id="healthRecordCensusListDiv">
		<jsp:include page="list.jsp"/>
    </div>
</div>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#reportYearId' 
     	   ,type: 'year'
     	   ,max:0
      });

  
});
</script>