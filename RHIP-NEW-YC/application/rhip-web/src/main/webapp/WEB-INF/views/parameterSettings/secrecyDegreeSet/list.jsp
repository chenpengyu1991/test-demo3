<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 18%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>设置</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${resultList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip><ehr:org code="${result.organCode}"></ehr:org></ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.secrecyDegree == '1'?'可见，隐藏敏感信息':'不可见'}</ehr:tip></td>
                <td class="centertd"><a href="javascript:void(0);" onclick="secrecyDegreeSearch.initAdd('${result.id}')">修改</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="secrecyDegreeSearch.search"/>
        </tr>
    </table>
</div>