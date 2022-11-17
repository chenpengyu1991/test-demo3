<%@page import="com.founder.rhip.ehr.common.EHRConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<c:set var="dataTypeIsAdd" value="<%=EHRConstants.LOCATION_DATA_TYPE_ADD%>"/>
<c:set var="dataStatusIsNormal" value="<%=EHRConstants.LOCATION_DATA_STATUS_NORMAL%>"/>
<table class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
        <col style="width: 5%;"/>
        <col style="width: 10%;"/>
        <col style="width: 10%"/>
        <col style="width: 10%"/>
        <col style="width: 10%"/>
        <col style="width: 10%"/>
        <col style="width: 10%"/>
        <col style="width: 15%"/>
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>发现时间</th>
        <th>信息类别</th>
        <th>信息内容</th>
        <th>报告时间</th>
        <th>报告人</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody class="tbody">
    <c:forEach var="report" varStatus="status" items="${reportRecords}">
        <tr>
            <td class="centertd">${status.index+page.startRow+1}</td>
            <td class="centertd"><ehr:tip>
                <fmt:formatDate value="${report.discoveryDate}" pattern="yyyy/MM/dd"/>
            </ehr:tip></td>
            <td><ehr:tip trim="true">
                <ehr:dic dicmeta="HSA00006" code="${report.infoTypeCode}"/>
            </ehr:tip></td>
            <td><ehr:tip>${report.infoContent}</ehr:tip></td>
            <td class="centertd"><ehr:tip>
                <fmt:formatDate value="${report.createDate}" pattern="yyyy/MM/dd"/>
            </ehr:tip></td>
            <td><ehr:tip>
                <ehr:user userCode="${report.createDoctorCode}"></ehr:user>
            </ehr:tip>
            </td>
            <td class="centertd"><ehr:tip>
                <c:choose>
                    <c:when test="${report.status eq '1'}"> 未接收 </c:when>
                    <c:when test="${report.status eq '2'}"> 已接收 </c:when>
                    <c:when test="${report.status eq '3'}"> 已处理 </c:when>
                    <c:when test="${report.status eq '4'}"> 待回访 </c:when>
                    <c:when test="${report.status eq '5'}"> 已回访 </c:when>
                </c:choose>
            </ehr:tip></td>
            <td class="centertd"><%-- <a title="点击进行查看" class="view-link" href="javascript:void(0)" data-id="${report.id}">查看 </a> --%>
                <a title="点击进行查看" class="view-link layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" data-id="${report.id}"><i
                        class="layui-icon">&#xe615;</i>查看</a>&nbsp;
                <c:choose>
                    <c:when test="${report.status eq '1'}">

                        <%-- <a title="点击进行修改" class="modify-link" href="javascript:void(0)" data-id="${report.id}" >修改</a> --%>

                        <a title="点击进行修改" class="modify-link layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" data-id="${report.id}"><i
                                class="layui-icon" >&#xe642;</i>修改</a>&nbsp;
                        <ehr:authorize ifAnyGranted="0122,0422">
                            <%-- <a title="接收" data-type="receive" class="app-link" href="javascript:void(0)" data-id="${report.id}">接收</a> --%>
                            <a title="接收" data-type="receive" class="app-link" href="javascript:void(0)"
                               data-id="${report.id}" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe605;</i>接收</a>&nbsp;
                        </ehr:authorize>
                    </c:when>
                    <c:when test="${report.status eq '2'}">
                        <ehr:authorize ifAnyGranted="0122,0422">
                            <%-- <a title="填写处理意见" data-type="deal" class="app-link" href="javascript:void(0)" data-id="${report.id}">处理</a> --%>
                            <a title="填写处理意见" data-type="deal" class="app-link layui-btn layui-btn-xs" href="javascript:void(0)"
                               data-id="${report.id}" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe608;</i>处理</a>&nbsp;
                        </ehr:authorize>
                    </c:when>
                    <c:when test="${report.status eq '4'}">
                        <%--<ehr:authorize ifAnyGranted="02">
                                <a title="回访" class="app-link" data-type="visit" href="javascript:void(0)" data-id="${report.id}">回访</a>
                        </ehr:authorize>--%>
                        <ehr:authorize ifAnyGranted="01,0122,0222,0422,02">
                            <c:if test="${report.createOrganCode eq currentUserOrganCode}">
                                <%-- <a title="回访" class="app-link" data-type="visit" href="javascript:void(0)" data-id="${report.id}">回访</a> --%>
                                <a title="点击回访" class="app-link layui-btn layui-btn-xs" data-type="visit" href="javascript:void(0)"
                                   data-id="${report.id}" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe608;</i>回访</a>
                            </c:if>
                        </ehr:authorize>
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8">
            <ehr:paging action="hsaReportRecordList.search"/>
        </td>
    </tr>
    </tbody>
</table>
<%-- <ehr:paging action="hsaReportRecordList.search" /> --%>