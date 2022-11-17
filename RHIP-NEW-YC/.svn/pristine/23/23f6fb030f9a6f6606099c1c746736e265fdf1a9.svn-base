<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/phsr/mentalEpilepsyCensus/search.js"
        type="text/javascript"></script>

<div class="section">

    <div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">公卫服务监管</a>
		        <a>
		          <cite>严重精神障碍患者管理统计报表</cite></a>
		      </span>
		</div>
        <!-- <a id="mentalEpilepsyCensusListDivExport" href="javascript:void(0)"><b class="export">导出</b></a> -->

    </div>

    <div class="searchBox searchSection x-admin-sm">
        <form id="MentalEpiForm">
            <table id="mentalEpilepsyCensus">
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
                    <td class="col-input" colspan="4">
                        <input type="radio" id="YearType" name="countType" class="radioGroup" value="1"
                               checked="checked" onclick="mentalEpilepsyCensus.changeReportType()"/><label
                            for="YearType">按年</label>
                        <input type="radio" id="QuarterType" name="countType" class="radioGroup" value="2"
                               onclick="mentalEpilepsyCensus.changeReportType()"/><label for="QuarterType">按季度</label>
                        <%-- <tag:dateInput nullToToday="true" id="Year" name="year" pattern="yyyy" date="${searchDate}"
                                       onlypast="true" reg='{"required":"true"}' style="width: 100px;"/> --%>
                                       
                          <input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:100px;padding-left: 0px;" name="year" id="Year" value="<fmt:formatDate value='${searchDate}' pattern='yyyy'/>" />             
                        <select id="Quarter" name="quarter" style="width: 100px;display:none" class="x-layui-input">
                            <option value="">请选择</option>
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
                        <ehr:authorize ifAnyGranted="01,12,0108">
                            <ehr:dic-town-centre-station centreName="parentCode" stationName="organCode"
                                                         townName="gbCode" width="130px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04,0408">
                            <ehr:dic-town-centre-station centreName="parentCode" stationName="organCode"
                                                         townName="gbCode" width="130px;" isShowOneself="true"
                                                         includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,03,0208">
                            <ehr:dic-org-list name="organCode" width="150px" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>
                    <td style="text-align: right;"><!-- <input type="button" id="mentalEpiSearch" value="查询"
                                                          class="search_btn"/> -->
                       <button class="layui-btn layui-btn-sm" id="mentalEpiSearch"><i class="layui-icon">&#xe615;</i>查询</button>                                   
                                                          </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom"><span
                            onclick="mentalEpilepsyCensus.toggle(this,'mentalEpilepsyCensus')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection">
    	<a id="mentalEpilepsyCensusListDivExport" href="javascript:void(0)"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        <ehr:authorize ifAnyGranted="0208,0408">
            <span id="modifyMentalEpi">
                <!-- <a href="javascript:void(0)" id="modify"><b class="xiug">修改</b></a> -->
                <a href="javascript:void(0)" id="modify"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe642;</i>修改</button></a>
            </span>
            <span id="cancelMentalEpi">
                <!-- <a href="javascript:void(0)" id="cancel"><b class="quxiao">取消</b></a> -->
                <a href="javascript:void(0)" id="cancel"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#x1006;</i>取消</button></a>
                <!-- <a href="javascript:void(0)" id="save"><b class="baocun">保存</b></a> -->
                <a href="javascript:void(0)" id="save"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe605;</i>保存</button></a>
            </span>
        </ehr:authorize>
    </div>
    
    <div id="mentalEpilepsyCensusListDiv">
        <jsp:include page="list.jsp"/>
    </div>
</div>

<script type="text/javascript">
  
  layui.use('laydate', function() {
      var laydate = layui.laydate;
      
     laydate.render({
        elem: '#Year' 
     	   ,type: 'year'
     	   ,max:0
      });

  
});
</script>