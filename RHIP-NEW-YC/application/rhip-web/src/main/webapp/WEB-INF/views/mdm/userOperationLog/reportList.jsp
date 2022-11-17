<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>

<script src="${pageContext.request.contextPath}/js/views/mdm/userOperationLog/list.js" type="text/javascript"></script>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:120px;width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:12%;"/>
            <col style="width:15%;"/>
            <col style="width:15%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="min-width:80px;width:10%;"/>

        </colgroup>
        <thead>
        <tr>
            <th>报卡类别</th>
            <th>疾病类别</th>
            <th>患者姓名</th>
            <th>患者身份证</th>
            <th>报卡机构</th>
            <th>报卡时间</th>
            <th>报卡医生</th>
            <th>报卡状态</th>
            <th>删除状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody class="tbody">
        <c:forEach items="${reportRecordList}" var="reportRecord" varStatus="status">
            <tr>
                <td>
                    <ehr:dic dicmeta="PH00028" code="${reportRecord.type}"/>
                </td>
                <td>
                    <c:if test="${reportRecord.type==1}">
                        <ehr:tip><ehr:dic dicmeta="DMD00004" code="${reportRecord.illnessSecondCode}"/></ehr:tip>
                    </c:if>
                    <c:if test="${reportRecord.type==2}">
                        <ehr:tip>${reportRecord.illnessSecondName}</ehr:tip>
                    </c:if>
                </td>
                <td>
                    <ehr:tip>${reportRecord.name}</ehr:tip>
                </td>
                <td>
                    <ehr:tip>${reportRecord.idcard}</ehr:tip>
                </td>
                <td>
                    <ehr:tip><ehr:org code="${reportRecord.createOrganCode}"/></ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip><fmt:formatDate value="${reportRecord.createDate}" pattern="yyyy/MM/dd HH:mm:ss"/></ehr:tip>
                </td>
                <td>
                    <ehr:tip>${reportRecord.reportDoctorName}</ehr:tip>
                </td>
                <td>
                    <c:if test="${reportRecord.type==1}">
                        <ehr:dic dicmeta="DMD00064" code="${reportRecord.status}"/>
                    </c:if>
                    <c:if test="${reportRecord.type==2}">
                        <ehr:dic dicmeta="IDM00336" code="${reportRecord.status}"/>
                    </c:if>
                </td>
                <td>
                    <c:if test="${reportRecord.isDelete == '0'}"><ehr:tip>否</ehr:tip></c:if>
                    <c:if test="${reportRecord.isDelete == '-1'}"><ehr:tip>是</ehr:tip></c:if>
                </td>
                <td>
                    <%-- <a href="javascript:void(0)" onclick="userOperationLogSearch.detailReportRecord(${reportRecord.id})"class="person-link-btn">查看</a> --%>
                    <a href="javascript:void(0)" onclick="userOperationLogSearch.detailReportRecord(${reportRecord.id})"class="person-link-btn" title="查看"><i class="layui-icon">&#xe615;</i></a>&nbsp;
                        <%--慢病:1未上报--%>
                    <c:if test="${reportRecord.type==1 && reportRecord.status == 1 && reportRecord.isDelete == '0'}">
                        <%-- <a href="javascript:void(0)" onclick="userOperationLogSearch.reSubmit(${reportRecord.id},${reportRecord.type})"class="person-link-btn">补卡</a> --%>
                        <a href="javascript:void(0)" onclick="userOperationLogSearch.reSubmit(${reportRecord.id},${reportRecord.type})"class="person-link-btn" title="补卡"><i class="layui-icon">&#xe608;</i></a>&nbsp;
                    </c:if>
                        <%--传染病:1初诊未上报；3复诊未上报--%>
                    <c:if test="${reportRecord.type==2 && (reportRecord.status == 1 || reportRecord.status == 3) && reportRecord.isDelete == '0'}">
                        <%-- <a href="javascript:void(0)" onclick="userOperationLogSearch.reSubmit(${reportRecord.id},${reportRecord.type})"class="person-link-btn">补卡</a> --%>
                        <a href="javascript:void(0)" onclick="userOperationLogSearch.reSubmit(${reportRecord.id},${reportRecord.type})"class="person-link-btn" title="补卡"><i class="layui-icon">&#xe608;</i></a>&nbsp;
                    </c:if>
                    <c:if test="${reportRecord.isDelete == '0'}"><%--需求变更弹出报卡删除原因页面，2014-02-07--%>
                        <%-- <a href="javascript:void(0)" onclick="userOperationLogSearch.deleteReportRecordDialog(${reportRecord.id})"class="person-link-btn">删除</a> --%>
                        <a href="javascript:void(0)" onclick="userOperationLogSearch.deleteReportRecordDialog(${reportRecord.id})"class="person-link-btn" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp;
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="userOperationLogSearch.searchReportRecord"/>
        </tr>
    </table>
</div>
