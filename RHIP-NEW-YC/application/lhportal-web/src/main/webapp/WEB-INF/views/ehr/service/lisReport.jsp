<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-6-8
  Time: 下午4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/index/main.css" />--%>
<style>
    .report_box{
        padding:4px;
        text-align: left;
    }
    .layout_table{
        text-align:left;
        margin-top: 4px;
        margin-bottom: 4px;
        border:0;
    }
    .layout_table td {
        border:0;
    }
    .layout_table .repeattable th {
    	text-align:left;
    	border:0;
    	width:14%;
    }
    .layout_table .repeattable td {
    	padding:0;
    	margin:0;
    }
    .repeattable  th {
        background: #EFF7FF;
    }
    table {
        background: #fff none repeat scroll 0 0;
        border-collapse: collapse;
        font-size: 12px;
        margin: 0 auto;
        padding: 0;
        table-layout: inherit;
        width: 100%;
        word-break: break-all;
    }
</style>
<body>
<div class="report_box" style="height:auto;">
    <c:set var="examEvent" value="${examReport.examineEvent}" scope="request">
    </c:set>
    <div>
        <div align="right">
            <fmt:formatDate value="${examEvent.checkDate}" pattern="yyyy/MM/dd" />
        </div>
        <h3 align="center">
            <c:out value="${examEvent.checkListTitle}"></c:out>
        </h3>
        <div align="right">
            No:
            <c:out value="${examEvent.recordNumber}"></c:out>
        </div>
    </div>
    <table class="layout_table">
        <tr>
            <td style="width:15%;margin:0;padding:0;">姓名</td>
            <td style="width: 20%" ><c:out value="${examEvent.name}"></c:out></td>
            <td style="width: 15%">性别</td>
            <td style="width: 15%"><ehr:dic dicmeta="GBT226112003" code="${examEvent.gender}" /></td>
            <td style="width: 15%">年龄</td>
            <td><c:out value="${examEvent.age}"></c:out></td>
        </tr>
        <tr>
            <td style="margin:0;padding:0;">科室</td>
            <td><c:out value="${examEvent.applyRoomName}"></c:out></td>
            <td>医生</td>
            <td><c:out value="${examEvent.applyPeopleName}"></c:out></td>
            <td>样本类型</td>
            <td><c:out value="${examEvent.sampleTypeName}"></c:out></td>
        </tr>
        <tr>
            <td style="margin:0;padding:0;" colspan="6">
                <hr />
            </td>
        </tr>
        <tr>
            <td style="vertical-align: top; height: 220px; overflow: auto;margin:0;padding:0;" colspan="6">
                <table class="repeattable">
                    <thead>
                    <tr>
                        <th>日期</th>
                        <th>项目</th>
                        <th>结果</th>
                        <th>参考范围</th>
                        <th>单位</th>
                        <th>提示</th>
                        <th>机构</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${examReport.examineDetails}" var="examineDetail">
                        <tr>
                            <td><fmt:formatDate value="${examineDetail.checkDate}" pattern="yyyy/MM/dd" /></td>
                            <td><ehr:tip>${examineDetail.inspectionItemName}</ehr:tip></td>
                            <td><c:out value="${examineDetail.inspectionResult}"></c:out></td>
                            <td><c:out value="${examineDetail.referenceRange}"></c:out></td>
                            <td><c:out value="${examineDetail.inspectionUnit}"></c:out></td>
                            <td>
                                <c:choose>
                                    <c:when test="${examineDetail.prompt eq '0'}">
                                    </c:when>
                                    <c:otherwise>
                                        <c:out value="${examineDetail.prompt}"></c:out>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><tags:textWithTip value="${examineDetail.detectionOrgName}"></tags:textWithTip></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </td>
        </tr>
        <tr>
            <td style="padding:0;margin:0;" colspan="6">
                <hr />
            </td>
        </tr>
        <tr>
            <td style="padding:0;margin:0;" >检验医生</td>
            <td colspan="3"><c:out value="${examEvent.checkPeopleName}"></c:out></td>
            <td>审核者</td>
            <td><c:out value="${examEvent.auditName}"></c:out></td>

        </tr>
        <tr>
            <td style="padding:0;margin:0;" colspan="4"></td>
            <td>审核时间</td>
            <td><fmt:formatDate value="${examEvent.auditDate}" pattern="yyyy/MM/dd HH:mm:ss" /></td>

        </tr>
    </table>
    <div>声明:本报告仅针对所接受样本负责</div>

</div>