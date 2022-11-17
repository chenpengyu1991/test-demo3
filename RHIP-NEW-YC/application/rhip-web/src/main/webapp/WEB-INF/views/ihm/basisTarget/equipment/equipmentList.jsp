<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable" style="width: 99.5%">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 25%;"/>
            <col style="min-width:150px;"/>
            <col style="min-width:120px;"/>
            <col style="min-width:80px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>医疗机构</th>
            <th>10万元以下数</th>
            <th>10万元~50万元数</th>
            <th>50万元以上数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="organization" items="${organizations}" varStatus="status">
            <tr>
                <td style="text-align: center">${organization.organName}</td>
                <td style="text-align: center">${organization.equipmentNum}</td>
                <td style="text-align: center">${organization.equipmentNumOne}</td>
                <td style="text-align: center">${organization.equipmentNumTwo}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>