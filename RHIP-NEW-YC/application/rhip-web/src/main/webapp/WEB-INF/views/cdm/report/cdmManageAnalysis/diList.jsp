<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
    <table id="statistics_record_table" class="layui-table x-admin-sm-table-list-middle">
        <caption><span style="font-size: 25px;font-weight:bold;">糖尿病统计</span></caption>
        <colgroup>
            <col style="width:160px" />
        </colgroup>
        <thead>
        <tr>
            <th>单位</th>
            <th>辖区人口数</th>
            <th>辖区估计病人数</th>
            <th>已管理慢性病人数</th>
            <th>规范管理人数</th>
            <th>规范化管理率</th>
            <%--<th rowspan="2">健康管理率</th>--%>
            <%--<th rowspan="2">最近一次随访血压达标人数</th>--%>
            <%--<th rowspan="2">管理人群血压控制率</th>--%>
            <th>最近一次随访空腹血糖达标人数</th>
            <th>管理人群血糖控制率</th>
        </tr>
        <%--<tr>--%>
        <%--<th>高血压</th>--%>
        <%--<th>糖尿病</th>--%>
        <%--<th>肿瘤</th>--%>
        <%--<th>冠心病</th>--%>
        <%--<th>脑卒中</th>--%>
        <%--<th>高血压</th>--%>
        <%--<th>糖尿病</th>--%>
        <%--<th>肿瘤</th>--%>
        <%--<th>冠心病</th>--%>
        <%--<th>脑卒中</th>--%>
        <%--<th>高血压</th>--%>
        <%--<th>糖尿病</th>--%>
        <%--<th>肿瘤</th>--%>
        <%--<th>冠心病</th>--%>
        <%--<th>脑卒中</th>--%>
        <%--</tr>--%>
        </thead>
        <tbody>
        <c:forEach items="${cdmsStatistsList}" var="cdmsStatists">
            <tr>
                <td title="${cdmsStatists.createUnitName}">${cdmsStatists.createUnitName}</td>
                <td>${cdmsStatists.districtPopulation}</td>
                <td>${cdmsStatists.appraisePopulation}</td>
                <%--<td>${cdmsStatists.manageHbpPopulation}</td>--%>
                    <td>${cdmsStatists.manageDiPopulation}</td>
                    <%--<td>${cdmsStatists.manageCancerPopulation}</td>--%>
                    <%--<td>${cdmsStatists.manageStrokePopulation}</td>--%>
                    <%--<td>${cdmsStatists.manageCoronaryPopulation}</td>--%>
                <%--<td>${cdmsStatists.standardizationHbpPopulation}</td>--%>
                    <td>${cdmsStatists.standardizationDiPopulation}</td>
                    <%--<td>${cdmsStatists.standardizationCancerPopulation}</td>--%>
                    <%--<td>${cdmsStatists.standardizationStrokePopulation}</td>--%>
                    <%--<td>${cdmsStatists.standardizationCoronaryPopulation}</td>--%>
                <%--<td><tags:numberLabel fractionDigits="2" type="percent"--%>
                                      <%--value="${cdmsStatists.standardizationManagementHbpRate}"></tags:numberLabel></td>--%>
                <td><tags:numberLabel fractionDigits="2" type="percent"
                    value="${cdmsStatists.standardizationManagementDiRate}"></tags:numberLabel></td>
                    <%--<td><tags:numberLabel fractionDigits="2" type="percent"--%>
                    <%--value="${cdmsStatists.standardizationManagementCancerRate}"></tags:numberLabel></td>--%>
                    <%--<td><tags:numberLabel fractionDigits="2" type="percent"--%>
                    <%--value="${cdmsStatists.standardizationManagementStrokeRate}"></tags:numberLabel></td>--%>
                    <%--<td><tags:numberLabel fractionDigits="2" type="percent"--%>
                    <%--value="${cdmsStatists.standardizationManagementCoronaryRate}"></tags:numberLabel></td>--%>
                    <%--<td><tags:numberLabel fractionDigits="2" type="percent"--%>
                    <%--value="${cdmsStatists.healthManagementRate}"></tags:numberLabel></td>--%>
                <%--<td>${cdmsStatists.bloodToStandard}</td>--%>
                <%--<td><tags:numberLabel fractionDigits="2" type="percent"--%>
                                      <%--value="${cdmsStatists.bloodToStandardRate}"></tags:numberLabel></td>--%>
                <td>${cdmsStatists.bloodSugerToStandard}</td>
                <td><tags:numberLabel fractionDigits="2" type="percent"
                    value="${cdmsStatists.bloodSugerToStandardRate}"></tags:numberLabel></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>