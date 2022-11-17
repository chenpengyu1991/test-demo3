<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKWJ" value="<%=RoleType.JKWJ.getValue()%>"/>
<c:set var="ZXWJ" value="<%=RoleType.ZXWJ.getValue()%>"/>
<c:set var="ZWJ" value="<%=RoleType.ZWJ.getValue()%>"/>
<c:set var="JKJKJY" value="<%=RoleType.JKJKJY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/he/active/search.js" type="text/javascript"></script>
<div class="section" id="heActiveSearchDivId">
    <div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		      <c:if test="${systemType ne '1' }">
		        <a href="javascript:void(0)">健康教育服务</a>
		        <a href="javascript:void(0)">健康教育登记</a>
		        <a>
		          <cite>健康讲座与咨询 </cite></a>
		          </c:if>
		          <c:if test="${systemType eq '1' }">
		        <a href="javascript:void(0)">卫生计生监督协管</a>
		        <a>
		          <cite>宣传培训</cite></a>
		          </c:if>
		      </span>
		</div>
    </div>
    <div class="searchBox searchSection x-admin-sm">
        <form id="healthEducationActiveSearchForm">
            <table id="healthEducationActiveSearch">
                <colgroup>
                    <col style="min-width: 70px; width: 11%;"/>
                    <col style="min-width: 140px; width: 21%;"/>
                    <col style="min-width: 70px; width: 11%;"/>
                    <col style="min-width: 100px; width: 18%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 160px; width: 26%;"/>
                    <col style="width: 100px;"/>
                </colgroup>
                <tbody>
                <c:choose>
                    <c:when test="${systemType eq '1'}">
                        <tr>
                            <td class="col-text">培训类型</td>
                            <td class="col-input"><ehr:dic-list name="activeType" uninclude="1,2,3,4,5,7,8,9,10,99"
                                                                dicmeta="HE00001" width="130px" id="activeType"
                                                                cssClass="x-layui-input"></ehr:dic-list></td>
                            <td class="col-text">卫生专业</td>
                            <td class="col-input"><ehr:dic-list dicmeta="HSA00006" name="industryType" id="industryType"
                                                                width="130px;" uninclude="1,4,99" parentCode="0"
                                                                cssClass="x-layui-input"/></td>
                            <td class="col-text">时间</td>
                            <td colspan="2" class="col-input"><%-- <tag:dateInput name="createBeginTime" id="createBeginTime" date="${currentYearStartDate}"  style="width:35%;" /> ~ <tag:dateInput name="createEndTime" id="createEndTime"
										style="width:35%;" /> --%>
                                <input type="text" class="layui-input x-admin-sm-date" name="createBeginTime"
                                       id="createBeginTime" style="padding-left: 0px;width:35%;"
                                       value="<fmt:formatDate value='${currentYearStartDate}' pattern='yyyy/MM/dd'/>"/>
                                ~
                                <input type="text" class="layui-input x-admin-sm-date" name="createEndTime"
                                       id="createEndDate" style="padding-left: 0px;width:35%;"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-text">
                                <ehr:authorize ifAnyGranted="${ADMIN},${JKWJ},${QWGZX}">
                                    组织培训机构
                                </ehr:authorize>
                            </td>
                            <td colspan="3" class="col-input">
                                <ehr:authorize ifAnyGranted="${ADMIN},${JKWJ}">
                                    <input type="hidden" id="isADMIN" value="01"/>
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
                                                                     townName="gbcode" width="130px;"
                                                                     isShowOneself="true"
                                                                     includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                     cssClass="x-layui-input"/>
                                    </c:if>
                                    <c:if test="${systemType ne '1'}">
                                        <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                     townName="gbcode" width="130px;"
                                                                     isShowOneself="true"
                                                                     includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                     cssClass="x-layui-input"/>
                                    </c:if>
                                </ehr:authorize>
                            </td>
                            <td></td>
                            <td></td>
                            <td rowspan="1">
                                <!-- <input type="button" id="healthEducationActiveBtnSearch" value="查询" class="search_btn" /> -->
                                <button class="layui-btn layui-btn-sm" id="healthEducationActiveBtnSearch"><i
                                        class="layui-icon">&#xe615;</i>查询
                                </button>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td class="col-text">活动类型</td>
                            <td class="col-input"><ehr:dic-list name="activeType" code="1,2" dicmeta="HE00001"
                                                                width="130px" id="activeType"
                                                                cssClass="x-layui-input"></ehr:dic-list></td>
                            <td class="col-text">教育人员类别</td>
                            <td class="col-input"><ehr:dic-list dicmeta="HE00002" name="educationPersonType"
                                                                id="educationPersonType" width="130px;"
                                                                cssClass="x-layui-input"/></td>
                            <td class="col-text">时间</td>
                            <td colspan="2" class="col-input"><%-- <tag:dateInput name="createBeginTime" id="createBeginTime" style="width:35%;" /> ~ <tag:dateInput name="createEndTime" id="createEndTime"
										style="width:35%;" /> --%>
                                <input type="text" class="layui-input x-admin-sm-date" name="createBeginTime"
                                       id="createBeginTime" style="padding-left: 0px;width:35%;"/> ~
                                <input type="text" class="layui-input x-admin-sm-date" name="createEndDate"
                                       id="createEndDate" style="padding-left: 0px;width:35%;"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="col-text">业务分类</td>
                            <td class="col-input"><ehr:dic-list name="businessType" dicmeta="HE00005" width="130px"
                                                                id="businessType"
                                                                cssClass="x-layui-input"></ehr:dic-list></td>
                            <td class="col-text">
                                <ehr:authorize ifAnyGranted="${ZWJ},${ZXWJ},${ADMIN},${JKWJ},${QWGZX},${JKJKJY}">
                                    机构
                                </ehr:authorize>
                            </td>
                            <td colspan="3" class="col-input">
                                <ehr:authorize ifAnyGranted="${ZWJ},${ZXWJ}">
                                    <ehr:dic-org-list name="orgCode" width="130px" isShowOneself="true"
                                                      cssClass="x-layui-input"/>
                                </ehr:authorize>
                                <ehr:authorize ifAnyGranted="${ADMIN},${JKWJ},${JKJKJY}">
                                    <input type="hidden" id="isADMIN" value="01"/>
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
                                                                     townName="gbcode" width="130px;"
                                                                     isShowOneself="true"
                                                                     includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                     cssClass="x-layui-input"/>
                                    </c:if>
                                    <c:if test="${systemType ne '1'}">
                                        <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode"
                                                                     townName="gbcode" width="130px;"
                                                                     isShowOneself="true"
                                                                     includeTownCodes="${currentLoginInfo.organization.gbCode}"
                                                                     cssClass="x-layui-input"/>
                                    </c:if>
                                </ehr:authorize>
                            </td>
                            <td rowspan="1">
                                <!-- <input type="button" id="healthEducationActiveBtnSearch" value="查询" class="search_btn" /> -->
                                <button class="layui-btn layui-btn-sm" id="healthEducationActiveBtnSearch"><i
                                        class="layui-icon">&#xe615;</i>查询
                                </button>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom"><span
                            onclick="healthEducationActiveSearch.toggle(this,'healthEducationActiveSearch')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
            <input type="hidden" name="resourceType" value="${type}"> <input type="hidden" id="systemType"
                                                                             name="systemType" value="${systemType}">
        </form>
    </div>
    <div class="toolbarSection x-admin-sm">
        <ehr:authorize ifNotGranted="${QWGZX}">
            <a id="activeAdd" href="javascript:void(0)">
                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
            </a>
        </ehr:authorize>
    </div>
    <input type="hidden" id="searchType" value="${type}"/>
    <div id="healthEducationActiveResultDiv"></div>
</div>
<div id="heActiveDetailDivId" class="postcontent"></div>
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#createBeginTime'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#createEndDate'
            , format: 'yyyy/MM/dd'
        });

    });
</script>