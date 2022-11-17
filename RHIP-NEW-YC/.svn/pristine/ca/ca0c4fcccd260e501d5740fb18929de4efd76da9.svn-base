<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/deathReport/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#deathDateStart'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#deathDateEnd'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

    });
</script>
<div class="section" id="childDeathListDiv">
	<ehr:authorize ifAnyGranted="01,0204,0304,0404">
        <div class="toolbar">
            <div class="x-nav">
                  <span class="layui-breadcrumb">
                    <a href="javascript:void(0)">儿童健康管理</a>
                    <a>
                      <cite>儿童死亡报告卡</cite></a>
                  </span>
            </div>
        </div>
    </ehr:authorize>
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="searchType" value="${searchType}">
		<form id="searchForm">
            <table id="child-death-search-table">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" style="width:172px;" name="name" class="x-layui-input">
                    </td>
                    <td class="col-text">死亡日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date" name="deathDateStart" id="deathDateStart" style="padding-left: 0px;width: 38%;" />
                        ~
                        <input type="text" class="layui-input x-admin-sm-date" name="deathDateEnd" id="deathDateEnd" style="padding-left: 0px;width: 38%;" />
                    </td>
                    <td class="col-text">填报机构</td>
                    <td class="col-input">
                        <ehr:authorize ifAnyGranted="03">
                            <ehr:dic-org-list name="organCode" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,0204">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation"  townName="searchTown" width="180px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="01,11,62,63,0104">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation"  townName="searchTown" width="180px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04,0404">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation" townName="searchTown" width="180px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>
                </tr>
                <tr>
                    <td colspan="5"></td>
                    <td>
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
			<table>
				<tr>
					<td colspan="4" class="colbottom"><span id="child-death-search-toggle-btn" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>

    <ehr:authorize ifAnyGranted="0204,0304,0404">
        <div class="toolbarSection">
            <ehr:authorize ifAnyGranted="0204,0304,0404">
                <a id="childDeathAdd">
                    <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
                </a>
            </ehr:authorize>
        </div>
    </ehr:authorize>
	<div id="resultDiv">
		<%-- <jsp:include page="list.jsp"></jsp:include> --%>
	</div>
</div>
<div id="childDeathDiv" class="postdiv"></div>