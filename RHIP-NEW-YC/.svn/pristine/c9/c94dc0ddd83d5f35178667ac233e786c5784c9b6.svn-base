<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="JK_CODE" value="<%=EHRConstants.JK_CODE%>"/>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/idm/report/search.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/util/jquery.placeholder.1.3.js" type="text/javascript"></script> --%>
<div class="section" id="top_all">
    <div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">传染病及突发事件</a>
		        <a href="javascript:void(0)">传染病报告</a>
		        <a>
		          <cite>报卡浏览审核</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <form id="reportSearchForm">
            <table id="reportSearch">
                <colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 27%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 27%;"/>
                    <col style="min-width:60px; width: 10%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">患者姓名</td>
                    <td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                    <td class="coltext">审批状态</td>
                    <td class="colinput">
                        <ehr:dic-radio name="reportStatus" dicmeta="PH00006" value="${reportStatus}" isDefault="Y"/>
                    </td>
                    <%-- <td class="colinput">
                        <ehr:dic-radio  name="reportStatus" dicmeta="PH00037" value="${reportStatus}" isDefault="Y"/>
                    </td> --%>
                </tr>
                <tr>
                    <td class="coltext">
                        <select style="width: 85px;" name="dateFlag">
                            <option value="1">录入日期</option>
                            <option value="2">发病日期</option>
                        </select>
                    </td>
                    <td class="colinput">
                        <%-- <tag:dateInput id="fillBeginDate" name="fillBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 38%;"></tag:dateInput>
                         ~<tag:dateInput id="fillEndDate" name="fillEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 38%;"></tag:dateInput> --%>

                        <input type="text" class="layui-input x-admin-sm-date" name="fillBeginDate" id="fillBeginDate"
                               style="width: 38%;padding-left: 0px;"> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="fillEndDate" id="fillEndDate"
                               style="width: 38%;padding-left: 0px;">
                    </td>
                    <td class="coltext">疾病名称</td>
                    <td class="colinput" colspan="2">
                        <input class="radioGroup" onclick="reportSearch.changeInfectious(this.value)"
                               id="infectiousType1" name="infectiousType" value="1" type="radio"
                               CHECKED="checked"><label for="infectiousType1">按分类</label>
                        <input class="radioGroup" onclick="reportSearch.changeInfectious(this.value)"
                               id="infectiousType2" name="infectiousType" value="2" type="radio"><label
                            for="infectiousType2">按名称</label>
                        <ehr:dic-list name="type" id="searchType" dicmeta="IDM00400" width="120px;"
                                      onchange="reportSearch.querySearchInfection()" cssClass="x-layui-input"/>
                        <select name="infectiousCode" id="searchInfectiousCode" style="width: 150px;"
                                class="x-layui-input">
                        </select>
                    </td>
                    <%-- <td class="coltext">上报单位</td>
                    <td class="colinput">
                        <ehr:authorize ifAnyGranted="${JKFYK},${ADMIN}">
                            <ehr:org-type-list name="fillOrganCode" type="hospital,centre,other,station" value="${currentOrgCode}" code="${fillOrganCode}" codeOther="46714114-9"/>
                        </ehr:authorize>
                        <ehr:authorize ifNotGranted="${JKFYK},${ADMIN}">
                            <ehr:org-type-list name="fillOrganCode" type="hospital,centre,other,station" value="${currentOrgCode}" code="${fillOrganCode}" codeOther="46714114-9" defaultval="Y"/>
                        </ehr:authorize>
                           <ehr:authorize ifAnyGranted="02,03">
                            <ehr:dic-org-list name="fillOrganCode"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="01,11">
                            <input type="hidden" id="fillOrganCode" name="fillOrganCode"/>
                            <tag:autoSelect name="fillOrganCode" id="fillOrganCode" style="width:170px" ></tag:autoSelect>
                        </ehr:authorize>

                    </td> --%>
                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <ehr:authorize ifAnyGranted="${ZXCRB}">
                        <td class="coltext">上报单位</td>
                        <td class="colinput">
                            <ehr:dic-org-list name="fillOrganCode" isShowOneself="true" cssClass="x-layui-input"/>
                        </td>
                        <td class="coltext"></td>
                    </ehr:authorize>
                    <ehr:authorize ifAnyGranted="${JKFYK},${ADMIN}">
                        <td class="coltext">上报单位</td>
                        <td class="colinput">
                            <ehr:org-type-list id="fillOrganCode" name="fillOrganCode"
                                               type="hospital,centre,other,station" code="${fillOrganCode}"
                                               codeOther="${JK_CODE}" cssClass="x-layui-input"/>
                        </td>
                        <td class="coltext"></td>
                    </ehr:authorize>
                    <ehr:authorize ifAnyGranted="${YYCRB}">
                        <td class="coltext" colspan="4"></td>
                    </ehr:authorize>
                </tr>
                <tr>
                    <td class="righttd" colspan="5">
                        <%-- <input type="button" value="查询" onclick="reportSearch.search(1)" class="search_btn"/> --%>
                        <button class="layui-btn layui-btn-sm" id="idmReportSearchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
                        <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span onclick="reportSearch.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

        </form>
    </div>
    <div class="toolbarSection x-admin-sm">
        <ehr:authorize ifAnyGranted="0111">
            <a id="caseInport" href="javascript:void(0)">
                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe62f;</i>导入</button>
            </a>
        </ehr:authorize>
        <a id="caseExport" href="javascript:void(0)">
            <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe67d;</i>导出</button>
        </a>

    </div>
    <div id="reportResultDiv">
    </div>
</div>
<div id="detailDiv"></div>
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#fillBeginDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#fillEndDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });


    });

</script>
