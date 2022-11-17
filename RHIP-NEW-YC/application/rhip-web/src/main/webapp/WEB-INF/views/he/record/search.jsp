<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKJKJY" value="<%=RoleType.JKJKJY.getValue()%>"/>
<c:set var="ZXJKJY" value="<%=RoleType.ZXJKJY.getValue()%>"/>
<c:set var="ZJKJY" value="<%=RoleType.ZJKJY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/he/record/search.js" type="text/javascript"></script>

<div class="section">
    <div class="toolbar">
    	<div class="x-nav">
		        <span class="layui-breadcrumb">
			    <a href="javascript:void(0)">健康教育服务</a>
			    <a href="javascript:void(0)">健康教育登记</a>
			    <a><cite><c:if test="${type eq '1'}">宣传栏使用</c:if><c:if
                            test="${type eq '2'}">健康资料发放</c:if> </cite></a>
		        </span>
            </div>
    </div>
    <div class="searchBox searchSection x-admin-sm">
        <form id="healthEducationResourceRecordSearchForm">
            <table id="healthEducationResourceRecordSearch">
                <colgroup>
                    <col style="width: 15%;"/>
                    <col style="width: 40%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 25%;"/>
                    <col style="width: 10%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text"><c:if test="${type eq '1'}">阵地类型</c:if><c:if
                            test="${type eq '2'}">资料类型</c:if></td>
                    <td class="col-input">
                        <c:if test="${type eq '1'}">
                            <ehr:dic-list name="positionType" dicmeta="HE00008" width="100px" id="positionType"
                                          cssClass="x-layui-input"></ehr:dic-list>
                        </c:if>
                        <c:if test="${type eq '2'}">
                            <ehr:dic-list name="materialType" dicmeta="HE00007" width="100px" id="materialType"
                                          cssClass="x-layui-input"></ehr:dic-list>
                        </c:if>
                    </td>
                    <td class="col-text">出刊时间</td>
                    <td class="col-input">
                        <%-- <tag:dateInput name="createBeginTime" id="createBeginTime"  style="width: 35%;"/>~<tag:dateInput name="createEndTime" id="createEndTime"  style="width: 35%;"/> --%>
                        <input type="text" class="layui-input x-admin-sm-date" name="createBeginTime"
                               id="createBeginTime" style="padding-left: 0px;width:35%;"/> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="createEndTime" id="createEndTime"
                               style="padding-left: 0px;width:35%;"/>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">机构</td>
                    <td class="col-input">
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKJKJY}">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                         townName="gbcode" width="100px;" isShowOneself="true"
                                                         cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${QWGZX}">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                         townName="gbcode" width="100px;" isShowOneself="true"
                                                         includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                         cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${ZJKJY},${ZXJKJY}">
                            <ehr:dic-org-list name="orgCode" width="100px" isShowOneself="true"
                                              cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>
                    <c:if test="${type eq '1'}">
                        <td class="col-text">宣传内容</td>
                        <td class="col-input">
                            <ehr:dic-list name="contentType" dicmeta="HE00005" width="195px" id="contentType"
                                          type="true" cssClass="x-layui-input"></ehr:dic-list>
                        </td>
                    </c:if>
                    <c:if test="${type eq '2'}">
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </c:if>
                    <td style="text-align: right;" rowspan="2"><!-- <input type="button" id="healthEducationResourceRecordBtnSearch" value="查询"
								 class="search_btn" /> -->
                        <button class="layui-btn layui-btn-sm" id="healthEducationResourceRecordBtnSearch"><i
                                class="layui-icon">&#xe615;</i>查询
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span
                            onclick="healthEducationResourceRecordSearch.toggle(this,'healthEducationResourceRecordSearch')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
            <input type="hidden" name="resourceType" value="${type}">
        </form>
    </div>
    <div class="toolbarSection x-admin-sm">
        <ehr:authorize ifNotGranted="${QWGZX}">
            <input type="hidden" id="wgzx" value="${QWGZX}"/>
            <a id="resourceRecordAdd" href="javascript:void(0)">
                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
            </a>
        </ehr:authorize>
    </div>
    <input type="hidden" id="searchType" value="${type}"/>
    <div id="healthEducationResourceRecordResultDiv">
    </div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#createBeginTime'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#createEndTime'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

    });
</script>