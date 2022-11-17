<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 12%;"/>
            <col style="min-width:80px;width: 18%;"/>
            <col style="min-width:80px;width: 14%;"/>
            <col style="min-width:80px;width: 18%;"/>
            <col style="min-width:80px;width: 10%"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>证件号码</th>
            <th>出生时间</th>
            <th>市民卡号</th>
            <th>状态</th>
            <th>联系电话</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="card" items="${healthCardList}" varStatus="status">
            <tr>
                <td class="centertd"><a href="javascript:void(0)" onclick="healthCardSearch.detail(${card.id})">${card.name}</a></td>
                <td class="centertd"><ehr:tip>${card.paperNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${card.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:tip>${card.citizenCardNo}</ehr:tip></td>
                <td class="centertd">
                    <c:if test="${card.cardStatus == '00'}">正常</c:if>
                    <c:if test="${card.cardStatus == '01'}">挂失</c:if>
                    <c:if test="${card.cardStatus == '02'}">冻结</c:if>
                    <c:if test="${card.cardStatus == '03'}">退卡</c:if>
                    <c:if test="${card.cardStatus == '04'}">换卡</c:if>
                    <c:if test="${card.cardStatus == '05'}">补卡</c:if>
                </td>
                <td class="centertd"><ehr:tip>${card.phone}</ehr:tip></td>
                <td class="centertd">
                    <a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
                       onclick="healthCardSearch.history('${card.paperType}','${card.paperNo}', 1)">
                        <i class="layui-icon">&#xe615;</i>查看</a>
                </td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="healthCardSearch.search"/>
        </tr>
    </table>
</div>