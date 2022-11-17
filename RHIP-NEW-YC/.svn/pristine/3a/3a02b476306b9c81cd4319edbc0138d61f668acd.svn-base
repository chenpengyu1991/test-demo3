<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
    <table  class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 20%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>镇</th>
            <th>3岁以下儿童数</th>
            <th>3岁以下儿童管理数</th>
            <th>3岁以下儿童管理数率</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="childmgnt3" items="${childmgnt3List}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip><ehr:dic dicmeta="FS990001" code="${childmgnt3.gbCode}"/></ehr:tip></td>
                <td class="centertd"><ehr:tip>${childmgnt3.underThreeNumber}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${childmgnt3.managementNumber}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${childmgnt3.managementRate}%</ehr:tip></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>