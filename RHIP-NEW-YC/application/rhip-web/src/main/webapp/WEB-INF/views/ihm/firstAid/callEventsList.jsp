<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:60px;width: 12%;"/>
            <col style="min-width:40px;width: 14%;"/>
            <col/>
            <col style="min-width:40px;width: 16%;"/>
            <col style="min-width:40px;width: 11%;"/>
            <col style="min-width:50px;width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>事件编码</th>
            <th>首次呼救电话</th>
            <th>事件名称</th>
            <th>首次受理时刻</th>
            <th>首次调度员</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${resultList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${result.eventNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.firstCall}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.eventTitle}</ehr:tip></td>
                <td class="centertd"><fmt:formatDate value="${result.firstAcceptTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
                <td class="centertd"><ehr:tip>${result.firstDispatcher}</ehr:tip></td>
                <td class="centertd">
                    <a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
                       onclick="firstAidSearch.viewCallEvent('${result.eventNo}')">
                        <i class="layui-icon">&#xe615;</i>查看</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="firstAidSearch.search" />
        </tr>
    </table>
</div>