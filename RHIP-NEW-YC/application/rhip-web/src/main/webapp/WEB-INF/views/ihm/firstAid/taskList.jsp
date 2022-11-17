<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:60px;width: 19%;"/>
            <col style="min-width:40px;width: 11%;"/>
            <col style="min-width:40px;width: 18%;"/>
            <col style="min-width:40px;width: 9%;"/>
            <col style="min-width:50px;width: 9%;"/>
            <col style="min-width:40px;width: 9%;"/>
            <col/>
            <col style="min-width:50px;width: 9%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>任务编码</th>
            <th>车辆编码</th>
            <th>出车时刻</th>
            <th>司机</th>
            <th>医生</th>
            <th>护士</th>
            <th>实际送往地点</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${resultList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${result.taskNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.carId}</ehr:tip></td>
                <td class="centertd"><fmt:formatDate value="${result.leaveTime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
                <td class="centertd"><ehr:tip>${result.driver}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.doctor}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.nurse}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.sendToPlace}</ehr:tip></td>
                <td class="centertd">
                    <a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
                       onclick="firstAidSearch.viewTask('${result.taskNo}')">
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