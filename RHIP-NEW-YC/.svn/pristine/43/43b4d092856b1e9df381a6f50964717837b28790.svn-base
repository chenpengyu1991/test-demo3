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

<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/search.js" type="text/javascript"></script>

<div class="section">
    <div class="toolbar">
    	<div class="x-nav">
		        <span class="layui-breadcrumb">
			    <a href="javascript:void(0)">健康教育服务</a>
			    <a href="javascript:void(0)">健康教育资源</a>
			    <a><cite><c:if test="${type=='1'}">宣传设备</c:if><c:if test="${type=='2'}">宣传阵地</c:if> <c:if test="${type=='3'}">健康资料模板登记</c:if> </cite></a>
		        </span>
            </div>
    </div>
    <div class="searchBox searchSection x-admin-sm">
        <form id="healthEducationResourceSearchForm">
            <table id="healthEducationResourceSearch">
                <c:if test="${type eq '1' || type eq '3'}">
                    <colgroup>
                        <col style="width: 15%;"/>
                        <col style="width: 30%;"/>
                        <col style="width: 15%;"/>
                        <col style="width: 30%;"/>
                        <col style="width: 10%;"/>
                    </colgroup>
                </c:if>
                <c:if test="${type eq '2'}">
                    <colgroup>
                        <col style="width: 10%;"/>
                        <col style="width: 20%;"/>
                        <col style="width: 15%;"/>
                        <col style="width: 45%;"/>
                        <col style="width: 10%;"/>
                    </colgroup>
                </c:if>
                <tbody>
                <c:if test="${type eq '1'}">
                    <tr>
                        <td class="col-text">器材名称</td>
                        <td class="col-input">
                            <ehr:dic-list name="deviceName" id="deviceName" dicmeta="HE00006" width="130px"
                                          cssClass="x-layui-input"></ehr:dic-list>
                        </td>
                        <td class="col-text">时间</td>
                        <td class="col-input">
                                <%-- <tag:dateInput name="createBeginTime" id="createBeginTime"  onlypast="true" style="width: 36%;"/>~<tag:dateInput name="createEndTime" id="createEndTime"  onlypast="true" style="width: 36%;"/> --%>
                            <input type="text" class="layui-input x-admin-sm-date" name="createBeginTime"
                                   id="createBeginTime" style="padding-left: 0px;width: 36%;"/> ~
                            <input type="text" class="layui-input x-admin-sm-date" name="createEndTime"
                                   id="createEndTime" style="padding-left: 0px;width: 36%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="col-text">机构</td>
                            <%--需求变更，隐藏站内有内容及权限，2014-03-04--%>
                        <td class="col-input" colspan="3">
                            <ehr:authorize ifAnyGranted="${ZJKJY},${ZXJKJY}">
                                <ehr:dic-org-list name="orgCode" width="130px" isShowOneself="true"
                                                  cssClass="x-layui-input"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ADMIN},${JKJKJY}">
                                <c:if test="${systemType eq '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName=""
                                                                 townName="gbcode" width="130px;" isShowOther="true"
                                                                 isShowOneself="true" cssClass="x-layui-input"/>
                                </c:if>
                                <c:if test="${systemType ne '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                 townName="gbcode" width="130px;" isShowOther="true"
                                                                 isShowOneself="true" cssClass="x-layui-input"/>
                                </c:if>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${QWGZX}">
                                <c:if test="${systemType eq '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName=""
                                                                 townName="gbcode" width="130px;" isShowOneself="true"
                                                                 includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                 cssClass="x-layui-input"/>
                                </c:if>
                                <c:if test="${systemType ne '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                 townName="gbcode" width="130px;" isShowOneself="true"
                                                                 includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                 cssClass="x-layui-input"/>
                                </c:if>
                            </ehr:authorize>
                                <%--<ehr:authorize ifAnyGranted="01,${JKJKJY}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" townName="gbcode" width="130px;" isShowOneself="true" />
                                </ehr:authorize>
                                <ehr:authorize ifAnyGranted="02,03">
                                <ehr:org-type-list value="${currentOrgCode}" code="${currentOrgCode}" name="orgCode" width="150px"/>
                                </ehr:authorize>--%>
                        </td>
                        <td style="text-align: right;" rowspan="2">
                            <!-- <input type="button" id="healthEducationResourceBtnSearch" value="查询" class="search_btn" /> -->
                            <button class="layui-btn layui-btn-sm" id="healthEducationResourceBtnSearch"><i
                                    class="layui-icon">&#xe615;</i>查询
                            </button>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${type eq '2'}">
                    <tr>
                        <td class="col-text">年度</td>
                        <td class="col-input">
                                <%-- <tag:dateInput name="positionYear" id="positionYear" pattern="yyyy" onlypast="false"/> --%>
                            <input type="text" class="layui-input x-admin-sm-date" name="positionYear" id="positionYear"
                                   style="padding-left: 0px;"/>
                        </td>
                        <td class="col-text">机构</td>
                            <%--需求变更，隐藏站内有内容及权限，2014-03-04--%>
                        <td class="col-input">
                            <ehr:authorize ifAnyGranted="${ZJKJY},${ZXJKJY}">
                                <ehr:dic-org-list name="orgCode" width="130px" isShowOneself="true"
                                                  cssClass="x-layui-input"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ADMIN},${JKJKJY}">
                                <c:if test="${systemType eq '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName=""
                                                                 townName="gbcode" width="130px;" isShowOther="true"
                                                                 isShowOneself="true" cssClass="x-layui-input"/>
                                </c:if>
                                <c:if test="${systemType ne '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                 townName="gbcode" width="130px;" isShowOther="true"
                                                                 isShowOneself="true" cssClass="x-layui-input"/>
                                </c:if>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${QWGZX}">
                                <c:if test="${systemType eq '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName=""
                                                                 townName="gbcode" width="130px;" isShowOneself="true"
                                                                 includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                 cssClass="x-layui-input"/>
                                </c:if>
                                <c:if test="${systemType ne '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                 townName="gbcode" width="130px;" isShowOneself="true"
                                                                 includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                 cssClass="x-layui-input"/>
                                </c:if>
                            </ehr:authorize>
                                <%--<ehr:authorize ifAnyGranted="01,12">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" townName="gbcode" width="130px;" isShowOneself="true" />
                                </ehr:authorize>
                                <ehr:authorize ifAnyGranted="02,03">
                                <ehr:org-type-list type="centre" value="${currentOrgCode}" code="${currentOrgCode}" name="orgCode" width="150px"/>
                                </ehr:authorize>--%>
                        </td>
                        <td style="text-align: right;">
                            <!-- <input type="button" id="healthEducationResourceBtnSearch" value="查询" class="search_btn" /> -->
                            <button class="layui-btn layui-btn-sm" id="healthEducationResourceBtnSearch"><i
                                    class="layui-icon">&#xe615;</i>查询
                            </button>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${type eq '3'}">
                    <tr>
                        <td class="col-text">宣传材料类型</td>
                        <td class="col-input">
                            <ehr:dic-list name="materialType" dicmeta="HE00007" width="130px" id="materialType"
                                          cssClass="x-layui-input"></ehr:dic-list>
                        </td>
                        <td class="col-text">时间</td>
                        <td class="col-input">
                                <%-- <tag:dateInput name="createBeginTime" id="createBeginTime"  style="width: 36%;"/>~<tag:dateInput name="createEndTime" id="createEndTime"  onlypast="true" style="width: 36%;"/> --%>
                            <input type="text" class="layui-input x-admin-sm-date" name="createBeginTime"
                                   id="createBeginTime" style="padding-left: 0px;width: 36%;"/> ~
                            <input type="text" class="layui-input x-admin-sm-date" name="createEndTime"
                                   id="createEndTime" style="padding-left: 0px;width: 36%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="col-text">机构</td>
                            <%--需求变更，隐藏站内有内容及权限，2014-03-04--%>
                        <td class="col-input" colspan="3">
                            <ehr:authorize ifAnyGranted="${ZJKJY},${ZXJKJY}">
                                <ehr:dic-org-list name="orgCode" width="130px" isShowOneself="true"
                                                  cssClass="x-layui-input"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ADMIN},${JKJKJY}">
                                <c:if test="${systemType eq '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName=""
                                                                 townName="gbcode" width="130px;" isShowOther="true"
                                                                 isShowOneself="true" cssClass="x-layui-input"/>
                                </c:if>
                                <c:if test="${systemType ne '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                 townName="gbcode" width="130px;" isShowOther="true"
                                                                 isShowOneself="true" cssClass="x-layui-input"/>
                                </c:if>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${QWGZX}">
                                <c:if test="${systemType eq '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName=""
                                                                 townName="gbcode" width="130px;" isShowOneself="true"
                                                                 includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                 cssClass="x-layui-input"/>
                                </c:if>
                                <c:if test="${systemType ne '1'}">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                 townName="gbcode" width="130px;" isShowOneself="true"
                                                                 includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                 cssClass="x-layui-input"/>
                                </c:if>
                            </ehr:authorize>
                                <%--<ehr:authorize ifAnyGranted="01,12">
                                    <ehr:dic-town-centre-station centreName="centerOrgCode" townName="gbcode" width="130px;" isShowOneself="true" />
                                </ehr:authorize>
                                <ehr:authorize ifAnyGranted="02,03">
                                <ehr:org-type-list value="${currentOrgCode}" code="${currentOrgCode}" name="orgCode" width="150px"/>
                                </ehr:authorize>--%>
                        </td>
                        <td style="text-align: right;" rowspan="2">
                            <!-- <input type="button" id="healthEducationResourceBtnSearch" value="查询"
                                 class="search_btn" /> -->
                            <button class="layui-btn layui-btn-sm" id="healthEducationResourceBtnSearch"><i
                                    class="layui-icon">&#xe615;</i>查询
                            </button>
                        </td>
                    </tr>
                </c:if>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span
                            onclick="healthEducationResourceSearch.toggle(this,'healthEducationResourceSearch')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
            <input type="hidden" name="resourceType" value="${type}">
        </form>
    </div>
    <div class="toolbarSection x-admin-sm">
		<ehr:authorize ifNotGranted="${QWGZX}">
			<input type="hidden" id="qwgzx" value="${'04'}"/>
		</ehr:authorize>
		<ehr:authorize ifNotGranted="${ADMIN},${QWGZX}">
			<a id="resourceAdd">
				<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
			</a>
		</ehr:authorize>
    </div>
    <input type="hidden" id="searchType" value="${type}"/>
    <div id="healthEducationResourceResultDiv">
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

        laydate.render({
            elem: '#positionYear'
            , type: 'year'
            , max: 0
        });

    });

</script>