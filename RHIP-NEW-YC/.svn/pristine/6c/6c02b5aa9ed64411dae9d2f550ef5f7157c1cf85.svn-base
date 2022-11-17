<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<%--<div class="repeattable">--%>
<div class="repeattable" style="overflow-x: auto; overflow-y: auto; min-width: 1700px; width: 100%; height: 450px;">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
		</colgroup>
		<thead>
		<tr>
			<th style="text-align: center" rowspan="3" width="120px;">单   位</th>
			<th style="text-align: center" rowspan="3">收入合计</th>
			<th style="text-align: center" colspan="4">其    中</th>
			<th style="text-align: center" rowspan="3">支出合计</th>
			<th style="text-align: center" colspan="7">其    中</th>
			<th style="text-align: center" rowspan="3">结   余(含财政基本补助）</th>
			<th style="text-align: center" rowspan="3">结   余(不含财政补助）</th>
			<th style="text-align: center" rowspan="3">药品收入占业务总收入比例%</th>
			<th style="text-align: center" rowspan="3">药品综合差价率%</th>
			<th style="text-align: center" colspan="3">去  年  同  期</th>
		</tr>
        <tr>
            <th style="text-align: center" rowspan="2">医疗收入</th>
            <th style="text-align: center">其中</th>
            <th style="text-align: center" rowspan="2">财政补助收入</th>
            <th style="text-align: center" rowspan="2">其他收入</th>
            <th style="text-align: center" rowspan="2">医疗业务成本</th>
            <th style="text-align: center" colspan="2">其中</th>
            <th style="text-align: center" rowspan="2">财政项目补助支出</th>
            <th style="text-align: center" rowspan="2">科教项目支出</th>
            <th style="text-align: center" rowspan="2">管理费用</th>
            <th style="text-align: center" rowspan="2">其他支出</th>
            <th style="text-align: center" rowspan="2">收入合计</th>
            <th style="text-align: center" rowspan="2">财政补助</th>
            <th style="text-align: center" rowspan="2">结余（含财政补助）</th>
        </tr>
        <tr>
            <th style="text-align: center">药品收入</th>
            <th style="text-align: center">药品费</th>
            <th style="text-align: center">折旧（摊销）</th>
        </tr>
		</thead>
		<tbody>
		<c:forEach var="result" items="${resultList}" varStatus="status">
            <tr>
                <td><ehr:tip><ehr:org code="${result.organCode}"></ehr:org></ehr:tip></td>
                <td><tags:numberLabel value="${result.srhj}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.ylsr}" defaultValue="0" align="center" fractionDigits="2"/></td>
                <td><tags:numberLabel value="${result.ypsr}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.czbz}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.qtsr}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.zchj}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.ylcb}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.ypf}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.zj}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.czxmbz}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.kjzc}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.glfy}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.qtzc}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.jyc}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.jyn}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.ypb}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.ypcj}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.srhjl}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.czbzl}" defaultValue="0" align="center"/></td>
                <td><tags:numberLabel value="${result.jyl}" defaultValue="0" align="center"/></td>
            </tr>
		</c:forEach>
		</tbody>
	</table>
</div>
