<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 15%;"/>
            <%--<col style="min-width:150px;width: 10%;"/>--%>
            <%--<col style="min-width:120px;width: 15%;"/>--%>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>医疗机构</th>
            <%--<th>床位数</th>--%>
            <%--<th>专业设备数</th>--%>
            <th>房屋建筑面积</th>
            <th>业务用房面积</th>
            <th>危房比例</th>
            <th>年内施工面积</th>
            <th>年内竣工面积</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="organization" items="${organizations}" varStatus="status">
            <tr>
                <td style="text-align: center">${organization.organName}</td>
                <td style="text-align: center">${organization.area}</td>
                <td style="text-align: center">${organization.businessArea}</td>
                <td style="text-align: center">${organization.dilapidatedRatio}</td>
                <td style="text-align: center">${organization.constructionArea}</td>
                <td style="text-align: center">${organization.completionArea}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
