<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:60px;width: 15%;"/>
            <col style="min-width:40px;width: 11%;"/>
            <col style="min-width:40px;width: 12%;"/>
            <col style="min-width:40px;width: 18%;"/>
            <col style="min-width:50px;width: 9%;"/>
            <col style="min-width:40px;width: 14%;"/>
            <col/>
            <col style="min-width:50px;width: 8%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>车牌号码</th>
            <th>车辆类型</th>
            <th>工作状态编码</th>
            <th>司机</th>
            <th>医生</th>
            <th>护士</th>
            <th>车载电话</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${resultList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${result.busNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.vehicleType}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.stateNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.driver}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.doctor}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.nurse}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.carTelphone}</ehr:tip></td>
                <td class="centertd">
                    <a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
                       onclick="firstAidSearch.viewAmbulance('${result.tambulanceNo}')">
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