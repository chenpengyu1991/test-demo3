<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKJKJY" value="<%=RoleType.JKJKJY.getValue()%>"/>
<c:set var="ZXJKJY" value="<%=RoleType.ZXJKJY.getValue()%>"/>
<c:set var="ZJKJY" value="<%=RoleType.ZJKJY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/he/plan/search.js" type="text/javascript"></script>
<div class="section">
    <div class="toolbar">
    	<div class="x-nav">
		        <span class="layui-breadcrumb">
			    <a href="javascript:void(0)">健康教育服务</a>
			    <a href="javascript:void(0)">健康教育登记</a>
			    <a><cite>年度工作计划 </cite></a>
		        </span>
            </div>
    </div>
    <div class="searchBox searchSection x-admin-sm">
        <form id="heWorkPlanSearchForm">
            <table id="healthEducationActiveSearch">
                <colgroup>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 140px; width: 25%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 100px; width: 25%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 160px; width: 30%;"/>
                    <col style="width: 100px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">填报机构</td>
                    <td>
                        <ehr:dic-town-centre-station stationName="createOrgCode" centreName="createCenterOrgCode"
                                                     townName="createGbcode" width="130px;" isShowOther="true"
                                                     isShowOneself="true" cssClass="x-layui-input"/>
                    </td>
                    <td class="col-text">计划类型</td>
                    <td><ehr:dic-list name="planType" dicmeta="HE00033" value="${heWorkPlan.planType}" width="75%"
                                      cssClass="x-layui-input"/></td>
                    <td class="col-text">填报时间</td>
                    <td>
                        <%-- <tag:dateInput name="beginDate" id="beginDate" date="${currentYearStartDate}"  style="width:35%;" /> ~ <tag:dateInput name="endDate" id="endDate"
                                                                                                                                                                  style="width:35%;" /> --%>
                        <input type="text" class="layui-input x-admin-sm-date" name="beginDate" id="beginDate"
                               style="padding-left: 0px;width:40%;"
                               value="<fmt:formatDate value='${currentYearStartDate}' pattern='yyyy/MM/dd'/>"/> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="endDate" id="endDate"
                               style="padding-left: 0px;width:40%;"/>
                    </td>
                    <td>
                        <!-- <input type="button" id="healthEducationActiveBtnSearch" value="查询" class="search_btn" /> -->
                        <button class="layui-btn layui-btn-sm" id="healthEducationActiveBtnSearch"><i
                                class="layui-icon">&#xe615;</i>查询
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span
                            onclick="healthEducationActiveSearch.toggle(this,'healthEducationActiveSearch')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
            <input type="hidden" name="resourceType" value="${type}"> <input type="hidden" id="systemType"
                                                                             name="systemType" value="${systemType}">
        </form>
    </div>
    <div class="toolbarSection x-admin-sm">
        <ehr:authorize ifAnyGranted="${ZXJKJY},${ZJKJY}">
            <a id="activeAdd" href="javascript:void(0)">
                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
            </a>
        </ehr:authorize>
    </div>
    <input type="hidden" id="searchType" value="${type}"/>
    <div id="healthEducationActiveResultDiv"></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#beginDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#endDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

    });
</script>