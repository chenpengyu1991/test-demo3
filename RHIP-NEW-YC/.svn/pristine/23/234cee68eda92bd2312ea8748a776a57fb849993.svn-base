<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/woman/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#checkDateStart'
             ,format: 'yyyy/MM/dd'
          });
          
          laydate.render({
            elem: '#checkDateEnd'
          	  ,format: 'yyyy/MM/dd'
          });
      });
</script>
<div class="section" id="pFollowupId">
    
    <div class="toolbar">
		<div class="toolbar">
           <div class="x-nav">
		        <span class="layui-breadcrumb">
                    <a href="javascript:void(0)">综合管理</a>
			    <a href="javascript:void(0)">孕产妇健康管理</a>
			    <a><cite>产后访视记录</cite></a>
		        </span>
            </div>
        </div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchType" value="${searchType}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 30%; min-width: 70px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" style="width:98%;" class="x-layui-input">
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="idCard" style="width:98%;" class="x-layui-input"/>
                    </td>
                    <td class="col-text">随访日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date" name="checkDateStart" id="checkDateStart" style="padding-left: 0px;width: 38%;" /> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="checkDateEnd" id="checkDateEnd" style="padding-left: 0px;width: 38%;" />
                    </td>
                </tr>
                <tr>
                    <td class="col-text">随访机构</td>
                    <td class="col-input" colspan="3">
                        <ehr:authorize ifAnyGranted="03">
                            <ehr:dic-org-list name="organCode" isShowOneself="true" width="180px;" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,0205">
                            <ehr:dic-org-list name="organCode" isShowOneself="true" width="180px;" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="01,0105,11,62,63">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation"  townName="searchTown" width="180px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04,0405">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="organCode" townName="searchTown" width="180px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>
                </tr>
                <tr>
                    <td colspan="5"></td>
                    <td>
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon"></i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <ehr:authorize ifAnyGranted="02,0205,0105,0405,03">
    <div class="toolbarSection">
        <a id="postnatalAdd"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>新增</button></a>
    </div>
    </ehr:authorize>
    <div id="womanListDiv">
        <%--<jsp:include page="${listpath}"></jsp:include>--%>
    </div>
</div>
<div id="pFOUpDiv" class="postcontent"></div>