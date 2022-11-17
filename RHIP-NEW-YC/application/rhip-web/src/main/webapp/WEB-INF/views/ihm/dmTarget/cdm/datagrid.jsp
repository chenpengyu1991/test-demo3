<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div style="overflow:auto">
    <div class="repeattable" style="width: 99.8%">
        <table class="layui-table x-admin-sm-table-list-middle">
            <thead>
            	<colgroup>
                <col style="width: 100px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                
            </colgroup>
            <tr>
                <th rowspan="2">机构</th>
                <th  colspan="4">登记人数</th>
                <th  colspan="2">管理人数</th>
                <th  colspan="2">规范化管理人数</th>
                <th  colspan="2">随访次数</th>
                <th  colspan="2">随访控制达标人数</th>
            </tr>
            <tr>
                <th>高血压1级</th>
                <th>高血压2级</th>

                <th>高血压3级</th>
                <th>糖尿病</th>

                <th>高血压</th>
                <th>糖尿病</th>

                <th>高血压</th>
                <th>糖尿病</th>

                <th>高血压</th>
                <th>糖尿病</th>

                <th>高血压</th>
                <th>糖尿病</th>

            </tr>
            </thead>
            <tbody>

            <c:forEach var="item" items="${data}"> <c:choose> <c:when test="${item.targetCode=='-1'}">
                <c:set var="total" scope="request" value="${item}"></c:set> </c:when> <c:otherwise>
                <tr>
                    <td><ehr:tip>${item.targetName}</ehr:tip></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.hbpOne}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.hbpTwo}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.hbpThree}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.diCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.hbpManagedCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.diManagedCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.hbpManagedLimitCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${item.diManagedLimitCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${item.hbpFollowupCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${item.diFollowupCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${item.hbpFollowupWellCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${item.diFollowupWellCount}" type="number"/></td>
                </tr>
            </c:otherwise> </c:choose> </c:forEach> <c:if test="${not empty total}">
                <tr>
                    <td>合计</td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.hbpOne}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.hbpTwo}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.hbpThree}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.diCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.hbpManagedCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.diManagedCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.hbpManagedLimitCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"  value="${total.diManagedLimitCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${total.hbpFollowupCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${total.diFollowupCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${total.hbpFollowupWellCount}" type="number"/></td>
                    <td><tags:numberLabel  defaultValue="0"   value="${total.diFollowupWellCount}" type="number"/></td>
                </tr>

            </c:if>

            </tbody>
        </table>
    </div>
</div>
