<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/statistics/drug/list.js" type="text/javascript"></script>
<div id="reportList" class="repeattable">
    <table id="reportTable" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 40px;"/>
            <col/>
            <col style="width: 70px;"/>
            <col/>
            <col/>
            <col style="width: 150px;"/>
            <col style="width: 80px;"/>
        </colgroup>
        <thead>
            <tr>
                <th>编号</th>
                <th>药品名称</th>
                <th>剂型</th>
                <th>规格</th>
                <th>机构</th>
                <th>时间</th>
                <th>费用</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="drug" items="${drugList}" varStatus="status">
                    <tr>
                        <td class="centertd">${status.index + 1}</td>
                        <td class="centertd">${drug.drugName}</td>
                        <td class="centertd">${drug.drugForm}</td>
                        <td class="centertd">${drug.drugSpecifications}</td>
                        <td class="centertd">${organName}</td>
                        <td class="centertd">${dateRange}</td>
                        <td style="text-align: right">${drug.currentPrice}</td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="mhmDrugSearch.searchDrug" />
        </tr>
    </table>

</div>