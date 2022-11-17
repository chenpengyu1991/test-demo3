<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKWJ" value="<%=RoleType.JKWJ.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="ZXWJ" value="<%=RoleType.ZXWJ.getValue()%>"/>

<script type="text/javascript">
    var reportSec = (function () {
        $(function () {
            $("#hsa-listDiv-export").click(function(e) {
            	e.preventDefault();
                $("#listDiv").exportExcel("卫生监督协管报表");
            });
            search();
            $("#search").click(function (e) {
                e.preventDefault();
            	search();
            });
        });

        function search() {
            $("#formSec").submitFormLoadHtml({
                url:"/hsa/inspRecord/healthSpur/list",
                insertDiv:"listDiv"
            });
        }

        //查询框
        function changeReportType(){
            var countType = $('input:radio[name="countType"]:checked').val();
            if(countType == '1'){//按年
                $('#reportYearId').show();
                $('#reportQuarter').hide();
                $("#reportQuarter").val(0);
            }else if(countType == '2'){//按季度
                $('#reportYearId').show();
                $('#reportQuarter').show();
            }
        }
        
        function changeQuarter() {
            search();
        }

        return{
            changeReportType:changeReportType,
            changeQuarter:changeQuarter
        }

    })();
</script>

<div class="section">
    <div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">公卫服务监管</a>
		        <a>
		          <cite>卫生监督协管报表</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchBox searchSection x-admin-sm">
        <form id="formSec">
            <table id="healthRecordCensus">
                <colgroup>
                    <col style="width: 50px;" />
                    <col style="width: 200px;" />
                    <col style="width: 50px;" />
                    <col style="width: 200px;" />
                    <col style="width: 200px;" />
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text"><label>时间范围</label></td>
                    <td class="col-input" >
                        <input type="radio" id="mhmReprtYearId" name="countType"  class="radioGroup" value="1" checked="checked" onclick="reportSec.changeReportType()"/><label for="mhmReprtYearId">按年</label>
                        <input type="radio" id="mhmReprtQuarterId" name="countType"  class="radioGroup" value="2" onclick="reportSec.changeReportType()"/><label for="mhmReprtQuarterId">按季度</label>
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
                 		<ehr:authorize ifAnyGranted="${ADMIN},${JKWJ}">
		                    <td class="col-text">机构</td>
		                    <td class="col-input" >
		                            <ehr:dic-town-centre-station centreName="centerOrgCode" townName="gbcode" width="130px;" isShowOneself="true" cssClass="x-layui-input" />
		                       <%-- <ehr:authorize ifAnyGranted="${ZX_GLY},${ZXWJ}">
		                            <ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true"/>
		                        </ehr:authorize>--%> 
		                    </td>
		                </ehr:authorize>
		                <ehr:authorize ifAnyGranted="${ZX_GLY},${ZXWJ}">
		                	<td colspan="2"></td>
		                 </ehr:authorize>
		                <td style="text-align: right;"><!-- <input type="button" id="search" value="查询" class="search_btn" /> -->
		                <button class="layui-btn layui-btn-sm" id="search"><i class="layui-icon">&#xe615;</i>查询</button>
		                </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="5" class="colbottom"><span
                            onclick="toggle(this,'healthRecordCensus')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection">
        <!-- <a href="javascript:void(0)" id="hsa-listDiv-export"><b class="export">导出</b></a> -->
        <a href="javascript:void(0)" id="hsa-listDiv-export"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
    </div>
    <div id="listDiv">
        <jsp:include page="resultSec.jsp"/>
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